
// Authors: Victor Nguyen, Roger Ye

import java.util.HashMap;
import java.util.Map;

public class Playfair {
	
	// Written by Victor Nguyen
	public static String encode(String raw, char skip) {
		raw = raw.replaceAll(" ", "").replaceAll("[^A-Za-z]", "").toUpperCase();
		char[][] mat = new char[5][5];
		String stuff = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".replaceAll(String.valueOf(Character.toUpperCase(skip)), "");
		Map<Character, int[]> positions = new HashMap<Character, int[]>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				mat[i][j] = stuff.charAt(i * 5 + j);
				positions.put(stuff.charAt(i * 5 + j), new int[] {i, j});
			}
		}
		StringBuffer enc = new StringBuffer();
		for (int i = 0; i < raw.length() - 1; i += 2) {
			char one = raw.charAt(i), two = raw.charAt(i + 1);
			if (one == skip || two == skip) {
				enc.append(one);
				enc.append(two);
				continue;
			}
			int[] pos1 = positions.get(one), pos2 = positions.get(two);
			int r1 = pos1[0], c1 = pos1[1], r2 = pos2[0], c2 = pos2[1];
			if (r1 == r2) {
				enc.append(mat[r1][(c1 + 1) % 5]);
				enc.append(mat[r2][(c2 + 1) % 5]);
			}
			else if (c1 == c2) {
				enc.append(mat[(r1 + 1) % 5][c1]);
				enc.append(mat[(r2 + 1) % 5][c2]);
			}
			else {
				enc.append(mat[r1][c2]);
				enc.append(mat[r2][c1]);
			}
		}
		if (raw.length() % 2 == 1)
			enc.append(raw.charAt(raw.length() - 1));
		return enc.toString();
	}
	
	// Written by Roger Ye
	public static String decode(String encrypted, char skip) {
		encrypted = encrypted.replaceAll(" ", "").replaceAll("[^A-Za-z]", "").toUpperCase();
		char[][] mat = new char[5][5];
		String stuff = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".replaceAll(String.valueOf(Character.toUpperCase(skip)), "");
		Map<Character, int[]> positions = new HashMap<Character, int[]>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				mat[i][j] = stuff.charAt(i * 5 + j);
				positions.put(stuff.charAt(i * 5 + j), new int[] {i, j});
			}
		}
		StringBuffer dec = new StringBuffer();
		for (int i = 0; i < encrypted.length() - 1; i += 2) {
			char one = encrypted.charAt(i), two = encrypted.charAt(i + 1);
			if (one == skip || two == skip) {
				dec.append(one);
				dec.append(two);
				continue;
			}
			int[] pos1 = positions.get(one), pos2 = positions.get(two);
			int r1 = pos1[0], c1 = pos1[1], r2 = pos2[0], c2 = pos2[1];
			if (r1 == r2) {
				dec.append(mat[r1][(c1 - 1 + 5) % 5]);
				dec.append(mat[r2][(c2 - 1 + 5) % 5]);
			}
			else if (c1 == c2) {
				dec.append(mat[(r1 - 1 + 5) % 5][c1]);
				dec.append(mat[(r2 - 1 + 5) % 5][c2]);
			}
			else {
				dec.append(mat[r1][c2]);
				dec.append(mat[r2][c1]);
			}
		}
		if (encrypted.length() % 2 == 1)
			dec.append(encrypted.charAt(encrypted.length() - 1));
		return dec.toString();
	}
	
}
