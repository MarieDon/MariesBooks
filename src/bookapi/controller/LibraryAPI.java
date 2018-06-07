package bookapi.controller;

import java.util.List;

import bookapi.models.Book;
import bookapi.models.Ratings;
import bookapi.models.User;

public interface LibraryAPI {
	/**Users**/
	public void addUser(String fName, String lName, int age, char gender, String job);
	public void removeUser(int userID);
	public List<User> getUser();
	
	/**Books**/
	public void addBook(String title, String date, String publisher, String bookID);
	public void removeBook(int bookID);
	public List<Book> getBook();
	
	public Book getBookbytitle(String title);
	public Book getBookbyyear(String year);
	public List<Book> getTop10();
	
	/**Ratings**/
	public void addRating (int rating, int userID, int bookID);
	public List<Ratings> getUserRatings(int userID);
	public List<Book> getBookRatings(int bookID);
}
