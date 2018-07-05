package bookapi.controller;

import java.util.Iterator;
import java.util.TreeSet;

import bookapi.models.User;

public class MenuSystem {

public BookRecommenderAPI menu = new BookRecommenderAPI();	
	
	public void getAllUsers ()
	{
	TreeSet<User> sortedUser = new TreeSet<User>();
	sortedUser.addAll(menu.getUser());
	Iterator<User> loop = sortedUser.iterator();
	while(loop.hasNext()) {
		User user = loop.next();
		System.out.println(user.fName + "" + user.lName);
	}
	}
	
	public void getSingleUser(Long id) 
	{
		User user= menu.getUserById(id);
		System.out.println(user);
	}
	
	public void createUser(String fName, String lName, String age, String gender, String job)
	{
		menu.addUser(fName, lName, age, gender, job);
	}
	
	public void getAllBooks ()
	{
	menu.getBook();
	}
	
	public void getAllRatings ()
	{
	menu.getRatings();
	}
}
