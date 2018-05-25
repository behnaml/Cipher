import java.util.*;

public class binary {
	private String binarytype;
	private String message;
	private alphabet ABC = new alphabet();
	private ArrayList<String> numbers = new ArrayList<String>();

	public binary(String m, String c) { // constructor
		numbers = new ArrayList<String>(Arrays.asList("01000001", "01000010", "01000011", "01000100", "01000101",
				"01000110", "01000111", "01001000", "01001001", "01001010", "01001011", "01001100", "01001101",
				"01001110", "01001111", "01010000", "01010001", "01010010", "01010011", "01010100", "01010101",
				"01010110", "01010111", "01011000", "01011001", "01011010")); // array to hold binary values in same pplace as alphabet in ABC array
		message = m; // m holds the regular alphabet message
		binarytype = c; // c holds the encrypted message
		if (c.equals("") && !m.equals("")) { // if c holds a message, run decrypt method
			message = m.toUpperCase();
			binarytype = encrypt();
		} else if (!c.equals("") && m.equals("")) { // if m holds a message, run the encrypt message
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

	public String encrypt() { // returns a decrypted message in binary form
		String e = "";
		if (binarytype.equals("")) {
			for (int i = 0; i < message.length(); i++) {
				String letter = message.substring(i, i+1);
				int placement = ABC.indexOf(letter);
				String other = numbers.get(placement);
				e += other;
			}
			return e;
			// EXECUTED ENCRYPTION
		} else {
			// IF ALREADY DETERMINED, GET encryptedMessage
			return binarytype;
		}
	}

	public String decrypt() { // decrypts an encrypted message
		String d = "";
		if (message.equals("")) {
			for (int k = 0; k < binarytype.length(); k=k+8) {
				String binumber = binarytype.substring(k, k+8);
				int placement = numbers.indexOf(binumber);
				String other = ABC.get(placement);
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
