package bookapi.models;

import java.util.HashMap;
import java.util.Map;

public class Book implements Comparable<Book> {
	static Long counter = 01L;
	public String title;
	public String date;
	public String publisher;
	public Long bookID;
	public Map<Long, Ratings> BookRatings = new HashMap<>();

	public Book(String title, String date, String publisher) {
		this.bookID = counter++;
		this.title = title;
		this.date = date;
		this.publisher = publisher;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Long getBookID() {
		return bookID;
	}

	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", date=" + date + ", publisher=" + publisher + ", bookID=" + bookID + "]";
	}

	@Override
	public int compareTo(Book book) {
		return this.title.compareTo(book.title);
	}

}
