class Room {
    String occupant;
    Room nextRoom;
}

public class Hotel4 {

    static Room front, rear;

    public static void main (String[] argv)
    {
	makeList ();
	remove ("Galen");
	addToList ("Hector");
	printList ();
    } //end-main


    static void remove (String name)
    {
	Room pointer = front;
	
	// In case the name is not in the list
	boolean onList = false;
	while (pointer != null) {
	    if ( pointer.occupant.equals (name) ) {
		onList = true;
		break;
	    }
	    pointer = pointer.nextRoom;
	}
	if ( !onList ) {
	    System.out.println (name + " is not on the list.");
	    return;
	}

	// In case name is in first object
	if ( front.occupant.equals(name) ) {
	    front = front.nextRoom;
	    return;
	}

	// In other cases
	pointer = front;
	while (pointer != null) {
	    if (pointer.occupant.equals(name)) {
		break;
	    }
	    pointer = pointer.nextRoom;
	}

	Room predPointer = front;
	while (predPointer.nextRoom != pointer) {
	    //System.out.println ("predPointer.occupant=" + predPointer.occupant  + " predPointer=" + predPointer);
	    predPointer = predPointer.nextRoom;
	}

	// Remove the object with "name" by
	// connecting predPoint to the object following name
	predPointer.nextRoom = pointer.nextRoom;


	// In case, the last object is removed.
	if (predPointer.nextRoom == null) {
	    rear = predPointer;
	}
	
    } // end-remove()

    
    static void predecessorPrint (String name)
    {

	// In case the name is not in the list
	Room pointer = front;
	
	boolean onList = false;
	while (pointer != null) {
	    if ( pointer.occupant.equals (name) ) {
		onList = true;
		break;
	    }
	    pointer = pointer.nextRoom;
	}
	if ( !onList )
	{
	    System.out.println (name + " is not on the list.");
	    return;
	}

	// In case, the name is first and there is no predecessor
	if ( front.occupant.equals(name) ) {
	    System.out.println (name + " is the first in the list and has no predecessors.");
	    return;
	}
	
	pointer = front;
	while (pointer != null) {
	    if (pointer.occupant.equals (name)) {
		break;
	    }
	    pointer = pointer.nextRoom;
	}

	Room predPointer = front;
	while (predPointer.nextRoom != pointer) {
	    //System.out.println ("predPointer.occupant=" + predPointer.occupant  + " predPointer=" + predPointer);
	    predPointer = predPointer.nextRoom;
	}

	System.out.println ("Predecessor to " + name + " is " + predPointer.occupant);
    }

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
