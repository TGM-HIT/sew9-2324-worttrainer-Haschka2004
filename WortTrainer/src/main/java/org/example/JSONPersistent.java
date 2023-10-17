package org.example;

public class JSONPersistent implements PersistenteSpeicherung {

	public boolean speichern(Rechtschreibtrainer letzterZustand) {
		return false;
	}

	public Rechtschreibtrainer letzterZustand() {
		return null;
	}

}
