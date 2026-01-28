package Assignment1Algo;

//Title: Main class
//Author: Yousef Ghadri
//Description: main program that manages passenger and cabin crew lists, allowing insertions, deletions, displays and list combination.
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// create 4 sublists and 1 list_of_lists
		SLinkedList economy = new SLinkedList();
		SLinkedList economyPremium = new SLinkedList();
		SLinkedList business = new SLinkedList();
		SLinkedList cabinCrew = new SLinkedList();

		SLinkedList list_of_lists = new SLinkedList();
		// insert the four sublists into list_of_lists
		list_of_lists.insert(economy);
		list_of_lists.insert(economyPremium);
		list_of_lists.insert(business);
		list_of_lists.insert(cabinCrew);
		// menu loop (:
		while (true) {
			System.out.println("Enter the operation:  ");
			System.out.println("1: Add a person");
			System.out.println("2: Print all the lists");
			System.out.println("3: Delete all the people with the given ID");
			System.out.println("4: Combine all the lists sorted by ID, print and then exit");

			String line = sc.nextLine().trim();
			if (line.length() == 0)
				continue;
			int option;
			try {
				option = Integer.parseInt(line);
			} catch (Exception e) {
				continue;
			}
			// Add person (passenger or cabin crew)
			if (option == 1) {
				System.out.println("Enter the name: ");
				String name = sc.nextLine().trim();

				System.out.println("Enter the ID: ");
				long id = Long.parseLong(sc.nextLine().trim());

				System.out.println("Enter the type (passanger or cabin-crew): ");
				String type = sc.nextLine().trim().toLowerCase();

				if (type.equals("passanger")) {
					System.out.println("Enter the ticket type (economy, economy-premium, business): ");
					String ticket = sc.nextLine().trim().toLowerCase();
					System.out.println("Enter the priority: ");
					int priority = Integer.parseInt(sc.nextLine().trim());
					Passanger passenger = new Passanger(name, id, ticket, priority);

					if (ticket.equals("economy"))
						economy.insert(passenger);
					else if (ticket.equals("economy-premium"))
						economyPremium.insert(passenger);
					else if (ticket.equals("business"))
						business.insert(passenger);
					else
						System.out.print("Invalid ticket type.");
				} else if (type.equals("cabin-crew")) {
					System.out.println("Enter the job: ");
					String job = sc.nextLine().trim();
					System.out.println("Enter the credit: ");
					double credit = Double.parseDouble(sc.nextLine().trim());
					Cabin_Crew cc = new Cabin_Crew(name, id, job, credit);
					cabinCrew.insert(cc);
				} else {
					System.out.println("Invalid type.");
				}
				System.out.println();
			} else if (option == 2) { // display all lists
				list_of_lists.displayList();
			} else if (option == 3) { // delete by ID in all lists
				System.out.println("Enter the ID to delete: ");
				long del = Long.parseLong(sc.nextLine().trim());
				SLinkedList.deleteAllInSubLists(list_of_lists, del);
			} else if (option == 4) { // combine and print
				SLinkedList combined = SLinkedList.combineAllById(list_of_lists);
				combined.displayList();
				System.out.println();
				break; // exit after printing list
			}
		}
	}
}
