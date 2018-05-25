import java.util.ArrayList;
import java.util.Arrays;

public class bella {
	private String encryptedMessage;
	private String message;
	private ArrayList<String> abcBella = new ArrayList<String>();

	public bella(String m, String c) {
		abcBella = new ArrayList<String>(Arrays.asList("^", "!", ")", "%", "(", "~", "+", "?", ",", ".", ";", "&", "$",
				"*", "`", "|", "#", "}", "-", "_", "=", ":", "/", "<", "{", ">"));
		encryptedMessage = c;
		message = m;

		if (m.length() > 0 && c.length() == 0) {
			message = m.toUpperCase();
			encryptedMessage = encrypt();
		} else if (m.length() == 0 && c.length() > 0) {
			encryptedMessage = c;
			message = decrypt();
		} else if (!m.equals("") && !c.equals("")) {
			encryptedMessage = c;
			message = m;
		} else {
			encryptedMessage = c.toUpperCase();
			message = m.toUpperCase();
		}
	}

	public String encrypt() {
		String e = "";
		if (encryptedMessage.length() == 0) {
			alphabet abc = new alphabet();
			for (int i = 0; i < message.length(); i++) {
				String m = message.substring(i, i + 1);
				int ind = abc.indexOf(m);
				if (ind != -1) {
					String l = abcBella.get(ind);
					e = e + l;
				} else {
					e = e + m;
				}
			}
		} 
		else {
			e = encryptedMessage;
		}
		return e;
	}

	public String decrypt() {
		String d = "";
		if (message.length()==0) {
			alphabet abc = new alphabet();
			for (int i = 0; i<encryptedMessage.length(); i++) {
				String m = encryptedMessage.substring(i, i+1);
				int ind = abcBella.indexOf(m);
				if (ind != -1) {
					String l = abc.get(ind);
					d = d + l;
				}
				else {
					d = d + m;
				}
			}
		}
		else {
			d = message;
		}
		return d;
	}

	public String toString() {
		return message + " = " + encryptedMessage;
	}

}
