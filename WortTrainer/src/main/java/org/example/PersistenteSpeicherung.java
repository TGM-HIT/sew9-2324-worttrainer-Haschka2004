package org.example;

public interface PersistenteSpeicherung {

	public abstract boolean speichern(Rechtschreibtrainer letzterZustand);

	public abstract Rechtschreibtrainer letzterZustand();

}
