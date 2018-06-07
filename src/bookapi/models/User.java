package bookapi.models;

public class User {
public String fName;
public String lName;
public int age;
public char gender;
public String job;
public Long userID;


public User(String fName, String lName, int age, char gender, String job, Long userID) {
	super();
	this.fName = fName;
	this.lName = lName;
	this.age = age;
	this.gender = gender;
	this.job = job;
	this.userID = userID;
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


public int getAge() {
	return age;
}


public void setAge(int age) {
	this.age = age;
}


public char getGender() {
	return gender;
}


public void setGender(char gender) {
	this.gender = gender;
}


public String getJob() {
	return job;
}


public void setJob(String job) {
	this.job = job;
}


@Override
public String toString() {
	return "User [fName=" + fName + ", lName=" + lName + ", age=" + age + ", gender=" + gender + ", job=" + job
			+ ", userID=" + userID + "]";
}


}


