package application.model;

public class Artist {

	private int age, id;
	private String firstName, lastName;
	public Artist(int age, String firstName, String lastName) {
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Artist [age=" + age + ", id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
