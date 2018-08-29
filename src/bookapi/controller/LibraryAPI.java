package bookapi.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import bookapi.models.Book;
import bookapi.models.Ratings;
import bookapi.models.User;

public interface LibraryAPI {

	/** Users **/
	public void addUser(String fName, String lName, String age, String gender, String job);

	public void removeUser(Long userID);

	public Collection<User> getUser();

	/** Books **/
	public void addBook(String title, String date, String publisher);

	public void removeBook(Long bookID);

	public Collection<Book> getBook();

	public Book getBookbytitle(String title);

	public Book getBookById(Long id);

	public void getTop10();

	/** Ratings **/
	public void addRating(Long userID, Long bookID, int ratings);

	public Map<Long, Ratings> getUserRatings(Long userID);

	public Map<Long, Book> getBookRatings(Long bookID);
}
