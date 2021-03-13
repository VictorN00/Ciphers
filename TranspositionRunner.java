
// Authors: Roger Ye, Victor Nguyen

public class TranspositionRunner {

	// Written by Victor Nguyen & Roger Ye
	public void run() throws Exception {
		System.out.println("Transposition Cipher:");
		System.out.println("Raw: " + "TRANSPOSITION\nEncrypted: " + Transposition.encode("TRANSPOSITION", "43152"));
		System.out.println("Decrypted: " + Transposition.decode("NIASNTPISTROO", "43152"));
		System.out.println();
		System.out.println("Raw: " + "hello dog\nEncrypted: " + Transposition.encode("hello dog", "2341"));
		System.out.println("Decrypted: " + Transposition.decode("EDLOLGHO", "2341"));
		System.out.println();
		System.out.println("Raw: " + "Mr. Armstrong\nEncrypted: " + Transposition.encode("Mr. Armstrong", "25341"));
		System.out.println("Decrypted: " + Transposition.decode("rsgro.tarmmn", "25341"));
	}

	public static void main(String[] args) throws Exception {
		new TranspositionRunner().run();
	}

}