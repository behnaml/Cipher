import java.util.*;
public class alphabet {
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
	public void bella() {
		
	}
	
	public void shift(int n) {
		for (int i = 0; i<n; i++) {
			for (int k = 0; k<26; k++) {
				String temp = abc.get(0);
				abc.remove(0);
				abc.add(temp);
			}
		}
	}
	public int indexOf(String a) {
		int index = abc.indexOf(a);
		return index;
	}
	
	public String get(int index) {
		String a = abc.get(index);
		return a;
	}
	
	public String toString() {
		String str = abc.get(0);
		for (int i=1; i<abc.size(); i++) {
			str = str + ", " + abc.get(i);
		}
		return str;
	}

}