package Assignment1Algo;

//Title: Person class
//Author: Yousef Ghadri
//Description: person class with a name, type, and ID.
public class Person {
	private String name;
	private String type;
	private long ID;
	// Summary: Constructor for Person.
    // Precondition: name, type, and ID must be provided.
    // Postcondition: Creates a new Person object.
	public Person(String name, String type, long ID) {
		this.name = name;
		this.type = type;
		this.ID = ID;
	}

	// setters and getters for better code maintainability and safety
	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public long getID() {
		return ID;
	}
}
