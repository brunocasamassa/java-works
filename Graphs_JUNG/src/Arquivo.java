

// STANDBY , NAO ESTAMOS USANDO AINDA

import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

s
public class Arquivo {

	public static void main(String[] args) {

		
		HashMap<String, String> themapa = new HashMap<String, String>();
		Scanner sc2 = null;
		try {
			sc2 = new Scanner(new File("C:\\Users\\Auryon.AURYON-PC\\Desktop\\flatWiki.txt"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (sc2.hasNextLine()) {
			Scanner s2 = new Scanner(sc2.nextLine());
			while (s2.hasNext()) {
				String s = s2.next();
				themapa.put(s, s);
				System.out.println(s);
			}
		}
		System.out.println("Qtd chaves: " + themapa.size());

	}

	
}
