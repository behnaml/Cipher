import java.util.*;

public class useCiphers {

	public static void main(String[] args) {
		Scanner aScan = new Scanner(System.in);
		System.out.println("\t\t Welcome to Bond Encryption.\n\t\t     by Leila and Bella");
		System.out.println("\n\t Enter the number for a corresponding action\n\t   1. Use a Cipher\n\t  2. Exit");
		int action = aScan.nextInt();
		while (action != 2 && (action == 1)) {
			if (action == 1) {
				cipherMenu();
			}

			System.out.println("\n\t Enter the number for a corresponding action\n\t   1. Use a Cipher\n\t    2. Exit");
			action = aScan.nextInt();
		}

		System.out.print("Exiting...");
	}

	public static void cipherMenu() {
		Scanner aScan = new Scanner(System.in);
		System.out.println(
				"\n\t Enter the number for a corresponding action\n\t   1. Compare all cipher decryptions of a message\n\t   2. Use atbash cipher \n\t   3. Use binary cipher \n\t   4. Use Leila's Cipher \n\t   5. Use Bella's Cipher. \n\t   6. Return to Main Menu");
		int action = aScan.nextInt();
		while (action < 6) {
			if (action == 1) {
				System.out.println("\tEnter your encrypted message: ");
				String non = aScan.nextLine();
				String code = aScan.nextLine();
				findEncryption(code);
				System.out.println("\nPress Enter to Continue.");
				non = aScan.nextLine();
			} else {
				System.out.println("\tEnter your message(Press enter if you don't have one):   ");
				String non = aScan.nextLine();
				String m = aScan.nextLine();
				System.out.println("\tEnter your encrypted message(Press enter if you don't have one):   ");
				String c = aScan.nextLine();

				switch (action) {

				case 2:
					atbash t1 = new atbash(m, c);
					System.out.println(t1);
					break;
				case 3:
					binary t2 = new binary(m, c);
					System.out.println(t2);
					break;
				case 4:
					// leila t3= new leila(m,c);
					// System.out.println(t3);
					break;
				case 5:
					bella t4 = new bella(m, c);
					System.out.println(t4);
					break;
				}
				System.out.println("\nPress Enter to Continue.");
				non = aScan.nextLine();
			}
			System.out.println(
					"\n\t Enter the number for a corresponding action\n\t   1. Compare all cipher decryptions of a message\n\t   2. Use atbash cipher \n\t   3. Use binary cipher \n\t   4. Use Leila's Cipher \n\t   5. Use Bella's Cipher. \n\t   6. Return to Main Menu");
			action = aScan.nextInt();
		}
	}

	public static void findEncryption(String c) {
		// to pass in empty decryptedMessage
		String m = "";
		c = c.toUpperCase();
		// prints encrypted message to compare
		System.out.println("\nTesting Decription of Encrypted Message: " + c);

		// General decryption format
		// EncryptionType a1 = new EncryptionType(m, c);
		// System.out.println(“\t Encryption Type: “ + a1.decrypt());

		try {
			atbash a2 = new atbash(m, c);
			System.out.println("\t Atbash: " + a2.decrypt());
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("\t Atbash: DOES NOT TRANSLATE");
		}

		// Binary
		try {
			binary b1 = new binary(m, c);
			System.out.println("\t Binary: " + b1.decrypt());
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("\t Binary: DOES NOT TRANSLATE");
		}

		try {
			// leila l1 = new leila(m,c);
			// System.out.println("\t Leila: " + l1.decrypt());
		} catch (StringIndexOutOfBoundsException e) {
			// System.out.println("\t Leila: DOES NOT TRANSLATE");
		}

		try {
			bella c1 = new bella(m, c);
			System.out.println("\t Bella: " + c1.decrypt());
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("\t Bella: DOES NOT TRANSLATE");
		}

	}

}