//Damit man sich Passwörter gut merken kann, ohne das diese sich leicht erraten lassen, 
//kann man Passwörter aus Merksätzen bilden. Wir wollen nach folgenden Regeln 
//Passwörter aus Sätzen bilden:
//
//Das Passwort wird als Folge der letzten Zeichen eines jeden Wortes im Satz gebildet. 
//Der erste Buchstabe soll gross geschrieben werden. 
//Wörter des Satzes sollen alle durch beliebig viele Leerzeichen abgetrennten Teilfolgen sein. 
//Werden Satzzeichen direkt hinter ein Wort geschrieben, so gehören sie zu dem Wort.
//
//"Wenn es regnet, dann wird es nass ." besteht aus den Teilwörtern 
//"Wenn" "es" "regnet," "dann" "wird" "es" "nass" "." und das dazugehörige Passwort ist "Ns,NdSs."
//
//Wenn das Password schon 6 soll 1 Sonderzeichen und 1 Zahl hinzugefügt werden (max 8). 
//Falls das Passwort weniger als 6 Zeichen ergibt, werden zusätzlich notwendiger 
//Anzahl der Zeichen ergänsen (Aus Sonderzeichen und Zahlen).


import Prog1Tools.IOTools; 

public class Main {

	public static void main(String[] args) {
		
		int i, character_i, number_i, symbol_plus;
		String sentence, password = "";
		String [] words;
		
		char [] character = {'!', '"', '#', '$', '%', '&', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\'', ']', '^', '_', '`', '{', '|', '}', '~'};
		
		sentence = IOTools.readLine("Geben Sie einen Satz ein: ");
		
		words = sentence.split(" ");
		String [] words_letter = new String [words.length];
		
		for (i = 0; i < words.length; i++) {
			words[0] = words[0].toUpperCase();
			words_letter[i] =  words[i].substring(words[i].length() - 1, words[i].length());
			password = password + words_letter[i];
		}
		
		character_i = (int)Math.round(Math.random() * (character.length - 1));
		number_i = (int)Math.round(Math.random() * 10);
		
		if (words_letter.length >= 6) {
			password = password.substring(0, 6);
			number_i = (int)Math.round(Math.random() * 10);
			password = password + character[character_i] + "" + number_i;
		} else {
			number_i = (int)Math.round(Math.random() * 10);
			password = password + character[character_i];
			symbol_plus = 8 - (int)password.length();
			for (i = 0; i < symbol_plus; i++) {
				number_i = (int)Math.round(Math.random() * 10);
				password = password + "" + number_i;
			}
		}
		
		System.out.println("Ihr Passwort: " + password);
	}

}
