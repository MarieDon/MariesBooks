import static org.junit.Assert.*;

import org.junit.Test;

import bookapi.models.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;


public class UserTests {

	User eoin = new User("Eoin", "Kelly", "38", "M", "Student");
	
	public static User[] users = { 
			new User("Eoin", "Kelly", "38", "M", "Student"),
			new User("Emma", "Martin", "32", "M", "Student") 
	};
	
	
	//Method to test the create function of users
	@Test
	public void testCreate() {
		assertEquals("Eoin", eoin.fName);
		assertEquals("Kelly", eoin.lName);
		assertEquals("38", eoin.age);
		assertEquals("M", eoin.gender);
		assertEquals("Student", eoin.job);
	}
	
	//Method to make sure users are different
	@Test
	public void testEquals() {
		User eoin = new User("Eoin", "Kelly", "38", "M", "Student");
		User emma = new User("Emma", "Martin", "31", "F", "Student");
		assertEquals(eoin, eoin);
		assertEquals(emma, emma);
		assertNotEquals(eoin, emma);
	}
	
	@Test
	  public void testIds()
	  {
	    Set<Long> ids = new HashSet<>();
	    for (User user : users)
	    {
	      ids.add(user.userID);
	    }
	    assertEquals (users.length, ids.size());
	  }
	
	//To String Test 
	@Test
	public void testToString() {
		assertEquals("User{" + eoin.userID + ", Eoin, Kelly, 38, M, Student}", eoin.toString());
	}
}
	
