package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONPersistent implements PersistenteSpeicherung {

	/**
	 * Speichert ein Rechtschreibtrainer Objekt in ein JSON FILE
	 * @param letzterZustand, Rechtschreibtrainer Objekt nach Ende einer Session
	 * @return gibt true zurück, wenn es gespeichert wurde und false, wenn nicht.
	 * @throws IOException, falls mögliche Fehler beim Lesen oder Schreiben der JSON Datei auftreten.
	 */
	@Override
	public boolean speichern(Rechtschreibtrainer letzterZustand) throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try(FileWriter fileWriter = new FileWriter("letzterZustand.json")){
			gson.toJson(letzterZustand,fileWriter);
			return true;
		}catch(IOException e){
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Entnimmt dem JSON File den Rechtschreibtrainer und gibt ihn zurück.
	 * @return gibt den Rechtschreibtrainer zurück.
	 */
	@Override
	public Rechtschreibtrainer letzterZustand() {
		Gson gson = new Gson();
		try(FileReader fileReader = new FileReader("C:/Users/alexa/Desktop/JavaH/GIT-WortTrainer/letzterZustand.json")){
            return gson.fromJson(fileReader, Rechtschreibtrainer.class);
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}

}
