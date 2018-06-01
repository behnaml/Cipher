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
			for (int i = 0; i < message.length(); i++) {
				String letter = message.substring(i, i+1);
				int placement = ABC.indexOf(letter);
				String other = words.get(placement);
				e += other + "-";
			}
			return e;
			// EXECUTED ENCRYPTION
		} else {
			// IF ALREADY DETERMINED, GET encryptedMessage
			return binarytype;
		}
	}

	public String decrypt() {
		String d = "";
		if (message.equals("")) {
			String x = binarytype;
			while(x.indexOf("-")!=-1) {
				String binumber = x.substring(0, x.indexOf("-"));
				int placement = words.indexOf(binumber);
				x = x.substring(binumber.length()+1);
					String other = ABC.get(placement)+(" ");
					d += other;
				
			}
			return d;
			// EXECUTE DECRYPTION
		} else {
			// IF ALREADY DETERMINED, GET message
			return message;
		}

	}

	public String toString() {
		return message + " = " + binarytype;
	}
}
