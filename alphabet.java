import java.util.*;
public class alphabet {
	//this class was made to reduce redundacy in the long run. with it you can creat an arraylist that contains the alphabet, 
	//reverse the alphabet in the arraylist,get the index of a letter in the arraylist, print the alphabet with just ',' seperating letters
	//get a letter in the arraylist
	private ArrayList<String> abc = new ArrayList<String>();
	public alphabet() {
		abc = new ArrayList<String> (Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
	}
	public void reverse() {
		for (int i = 0; i<13;i++) {
			String temp = abc.get(i);
			abc.set(i, abc.get(25-i));
			abc.set(25-i, temp);
		}
		
	}
	public int indexOf(String a) {
		//gets the index of a letter
		int index = abc.indexOf(a);
		return index;
	}
	
	public String get(int index) {
		//get a letter in arraylist with index
		String a = abc.get(index);
		return a;
	}
	
	public String toString() {
		//print arraylist with ',' seperating each letter
		String str = abc.get(0);
		for (int i=1; i<abc.size(); i++) {
			str = str + ", " + abc.get(i);
		}
		return str;
	}

}
