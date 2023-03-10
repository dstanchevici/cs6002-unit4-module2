class Room {
    String occupant;
    Room nextRoom;
}

public class Hotel {

    static Room front, rear;

    public static void main (String[] argv)
    {
	makeList ();
	printList ();
	System.out.println ("----");
	printUpTo ("Elsa");

    } //end-main


    static void printList ()
    {
	Room pointer = front;
	while (pointer != null) {
	    System.out.println (pointer.occupant);
	    pointer = pointer.nextRoom;
	}
    }

    static void printUpTo (String name) {

	Room pointer = front;
	while (pointer != null) {
	    System.out.println (pointer.occupant);
	    if (pointer.occupant == name) {
		return;
	    }
	    pointer = pointer.nextRoom;
	}

    }


    static void makeList ()
    {
	addToList ("Aiko");
	addToList ("Boris");
	addToList ("Caterina");
	addToList ("Dayo");
	addToList ("Elsa");
	addToList ("Felix");
	addToList ("Galen");
    }


    static void addToList (String name)
    {
	if (front == null) {
	    front = rear = new Room ();
	    front.occupant = name;
	    return;
	}

	rear.nextRoom = new Room ();
	rear = rear.nextRoom;
	rear.occupant = name;
	return;
    }


} // end-Hotel
