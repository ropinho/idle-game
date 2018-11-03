package util;

import personagem.Character;
import personagem.Hero;

/*
 * Módulo criado para impressão de logs, instruções e informações no terminal
 * */

public abstract class Console {
	
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
	
	
	public static void printAtackLog(Character c1, Character c2, int damage) {
		System.out.printf("%s(%d) causou %d de dano em %s(%d)\n", c1.getName(), c1.getHp(), damage, c2.getName(), c2.getHp());
	}
	
	
	public static void printEndOfBattle(Character winner) {
		System.out.printf("%s venceu!\n", winner.getName());
	}
	
	public static void printGameOver() {
		System.out.println("GAME OVER! SE FODEU!!!");
	}

}