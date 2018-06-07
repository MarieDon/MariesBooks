package bookapi.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bookapi.models.Book;
import bookapi.models.Ratings;
import bookapi.models.User;

public class BookRecommenderAPI implements LibraryAPI {

	public Map<Long, User> users= new HashMap<> ();
	public Map<String, User> userName= new HashMap<> ();
	public Map<Long, Book> books= new HashMap<> ();
	
	
	public BookRecommenderAPI() {
		
	}
	

	@Override
	public void addUser(String fName, String lName, int age, char gender, String job) {
		User user = new User(fName,lName,age,gender,job, 123l);
		users.put(user.userID, user);
	}

	@Override
	public void removeUser(int userID) {
		
	}

	@Override
	public Collection<User> getUser() {
		return users.values();
	}
	
//	public User getUserByName(String fName) {
//		return userName.get(fName);
//	}
	

	@Override
	public void addBook(String title, String date, String publisher, String bookID) {
		Book book = new Book(title,date,publisher,456l);
		books.put(book.bookID, book);
	}

	@Override
	public void removeBook(int bookID) {
	
	}

	@Override
	public Collection<Book> getBook() {
	
		return books.values();
	}

	@Override
	public Book getBookbytitle(String title) {
		
		return null;
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

	@Override
	public List<Ratings> getUserRatings(int userID) {
		
		return null;
	}

	@Override
	public List<Book> getBookRatings(int bookID) {
		
		return null;
	}

}
