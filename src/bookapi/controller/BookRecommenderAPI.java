package bookapi.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import bookapi.models.Book;
import bookapi.models.Ratings;
import bookapi.models.User;
import utils.Serializer;

public class BookRecommenderAPI implements LibraryAPI {

	/********* Declare Variables *********/
	Book book;
	User user;
	public Serializer serializer;
	public Map<Long, User> users = new HashMap<>();
	public Map<String, User> userName = new HashMap<>();
	public Map<Long, Book> books = new HashMap<>();
	public Map<String, Book> bookTitle = new HashMap<>();
	public Map<Long, Ratings> ratings = new HashMap<>();

	/********* Constructors *********/
	public BookRecommenderAPI() {

	}

	public BookRecommenderAPI(Serializer serializer) {
		this.serializer = serializer;
	}

	/*
	 * Read the data from the user,books and ratings.dat files
	 */

	public void loadData () throws IOException 
	{
		String pipe = "[|]";
		Scanner scanner = new Scanner (new File ("./libs/users.dat"));
	    while (scanner.hasNextLine())
	    {
	    	String userDetails = scanner.nextLine();
	    	String[] tokenArray = userDetails.split(pipe);
	    	
	    	if (tokenArray.length == 7)
	    	{
	    		addUser(tokenArray[1], tokenArray[2], tokenArray[3], tokenArray[4], tokenArray[5]);
	    	}else{
	    		scanner.close();
	    		throw new IOException("Invalid member length: " + tokenArray.length);	
	    	}
	    }
	    
	    Scanner scanner1 = new Scanner (new File ("./libs/books.dat"));
	    while (scanner1.hasNextLine())
	    {
	    	String bookDetails = scanner1.nextLine();
	    	
	    	String[] bookArray = bookDetails.split(pipe);
	    	
	    	
	    	if (bookArray.length == 4)
	    	{
	    		addBook(bookArray[1], bookArray[2], bookArray[3]);
	    	}else{
	    		scanner.close();
	    		//throw new IOException("Invalid member length: " + bookArray.length);
	    	}
	    }
	    
	   Scanner scanner2 = new Scanner (new File ("./libs/ratings.dat"));
		
	    while (scanner2.hasNextLine())
	    {
	    	String ratingsDetails = scanner2.nextLine();
	    	String [] ratingArray = ratingsDetails.split(pipe);
	    	
	    	if (ratingArray.length == 4)
	    	{
	    		//addRatings(tokenArray[1], tokenArray[2], tokenArray[3]);
	    	}else{
	    		scanner.close();
	    		throw new IOException("Invalid member length: " + ratingArray.length);
	    			
	    	}
	    }
	    scanner.close();	    
	  }
	
	//TODO delete this method
//	public void loadData() throws IOException {
//		String pipe = "[|]";
//		Scanner scanner = new Scanner(new File("./libs/users.dat"));
//
//		/*
//		 * Loops trough the data in the users.dat files and splits the data with the
//		 * pipe carachter so we get a first name, last name, age, gender, and job
//		 */
//		while (scanner.hasNextLine()) {
//			String userDetails = scanner.nextLine();
//			String[] tokenArray = userDetails.split(pipe);
//
//			if (tokenArray.length == 7) {
//				addUser(tokenArray[1], tokenArray[2], tokenArray[3], tokenArray[4], tokenArray[5]);
//			} else {
//				scanner.close();
//				throw new IOException("Invalid member length: " + tokenArray.length);
//			}
//		}
//		
//
//		Scanner scanner1 = new Scanner(new File("./libs/books.dat"));
//		/*
//		 * Loops trough the data in the books.dat file and splits the data with the pipe
//		 * Character so we get a title, year and publisher
//		 */
//		while (scanner1.hasNextLine()) {
//			String bookDetails = scanner1.nextLine();
//
//			String[] bookArray = bookDetails.split(pipe);
//
//			if (bookArray.length == 4) {
//				addBook(bookArray[1], bookArray[2], bookArray[3]);
//			} else {
//				scanner1.close();
//				// throw new IOException("Invalid member length: " + bookArray.length);
//			}
//		}
//		
//		
//		Scanner scanner2 = new Scanner(new File("./libs/ratings.dat"));
//		/*
//		 * Loops trough the data in the ratings.dat files and splits the data with the
//		 * pipe carachter so we get a userID, BookID and RatingID
//		 */
//		while (scanner2.hasNextLine()) {
//			String ratingsDetails = scanner2.nextLine();
//			String[] ratingArray = ratingsDetails.split(pipe);
//
//			if (ratingArray.length == 4) {
//				// addRatings(tokenArray[1], tokenArray[2], tokenArray[3]);
//			} else {
//				scanner2.close();
//				throw new IOException("Invalid member length: " + ratingArray.length);
//
//			}
//		}
//		scanner.close();
//	}

	/*
	 * Load the data into the system
	 */
	@SuppressWarnings("unchecked")
	public void load() throws Exception {
		serializer.read();
		users = (Map<Long, User>) serializer.pop();
		books = (Map<Long, Book>) serializer.pop();
		ratings = (Map<Long, Ratings>) serializer.pop();
	}

	/*
	 * Save the data to the file data.xml in the files folder
	 */
	public void store() throws Exception {
		serializer.push(users);
		serializer.push(books);
		serializer.push(ratings);
		serializer.write();
	}

	/********* Users Methods *********/
	/*
	 * adds a user to the system by taking there(first name last name, age gender,
	 * job )
	 */
	@Override
	public void addUser(String fName, String lName, String age, String gender, String job) {
		user = new User(fName, lName, age, gender, job);
		users.put(user.userID, user);
		userName.put(fName, user);
	}

	/*
	 * Remove a user from the system by there id
	 */

	@Override
	public void removeUser(Long userID) {
		user = users.remove(userID);
	}

	/*
	 * gets all the users in the system
	 */
	@Override
	public Collection<User> getUser() {
		return users.values();
	}

	/*
	 * Get a user by his first name
	 */
	public User getUserByName(String fName) {
		return userName.get(fName);
	}

	/*
	 * Get a user by his id
	 */
	public User getUserById(Long num) {
		return users.get(num);
	}

	/********* Book Methods *********/
	/*
	 * Adds a book to the system with a title date and a publisher
	 */
	@Override
	public void addBook(String title, String date, String publisher) {
		book = new Book(title, date, publisher);
		books.put(book.bookID, book);
		bookTitle.put(title, book);
	}

	/*
	 * Remove a book by its id
	 */
	@Override
	public void removeBook(Long bookID) {
		book = books.remove(bookID);
	}

	/*
	 * Get a list of the book in the system
	 */
	@Override
	public Collection<Book> getBook() {
		return books.values();
	}

	/*
	 * get a book by its title
	 */
	@Override
	public Book getBookbytitle(String title) {

		return bookTitle.get(title);
	}

	/*
	 * Get a book by its id
	 */
	@Override
	public Book getBookById(Long id) {
		return books.get(id);
	}

	/*
	 * Get the top 10 books
	 */
	@Override
	public List<Book> getTop10() {
		//TODO Make method work for top 10 books 
		return null;
	}

	/********* Rating Methods *********/

	@Override
	public void addRating(int rating, int userID, int bookID) {

	}

	public Collection<Ratings> getRatings() {

		return ratings.values();
	}

	@Override
	public List<Ratings> getUserRatings(int userID) {

		return null;
	}

	@Override
	public List<Book> getBookRatings(int bookID) {

		return null;
	}

}
