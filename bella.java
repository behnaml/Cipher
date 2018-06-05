import java.util.ArrayList;
import java.util.Arrays;

public class bella {
	private String encryptedMessage;
	private String message;
	private ArrayList<String> abcBella = new ArrayList<String>();

	public bella(String m, String c) {
		abcBella = new ArrayList<String>(Arrays.asList("^", "!", ")", "%", "(", "~", "+", "?", ",", ".", ";", "&", "$",
				"*", "`", "|", "#", "}", "-", "_", "=", ":", "/", "<", "{", ">")); //bella alphabet
		encryptedMessage = c;
		message = m;

		if (m.length() > 0 && c.length() == 0) { //if you have message, but not encrypted: find encrypted
			message = m.toUpperCase();
			encryptedMessage = encrypt();
		} else if (m.length() == 0 && c.length() > 0) { //if you have encrypted, but not reg: decrypt message
			encryptedMessage = c;
			message = decrypt();
		} else if (!m.equals("") && !c.equals("")) { //if you have both, set both
			encryptedMessage = c.toUpperCase();
			message = m.toUpperCase();
		} else { //if you have neither, set to "" and ""
			encryptedMessage = c.toUpperCase();
			message = m.toUpperCase();
		}
	}

	public String encrypt() {
		String e = "";
		if (encryptedMessage.length() == 0) { //if you have not yet encrypted, start encryption
			alphabet abc = new alphabet(); //reg alphabet 
			for (int i = 0; i < message.length(); i++) { //character by character
				String m = message.substring(i, i + 1); //chooses a single char
				int ind = abc.indexOf(m); //finds index of it in reg alphabet
				if (ind != -1) { //if in alphabet, find char at ind of Bella's Alphabet
					String l = abcBella.get(ind); //get char
					e = e + l;
				} else { //if empty add untranstlated char
					e = e + m;
				}
			}
		} 
		else { //if already encrypted get encryptedMessage
			e = encryptedMessage;
		}
		return e;
	}

	public String decrypt() {
		String d = "";
		if (message.length()==0) { //if empty
			alphabet abc = new alphabet(); //reg alphabet
			for (int i = 0; i<encryptedMessage.length(); i++) {
				String m = encryptedMessage.substring(i, i+1); //Char by Char
				int ind = abcBella.indexOf(m); //find index of char
				if (ind != -1) { //if in alphabet
					String l = abc.get(ind); //find char at said index in reg alphabet
					d = d + l;
				}
				else {
					d = d + m; //if empty add untranslated char
				}
			}
		}
		else {
			d = message;
		}
		return d;
	}

	public String toString() {
		return message + " = " + encryptedMessage; //toString format (message = $%^&*(_)
	}

}
