import java.util.*;

public class useCiphers {
	//This Class acts as User interface, making it easy to use the different ciphers

	public static void main(String[] args) {
		Scanner aScan = new Scanner(System.in);
		System.out.println("\t\t Welcome to Bond Encryption.\n\t\t     by Leila and Bella");
		//the Main Menu has two options: go to cipher menu and exit class
		System.out.println("\n\t Enter the number for a corresponding action\n\t   1. Use a Cipher\n\t   2. Exit");
		int action = aScan.nextInt();
		//this while loops allows the user to back and forth between the main menu and the cipher menu
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
		//cipher menu options: input decrypted message, try different ciphers, and return to main menu
		System.out.println(
				"\n\t Enter the number for a corresponding action\n\t   1. Compare all cipher decryptions of a message\n\t   2. Use atbash cipher \n\t   3. Use binary cipher \n\t   4. Use Leila's Cipher \n\t   5. Use Bella's Cipher. \n\t   6. Return to Main Menu");
		int action = aScan.nextInt();
		while (action < 6) {
			//if the option is not to exit, execute one of the following:
			if (action == 1) {
				//this 
				System.out.println("\tEnter your encrypted message: ");
				String non = aScan.nextLine();
				String code = aScan.nextLine();
				findEncryption(code);
				System.out.println("\nPress Enter to Continue.");
				non = aScan.nextLine();
			} else {
				// recieves the message and/or encrypted message without submitting it to a cipher
				System.out.println("\tEnter your message(Press enter if you don't have one):   ");
				String non = aScan.nextLine();
				String m = aScan.nextLine();
				System.out.println("\tEnter your encrypted message(Press enter if you don't have one):   ");
				String c = aScan.nextLine();

				switch (action) {
				// this switch-case accounts for the different cipher types the user has chosen to use
				// 2 = atbash, 3 = binary, 4 = leila, 5 = bella
				case 2:
					try {
						atbash t1 = new atbash(m, c);
						System.out.println(t1);
					} catch (StringIndexOutOfBoundsException e) {
						System.out.println("\t Atbash for " + c + m + ": DOES NOT TRANSLATE");
					}
					break;
				case 3:
					try {
						binary t2 = new binary(m, c);
						System.out.println(t2);
					} catch (StringIndexOutOfBoundsException e) {
						System.out.println("\t Binary for " + c + m + ": DOES NOT TRANSLATE");
					}
					break;
				case 4:
					try {
						leila t3 = new leila(m, c.toLowerCase());
						System.out.println(t3);
					} catch (StringIndexOutOfBoundsException e) {
						System.out.println("\t Leila for " + c + m + ": DOES NOT TRANSLATE");
					}
					break;
				case 5:
					try {
						bella t4 = new bella(m, c);
						System.out.println(t4);
					} catch (StringIndexOutOfBoundsException e) {
						System.out.println("\t Bella for " + c + m + ": DOES NOT TRANSLATE");
					}
					break;
				}
				System.out.println("\nPress Enter to Continue.");
				non = aScan.nextLine();
			}
			System.out.println(
					"\n\t Enter the number for a corresponding action\n\t   1. Compare all cipher decryptions of a message\n\t   2. Use atbash cipher \n\t   3. Use binary cipher \n\t   4. Use Leila's Cipher \n\t   5. Use Bella's Cipher. \n\t   6. Return to Main Menu");
			action = aScan.nextInt();
		//exits while loop if 6 is chosen
		}
	}

	public static void findEncryption(String c) {
		// to pass in empty decryptedMessage
		String m = "";
		c = c.toUpperCase();
		// prints encrypted message to compare
		System.out.println("\nTesting Decryption of Encrypted Message: " + c);

		//BELOW is the testing of each code to the same encrypted message
		//they will print DOES NOT TRANSLATE if the code is not the same type
		//It returns DOES NOT TRANSLATE for one of the following reason:
			//the message is the exact same as the encrypted message
				//E.G. in atbash: 01000001 will be returned unchanged
			//if the entered encrypted message contains errors
				//E.G. for Leila: tokyo- is not one of her keywords
		
		//NOTE: that in the case of Bella an Atbash message like "SVOOL DLIOW GVHGRMT !" 
		//will be returned as "SVOOL DLIOW GVHGRMT B", but this is fine because the whole
		//point is to allow the user to compare which cipher option makes the most sense
		//THE best situation to explain when you might need this is when you have a message 
		// and you're not sure if it's atbash or caesar's shift (which we don't actually have)
		
		try {
			//checks for out of bounds exceptions for ATBASH decryption
			atbash a2 = new atbash(m, c);
			if (a2.decrypt().length()<1 || a2.decrypt().equals(a2.encrypt())) {
			//if the message is empty or the decrypted message is the same as the encrypted message
				System.out.println("\t Atbash: DOES NOT TRANSLATE");
			}
			else {
				System.out.println("\t Atbash: " + a2.decrypt());
			}
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("\t Atbash: DOES NOT TRANSLATE");
		}

		// Binary
		try {
			binary b1 = new binary(m, c);
			if (b1.decrypt().length()<1 || b1.decrypt().equals(b1.encrypt())) {
			//if the message is empty or the decrypted message is the same as the encrypted message
				System.out.println("\t Binary: DOES NOT TRANSLATE");
			}
			else {
				System.out.println("\t Binary: " + b1.decrypt());
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("\t Binary: DOES NOT TRANSLATE");
		}
		catch (StringIndexOutOfBoundsException r) {
			System.out.println("\t Binary: DOES NOT TRANSLATE");
		}

		try {
			leila l1 = new leila(m, c.toLowerCase());
			if (l1.decrypt().length()<1 || l1.decrypt().equals(l1.encrypt())) {
			//if the message is empty or the decrypted message is the same as the encrypted message
				System.out.println("\t Leila:  DOES NOT TRANSLATE");
			}
			else {
				System.out.print("\t Leila: " + l1.decrypt());
				}
		// this one has two different out of bounds exceptions so it has two catches
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("\t Leila: DOES NOT TRANSLATE");
		}
		catch (ArrayIndexOutOfBoundsException r) {
			System.out.println("\t Leila: DOES NOT TRANSLATE");
		}

		try {
			bella c1 = new bella(m, c);
			if (c1.decrypt().equals(c1.encrypt())) {
			//the decrypted message is the same as the encrypted message
				System.out.println("\t Bella:  DOES NOT TRANSLATE");
			}
			else {
				System.out.println("\t Bella:  " + c1.decrypt());
			}
		// this one has two different out of bounds exceptions so it has two catches
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("\t Bella:  DOES NOT TRANSLATE");
		}
		catch (ArrayIndexOutOfBoundsException r) {
			System.out.println("\t Bella:  DOES NOT TRANSLATE");
		}

	}

}
