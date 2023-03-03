class ListItem {
    String data;
    ListItem next;
    ListItem prev;
}


public class DoublyLinkedRemoval {

    static ListItem front = null;
    static ListItem rear = null;

    public static void main (String[] argv)
    {
	makeList ();
	printReverse ();
	remove ("Felix");
	remove ("Aiko");
	remove ("Galen");
	printReverse ();
    }

    static void remove (String name)
    {
	/*** Node is in front ***/ 
	
	if ( front.data.equals(name) ){
	    front = front.next;
	    front.prev = null;
	    return;
	}

	
	/*** Node is in rear ***/ 
	
	if ( rear.data.equals(name) ){
	    rear = rear.prev;
	    rear.next = null;
	    return;
	}

	
	/*** Node is neither front nor rear ***/
	
	// Find node with name to be removed
	ListItem listPtr = front;
	while (listPtr != null) {
	    if (listPtr.data.equals(name)) {
		break;
	    }
	    listPtr = listPtr.next;
	}

	// Remove node be relinking adjacent nodes
	ListItem prevNode = listPtr.prev;
	ListItem nextNode = listPtr.next;
	prevNode.next = nextNode;
	nextNode.prev = prevNode;
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
