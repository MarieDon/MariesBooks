package utils;
import java.util.Comparator;

import bookapi.models.Book;

public class CompareByID implements Comparator<Book> {
	@Override
	public int compare(Book s1, Book s2) {
		
		return (int) (s1.rating - s2.rating);
	}

}

