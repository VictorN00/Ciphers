
// Authors: Roger Ye, Victor Nguyen

public class CaesarRunner {

	// Written by Roger Ye & Victor Nguyen
	public void run() throws Exception {
		System.out.println("Caesar Cipher:");
		System.out.println("Raw: The cow goes moo.\nEncrypted: " + Caesar.encode("The cow goes moo.", 5, false));
		System.out.println("Decrypted: " + Caesar.decode("Ocz xjr bjzn hjj.", 5, false));
		System.out.println();
		
		System.out.println("Raw: i like to walk my dog\nEncrypted: " + Caesar.encode("i like to walk my dog", 18, true));
		System.out.println("Decrypted: " + Caesar.decode("a dacw lg osdc eq vgy", 18, true));
		System.out.println();
		
		System.out.println("Raw: CEO Worked Way Up From Son of CEO\nEncrypted: " + Caesar.encode("CEO Worked Way Up From Son of CEO", 2, false));
		System.out.println("Decrypted: " + Caesar.decode("ACM Umpicb Uyw Sn Dpmk Qml md ACM", 2, false));
		System.out.println();
		
		System.out.println("Raw: I like coconut milk... But, I dont know what it tastes like.\nEncrypted: " + Caesar.encode("I like coconut milk... But, I dont know what it tastes like.", 14, true));
		System.out.println("Decrypted: " + Caesar.decode("W zwys qcqcbih awzy... Pih, W rcbh ybck kvoh wh hoghsg zwys.", 14, true));
		System.out.println();
		
		System.out.println("Raw: Sunsettias are tasty!\nEncrypted: " + Caesar.encode("Sunsettias are tasty!", 26, false));
		System.out.println("Decrypted: " + Caesar.decode("Sunsettias are tasty!", 26, false));
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		new CaesarRunner().run();
	}

}