package view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import bookapi.controller.BookRecommenderAPI;
import bookapi.models.Book;
import utils.FileLogger;

public class BookGUI {

	public static void main(String[] args) throws IOException {
		BookRecommenderAPI bookAPI = new BookRecommenderAPI();

		 FileLogger logger = FileLogger.getLogger();
		    logger.log("Creating user list");

		    bookAPI.addBook("Adventures", "2018", "J.K Rowling", "456");
		    
		   
		    Collection<Book> book = bookAPI.getBook();
		    System.out.println(book);
		    
//		    User name = bookAPI.getUserByName("Marie");
//		    System.out.println(name);
		    
		    logger.log("Serializing contacts to XML");
		    XStream xstream = new XStream(new DomDriver());
		    ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("users.xml"));
		  //  out.writeObject(user);
		    out.close();    

		    logger.log("Finished - shutting down");
	}
}
