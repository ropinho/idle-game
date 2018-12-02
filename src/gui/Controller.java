package gui;

import personagem.*;
import util.Creator;
import util.Explore;

public class Controller {
	
	public Explore exploration;
	public Hero HERO;
	
	public Controller() {
		HERO = Creator.createHero("s", "Panaka");
		exploration = new Explore(HERO);
	}
	
	/*
	 * Faz prints no console principal da GUI, na aba Jogo 
	 * */
	public void print(String s) {
		Play.console.append(s + "\n");
	}
	
	
	/*
	 * Faz prints na area de texto da aba Mochila 
	 * */
	public void printBag(String s) {
		Play.bagInfo.append(s + "\n");
	}
	
}
