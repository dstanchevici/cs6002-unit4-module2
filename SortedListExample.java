public class SortedListExample {

    public static void main (String[] argv)
    {
	SortedList someNames = new SortedList ();
	someNames.add ("Jisoo");
	someNames.add ("Maija");
	someNames.add ("Yoram");
	someNames.add ("Fazia");
	someNames.add ("Kojo");
	someNames.add ("Jian");
	
	someNames.printList ();
	someNames.printReverse ();
    }
    
}
