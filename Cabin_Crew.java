package Assignment1Algo;

//Title: Cabin_Crew class
//Author: Yousef Ghadri
//Description: Represents a cabin crew member with a job title and credit score; Inherits from Person.
public class Cabin_Crew extends Person {
	private String job; // pilot, hostess, etc.
	private double credit;

	// Summary: Constructor for Cabin_Crew class.
	// Precondition: name, ID, job, and credit should be provided.
	// Postcondition: Creates a Cabin_Crew object with given attributes.
	public Cabin_Crew(String name, long ID, String job, double credit) {
		super(name, "cabin-crew", ID);
		this.job = job;
		this.credit = credit;
	}

	// setters and getters for better code maintainability and safety
	public String getJob() {
		return job;
	}

	public double getCredit() {
		return credit;
	}

}
