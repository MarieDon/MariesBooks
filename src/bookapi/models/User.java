package bookapi.models;

import java.util.HashMap;
import java.util.Map;

public class User implements Comparable<User> {
	static Long counter = 01L;
	public String fName;
	public String lName;
	public String age;
	public String gender;
	public String job;
	public Long userID;
	public Map<Long, Ratings> UserRatings = new HashMap<>();

	// public User(String fName, String lName, int age, char gender, String job) {
	// this.userID = counter++;
	// this.fName = fName;
	// this.lName = lName;
	// this.age = age;
	// this.gender = gender;
	// this.job = job;
	// }

	public User(String fName, String lName, String age, String gender, String job) {
		this.userID = counter++;
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		this.gender = gender;
		this.job = job;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "User [fName=" + fName + ", lName=" + lName + ", age=" + age + ", gender=" + gender + ", job=" + job
				+ ", userID=" + userID + "]";
	}

	@Override
	public int compareTo(User user) {
		return this.fName.compareTo(user.fName);
	}

}
