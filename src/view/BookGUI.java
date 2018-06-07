package view;

import java.util.ArrayList;
import java.util.List;

import bookapi.models.User;

public class BookGUI {

	public static void main(String[] args) {
		List<User> user = new ArrayList<User>();
		user.add(new User("Marie", "Donoval" , 20 , 'F', "waitress", 123l));
		System.out.println(user);
	}

}
