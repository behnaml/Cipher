import java.util.ArrayList;
import java.util.Arrays;

public class leila {
	private String binarytype;
	private String message;
	private alphabet ABC = new alphabet();
	private ArrayList<String> words = new ArrayList<String>();

	public leila(String m, String c) {
		words = new ArrayList<String>(Arrays.asList("dog", "slither.io", "java", "summer", "winter",
				"games", "food", "birthday", "thanksgiving", "clothes", "shoes", "vacations", "family",
				"friends", "cookies", "water", "ice", "beach", "hawaii", "house", "rain",
				"lucky", "traveling", "phone", "laptop", "ipad"));
		message = m;
		binarytype = c;
		if (c.equals("") && !m.equals("")) {
			message = m.toUpperCase();
			binarytype = encrypt();
		} else if (!c.equals("") && m.equals("")) {
			binarytype = c;
			message = decrypt();
		} else if (!m.equals("") && !c.equals("")) {
			binarytype = c;
			message = m;
		} else {
			binarytype = c.toUpperCase();
			message = m.toUpperCase();
		}
	}

	public String encrypt() {
		String e = "";
	if (binarytype.equals("")) {
		String[] newword = message.split(" ");
		for (int i=0; i< newword.length; i++) {
			String that = newword[i];
			if (that.length()>1) {
				for (int j=0; j<that.length(); j++) {
					String subthis = that.substring(j, j+1);
					int placement = ABC.indexOf(subthis);
					String other = words.get(placement);
					e +=  other;
				}
				}
		
			else {
			int placement = ABC.indexOf(that);
			String other = words.get(placement);
			e += other;
//			for (int i = 0; i < message.length(); i++) {
//				String letter = message.substring(i, i+1);
//				int placement = ABC.indexOf(letter);
//				String other = words.get(placement);
//				e += other + "-";
	}
			e += " ";
		}
	}
			// EXECUTED ENCRYPTION
			else {
			// IF ALREADY DETERMINED, GET encryptedMessage
			return binarytype;
		}
	return e;
	}

	public String decrypt() {
		String d = "";
		String newword[] = binarytype.split(" ");
		if (message.equals("")) {
			for(int i=0; i<newword.length; i++) {
			String that = newword[i];
					while (that.indexOf("-")!=-1) {
						String subthat = that.substring(0, that.indexOf("-"));
						int placement = words.indexOf(subthat);
						String other = ABC.get(placement);
						that = that.substring(that.indexOf("-")+1, that.length());
						d += other;
						System.out.println(d);
					}
						int placement = words.indexOf(that);
						String other = ABC.get(placement);
						d += other;
						d += " ";
				}
//			for(int i = 0; i<binarytype.length(); i++) {
//				String partial = binarytype.substring(i, binarytype.indexOf(" "));
//				String x = partial;
//			while(x.indexOf("-")!=-1) {
//				String binumber = x.substring(0, x.indexOf("-"));
//				System.out.println(binumber);
//				int placement = words.indexOf(binumber);
//				x = x.substring(binumber.length()+1);
//					String other = ABC.get(placement);
//					d += other;
//			}
//			}
		}
			// EXECUTE DECRYPTION
		 else {
			// IF ALREADY DETERMINED, GET message
			return message;
		}
		return d;

	}

	public String toString() {
		return message + " = " + binarytype;
	}
}
