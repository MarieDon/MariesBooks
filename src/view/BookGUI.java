package view;

import java.io.File;
import java.util.Iterator;
import java.util.TreeSet;
import bookapi.controller.BookRecommenderAPI;
import bookapi.controller.EasyScanner;
import bookapi.models.Book;
import bookapi.models.User;
import utils.Serializer;
import utils.XMLSerializer;

public class BookGUI {
	public BookRecommenderAPI bookAPI = new BookRecommenderAPI();
	public Long id;

	// Make a constructor of the BookGUI class to load the users.xml file 
	//for reading and writing
	public BookGUI() throws Exception {
		File book = new File("./files/users.xml");
		Serializer serializer = new XMLSerializer(book);
		bookAPI = new BookRecommenderAPI(serializer);
		if (book.isFile()) {
			bookAPI.load();
		}
	}

	public static void main(String[] args) throws Exception {
		BookGUI myBook = new BookGUI();
		int choice;
		System.out.println("Please select one of the following options.");
		myBook.menu();
		do {
			choice = EasyScanner.nextInt();
			
			switch (choice) {
			case 0:
				myBook.bookAPI.loadData();
				System.out.println("Data was loded successfully");
				break;
				
			case 1:
				myBook.getAllUsers();
				break;

			case 2:
				myBook.getSingleUser();
				break;

			case 3:
				myBook.addUserToSystem();
				break;

			case 4:
				myBook.removeUser();
				break;

			case 5:
				break;

			case 6:
				break;

			case 7:
				break;

			case 8:
				break;

			case 9:
				break;

			case 10:
				break;

			case 11:
				break;

			case 12:
				break;

			case 13:
				break;

			case 14:
				break;

			case 15:
				break;

			case 16:
				break;
			}

		} while (choice != 16);

		
		
		//When user enters 16 into the menu the file gets saved
		myBook.bookAPI.store();


//		myBook.getAllUsers();
//		myBook.getAllBooks();

		// bookAPI.addBook("Adventures", "2018", "J.K Rowling");
		// bookAPI.addBook("Summer", "2010", "M. Donoval");
		// bookAPI.addBook("Rush Hour", "2008", "Julie Halligan");

		// Collection<Book> book = bookAPI.getBook();
		// System.out.println("This prints All Book " + book);
		//
		// Book myBook = bookAPI.getBookbytitle("Wicked");
		// System.out.println("this prints the Book Title " + myBook);
		// bookAPI.removeBook(2L);
		// //bookAPI.addBook("Rat Tail", "2002", "Ola Bartos");
		//
		// System.out.println("Deleted Book " + book);
		//
		//
		//
		//// bookAPI.addUser("Eoin", "Kelly", 20, 'M', "Programmer");
		//// bookAPI.addUser("Ola", "Bartos", 20, 'F', "tattooer");
		//// bookAPI.addUser("Andis", "Zeibots", 20, 'M', "Gamer");
		//
		//
		
	}


	/*
	 * Print a menu to the screen
	 */
	public void menu() {
		System.out.println("0. Load Data From File");
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
	
	/*
	 * Get all user and sort them alphabetical order of the first name 
	 */
	public void getAllUsers() {
		TreeSet<User> sortedUser = new TreeSet<User>();
		sortedUser.addAll(bookAPI.getUser());
		Iterator<User> loop = sortedUser.iterator();
		while (loop.hasNext()) {
			User user = loop.next();
			System.out.println(user.fName + " " + user.lName);
		}
	}

	/*
	 * Gets a single user depending on the number the user enters
	 */
	public void getSingleUser() { 
		System.out.println("Please enter the id of the persome you want to remove");
		id = EasyScanner.nextLong();
		User user = bookAPI.getUserById(id);
		if(user == null) {
			System.out.println("There is no user with that id please try again");
		}else {
			System.out.println(user);
		}
	}

	/*
	 * Add user to the system only if all field are filled in
	 */
	private void addUserToSystem() {
		System.out.println("Please add your first name");
		String fName = EasyScanner.nextString();
		
		System.out.println("Please enter your last name");
		String lName = EasyScanner.nextString();
		
		System.out.println("Please enter your");
		String age = EasyScanner.nextString();
		
		System.out.println("Please enter a gender");
		String gender = EasyScanner.nextString();
		
		System.out.println("Please enter a job title");
		String job = EasyScanner.nextString();
		
		//check to see if all fields are filled in by the user and if they are add user to system
		if(!fName.equals("") && !lName.equals("") && !age.equals("") && !gender.equals("") && !job.equals("")) {
			bookAPI.addUser(fName, lName, age, gender, job);
			System.out.println(fName +" " + lName + " Was added to the system" );
		}else {
			System.out.println("All filed must be filled in to add the person to the system");
		}
	}
	

	/*
	 * Delete a user from the system based on the id that is entered
	 */
	public void removeUser() {
		System.out.println("Please enter the id of the person you want to Delete from the system");
		id = EasyScanner.nextLong();
		User user = bookAPI.getUserById(id);
		
		//check to see if a user is found if the user is found then delete him 
		if(user != null) {
			System.out.println("The user " + user.getfName() + " " + user.getlName() +  " has been deleted");
			bookAPI.removeUser(id);
		}else {
			System.out.println("No user with that id is in the system");
		}
	}

	public void getAllBooks() {
		TreeSet<Book> sortedBooks = new TreeSet<Book>();
		sortedBooks.addAll(bookAPI.getBook());
		Iterator<Book> itBook = sortedBooks.iterator();

		while (itBook.hasNext()) {
			Book b = itBook.next();
			System.out.println(b.title);
		}
	}

	public void getbookById() {
		System.out.println("Please enter the id of the persome you want to remove");
		id = EasyScanner.nextLong();
		Book user = bookAPI.getBookById(id);
		System.out.println(user);
	}
}
