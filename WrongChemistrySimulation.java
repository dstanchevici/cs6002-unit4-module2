
import java.util.*;

class Molecule {
    double x,y;     // It's location in space.
}

public class WrongChemistrySimulation {

    static double gridSize = 10;         // 10 x 10 box.
    static double reactDistance = 1;     // If two molecules are within 1,
                                         // they can react.

    // One linked list for each type of molecule:
    static LinkedList<Molecule> typeA, typeB, typeC;

    public static void main (String[] argv)
    {
	DrawTool.display ();
	DrawTool.setXYRange (0, gridSize, 0, gridSize);
	DrawTool.startAnimationMode ();

	// Initial number of type A, type B, and type C molecules:
	initialize (10, 10, 10);

	int numSteps = 100;

	for (int step=1; step<=numSteps; step++) {
	    DrawTool.writeTopString ("Step: " + step);
	    move ();
	    react ();
	    draw ();
	    DrawTool.animationPause (100);
	}	
	DrawTool.endAnimationMode ();
    }

    static void move ()
    {
	// Each molecule of the three types is moved randomly a short distance.
	for (Molecule a: typeA) {
	    moveRandom (a);
	}

	for (Molecule b: typeB) {
	    moveRandom (b);
	}

	for (Molecule c: typeC) {
	    moveRandom (c);
	}
    }


    static void react ()
    {
	// This version of react() is different, as we'll see.
	// We are not creating a "removal list".

	for (Molecule c: typeC) {
	    boolean react = false;
	    for (Molecule a: typeA) {
		if (isClose(c,a)) {
		    react = true;
		    break;
		}
	    }

	    if (react) {
		// Create a red and green.
		Molecule a = new Molecule ();
		setRandomLocation (a);
		typeA.add (a);

		Molecule g = new Molecule ();
		setRandomLocation (g);
		typeB.add (g);
	    
		// Remove the yellow one. (DANGER!)
		typeC.remove (c);
	    }
	}

	// Now we'll deal with the reds (typeA) and greens (typeB)

	for (Molecule a: typeA) {
	    Molecule b = null;
	    for (Molecule b2: typeB) {
		if (isClose(a,b2)) {
		    b = b2;
		    break;
		}
	    }
	    if (b != null) {
		// They form a type C
		Molecule c = new Molecule ();
		setRandomLocation (c);
		typeC.add (c);
		typeA.remove (a);          // DANGER!
		typeB.remove (b);
	    }
	}
    }

    //-------------------- the rest is the same (below) ----------------

    static void draw ()
    {
	for (Molecule a: typeA) {
	    DrawTool.setCircleColor ("red");
	    DrawTool.drawCircle (a.x,a.y,0.1);
	}

	for (Molecule b: typeB) {
	    DrawTool.setCircleColor ("green");
	    DrawTool.drawCircle (b.x,b.y,0.1);
	}

	for (Molecule c: typeC) {
	    DrawTool.setCircleColor ("yellow");
	    DrawTool.drawCircle (c.x,c.y,0.1);
	}
    }

    static boolean isClose (Molecule m1, Molecule m2) 
    {
	if (distance(m1.x,m1.y,m2.x,m2.y) < reactDistance) {
	    return true;
	}
	else {
	    return false;
	}
    }

    static void moveRandom (Molecule m)
    {
	Random r = new Random ();
	double sign = 1;
	if (r.nextDouble() < 0.5) {
	    sign = -1;
	}
	double tempX = m.x + sign*0.1;
	if ( (tempX > 0) && (tempX < gridSize) ) {
	    m.x = tempX;
	}
	sign = 1;
	if (r.nextDouble() < 0.5) {
	    sign = -1;
	}
	double tempY = m.y + sign*0.1;
	if ( (tempY > 0) && (tempY < gridSize) ) {
	    m.y = tempY;
	}
    }

    static void initialize (int numA, int numB, int numC)
    {
	typeA = new LinkedList<>();
	typeB = new LinkedList<>();
	typeC = new LinkedList<>();
	for (int i=0; i<numA; i++) {
	    Molecule a = new Molecule ();
	    setRandomLocation (a);
	    typeA.add (a);
	}

	for (int i=0; i<numB; i++) {
	    Molecule b = new Molecule ();
	    setRandomLocation (b);
	    typeB.add (b);
	}

	for (int i=0; i<numC; i++) {
	    Molecule c = new Molecule ();
	    setRandomLocation (c);
	    typeC.add (c);
	}
	
    }

    static void setRandomLocation (Molecule m)
    {
	Random r = new Random ();
	m.x = gridSize * r.nextDouble ();
	m.y = gridSize * r.nextDouble ();
    }

    static double distance (double x1, double y1, double x2, double y2)
    {
	return Math.sqrt ((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }

}
