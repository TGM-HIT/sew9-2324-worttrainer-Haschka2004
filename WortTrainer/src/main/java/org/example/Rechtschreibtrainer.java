package org.example;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class Rechtschreibtrainer {

	private PersistenteSpeicherung speicher;

	private int fehler;

	private int errateneWortpaare;

	private ArrayList<WortPaar> wortPaare;

	public Rechtschreibtrainer(){
		wortPaare = new ArrayList<>();
		fehler = 0;
		errateneWortpaare = 0;
		speicher = new JSONPersistent();
	}

	/**
	 * Gibt das Wortpaar bei einem gültigen Index zurück.
	 * @param index, ist der Index des Wortpaares, welches zurückgegeben wird.
	 * @return, returned bei einem gültigen Index das jeweilige Wortpaar oder bei ungültigem Index null.
	 */
	public WortPaar indexWortPaar(int index) {
		if(index >= 0 && index <= wortPaare.size()) return wortPaare.get(index);
		return null;
	}

	public WortPaar zufallsWortPaar() {
		Random zufallsIndex = new Random();
		return wortPaare.get(zufallsIndex.nextInt(wortPaare.size()));
	}

	/**
	 * Spiellogik: Bilder und Eingabefenster werden angezeigt. Des Weiteren wird die Eingabe mit dem Wort überprüft. Sollte das Wort stimmen,
	 * wir ein neus angezeigt. Ist die Session zu Ende, wird der Zustand des Objekts gespeichert. Außerdem wird die Statistik nachverfolgt.
	 * @throws MalformedURLException, wird geworfen, wenn die URL ungültig ist.
	 */
	public void spiel() throws MalformedURLException {

		int index = 0;

	while(!(index+1 > wortPaare.size())){

		URL url = new URL(wortPaare.get(index).getURL());
		Icon bildIcon = new ImageIcon(url);
		String inputValue = (String) JOptionPane.showInputDialog(null,"Was siehst du?","Bilderratespiel", JOptionPane.QUESTION_MESSAGE,bildIcon,null,"Standardwert");
		if(inputValue.equals(wortPaare.get(index).getWort())) { index += 1; errateneWortpaare += 1; }
		else {
			fehler += 1;
		}
		JOptionPane.showMessageDialog(null,this.statistik());
		if(index+1 > wortPaare.size())  JOptionPane.showMessageDialog(null,"Gut gemacht starte eine neue Runde!");
	}

	}

	/**
	 * Zeigt die Statistik
	 * @return, gibt die Menge an Fehlern und richtig erratenen zurück.
	 */
	public String statistik() {
		return "Du hast: " + getFehler() + "fehler gemacht und " + "richtig Erratene: " + getErrateneWortpaare() + ".";
	}

	/**
	 * Fügt ein neues Wortpaar hinzu.
	 * @param neuesWortPaar, das neue Wortpaar, welches hinzugefügt wird, solange keiner seiner Parameter null ist.
	 * @return gibt true zurück, wenn es das Wortpaar gespeichert wurde und false, wenn nicht.
	 */
	public boolean addWortPaar(WortPaar neuesWortPaar) {
		if(neuesWortPaar.getWort() != null && neuesWortPaar.getURL() != null){ wortPaare.add(neuesWortPaar); return true; }
		return false;
	}


	public int getErrateneWortpaare() {
		return this.errateneWortpaare;
	}

	public int getFehler() {
		return this.fehler;
	}

	/**
	 * Befüllt den Rechtschreibtrainer mit hard gecodeten Wortpaare.
	 */
	public void autoBefuellen() {
		wortPaare.add(new WortPaar("Hund","https://imgs.search.brave.com/cQyVVawhlQSjv9tiCojFYkUdnIN5pDDsj084GmlXxSg/rs:fit:860:0:0/g:ce/aHR0cHM6Ly93d3cx/Lndkci5kZS9mZXJu/c2VoZW4vdGllcmUt/c3VjaGVuLWVpbi16/dWhhdXNlL2tsZWlu/ZS1odW5kZS0xMTh-/X3YtZ3NlYXByZW1p/dW14bC5qcGc"));
		wortPaare.add(new WortPaar("Katze","https://imgs.search.brave.com/dhhvzfic0k7gPD8RxYFHQyybM19HiQaDfCY84UMaz04/rs:fit:860:0:0/g:ce/aHR0cHM6Ly91cGxv/YWQud2lraW1lZGlh/Lm9yZy93aWtpcGVk/aWEvY29tbW9ucy84/LzhlL0hhdXNrYXR6/ZV9sYW5naGFhci5q/cGc"));
		wortPaare.add(new WortPaar("Kamel","https://imgs.search.brave.com/2t_UmV2Tp4c8WSLDz9H6XkQeufK4H0K9K161-uCFXoc/rs:fit:500:0:0/g:ce/aHR0cHM6Ly91cGxv/YWQud2lraW1lZGlh/Lm9yZy93aWtpcGVk/aWEvY29tbW9ucy84/LzgzL0NhbWVsX2lu/X01vbmdvbGlhLmpw/Zw"));
		wortPaare.add(new WortPaar("Hai","https://imgs.search.brave.com/cZ1YrokSyRi6_MmhR01oISHbb5rEb467UICpEkeZdZk/rs:fit:860:0:0/g:ce/aHR0cHM6Ly93d3cu/d3dmLmRlL2ZpbGVh/ZG1pbi9fcHJvY2Vz/c2VkXy9hLzQvY3Nt/XzM1MC1ISV8xMTE3/NTQtV2Vpc3Nlci1I/YWktX2NfLVdpbGRs/aWZlLVBpY3R1cmVz/LUplcm9tZS1NYWxs/ZWZldC1XV0YtQ2Fu/b25fZDQ0ZGZjZTU1/Yi5qcGc"));
	}

}
