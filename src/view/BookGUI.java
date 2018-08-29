package view;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

import bookapi.controller.BookRecommenderAPI;
import bookapi.controller.EasyScanner;
import bookapi.models.Book;
import bookapi.models.Ratings;
import bookapi.models.User;
import utils.Serializer;
import utils.XMLSerializer;

public class BookGUI {
	public BookRecommenderAPI bookAPI = new BookRecommenderAPI();
	public Long id;
	public String title;

	// Make a constructor of the BookGUI class to load the users.xml file 
	//for reading and writing
	public BookGUI() throws Exception {
		File book = new File("./files/users.xml");
		Serializer serializer = new XMLSerializer(book);
		bookAPI = new BookRecommenderAPI(serializer);
		if (book.isFile()) {
			bookAPI.load();
		}
	}

	public static void main(String[] args) throws Exception {
		BookGUI myBook = new BookGUI();
		int choice;
		System.out.println("Please select one of the following options.");
		myBook.menu();
		do {
			choice = EasyScanner.nextInt();
			
			switch (choice) {
			case 0:
				myBook.bookAPI.loadData();
				System.out.println("Data was loaded successfully");
				break;
				
			case 1:
				myBook.getAllUsers();
				break;

			case 2:
				myBook.getSingleUser();
				break;

			case 3:
				myBook.addUserToSystem();
				break;

			case 4:
				myBook.removeUser();
				break;

			case 5:
				myBook.getAllBooks();
				break;

			case 6:
				myBook.getbookByTitle();
				break;

			case 7:
				myBook.addBookToSystem();
				break;

			case 8:
				myBook.removeBook();
				break;

			case 9:
				myBook.getTop10();
				break;

			case 10:
				myBook.getUserRatings();
				break;

			case 11:
				myBook.myRatings();
				break;

			case 12:
				myBook.addRating();
				break;

			case 13:
				System.out.println("Thank you for using my system. Goodbye");
				
				//When user enters 13 into the menu the file gets saved
				myBook.bookAPI.store();
				break;
			}

		} while (choice != 13);
		
		
	}



	/*
	 * Print a menu to the screen
	 */
	public void menu() {
		System.out.println("0. Load data from file");
		System.out.println("1. View all users.");
		System.out.println("2. Find user by ID.");
		System.out.println("3. Create new user.");
		System.out.println("4. Remove a user by ID.");
		System.out.println("5. View all books.");
		System.out.println("6. Find a book by title.");
		System.out.println("7. Add a book.");
		System.out.println("8. Remove a book by ID.");
		System.out.println("9. Top 10 books.");
		System.out.println("10. View user ratings.");
		System.out.println("11. View book ratings.");
		System.out.println("12. Add rating.");
		System.out.println("13. Exit.");
		
	}
	
	/*
	 * Get all user and sort them alphabetical order of the first name 
	 */
	public void getAllUsers() {
		TreeSet<User> sortedUser = new TreeSet<User>();
		sortedUser.addAll(bookAPI.getUser());
		Iterator<User> loop = sortedUser.iterator();
		while (loop.hasNext()) {
			User user = loop.next();
			System.out.println(user.fName + " " + user.lName);
		}
	}

	/*
	 * Gets a single user depending on the number the user enters
	 */
	public void getSingleUser() { 
		System.out.println("Please enter the id of the person you want to retrieve");
		id = EasyScanner.nextLong();
		User user = bookAPI.getUserById(id);
		//Check to see if the user exists
		if(user == null) {
			System.out.println("There is no user with that id please try again");
		}else {
			System.out.println(user);
		}
	}

