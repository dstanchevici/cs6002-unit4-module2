class ListItem {
    String data;
    ListItem next;
}

public class ListRemovalExample {

    static ListItem front, rear;

    public static void main (String[] argv)
    {
	makeList ();
	printList ();
	System.out.println ("**** Get Element ***");
	System.out.println ("3rd element: " + get(2));
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
    
    static void remove (String data)
    {
	ListItem pointer = front;
	
	// In case the data is not in the list
	boolean onList = false;
	while (pointer != null) {
	    if ( pointer.data.equals (data) ) {
		onList = true;
		break;
	    }
	    pointer = pointer.next;
	}
	if ( !onList ) {
	    System.out.println (data + " is not on the list.");
	    return;
	}

	// In case data is in first object
	if ( front.data.equals(data) ) {
	    front = front.next;
	    return;
	}

	// In other cases
	pointer = front;
	while (pointer != null) {
	    if (pointer.data.equals(data)) {
		break;
	    }
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

    
    static void predecessorPrint (String data)
    {

	// In case the data is not in the list
	ListItem pointer = front;
	
	boolean onList = false;
	while (pointer != null) {
	    if ( pointer.data.equals (data) ) {
		onList = true;
		break;
	    }
	    pointer = pointer.next;
	}
	if ( !onList )
	{
	    System.out.println (data + " is not on the list.");
	    return;
	}

	// In case, the data is first and there is no predecessor
	if ( front.data.equals(data) ) {
	    System.out.println (data + " is the first in the list and has no predecessors.");
	    return;
	}
	
	pointer = front;
	while (pointer != null) {
	    if (pointer.data.equals (data)) {
		break;
	    }
	    pointer = pointer.next;
	}

	ListItem predPointer = front;
	while (predPointer.next != pointer) {
	    //System.out.println ("predPointer.data=" + predPointer.data  + " predPointer=" + predPointer);
	    predPointer = predPointer.next;
	}

	System.out.println ("Predecessor to " + data + " is " + predPointer.data);
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

    static void printUpTo (String data) {

	ListItem pointer = front;
	while (pointer != null) {
	    System.out.println (pointer.data);
	    if (pointer.data == data) {
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


    static void addToList (String data)
    {
	if (front == null) {
	    front = rear = new ListItem ();
	    front.data = data;
	    return;
	}

	rear.next = new ListItem ();
	rear = rear.next;
	rear.data = data;
	return;
    }


} // end-Hotel
