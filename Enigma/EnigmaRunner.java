import java.util.Scanner;

public class EnigmaRunner {

	public void run() throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Enigma Machine simulation!");
		System.out.print("Plugboard (ex: BX LP QN): ");
		String pb = input.nextLine().trim();
		System.out.print("Reflector (B, C, B Dunn, or C Dunn): ");
		String refl = input.nextLine().trim();
		/*
		String choice = "";
		while (!(choice.equals("yes") || choice.equals("y") || choice.equals("no") || choice.equals("n"))) {
			System.out.print("Would you like to use the preset rotors (yes or no)? ");
			choice = input.nextLine().trim();
		}
		*/
		EnigmaMachine one = new EnigmaMachine(pb, refl, new int[] {0, 1, 2}, new int[] {0, 0, 0});
		//if (choice.equals("yes") || choice.equals("y")) {
			int r1 = -1, r2 = -1, r3 = -1;
			int s1 = -1, s2 = -1, s3 = -1;
			while (r1 < 0 || r1 >= RotorSystem.presets.length) {
				System.out.print("First rotor (1-" + (RotorSystem.presets.length) + "): ");
				try {
					r1 = Integer.parseInt(input.nextLine().trim());
				} catch (Exception e) { }
			}
			while (s1 < 0 || s1 > 25) {
				System.out.print("Starting position of first rotor (A-Z): ");
				try {
					s1 = Character.toUpperCase(input.nextLine().trim().charAt(0)) - 65;
				} catch (Exception e) { }
			}
			while (r2 < 0 || r2 >= RotorSystem.presets.length || r2 == r1) {
				System.out.print("Second rotor (1-" + (RotorSystem.presets.length) + "): ");
				try {
					r2 = Integer.parseInt(input.nextLine().trim());
				} catch (Exception e) { }
			}
			while (s2 < 0 || s2 > 25) {
				System.out.print("Starting position of second rotor (A-Z): ");
				try {
					s2 = Character.toUpperCase(input.nextLine().trim().charAt(0)) - 65;
				} catch (Exception e) { }
			}
			while (r3 < 0 || r3 >= RotorSystem.presets.length || r3 == r2 || r3 == r1) {
				System.out.print("Third rotor (1-" + (RotorSystem.presets.length) + "): ");
				try {
					r3 = Integer.parseInt(input.nextLine().trim());
				} catch (Exception e) { }
			}
			while (s3 < 0 || s3 > 25) {
				System.out.print("Starting position of third rotor (A-Z): ");
				try {
					s3 = Character.toUpperCase(input.nextLine().trim().charAt(0)) - 65;
				} catch (Exception e) { }
			}
			one = new EnigmaMachine(pb, refl, new int[] {r1 - 1, r2 - 1, r3 - 1}, new int[] {s1, s2, s3});
		/*
		}
		else {

		}
		*/
		
		//System.out.println(s1 + " " + s2 + " " + s3);
		while (true) {
			System.out.print("\nRaw message (type reset() to reset the rotors or exit() to quit): ");
			String line = input.nextLine().trim();
			if (line.equals("exit()")) {
				System.out.println("Thank you for using the Enigma Machine simulation!");
				break;
			}
			if (line.equals("reset()")) {
				one = new EnigmaMachine(pb, refl, new int[] {r1 - 1, r2 - 1, r3 - 1}, new int[] {s1, s2, s3});
				System.out.println("Rotors have been reset!");
			}
			else
				System.out.println("Translated message: " + one.translate(line));
		}
	}

	public static void main(String[] args) throws Exception {
		new EnigmaRunner().run();
	}

}
