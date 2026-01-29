# Passenger-crew-system-SLinkedList

an airline management system to manage passengers and
cabin crews; the system organizes data into 4 main singly linked lists economy, economy-premium,
business and cabin crew. Each list stores specific people objects and another list that holds the
sublists for the same operations. The passangers are sorted depending on their priority and the
cabin crew are sorted based on their credit score; the program enables you to insert, delete by ID,
print lists, and merge all lists into a sorted one depending on the ID.

Implementation and Functionality:
The program used OOP principles. The program included the following
classes and functionalities:
Person → super class, has the following attributes: name, ID and type.
Passanger → child class that inherits from Person and has (ticket) type and
(priority) level attributes.
Cabin_Crew → inherits from Person and adds (job) title and (credit) score
attributes.
Node → provides the structure for the linked list class.
SLinkedList → responsible for the operations and methods like insertion,
deletion, printing, and merging the lists.
Main → manages the user's input and the menu for the inputs and outputs.
The functionality of the insertion method: it identifies the object type and sorts it with the help of
instanceof to decide whether to compare priority or credit.
