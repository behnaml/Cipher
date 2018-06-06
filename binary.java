import java.util.*;

public class binary {
	private String binarytype;
	private String message;
	private alphabet ABC = new alphabet();
	private ArrayList<String> numbers = new ArrayList<String>();

	public binary(String m, String c) {
		numbers = new ArrayList<String>(Arrays.asList("01000001", "01000010", "01000011", "01000100", "01000101",
				"01000110", "01000111", "01001000", "01001001", "01001010", "01001011", "01001100", "01001101",
				"01001110", "01001111", "01010000", "01010001", "01010010", "01010011", "01010100", "01010101",
				"01010110", "01010111", "01011000", "01011001", "01011010"));
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
						String other = numbers.get(placement);
						e +=  other;
					}
				}
				else {
				int placement = ABC.indexOf(that);
				String other = numbers.get(placement);
				e += other;
			}
				e += " ";
//			for (int i = 0; i < message.length(); i++) {
//				if (ABC.indexOf(message.substring(i, i+1))==-1) {
//					e += message.substring(i, i+1);
//				}
//				else {
//				String letter = message.substring(i, i+1);
//				int placement = ABC.indexOf(letter);
//				String other = numbers.get(placement);
//				e += other;
//			}
		}
			return e;
		}
			// EXECUTED ENCRYPTION
		else {
			// IF ALREADY DETERMINED, GET encryptedMessage
			return binarytype;
		}
	}
	public String decrypt() {
		String d = "";
		String[] newword = binarytype.split(" ");
		for (int i=0; i< newword.length; i++) {
			String that = newword[i];
			if (that.length()>8) {
				for (int j=0; j<that.length(); j+=8) {
					String subthis = that.substring(j, j+8);
					int placement = numbers.indexOf(subthis);
					String other = ABC.get(placement);
					d +=  other;
				}
			}
			else {
			int placement = numbers.indexOf(that);
			String other = ABC.get(placement);
			d += other;
		}
			d += " ";
		}
		if (message.equals("")) {
//			for (int i = 0; i < newword.length; i=i+8) {
//				if (!binarytype.substring(k, k+1).equals("0") || !binarytype.substring(k,k+1).equals("1")) {
//					d += binarytype.substring(k, k+1);
//					System.out.println(d);
//					k = k + 1;
//				}
				//ISSUE HERE
//				System.out.println(newword);
//				String binumber = binarytype.substring(k, k+8);
//				int placement = numbers.indexOf(binumber);
//				String other = ABC.get(placement);
//				d += other + " ";
//				k = k + 8;
//				}
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
