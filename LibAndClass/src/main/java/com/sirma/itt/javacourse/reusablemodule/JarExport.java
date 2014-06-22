package main.java.com.sirma.itt.javacourse.reusablemodule;

/**
 * Class which run the introToJava's main methods from a jar file.
 * 
 * @author radoslav
 */

public class JarExport {

	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		try {
			main.java.com.sirma.itt.javacourse.intro.hangman.main.Main
					.main(args);
			main.java.com.sirma.itt.javacourse.intro.arrayutils.main.Main
					.main(args);
			main.java.com.sirma.itt.javacourse.intro.bigint.Main.main(args);
			main.java.com.sirma.itt.javacourse.intro.gcd.Main.main(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
