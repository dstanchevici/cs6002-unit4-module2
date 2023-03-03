class ListItem {
    String data;
    ListItem next;
    ListItem prev;
}

public class SortedList {

    ListItem front = null;
    ListItem rear = null;

    public void add (String s)
    {
	// Empty list
	if (front == null) {
	    front = rear = new ListItem ();
	    front.data = s;
	    return;
	}

	// Not empty
	
	// Find element before  which to insert new node
	ListItem listPtr = front;
	while ( (listPtr != null) && (listPtr.data.compareTo(s)<0) ) {
	    listPtr = listPtr.next;
	}
	
	// Make a new node and put s init
	ListItem nextOne = new ListItem ();
	nextOne.data = s;

	// Three cases
	
	// 1. Insert in front
	if (listPtr == front) {
	    nextOne.next = front;
	    front.prev = nextOne;
	    front = nextOne;
	}
	// 2. At rear
	else if (listPtr == null) {
	    nextOne.prev = rear;
	    rear.next = nextOne;
	    rear = nextOne;

	}
	// 3. In middle
	else {
	    //System.out.println ("---");
	    //System.out.println ("listPtr=" + listPtr.data);
	    //System.out.println ("nextOne=" + nextOne.data);
	    listPtr.prev.next = nextOne;
	    nextOne.prev = listPtr.prev;
	    listPtr.prev = nextOne;
	    nextOne.next = listPtr;
	}
	
	
    }

    public void printList ()
    {
	System.out.println ("List:");
	ListItem listPtr = front;
	while (listPtr != null) {
	    System.out.print (" " + listPtr.data);
	    listPtr = listPtr.next;
	}
	System.out.println ();
    }

    public void printReverse ()
    {
	System.out.println ("List in reverse:");
	ListItem listPtr = rear;
	while (listPtr != null) {
	    System.out.print (" " + listPtr.data);
	    listPtr = listPtr.prev;
	}
	System.out.println ();
    }

    
}
