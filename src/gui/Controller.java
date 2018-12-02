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
	
	public void print(String s) {
		Play.console.append(s);
	}
	
}
