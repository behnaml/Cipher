
public class atbash {
	// reverse the alphabet and translate (A=Z, B=Y...)
	private String encryptedMessage;
	private String message;

	public atbash(String m, String c) {
		encryptedMessage = "";
		message = "";

		if (m.length() > 0 && c.length() == 0) { // with message, but no encrypted message: solves for encrypted message
			message = m.toUpperCase();
			encryptedMessage = encrypt();
		} else if (m.length() == 0 && c.length() > 0) { // with encrypted message, but not original message: solves for
														// original
			encryptedMessage = c;
			message = decrypt();
		} else if (!m.equals("") && !c.equals("")) { // with both: sets both
			encryptedMessage = c;
			message = m;
		} else { // with neither: sets to empty
			encryptedMessage = "";
			message = "";
		}
	}

	public String encrypt() {
		// converts initial message to encrypted version
		String e = "";
		if (encryptedMessage.length() == 0) {
			// EXECUTE ENCRYPTION
			// Reverse the alphabet so that: A = Z and B = Y...
			alphabet a = new alphabet();
			alphabet r = new alphabet();
			r.reverse(); // reverses alphabet r
			for (int i = 0; i < message.length(); i++) {
				String letter = message.substring(i, i + 1); // turns each character of the message into a substring
				int ind = a.indexOf(letter);

				if (ind == -1) { // if it's not a letter add w/o encryption
					e = e + letter;
				} else { // add encrypted letter
					e = e + r.get(ind);

				}
			}
		} else {
			return encryptedMessage;
		}

		return e;
	}

	public String decrypt() {
		String d = "";
		if (message.equals("")) {
			alphabet a = new alphabet();
			alphabet r = new alphabet();
			r.reverse();
			for (int i = 0; i < encryptedMessage.length(); i++) {
				String letter = encryptedMessage.substring(i, i + 1);
				int ind = r.indexOf(letter);
				if (ind == -1) {
					d = d + letter;
				} else {
					d = d + a.get(ind);

				}
			}
		} else {
			return message;
		}
		return d;
	}

	public String toString() {
		return message + " = " + encryptedMessage;
	}
}
