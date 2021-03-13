
public class PlayfairRunner {
	
	public void run() throws Exception {
		System.out.println("Playfair Cipher:");
		System.out.println("Raw: Meet me at noon\nEncrypted: " + Playfair.encode("Meet me at noon", 'J'));
		System.out.println("Decrypted: " + Playfair.decode("PBDUPBDQOPPO", 'J'));
		System.out.println();
		
		System.out.println("Raw: Hello, Mr. Armstrong!\nEncrypted: " + Playfair.encode("Hello, Mr. Armstrong!", 'Z'));
		System.out.println("Decrypted: " + Playfair.decode("JCMMKNPCWRTPTMLI", 'Z'));
		System.out.println();

		System.out.println("Raw: Cy Woods CS is OP\nEncrypted: " + Playfair.encode("Cy Woods CS is OP", 'R'));
		System.out.println("Decrypted: " + Playfair.decode("DXZLNEXHTHUMP", 'R'));
		System.out.println();
		
		System.out.println("Raw: This project is due today.\nEncrypted: " + Playfair.encode("This project is due today.", 'G'));
		System.out.println("Decrypted: " + Playfair.decode("RJNXMUTOADSJTCZKYTEBY", 'G'));
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		new PlayfairRunner().run();
	}

}
