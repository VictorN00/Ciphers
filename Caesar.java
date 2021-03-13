
// Authors: Roger Ye, Victor Nguyen

public class Caesar {
	
	// Written by Roger Ye & Victor Nguyen
	public static String encode(String raw, int shift, boolean right) {
		StringBuffer enc = new StringBuffer();
		for (int i = 0; i < raw.length(); i++) {
			char curr = raw.charAt(i);
			if (Character.isAlphabetic(curr)) {
				boolean upper = Character.isUpperCase(curr);
				curr = Character.toUpperCase(curr);
				if (right)
					curr = (char) ((((curr - 65) + shift) % 26) + 65);
				else
					curr = (char) ((((curr - 65) - shift + 26) % 26) + 65);
				if (!upper)
					curr = Character.toLowerCase(curr);
			}
			enc.append(curr);
		}
		return enc.toString();
	}
	
	public static String decode(String encrypted, int shift, boolean right) {
		return encode(encrypted, shift, !right);
	}
	
}
