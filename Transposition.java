
// Authors: Roger Ye, Victor Nguyen

public class Transposition {

	// Written by Roger Ye
	public static String encode(String raw, String key) {
		raw = raw.replaceAll(" ", "").toUpperCase();
		char[][] mat = new char[(int) Math.ceil((double) raw.length() / key.length())][key.length()];
		int i = 0, j = 0;
		outer: for (; i < mat.length; i++) {
			for (j = 0; j < mat[i].length; j++) {
				//System.out.println(i * key.length() + j);
				if (i * key.length() + j >= raw.length())
					break outer;
				mat[i][j] = raw.charAt(i * key.length() + j);
			}
		}
		
		if (i < mat.length) {
			for (; j < mat[i].length; j++)
				mat[i][j] = ' ';
		}
		
		//System.out.println(Arrays.deepToString(mat).replaceAll("\\], \\[", "\n").replaceAll("[\\]\\[,]", ""));
		StringBuffer enc = new StringBuffer();
		for (int x = 0; x < key.length(); x++) {
			int col = key.charAt(x) - '1';
			for (int e = 0; e < mat.length; e++)
				enc.append(mat[e][col]);
		}
		return enc.toString().replaceAll(" ", "");
	}

	// Written by Victor Nguyen
	public static String decode(String encrypted, String key) {
		encrypted = encrypted.replaceAll(" ", "").toUpperCase();
		char[][] mat = new char[(int) Math.ceil((double) encrypted.length() / key.length())][key.length()];
		int num_extra = mat.length * mat[0].length - encrypted.length();
		int incr = 0;
		for (int x = 0; x < key.length(); x++) {
			int col = key.charAt(x) - '1';
			for (int d = 0; d < mat.length; d++) {
				if (d * key.length() + col >= mat.length * mat[0].length - num_extra) {
					mat[d][col] = ' ';
				}
				else
					mat[d][col] = encrypted.charAt(incr++);
			}
		}
		//System.out.println(Arrays.deepToString(mat).replaceAll("\\], \\[", "\n").replaceAll("[\\]\\[,]", ""));
		
		StringBuffer dec = new StringBuffer();
		for (int i = 0; i < mat.length; i++)
			for (int j = 0; j < mat[i].length; j++)
				dec.append(mat[i][j]);
		/*
		for (int i = 0; i < mat.length; i++) {
			for (int x = 0; x < key.length(); x++) {
				dec.append(mat[i][key.indexOf('1' + x)]);
			}
		}
		*/
		return dec.toString().substring(0, mat.length * mat[0].length - num_extra);
	}

}
