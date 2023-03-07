// Unit 4, Module 2, Ex. 2.28

import java.util.*;

class PlayerInfo {
    String name;
    double pointsPerGame;
}

public class MultiDataList2 {

    static LinkedList<PlayerInfo> players = new LinkedList<> ();
    
    public static void main (String[] argv)
    {
	addPlayer ("Kareem Abdul-Jabbar", 30.12);
	addPlayer ("Wilt Chamberlain", 30.07);
	addPlayer ("Elgin Baylor", 27.36);
	addPlayer ("LeBron James", 27.16);
	addPlayer ("Kevin Durant", 27.15);

	printList ();
	printList2 ();
	printList3 ();
    }

    static void addPlayer (String name, double points)
    {
	// Make an instance of the PlayerInfo object and
	// add it to list.
	PlayerInfo p = new PlayerInfo ();
	p.name = name;
	p.pointsPerGame = points;
	players.add (p);
    }

    static void printList ()
    {
	System.out.println ("--------");
	for (PlayerInfo p: players) {
	    System.out.println (p.name + " " + p.pointsPerGame);
	}
    }

    static void printList2 () {
	System.out.println ("--------");
	for (int i=0; i<players.size(); i++) {
	    System.out.println (players.get(i).name + " " + players.get(i).pointsPerGame);
	}
    }

    static void printList3 () {
	System.out.println ("--------");
	int i = 0;
	while ( i < players.size() ){
	    System.out.println (players.get(i).name + " " + players.get(i).pointsPerGame);
	    i++;
	}
    }
}
