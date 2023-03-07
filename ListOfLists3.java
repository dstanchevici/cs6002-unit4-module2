// Unit 4, Module 2, Ex. 2.29

import java.util.*;

class SubList {
    String title;
    LinkedList<String>items;
}

public class ListOfLists3 {

    public static void main (String[] argv)
    {
	SubList homework = new SubList ();
	homework.title = "Homework";
	homework.items = new LinkedList<>();
	homework.items.add ("CS-1112");
	homework.items.add ("Microbiology");
	homework.items.add ("Medieval history");
	homework.items.add ("Calculus");

	SubList chores = new SubList ();
	chores.title = "Chores";
	chores.items = new LinkedList<>();
	chores.items.add ("Laundry");
	chores.items.add ("Room clean up");
	chores.items.add ("Fix bike");

	SubList social = new SubList ();
	social.title = "Social";
	social.items = new LinkedList<>();
	social.items.add ("Call home");
	social.items.add ("Meet bae for lunch");
	social.items.add ("Blog about trip");

	SubList[] toDo = new SubList [3];
	toDo[0] = homework;
	toDo[1] = chores;
	toDo[2] = social;

	print (toDo);
    }

    static void print (SubList[] subListArray)
    {
	for (SubList sublist: subListArray) {
	    System.out.print (sublist.title + ": ");
	    for (String s: sublist.items) {
		System.out.print (" \'" + s + "\'");
	    }
	    System.out.println ();
	}
    }
    
}
