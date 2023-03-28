package it.uniroma3.diadia;
import java.util.Scanner;

public class IOconsole {
	
	public void mostraMessaggio(String msg) {
		System.out.println(msg);		
	}
	
	public String leggiRiga() {
		Scanner scannerDiLinea = new Scanner(System.in);
		String riga = scannerDiLinea.nextLine();
		/*scannerDiLinea.close();*/
		return riga;
	}

}
