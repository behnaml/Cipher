import java.util.*;

public class accessBond {

	public static void main(String[] args) {
		Scanner aScan = new Scanner(System.in);
		System.out.println("\t\t Welcome to Bond Encryption.\n\t\t     by Leila and Bella");
		System.out.println(
				"\n\t Enter the number for a corresponding action\n\t   1. Use a Cipher\n\t   2. About Ciphers\n\t   3. Exit");
		int action = aScan.nextInt();
		while (action != 3 && (action == 2 || action == 1)) {
			if (action == 1) {
				cipherMenu();
			}

			System.out.println(
					"\n\t Enter the number for a corresponding action\n\t   1. Use a Cipher\n\t   2. About Ciphers\n\t   3. Exit");
			action = aScan.nextInt();
		}

		System.out.print("Exiting...");
	}

	public static void cipherMenu() {
		Scanner aScan = new Scanner(System.in);
		System.out.println(
				"\n\t Enter the number for a corresponding action\n\t   1. Compare all cipher decryptions of a message\n\t   2. Use atbash cipher \n\t   3. Use binary cipher \n\t   4. Use Leila's Cipher \n\t   5. Use Bella's Cipher. \n\t   6. Return to Main Menu");
		int action = aScan.nextInt();
		while (action != 3 && (action == 2 || action == 1)) {
			if (action == 1) {
				System.out.println("\tEnter your encrypted message: ");
				String non = aScan.nextLine();
				String code = aScan.nextLine();
				findEncryption(code);
				System.out.println("Press Enter to Continue.");
				non = aScan.nextLine();
			} else if (action == 2) {
				System.out.println("\tEnter your message(Press enter if you don't have one):   ");
				String non = aScan.nextLine();
				String code = aScan.nextLine();
				findEncryption(code);
				System.out.println("Press Enter to Continue.");
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
		// prints encrypted message to compare
		System.out.println("\nTesting Decription of Encrypted Message: " + c);

		// General decryption format
		// EncryptionType a1 = new EncryptionType(m, c);
		// System.out.println(“\t Encryption Type: “ + a1.decrypt());

		// Atbash
		atbash a2 = new atbash(m, c);
		System.out.println("\t Atbash: " + a2.decrypt());

		// Binary
		System.out.println("\n");
		binary b1 = new binary(m,c);
		System.out.print("\t Binary: " + b1.decrypt());

	}

}
