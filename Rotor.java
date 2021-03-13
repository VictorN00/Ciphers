
// Authors: Victor Nguyen, Roger Ye

import java.util.Arrays;

// Written by Victor Nguyen
public class Rotor {
	
	char[] letters;
	int[] rotating_positions;
	int num_rotations;
	
	public Rotor(char[] l, int[] rps) {
		letters = l;
		rotating_positions = rps;
	}
	
	public Rotor(String str, int[] rps) {
		letters = str.toCharArray();
		rotating_positions = rps;
	}
	
	public void rotate() {
		char store = letters[0];
		for (int i = 0; i < letters.length - 1; i++) {
			letters[i] = letters[i + 1];
		}
		letters[letters.length - 1] = store;
		num_rotations++;
	}
	
	public void rotate(int num) {
		char[] store = new char[num];
		for (int i = 0; i < num; i++)
			store[i] = letters[i];
		int i = 0;
		for (i = 0; i < letters.length - num ; i++) {
			letters[i] = letters[i + num];
		}
		for (int j = 0; j < num; j++, i++)
			letters[i] = store[j];
	}
	
	public boolean checkRotate() {
		for (int rp : rotating_positions)
			if (num_rotations == rp)
				return true;
		return false;
	}
	
	public void resetRotate() {
		num_rotations = 0;
	}
	
	public String toString() {
		return Arrays.toString("ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()).replaceAll("[\\]\\[,]", "") + "\n" + Arrays.toString(letters).replaceAll("[\\]\\[,]", "");
	}
	
}
