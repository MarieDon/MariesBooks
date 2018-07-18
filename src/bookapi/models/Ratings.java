package bookapi.models;
import static com.google.common.base.MoreObjects.toStringHelper;

public class Ratings {
	 public float ratings;
     public Long id;
     public Long userID;
     public Long bookID;
     static Long counter = 01L;
     
	public Ratings(Long userID, Long bookID, float ratings) {
		this.ratings = ratings;
		this.id = counter++;
		this.userID = userID;
		this.bookID = bookID;
		
	}

//	@Override
//	public String toString() {
//		return "Ratings [ratings=" + ratings + ", id=" + id + ", userID=" + userID + ", bookID=" + bookID + "]";
//	}

	


	@Override
	public String toString() {
		return toStringHelper(this).addValue(id)
			   .addValue(userID).addValue(bookID).addValue(ratings).toString();
	}
     
     
}
