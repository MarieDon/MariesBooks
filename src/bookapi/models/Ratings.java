package bookapi.models;

public class Ratings {
     public int rating;
     public int userID;
     public int bookID;
     
     
	public Ratings(int rating, int userID, int bookID) {
		super();
		this.rating = rating;
		this.userID = userID;
		this.bookID = bookID;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public int getBookID() {
		return bookID;
	}


	public void setBookID(int bookID) {
		this.bookID = bookID;
	}


	@Override
	public String toString() {
		return "Ratings [rating=" + rating + ", userID=" + userID + ", bookID=" + bookID + "]";
	}
     
     
}
