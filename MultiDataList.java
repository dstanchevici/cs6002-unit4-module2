// Unit 4, Module 2, ex. 2.27

class MultiDataItem {
    String name;
    double pointsPerGame;
    MultiDataItem next;
}

public class MultiDataList {

    static MultiDataItem front, rear;

    public static void main (String[] argv)
    {
	addPlayer ("Kareem Abdul-Jabbar", 30.12);
	addPlayer ("Wilt Chamberlain", 30.07);
	addPlayer ("Elgin Baylor", 27.36);
	addPlayer ("LeBron James", 27.16);
	addPlayer ("Kevin Durant", 27.15);

	printList ();
    }

    static void addPlayer (String name, double points)
    {
	if (front == null) {
	    front = rear = new MultiDataItem ();
	    front.name = name;
	    front.pointsPerGame = points;

	    return;
	}
	
	MultiDataItem d = new MultiDataItem ();
	d.name = name;
	d.pointsPerGame = points;

	rear.next = d;
	rear = d;
    }

    static void printList ()
    {
	MultiDataItem listPtr = front;
	while (listPtr != null) {
	    System.out.println (listPtr.name + " has " + listPtr.pointsPerGame + " points.");
	    listPtr = listPtr.next;
	}
    }

}
