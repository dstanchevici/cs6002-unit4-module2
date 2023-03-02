class ListItem {
    String data;
    ListItem next;
}

public class ListRemovalExample2 {

    static ListItem front, rear;

    public static void main (String[] argv)
    {
	makeList ();
	printList ();
	System.out.println ("**** Get Element ***");
	System.out.println ("3rd element: " + get(2));
	System.out.println ("**** Remove Someone Not On List ***");
	remove ("Sarah");
	remove ("Felix");
	remove ("Aiko");
	remove ("Galen");
	addToList ("Hector");
	printList ();
	
    } //end-main

    static String get (int x)
    {
	ListItem pointer = front;
	for (int i=1; i <= x; i++) {
	    pointer = pointer.next;
	}
	return pointer.data;
    }
    
    static void remove (String name)
    {
	ListItem pointer = front;
	
	// In case the name is not in the list
	boolean onList = false;

	// Revised to eliminate break from while.
	while ( (pointer != null) && (!onList) ) {
	    if ( pointer.data.equals (name) ) {
		onList = true;
		//break;
	    }
	    pointer = pointer.next;
	}
	if ( !onList ) {
	    System.out.println (name + " is not on the list.");
	    return;
	}

	// In case name is in first object
	if ( front.data.equals(name) ) {
	    front = front.next;
	    return;
	}

	// In other cases
	pointer = front;
	// Revised to eliminate break from while
	while ( (pointer != null) &&  (!pointer.data.equals(name)) ) {
	    /*
	    if (pointer.data.equals(name)) {
		break;
	    }
	    */
	    pointer = pointer.next;
	}

	ListItem predPointer = front;
	while (predPointer.next != pointer) {
	    //System.out.println ("predPointer.data=" + predPointer.data  + " predPointer=" + predPointer);
	    predPointer = predPointer.next;
	}

	// Remove the object with "data" by
	// connecting predPoint to the object following data
	predPointer.next = pointer.next;


	// In case, the last object is removed.
	if (predPointer.next == null) {
	    rear = predPointer;
	}
	
    } // end-remove()

    
    static void predecessorPrint (String name)
    {

	// In case the data is not in the list
	ListItem pointer = front;
	
	boolean onList = false;
	while (pointer != null) {
	    if ( pointer.data.equals (name) ) {
		onList = true;
		break;
	    }
	    pointer = pointer.next;
	}
	if ( !onList )
	{
	    System.out.println (name + " is not on the list.");
	    return;
	}

	// In case, the data is first and there is no predecessor
	if ( front.data.equals(name) ) {
	    System.out.println (name + " is the first in the list and has no predecessors.");
	    return;
	}
	
	pointer = front;
	while (pointer != null) {
	    if (pointer.data.equals (name)) {
		break;
	    }
	    pointer = pointer.next;
	}

	ListItem predPointer = front;
	while (predPointer.next != pointer) {
	    //System.out.println ("predPointer.data=" + predPointer.data  + " predPointer=" + predPointer);
	    predPointer = predPointer.next;
	}

	System.out.println ("Predecessor to " + name + " is " + predPointer.data);
    }

    static void printList ()
    {
	System.out.println ("**** Print List ***");
	ListItem pointer = front;
	while (pointer != null) {
	    System.out.println (pointer.data);
	    pointer = pointer.next;
	}
    }

    static void printUpTo (String name) {

	ListItem pointer = front;
	while (pointer != null) {
	    System.out.println (pointer.data);
	    if (pointer.data == name) {
		return;
	    }
	    pointer = pointer.next;
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
	    front = rear = new ListItem ();
	    front.data = name;
	    return;
	}

	rear.next = new ListItem ();
	rear = rear.next;
	rear.data = name;
	return;
    }


} // end-Hotel
