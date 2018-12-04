package util;

import personagem.Character;
import personagem.Hero;

import item.Item;
import map.Map;
/*
 * Módulo criado para impressão de logs, instruções e informações no terminal
 * */

public abstract class Console {
	
	public static void printAllCharacterInfo(Hero character) {
		System.out.printf("Nome: %s\nJob: %s\n", character.getName(), character.getJOB());
		System.out.printf("Level: %d\n", character.getLevel());
		printAttributesOf(character);
		System.out.printf("\nPower: %d\nHP: %d\nXP: %d\n", character.getPower(), character.getHp(), character.getXp());
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
	
	public static void printIncreaseXP(int xp) {
		System.out.printf("Ganhou +%dXP\n", xp);
	}
	
	public static void levelUp(Character c) {
		System.out.printf("%s LEVEL UP! New Level -> %d\n", c.getName(), c.getLevel());
	}

	public static void printEquip(Item equip){
		System.out.println("Item: " + equip.getName()
							+ " \nlevel: " + equip.getLevel() 
							+ "\nAtack: " + equip.getAtack()
							+ "\nDefense: " + equip.getDefense() 
							+ "\nHp: " + equip.getHp());
	}
	public static void printMap(Map fase) {
		System.out.println("Fase: " + fase.getFase() + " - Nivel: " + fase.getLevel());
	}
}
