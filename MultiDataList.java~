// Unit 4, Module 2, ex. 2.26

class NameItem {
    String name;
    NameItem next;
}

class PointItem {
    double pointsPerGame;
    PointItem next;
}

public class WrongMultiData {

    static NameItem nameFront, nameRear;
    static PointItem pointFront, pointRear;

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
	if (nameFront == null) {
	    
	    nameFront = nameRear = new NameItem ();
	    nameFront.name = name;

	    pointFront = pointRear = new PointItem ();
	    pointFront.pointsPerGame = points;

	    return;
	}
	
	// Node for name list:
	NameItem n = new NameItem ();
	n.name = name;

	// Node for point list:
	PointItem p = new PointItem ();
	p.pointsPerGame = points;

	nameRear.next = n;
	nameRear = n;
	
	pointRear.next = p;
	pointRear = p;
	
    }

    static void printList ()
    {
	NameItem nPtr = nameFront;
	PointItem pPtr = pointFront;
	while (nPtr != null) {
	    System.out.println (nPtr.name + " has " + pPtr.pointsPerGame + " points.");
	    nPtr = nPtr.next;
	    pPtr = pPtr.next;
	}
    }

}
