package util;

import personagem.Character;

public interface Battle {
	
	public void start();
	
	public void finish();
	
	public Character winner();

}
