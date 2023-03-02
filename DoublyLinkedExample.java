class ListItem {
    String data;
    ListItem next;
    ListItem prev;
}


public class DoublyLinkedExample {

    static ListItem front = null;
    static ListItem rear = null;

    public static void main (String[] argv)
    {
	makeList ();
	printList ();
	printReverse ();
	System.out.println ( "item #3: " + get(3) ); // I wonder if it's get(2)?
	// Note to grader: Is it get(2) or get (3)? What corresponds to item# 3?
	// In previous assignments: Item#3 was at get (2) (see ex. 2.13
	// where in ListRemovalExample:
	// 	System.out.println ("3rd element: " + get(2));)
    }

    static void printList ()
    {
	System.out.println ("List:");
	ListItem listPtr = front;
	while (listPtr != null) {
	    System.out.print (" " + listPtr.data);
	    listPtr = listPtr.next;
	}
	System.out.println ();
    }

    static void printReverse ()
    {
	System.out.println ("List in reverse:");
	ListItem listPtr = rear;
	while (listPtr != null) {
	    System.out.print (" " + listPtr.data);
	    listPtr = listPtr.prev;
	}
	System.out.println ();
    }

    static String get (int i)
    {
	ListItem listPtr = front;
	for (int j = 1; j <= i; j++) {
	    listPtr = listPtr.next;
	}
	return listPtr.data;
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

    static void addToList (String s)
    {
	if (front == null) {
	    front = rear = new ListItem ();
	    front.data = s;
	    rear.prev = null; // For clarity
	}
	else {
	    ListItem nextOne = new ListItem ();
	    nextOne.data = s;
	    nextOne.next = null; // For clarity
	    nextOne.prev = rear; // Backward link
	    rear.next = nextOne; // Forward link
	    rear = nextOne;
	}
    }
}
