import java.util.HashMap;
import java.util.Map;

// preset rotors and reflectors are based off of https://www.codesandciphers.org.uk/enigma/rotorspec.htm
public class EnigmaMachine {
	
	private static final Map<String, char[]> reflector_list = new HashMap<String, char[]>() {
		private static final long serialVersionUID = 5904517415606394221L;
	{
		put("B", "YRUHQSLDPXNGOKMIEBFZCWVJAT".toCharArray());
		put("C", "FVPJIAOYEDRZXWGCTKUQSBNMHL".toCharArray());
		put("B DUNN", "ENKQAUYWJICOPBLMDXZVFTHRGS".toCharArray());
		put("C DUNN", "RDOBJNTKVEHMLFCWZAXGYIPSUQ".toCharArray());
	}};
	/*
	B: (AY) (BR) (CU) (DH) (EQ) (FS) (GL) (IP) (JX) (KN) (MO) (TZ) (VW)
	C: (AF) (BV) (CP) (DJ) (EI) (GO) (HY) (KR) (LZ) (MX) (NW) (TQ) (SU)
	B Dünn: (AE) (BN) (CK) (DQ) (FU) (GY) (HW) (IJ) (LO) (MP) (RX) (SZ) (TV)
	C Dünn: (AR) (BD) (CO) (EJ) (FN) (GT) (HK) (IV) (LM) (PW) (QZ) (SX) (UY)
	*/
	
	Map<Character, Character> plugboard;
	char[] reflector;
	
	RotorSystem rotor_system;
	
	private EnigmaMachine(String pb, String refl) {
		plugboard = new HashMap<Character, Character>();
		for (String link : pb.toUpperCase().split(" ")) {
			char one = Character.toUpperCase(link.charAt(0)), two = Character.toUpperCase(link.charAt(1));
			plugboard.put(one, two);
			plugboard.put(two, one);
		}
		
		try {
			reflector = reflector_list.get(refl.toUpperCase());
		} catch (Exception e) {
			throw new IllegalArgumentException("reflector bad");
		}
		if (reflector == null)
			throw new IllegalArgumentException("reflector bad");
	}
	
	public EnigmaMachine(String pb, String refl, Rotor[] rotor_selection, int[] starting_positions) {
		this(pb, refl);
		rotor_system = new RotorSystem(rotor_selection);
	}
	
	public EnigmaMachine(String pb, String refl, int[] rotor_pick, int[] starting_positions) {
		this(pb, refl);
		rotor_system = new RotorSystem(rotor_pick, starting_positions);
		/*
		System.out.println(rotor_system);
		System.out.println("Rotor 4:");
		System.out.println(RotorSystem.presets[3]);
		*/
	}
	
	public String translate(String raw) {
		//raw = raw.replaceAll("[^A-Za-z ]", "");
		StringBuffer encrypted = new StringBuffer();
		for (int i = 0; i < raw.length(); i++) {
			char c = raw.charAt(i);
			if (!Character.isAlphabetic(c)) {
				encrypted.append(c);
				continue;
			}
			boolean upper = Character.isUpperCase(c);
			c = Character.toUpperCase(c);
			c = plugboard.getOrDefault(c, c);
			for (Rotor rc : rotor_system.rotors) {
				c = rc.letters[c - 65];
			}
			c = reflector[c - 65];
			for (int r = rotor_system.rotors.length - 1; r >= 0; r--) {
				Rotor rc = rotor_system.rotors[r];
				for (int j = 0; j < rc.letters.length; j++) {
					if (rc.letters[j] == c) {
						c = (char) (j + 65);
						break;
					}
				}
			}
			c = plugboard.getOrDefault(c, c);
			
			encrypted.append(upper ? c : Character.toLowerCase(c));
			
			rotor_system.rotate();
		}
		return encrypted.toString();
	}
	
}
