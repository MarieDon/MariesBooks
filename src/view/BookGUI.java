package view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import bookapi.controller.BookRecommenderAPI;
import bookapi.models.Book;
import bookapi.models.User;
import utils.FileLogger;

public class BookGUI {

	public static BookRecommenderAPI bookAPI = new BookRecommenderAPI();
	
	public static void getAllBooks ()
	{
		TreeSet<Book> sortedBooks = new TreeSet<Book>();
		sortedBooks.addAll(bookAPI.getBook());
		Iterator<Book> itBook = sortedBooks.iterator();
		
		while(itBook.hasNext())
		{
			Book b = itBook.next();
			System.out.println(b.title);
		}
	}
	
	public static void main(String[] args) throws IOException {
		

		 FileLogger logger = FileLogger.getLogger();
		    logger.log("Creating user list");
		    bookAPI.loadData();
		    
		    getAllBooks();

		
//		    bookAPI.addBook("Adventures", "2018", "J.K Rowling");
//		    bookAPI.addBook("Summer", "2010", "M. Donoval");
//		    bookAPI.addBook("Rush Hour", "2008", "Julie Halligan");
		    
		    
		   
		    Collection<Book> book = bookAPI.getBook();
		    System.out.println("This prints All Book " + book);
		    
		    Book myBook = bookAPI.getBookbytitle("Wicked");
		    System.out.println("this prints the Book Title " + myBook);
		    bookAPI.removeBook(2L);
		    //bookAPI.addBook("Rat Tail", "2002", "Ola Bartos");
		    
		    System.out.println("Deleted Book " + book);
		    
			   
		    
//		    bookAPI.addUser("Eoin", "Kelly", 20, 'M', "Programmer");
//		    bookAPI.addUser("Ola", "Bartos", 20, 'F', "tattooer");
//		    bookAPI.addUser("Andis", "Zeibots", 20, 'M', "Gamer");


		    Collection<User> book1 = bookAPI.getUser();
		    System.out.println(book1);
		    bookAPI.removeUser(3L);
		    
		    System.out.println(book1);
		    
		    logger.log("Serializing contacts to XML");
		    XStream xstream = new XStream(new DomDriver());
		    ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("users.xml"));
		    out.writeObject(book);
		    out.close();    

		    logger.log("Finished - shutting down");
	}
}
