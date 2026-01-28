package Assignment1Algo;
//Title: SLinkedList class

//Author: Yousef Ghadri
//Description: A singly linked list that can store both Person objects (Passanger, Cabin_Crew)
//and SLinkedList objects. Insertion order depends on object type (priority, credit, or ID).

public class SLinkedList {
	private Node head;

	// Checks if the list is empty.
	public boolean isEmpty() {
		return head == null;
	}

	public Node getHead() {
		return head;
	}

	// Summary: Inserts an item (SLinkedList, Passanger, Cabin_Crew, or Person)
	// Precondition: Object must be one of the allowed types.
	// Postcondition: Inserts into the list in the proper position based on type.
	public void insert(Object item) {// Body of the function
		if (item instanceof SLinkedList) {
			insertListAtEnd((SLinkedList) item);
		} else if (item instanceof Passanger) {
			insertPassanger((Passanger) item);
		} else if (item instanceof Cabin_Crew) {
			insertCrew((Cabin_Crew) item);
		} else if (item instanceof Person) {
			insertPersonById((Person) item);
		}
	}

	// Summary: Prints all nodes in the list.
	// Precondition: The list may contain Person or SLinkedList objects.
	// Postcondition: Displays each element’s information on screen.
	public void displayList() {// Body of the function
		Node current = head;
		while (current != null) {
			Object data = current.getData();
			if (data instanceof Passanger) {
				Passanger passenger = (Passanger) data;
				System.out.println(
						"Name: " + passenger.getName() + ", Type: " + passenger.getType() + ", ID: " + passenger.getID()
								+ " Ticket: " + passenger.getTicket() + ", Priority: " + passenger.getPriority());
			} else if (data instanceof Cabin_Crew) {
				Cabin_Crew crewMember = (Cabin_Crew) data;
				System.out.println("Name: " + crewMember.getName() + ", Type: " + crewMember.getType() + ", ID: "
						+ crewMember.getID() + " Job: " + crewMember.getJob() + ", Credit: " + crewMember.getCredit());
			} else if (data instanceof Person) {
				Person passenger = (Person) data;
				System.out.println("Name: " + passenger.getName() + ", Type: " + passenger.getType() + ", ID: "
						+ passenger.getID());
			} else if (data instanceof SLinkedList) {
				((SLinkedList) data).displayList();
			}
			current = current.getNext();
		}
	}

	// Summary: Deletes all people with the given ID from this list.
	// Precondition: The list may contain Person type nodes.
	// Postcondition: All nodes with matching ID are removed.
	public void deleteByID(long id) {// Body of the function
		while (head != null && head.getData() instanceof Person && ((Person) head.getData()).getID() == id) {
			head = head.getNext();
		}
		Node current = head;
		while (current != null && current.getNext() != null) {
			Object nd = current.getNext().getData();
			if (nd instanceof Person && ((Person) nd).getID() == id) {
				current.setNext(current.getNext().getNext());
			} else {
				current = current.getNext();
			}
		}
	}

	// Summary:Deletes all people with the given ID in each sublist of list_of_lists.
	// Precondition:listOfLists contains SLinkedList objects.
	// Postcondition:all matching people are deleted from every sublist.
	public static void deleteAllInSubLists(SLinkedList listOfLists, long id) {// Body of the function
		Node current = listOfLists.getHead();
		while (current != null) {
			Object d = current.getData();
			if (d instanceof SLinkedList) {
				((SLinkedList) d).deleteByID(id);
			}
			current = current.getNext();
		}
	}

	// Summary: Combines all four sublists into one list sorted by ascending ID.
	// Precondition: listOfLists contains four SLinkedList objects in order.
	// Postcondition: Returns a new list containing all Person objects sorted by ID.
	public static SLinkedList combineAllById(SLinkedList allLists) {
	    SLinkedList combinedList = new SLinkedList();

	    // Go through each sublist in the main list
	    Node currentListNode = allLists.getHead();
	    while (currentListNode != null) {
	        Object sublistData = currentListNode.getData();

	        if (sublistData instanceof SLinkedList) {
	            SLinkedList sublist = (SLinkedList) sublistData;
	            Node currentNode = sublist.getHead();

	            // Go through each person in the sublist
	            while (currentNode != null) {
	                Object personData = currentNode.getData();
	                if (personData instanceof Person) {
	                    combinedList.insert((Person) personData); // Insert sorted by ID
	                }
	                currentNode = currentNode.getNext();
	            }
	        }
	        currentListNode = currentListNode.getNext();
	    }

	    return combinedList;
	}

	// Inserts a sublist to the end of this list.
	// Precondition: list is a valid SLinkedList object.
	// Postcondition: New node containing the list is appended at the end.
	private void insertListAtEnd(SLinkedList list) {// Body of the function
		Node newNode = new Node(list);
		if (head == null) {
			head = newNode;
			return;
		}
		Node current = head;
		while (current.getNext() != null)
			current = current.getNext();
		current.setNext(newNode);
	}

	// Summary: Inserts a Passanger object in ascending order by priority.
	// Precondition: passenger is not null.
	// Postcondition: The list remains sorted by priority.
	private void insertPassanger(Passanger passenger) {// Body of the function
		Node newNode = new Node(passenger);
		if (head == null || (head.getData() instanceof Passanger
				&& ((Passanger) head.getData()).getPriority() > passenger.getPriority())) {
			newNode.setNext(head);
			head = newNode;
			return;
		}
		Node current = head;
		while (current.getNext() != null) {
			Object nextData = current.getNext().getData();
			if (!(nextData instanceof Passanger))
				break;
			if (((Passanger) nextData).getPriority() > passenger.getPriority())
				break;
			current = current.getNext();
		}
		newNode.setNext(current.getNext());
		current.setNext(newNode);
	}

	// Summary: Inserts a Cabin_Crew object in ascending order by credit.
	// Precondition: crew is not null.
	// Postcondition: The list remains sorted by credit.
	private void insertCrew(Cabin_Crew crew) {// Body of the function
		Node newNode = new Node(crew);
		if (head == null || (head.getData() instanceof Cabin_Crew
				&& ((Cabin_Crew) head.getData()).getCredit() > crew.getCredit())) {
			newNode.setNext(head);
			head = newNode;
			return;
		}
		Node current = head;
		while (current.getNext() != null) {
			Object nextData = current.getNext().getData();
			if (!(nextData instanceof Cabin_Crew))
				break;
			if (((Cabin_Crew) nextData).getCredit() > crew.getCredit())
				break;
			current = current.getNext();
		}
		newNode.setNext(current.getNext());
		current.setNext(newNode);
	}

	// Summary: Inserts a Person object in ascending order by ID.
	// Precondition: person is not null.
	// Postcondition: The list remains sorted by ID.
	private void insertPersonById(Person person) {// Body of the function
		Node newNode = new Node(person);
		if (head == null || (head.getData() instanceof Person && ((Person) head.getData()).getID() > person.getID())) {
			newNode.setNext(head);
			head = newNode;
			return;
		}
		Node current = head;
		while (current.getNext() != null) {
			Object nextData = current.getNext().getData();
			if (!(nextData instanceof Person))
				break;
			if (((Person) nextData).getID() > person.getID())
				break;
			current = current.getNext();
		}
		newNode.setNext(current.getNext());
		current.setNext(newNode);
	}
}
