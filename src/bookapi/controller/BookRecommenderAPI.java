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

	public Serializer serializer;
	public Map<Long, User> users= new HashMap<> ();
	public Map<String, User> userName= new HashMap<> ();
	public Map<Long, Book> books= new HashMap<> ();
	public Map<String, Book> bookTitle= new HashMap<> ();
	public Map<Long, Ratings> ratings= new HashMap<> ();
	
	
	public BookRecommenderAPI() {
	
	}
	
	public BookRecommenderAPI(Serializer serializer)
	{
		this.serializer=serializer;
	}
	
	
	
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
	
	
	public void load() throws Exception
	{
		serializer.read();
		users = (Map<Long, User>) serializer.pop();
		books = (Map<Long, Book>) serializer.pop();
		ratings = (Map<Long, Ratings>) serializer.pop();
	}
	
	public void store() throws Exception
	{
		serializer.push(users);
		serializer.push(books);
		serializer.push(ratings);
		serializer.write();
	}

	

	@Override
	public void addUser(String fName, String lName, String age, String gender, String job) {
		User user = new User(fName, lName, age, gender, job);
		users.put(user.userID, user);
		userName.put(fName, user);
		
	}

	@Override
	public void removeUser(Long userID) {
		User user = users.remove(userID);
	}

	@Override
	public Collection<User> getUser() {
		return users.values();
	}
	
	public User getUserByName(String fName) {
		return userName.get(fName);
	}
	
	public User getUserById(Long num) {
		return userName.get(num);
	}
	

	@Override
	public void addBook(String title, String date, String publisher) {
		Book book = new Book(title,date,publisher);
		books.put(book.bookID, book);
		bookTitle.put(title, book);
	}

	@Override
	public void removeBook(Long bookID) {
		Book book= books.remove(bookID);
	}

	@Override
	public Collection<Book> getBook() {
	
		return books.values();
	}

	@Override
	public Book getBookbytitle(String title) {
		
		return bookTitle.get(title);
	}

	@Override
	public Book getBookbyyear(String year) {
	
		return null;
	}

	@Override
	public List<Book> getTop10() {
		
		return null;
	}

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
