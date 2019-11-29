package application.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Artist {

	private IntegerProperty age, id;
	private StringProperty firstName, lastName;

	public Artist(int id,  String firstName, String lastName, int age) {
		this.age = new SimpleIntegerProperty(age);
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.id = new SimpleIntegerProperty(id);
	}

	@Override
	public String toString() {
		return "Artist [age=" + age.get() + ", id=" + id.get() + ", firstName=" + firstName.get() + ", lastName=" + lastName.get() + "]";
	}

	public int getAge() {
		return age.get();
	}

	public int getId() {
		return id.get();
	}

	public String getFirstName() {
		return firstName.get();
	}

	public String getLastName() {
		return lastName.get();
	}

	public void setAge(int age) {
		this.age.set(age);
	}

	public void setId(int id) {
		this.id.set(id);
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public StringProperty firstNameProperty() {
		return firstName;
	}

	public StringProperty lastNameProperty() {
		return lastName;
	}

	public IntegerProperty ageProperty() {
		return age;
	}

	public IntegerProperty idProperty() {
		return id;
	}

}
