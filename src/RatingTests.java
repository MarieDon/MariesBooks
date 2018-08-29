import static org.junit.Assert.*;

import org.junit.Test;
import org.xml.sax.helpers.ParserFactory;

import bookapi.models.Ratings;

public class RatingTests {
	public static Ratings[] rating = { 
			new Ratings(1L, 2L, 3),
			new Ratings(2L, 3L, 4), 
			new Ratings(3L, 4L, 5),
			new Ratings(4L, 5L, 6)

	};


//		@Test
//		public void testCreate() {
//			assertEquals(1 , 1L, 	rating[0].userID);
//			assertEquals(1, 2L, 	rating[0].bookID);
//			assertEquals((float)3, 	rating[0].ratings);
//		}
	
		@Test
		public void testIds() {
			
			assertNotEquals(rating[0].id, rating[1].id);
		}
		
		@Test
		public void testToString() {
			assertEquals("Ratings{"+rating[0].id +", 1, 2, 3}", rating[0].toString());
		}
	}

