package gui;

import personagem.*;
import util.Creator;
import util.Explore;

public class Controller {
	
	public Explore exploration;
	public Hero HERO;
	
	public Controller() {
		
	}
	
	/*
	 * Faz prints no console principal da GUI, na aba Jogo 
	 * */
	public void print(String s) {
		System.out.println(s);
		PlayFrame.console.append(s + "\n");
		PlayFrame.console.setCaretPosition(PlayFrame.console.getText().length()); // rolagem automática
	}
	
	
	/*
	 * Faz prints na area de texto da aba Mochila 
	 * */
	public void printBag(String s) {
		PlayFrame.bagInfo.append(s + "\n");
	}
	
	/*
	 * Atualiza as informações da Mochila
	 * */
	public void updateBagInfo() {
		
	}
	
	/*
	 * Atualiza as informações do Personagem
	 * */
	public void updateCharacterInfo() {
		PlayFrame.updateCharacterInfo();
	}
	
	public void createHero(String cls, String name) {
		try {
			HERO = Creator.createHero(cls, name);
			exploration = new Explore(HERO);
		} catch(NullPointerException e) {
			System.out.println("CreateHero(): "+ e.toString());
		}
	}
}
