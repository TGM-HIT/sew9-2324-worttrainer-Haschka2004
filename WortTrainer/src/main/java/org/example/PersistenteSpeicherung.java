package org.example;

import java.io.IOException;

public interface PersistenteSpeicherung {

	public abstract boolean speichern(Rechtschreibtrainer letzterZustand) throws IOException;

	public abstract Rechtschreibtrainer letzterZustand();

}