	/*
	 * Add user to the system only if all field are filled in
	 */
	public void addUserToSystem() {
		System.out.println("Please add your first name");
		String fName = EasyScanner.nextString();
		
		System.out.println("Please enter your last name");
		String lName = EasyScanner.nextString();
		
		System.out.println("Please enter your age");
		String age = EasyScanner.nextString();
		
		System.out.println("Please enter a gender");
		String gender = EasyScanner.nextString();
		
		System.out.println("Please enter a job title");
		String job = EasyScanner.nextString();
		
		//check to see if all fields are filled in by the user and if they are add user to system
		if(!fName.equals("") && !lName.equals("") && !age.equals("") && !gender.equals("") && !job.equals("")) {
			bookAPI.addUser(fName, lName, age, gender, job);
			System.out.println(fName +" " + lName + " Was added to the system" );
		}else {
			System.out.println("All fields must be filled in to add the person to the system");
		}
	}
	

	/*
	 * Delete a user from the system based on the id that is entered
	 */
	public void removeUser() {
		System.out.println("Please enter the id of the person you want to Delete from the system");
		id = EasyScanner.nextLong();
		User user = bookAPI.getUserById(id);
		
		//check to see if a user is found if the user is found then delete him 
		if(user != null) {
			System.out.println("The user " + user.getfName() + " " + user.getlName() +  " has been deleted");
			bookAPI.removeUser(id);
		}else {
			System.out.println("No user with that id is in the system");
		}
	}

	public void getAllBooks() {
		TreeSet<Book> sortedBooks = new TreeSet<Book>();
		sortedBooks.addAll(bookAPI.getBook());
		Iterator<Book> itBook = sortedBooks.iterator();

		while (itBook.hasNext()) {
			Book b = itBook.next();
			System.out.println(b.title);
		}
	}

	public void getbookByTitle() {
		System.out.println("Please enter the title of the book you want to retrive");
		title = EasyScanner.nextString();
		Book book = bookAPI.getBookbytitle(title);
		System.out.println(book);
	}
	
	/*
	 * Add book to the system only if all field are filled in
	 */
	public void addBookToSystem() {
		System.out.println("Please enter title");
		String title = EasyScanner.nextString();
		
		System.out.println("Please enter date");
		String date = EasyScanner.nextString();
		
		System.out.println("Please enter publisher");
		String publisher = EasyScanner.nextString();
		
	
		//check to see if all fields are filled in by the user and if they are adding book to system
		if(!title.equals("") && !date.equals("") && !publisher.equals("")) {
			bookAPI.addBook(title, date, publisher);
			System.out.println(title + " Was added to the system" );
		}else {
			System.out.println("All fields must be filled in to add the book to the system");
		}
	}
	
	/*
	 * Delete a book from the system based on the id that is entered
	 */
	public void removeBook() {
		System.out.println("Please enter the id of the book you want to delete from the system");
		id = EasyScanner.nextLong();
		Book bookdeleted = bookAPI.getBookById(id);
		
		//check to see if a book is found if the book is found then delete it 
		if(bookdeleted != null) {
			System.out.println("The book " + bookdeleted.getTitle() + " has been deleted");
			bookAPI.removeBook(id);
		}else {
			System.out.println("No book with that id is in the system");
		}
	}
	
	public void getTop10 () {
		bookAPI.getTop10();
	}
	
	public void addRating() {
		long userID = 0;
		long bookID = 0;
		int rating = 0;
	
	    System.out.println("Please enter user ID");
	    userID = EasyScanner.nextLong();
	    System.out.println("Please enter book ID");
	    bookID = EasyScanner.nextLong();
	    System.out.println("Please enter a rating");
	    rating = EasyScanner.nextInt();
	    
	   bookAPI.addRating(userID, bookID, rating);
	   
		
	    
		
	}
	public void getUserRatings() {
		System.out.println("Please enter the ID of the user  you want to get the ratings for");
		id = EasyScanner.nextLong();
		System.out.println(bookAPI.getUserRatings(id)); 
	}
	
	public void myRatings() {
		Collection<Ratings> book = bookAPI.getRatings();
		 System.out.println(book);
	}
	
	public void getRatingss() {
		bookAPI.getRating(1L);
	}
	
}
