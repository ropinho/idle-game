
public class Personagem {

	// Atributos comuns a todos os personagens	
	protected String nome;
	protected int hp; // saúde
	protected int xp; // experiencia
	protected int level;
	/***/ // ideia: vetor de atributos
	protected int forca;
	protected int destreza;
	protected int agilidade;
	protected int inteligencia;
	protected int sorte;
	protected int vitalidade;
	/***/
	protected int poder;
	protected int overall;
	
	public Personagem(String nome){
		this.nome = nome;
		this.hp = 400;
		this.xp = 0;
		this.level = 1;
		this.forca = 100;
		this.destreza = 100;
		this.agilidade = 100;
		this.inteligencia = 100;
		this.sorte = 100;
		this.vitalidade = 100;
		this.poder = 100;
	}


	/* incrementadores de atributos */
	public void incrForca(int i){ forca+=i; }
	public void incrDestreza(int i){ destreza+=i; }
	public void incrAgilidade(int i){ agilidade+=i; }
	public void incrInteligencia(int i){ inteligencia+=i; }
	public void incrSorte(int i){ sorte+=i; }
	public void incrVitalidade(int i){ vitalidade+=i; }


}
