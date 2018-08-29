import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bookapi.models.Book;

public class bookTests {
	Book test = new Book ("Gonnies", "1989", "Helen Sanders");

	// See if a movie can be created
	@Test
	public void testCreate() {
		assertEquals("Gonnies", test.title);
		assertEquals("1989", test.date);
		assertEquals("Helen Sanders", test.publisher);
	}

	// test toString method
	@Test
	public void testToString() {
		assertEquals("Book{" + test.bookID + ", Gonnies, 1989, Helen Sanders}", test.toString());
	}
}
