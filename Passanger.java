package Assignment1Algo;

//Title: Passanger class
//Author: Yousef Ghadri
//Description: Represents a passenger class with a ticket type and priority; Inherits from Person.

public class Passanger extends Person {
	private String ticket; // economy, economy-premium, business
	private int priority;

	// Summary: Constructor for Passanger class.
	// Precondition: name, ID, ticket, and priority should be provided.
	// Postcondition: Creates a Passanger object with given attributes.
	public Passanger(String name, long ID, String ticket, int priority) {
		super(name, "passanger", ID);
		this.ticket = ticket;
		this.priority = priority;
	}

	// setters and getters for better code maintainability and safety
	public String getTicket() {
		return ticket;
	}

	public int getPriority() {
		return priority;
	}

}
