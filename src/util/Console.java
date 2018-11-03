package util;

import personagem.Character;
import personagem.Hero;

public abstract class Console {
	
	/*
	 * Mostrar toda a informação do personagem no console
	 * */
	public static void printAllCharacterInfo(Hero character) {
		System.out.printf("Nome: %s\nJob: %s\n", character.getName(), character.getJOB());
		printAttributesOf(character);
		System.out.printf("\nPower: %d\nHP: %d\n", character.getPower(), character.getHp());
	}
	
	public static void printAttributesOf(Character character) {
		String[] nomes = character.getAttrNames();
		for (int i=0; i < 6; i++)
			System.out.printf("[%d] %s = %d\n", i+1, nomes[i], character.getAttributes()[i]);
	}

}
