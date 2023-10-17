package org.example;

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

	public void spiel() {

	}

	/**
	 * Zeigt die Statistik
	 * @return, gibt die Menge an Fehlern und richtig erratenen zurück.
	 */
	public String statistik() {
		return "Du hast: " + getFehler() + " und " + "richtig Erratene: " + getErrateneWortpaare() + ".";
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

	}

}
