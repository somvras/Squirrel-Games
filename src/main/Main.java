package main;

import java.time.LocalDate;

import concursantes.Concursante;

public class Main {

	public static void main(String[] args) {
	
		Concursante c1 = new Concursante(1, "Paco", "Jiménez", "Española", "24/01/1567", true, 5000);
		System.out.println(c1);
		Concursante c2 = new Concursante(3, "antonia", "pepota", "Gabacha", "28/04/1958", false, 10000, "maria", "pascuala");
		System.out.println(c2);
	}

}
