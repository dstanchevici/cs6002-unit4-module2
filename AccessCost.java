// Unit 4, Module 2, ex. 2.33

import java.util.*;

public class AccessCost {

    public static void main (String[] argv)
    {
	LinkedList<Integer> list = new LinkedList<> ();
	for (int i=0; i<100000; i++) {
	    list.add (i);
	}

	long start = System.currentTimeMillis ();
	double s = 0;
	for (int K: list) {
	    s += K;
	}
	long end = System.currentTimeMillis ();
	System.out.println ("Iterator time: " + (end-start));

	start = System.currentTimeMillis ();
	s = 0;
	for (int i=0; i<list.size(); i++) {
	    int K = list.get (i);
	    s += K;
	}
	end = System.currentTimeMillis ();
	System.out.println ("Get-loop time: " + (end-start));
    }

}
