package org.example;

/**
 * @author Alexander Haschka
 * @versin 2023-10-17
 * In die Klasse Wortpaar wird die Url der Bilder und das zugehörige Wort, welches die Kinder richtig schreiben müssen gespeichert
 */
public class WortPaar {

	private String url;

	private String wort;
	public WortPaar(String wort,String url) {
		this.url = url;
		this.wort = wort;
	}

	public String getURL() {
		return this.url;
	}

	public String getWort() {
		return this.getWort();
	}

}
