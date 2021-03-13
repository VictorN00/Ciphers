
public class RotorSystem {
	/*
	public static final Rotor[] presets = {
											new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", new int[] {'R' - 65}),
											new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", new int[] {'F' - 65}),
											new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", new int[] {'W' - 65}),
											new Rotor("ESOVPZJAYQUIRHXLNFTGKDCMWB", new int[] {'K' - 65}),
											new Rotor("VZBRGITYUPSDNHLXAWMJQOFECK", new int[] {'A' - 65}),
											new Rotor("JPGVOUMFYQBENHZRDKASXLICTW", new int[] {'A' - 65, 'N' - 65}),
											new Rotor("NZJHGRCXMYSWBOUFAIVLPEKQDT", new int[] {'A' - 65, 'N' - 65}),
											new Rotor("FKQHTLXOCBJSPDZRAMEWNIUYGV", new int[] {'A' - 65, 'N' - 65})
										  };
	*/
	
	//stores the fields of the rotors instead of the rotors themselves because the array is mutable, and we don't want it to be
	public static final Object[][] presets = {
			{"EKMFLGDQVZNTOWYHXUSPAIBRCJ", new int[] {'R' - 65}},
			{"AJDKSIRUXBLHWTMCQGZNPYFVOE", new int[] {'F' - 65}},
			{"BDFHJLCPRTXVZNYEIWGAKMUSQO", new int[] {'W' - 65}},
			{"ESOVPZJAYQUIRHXLNFTGKDCMWB", new int[] {'K' - 65}},
			{"VZBRGITYUPSDNHLXAWMJQOFECK", new int[] {'A' - 65}},
			{"JPGVOUMFYQBENHZRDKASXLICTW", new int[] {'A' - 65, 'N' - 65}},
			{"NZJHGRCXMYSWBOUFAIVLPEKQDT", new int[] {'A' - 65, 'N' - 65}},
			{"FKQHTLXOCBJSPDZRAMEWNIUYGV", new int[] {'A' - 65, 'N' - 65}}
	};
	
	Rotor[] rotors;
	
	public RotorSystem(Rotor[] rs) {
		rotors = rs;
	}
	
	public RotorSystem(Rotor[] rs, int[] starting_positions) {
		rotors = rs;
		for (int i = 0; i < rotors.length; i++)
			rotors[i].rotate(starting_positions[i]);
	}
	
	public RotorSystem(int[] presets) {
		rotors = new Rotor[presets.length];
		for (int i = 0; i < presets.length; i++) {
			if (presets[i] >= RotorSystem.presets.length)
				throw new IllegalArgumentException("rotor preset index out of bounds");
			Object[] put = RotorSystem.presets[presets[i]];
			rotors[i] = new Rotor((String) put[0], (int[]) put[1]);
		}
	}
	
	public RotorSystem(int[] presets, int[] starting_positions) {
		this(presets);
		for (int i = 0; i < rotors.length; i++) {
			rotors[i].rotate(starting_positions[i]);
		}
	}
	
	public void rotate() {
		rotors[0].rotate();
		if (rotors[0].checkRotate()) {
			rotors[1].rotate();
			rotors[0].resetRotate();
			if (rotors[1].checkRotate()) {
				rotors[2].rotate();
				rotors[1].resetRotate();
				if (rotors[2].checkRotate())
					rotors[2].resetRotate();
			}
		}
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Rotor r : rotors) {
			sb.append(r + "\n\n");
		}
		return sb.toString().trim();
	}
	
}
