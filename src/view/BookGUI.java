package view;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import bookapi.controller.BookRecommenderAPI;
import bookapi.controller.EasyScanner;
import bookapi.models.Book;
import bookapi.models.User;
import utils.FileLogger;

public class BookGUI {

	public static BookRecommenderAPI bookAPI = new BookRecommenderAPI();
	public static EasyScanner userInput = new EasyScanner();
	public static void main(String[] args) throws IOException {
		int choice;
		 bookAPI.loadData();
	    bookAPI.addUser("Andis", "Zeibots", "20", "M", "Gamer");
		System.out.println( bookAPI.getUserById(1L));	 
		
		
		
		System.out.println("Please select one of the following options.");
		
		
		do {
		menu();
		 choice = userInput.nextInt();
		 
		 switch (choice)
		 {
		 case 1 : getAllUsers();
			 break;
			 
		 case 2 :
			
			 getSingleUser();	 		
			 break;
			 
		 case 3 :
			 break;
			 
		 case 4 :
			 break;
			 
		 case 5 :
			 break;
			 
		 case 6 :
			 break;
			 
		 case 7 :
			 break;
			 
		 case 8 :
			 break;
			 
		 case 9 :
			 break;
			 
		 case 10 :
			 break;
			 
		 case 11 :
			 break;
			 
		 case 12 :
			 break;
			 
		 case 13 :
			 break;
			 
		 case 14 :
			 break;
			 
		 case 15 :
			 break;
			 
		 case 16 :
			 break;
		 }
	
		} while(choice!=16);
		

		 FileLogger logger = FileLogger.getLogger();
		    logger.log("Creating user list");
		   
		    
		    getAllUsers();
		    getAllBooks();
		    
		    
		    
		  
		
//		    bookAPI.addBook("Adventures", "2018", "J.K Rowling");
//		    bookAPI.addBook("Summer", "2010", "M. Donoval");
//		    bookAPI.addBook("Rush Hour", "2008", "Julie Halligan");
		    
		    
		   
//		    Collection<Book> book = bookAPI.getBook();
//		    System.out.println("This prints All Book " + book);
//		    
//		    Book myBook = bookAPI.getBookbytitle("Wicked");
//		    System.out.println("this prints the Book Title " + myBook);
//		    bookAPI.removeBook(2L);
//		    //bookAPI.addBook("Rat Tail", "2002", "Ola Bartos");
//		    
//		    System.out.println("Deleted Book " + book);
//		    
//			   
//		    
////		    bookAPI.addUser("Eoin", "Kelly", 20, 'M', "Programmer");
////		    bookAPI.addUser("Ola", "Bartos", 20, 'F', "tattooer");
////		    bookAPI.addUser("Andis", "Zeibots", 20, 'M', "Gamer");
//
//
		    Collection<User> book1 = bookAPI.getUser();
		    System.out.println(book1);
		    bookAPI.removeUser(3L);
//		    
//		    System.out.println(book1);
//		    
//		    logger.log("Serializing contacts to XML");
//		    XStream xstream = new XStream(new DomDriver());
//		    ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("users.xml"));
//		    out.writeObject(book);
//		    out.close();    
//
//		    logger.log("Finished - shutting down");
	}
	
	public static void menu()
	{
		System.out.println("1. View all users.");
		System.out.println("2. Find user by ID.");
		System.out.println("3. Create new user.");
		System.out.println("4. Remove a user by ID.");
		System.out.println("5. View all books.");
		System.out.println("6. Find a book by title.");
		System.out.println("7. Add a book.");
		System.out.println("8. Remove a book by ID.");
		System.out.println("9. Top 10 books.");
		System.out.println("10. View user ratings.");
		System.out.println("11. View book ratings.");
		System.out.println("12. Add rating.");
		System.out.println("13. Remove rating.");
		System.out.println("14. Recommendation");
		System.out.println("15.");
		System.out.println("16. Exit.");
	}
	
	public static void getSingleUser() 
	{
		 System.out.println("Please enter the id of the persome you want to remove");
		 Long id = userInput.nextLong();
		User user= bookAPI.getUserById(id);
		System.out.println(user);
	}
	
	public void createUser(String fName, String lName, String age, String gender, String job)
	{
		bookAPI.addUser(fName, lName, age, gender, job);
	}
	
	public static void removeUser() {
		 System.out.println("Please enter the id of the persome you want to remove");
		 Long id = userInput.nextLong();
		 bookAPI.removeUser(id);
		 
	}
	
	public static void getAllUsers ()
	{
	TreeSet<User> sortedUser = new TreeSet<User>();
	sortedUser.addAll(bookAPI.getUser());
	
	Iterator<User> loop = sortedUser.iterator();
	while(loop.hasNext()) {
		User user = loop.next();
		System.out.println(user.fName + "" + user.lName);
	}
	}
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
}
