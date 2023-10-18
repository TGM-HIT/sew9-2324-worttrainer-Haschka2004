package org.example;

import java.io.IOException;
import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) throws IOException {
        Rechtschreibtrainer rt = new Rechtschreibtrainer();
        rt.autoBefuellen();
        rt.spiel();
        JSONPersistent persistent = new JSONPersistent();
        persistent.speichern(rt);
        System.out.println(persistent.letzterZustand().statistik());

    }
}