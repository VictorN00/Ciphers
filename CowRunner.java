
// Authors: Victor Nguyen, Roger Ye

public class CowRunner {

	// Written by Victor Nguyen & Roger Ye
	public void run() throws Exception {
		System.out.println("Cow Cipher:");
		System.out.println("Raw: that's not a bad idea\nEncrypted: " + Cow.encode("that's not a bad idea"));
		System.out.println("Decrypted: " + Cow.decode("t'nabi"));
		System.out.println();
		
		System.out.println("Raw: I see you.\nEncrypted: " + Cow.encode("I see you."));
		System.out.println("Decrypted: " + Cow.decode("Isy."));
		System.out.println();
		
		System.out.println("Raw: COCONUT MILK\nEncrypted: " + Cow.encode("COCONUT MILK"));
		System.out.println("Decrypted: " + Cow.decode("CM"));
		System.out.println();
		
		System.out.println("Raw: This is the most advanced cipher of the 21st century!\nEncrypted: " + Cow.encode("This is the most advanced cipher of the 21st century!"));
		System.out.println("Decrypted: " + Cow.decode("Titmacot2c!"));
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		new CowRunner().run();
	}

}