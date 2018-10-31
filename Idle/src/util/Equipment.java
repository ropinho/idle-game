package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import personagem.Hero;

public class Equipment {
	private int[] Attribute;

	public void equiparPersonagem(Hero person){
		person.showAttributes();

		for(int i=0; i<6; i++){
			Attribute[0] = person.getAttributes(i) + (person.getAttributes(i) * 37)/100
		}

		for(int i=0; i<6; i++){
			System.out.println(Attribute[i]);
		}
		
	}	

	public void equipamentos(){
		String equipamento = null;
		Path endereco = Paths.get("src/util/dados.txt"); //Cria o objeto do tipo path contendo o caminho do txt
		
		try {
			byte[] texto = Files.readAllBytes(endereco);
			equipamento = new String(texto);
			
		}catch(Exception erro) {
			
		}
		
		String[] separar = equipamento.split(",");
		
		System.out.println(separar[0]);
	}
}
