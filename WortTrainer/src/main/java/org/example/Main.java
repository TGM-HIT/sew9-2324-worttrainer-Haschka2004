package org.example;

import java.io.IOException;
import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) throws IOException {
        //Runde1
        Rechtschreibtrainer rt = new Rechtschreibtrainer();
        rt.autoBefuellen();
        WortPaar w1 = new WortPaar("Wasser","https://imgs.search.brave.com/-HcNdev-8CchOimS6ETAsk_6Q_ZfKs9G0pNmmyW3EQ4/rs:fit:860:0:0/g:ce/aHR0cHM6Ly91cGxv/YWQud2lraW1lZGlh/Lm9yZy93aWtpcGVk/aWEvY29tbW9ucy8w/LzAyL1N0aWxsZXNf/TWluZXJhbHdhc3Nl/ci5qcGc");
        rt.addWortPaar(w1);
        rt.spiel(); //starten einer Runde
        JSONPersistent persistent = new JSONPersistent();
        persistent.speichern(rt);
        System.out.println(rt.statistik());


        //persistent.letzterZustand().spiel();

    }
}