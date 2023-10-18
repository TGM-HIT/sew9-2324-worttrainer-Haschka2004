package org.example;

import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        Rechtschreibtrainer rt = new Rechtschreibtrainer();
        rt.autoBefuellen();
        rt.spiel();
    }
}