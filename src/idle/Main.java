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

			showAttributeMenu(hero);

			System.out.print("Atributo: ");
			cmd = in.nextInt();

			System.out.print("+Pontos: ");
			int numeroDePontos = in.nextInt(); // numero de pontos

			if (cmd == 1) hero.incrForca(numeroDePontos);
			if (cmd == 2) hero.incrDestreza(numeroDePontos);
			if (cmd == 3) hero.incrAgilidade(numeroDePontos);
			if (cmd == 4) hero.incrInteligencia(numeroDePontos);
			if (cmd == 5) hero.incrSorte(numeroDePontos);
			if (cmd == 6) hero.incrVitalidade(numeroDePontos);
			pts -= numeroDePontos;
		}
	}


	// instancia o objeto Persoagem a partir do numero de classe escolhido
	public static Personagem createPersonagem(int classe, String nome){
		  Personagem hero = null;
			if (classe == 1){
				hero = new Arqueiro(nome);
			} else {
					if (classe == 2){
						hero = new Espadachim(nome);
			} else {
					if (classe == 3){
						hero = new Mago(nome);
					}
				}
			}
			return hero;
  }

	public static void showAttributeMenu(Personagem hero) {
		System.out.printf("[1] Força = %d\n", hero.getForca());
		System.out.printf("[2] Destreza = %d\n", hero.getDestreza());
		System.out.printf("[3] Agilidade = %d\n", hero.getAgilidade());
		System.out.printf("[4] Inteligencia = %d\n", hero.getInteligencia());
		System.out.printf("[5] Sorte = %d\n", hero.getSorte());
		System.out.printf("[6] Vitalidade = %d\n", hero.getVitalidade());
		}

}
