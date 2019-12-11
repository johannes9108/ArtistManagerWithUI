package application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


@Entity
@Table(name="artists")
public class Artist {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int age;
	private String firstName;
	private String lastName;
	
	
	@Transient
	private IntegerProperty ageProperty;
	@Transient
	private IntegerProperty idProperty;
	@Transient
	private StringProperty firstNameProperty;
	@Transient
	private StringProperty lastNameProperty;

	public Artist(String firstName, String lastName, int age) {
		this.ageProperty = new SimpleIntegerProperty(age);
		this.firstNameProperty = new SimpleStringProperty(firstName);
		this.lastNameProperty = new SimpleStringProperty(lastName);
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Artist() {}
	@Override
	public String toString() {
		return "Artist [age=" + age + ", id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public int getAge() {
		return age;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setAge(int age) {
		this.ageProperty.set(age);
		this.age = age;
	}

	public void setId(int id) {
		if(this.idProperty==null)
			this.idProperty = new SimpleIntegerProperty(id);
		this.idProperty.set(id);
		this.id = age;
	}

	public void setFirstName(String firstName) {
		this.firstNameProperty.set(firstName);
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastNameProperty.set(lastName);
		this.lastName = lastName;
	}


//	public IntegerProperty aeProperty() {
//		return ageProperty;
//	}
//
//	public IntegerProperty Property() {
//		return idProperty;
//	}
//
//	public StringProperty firstNameProperty() {
//		return firstNameProperty;
//	}
//
//	public StringProperty lastNameProperty() {
//		return lastNameProperty;
//	}

}
