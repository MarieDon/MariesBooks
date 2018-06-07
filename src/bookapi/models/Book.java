package bookapi.models;

public class Book {
	public String title;
	public String date;
	public String publisher;
	public Long bookID;
	
	
	public Book(String title, String date, String publisher, Long bookID) {
		super();
		this.title = title;
		this.date = date;
		this.publisher = publisher;
		this.bookID = bookID;
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
	
	
}
