import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int cmd;
		
		System.out.print("Criar personagem.\nDigite o nome: ");
		String nome = in.next();
		Personagem hero = null;

		System.out.print("Escolha a classe\n[1] Arqueiro\t[2] Espadachim\t[3] Mago\n");
		System.out.println("-----------------------------------------------");
		System.out.print("Digite: ");
		int classe = in.nextInt();
		
        hero = createPersonagem(classe, nome);
	
		/* recebe 50 pontos p/ distribuir nos atributos */
		int pts = 50;
		while (pts > 0) {
			System.out.println("------------------------------------------------");
			System.out.printf("Você tem %d pontos de atributos\n", pts);
			System.out.print("Escolha os atributo que deseja e em seguida digite o numero de pontos que deseja incrementar nele\n");
			showAttrMenu(hero);

			System.out.print("Atributo: ");
			cmd = in.nextInt();
			System.out.print("+Pontos: ");
			int q = in.nextInt(); // numero de pontos
			if (cmd == 1) hero.incrForca(q);
			if (cmd == 2) hero.incrDestreza(q);
			if (cmd == 3) hero.incrAgilidade(q);
			if (cmd == 4) hero.incrInteligencia(q);
			if (cmd == 5) hero.incrSorte(q);
			if (cmd == 6) hero.incrVitalidade(q);
			pts -= q;
		}

	}


	// instancia o objeto Persoagem a partir do numero de classe escolhido
    public static Personagem createPersonagem(int n, String nome){
        Personagem hero = null;
        if (n == 1){
			hero = new Arqueiro(nome);
		} else {
			if (n == 2){
				hero = new Espadachim(nome);
			} else {
				if (n == 3){
					hero = new Mago(nome);
				}
			}
		}
        return hero;
    }

    public static void showAttrMenu(Personagem p) {
    	System.out.printf("[1] Força = %d\n", p.forca);
    	System.out.printf("[2] Destreza = %d\n", p.destreza);
    	System.out.printf("[3] Agilidade = %d\n", p.agilidade);
    	System.out.printf("[4] Inteligencia = %d\n", p.inteligencia);
    	System.out.printf("[5] Sorte = %d\n", p.sorte);
    	System.out.printf("[6] Vitalidade = %d\n", p.vitalidade);
    }
}