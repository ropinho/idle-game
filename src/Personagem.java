
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

	/* getters and stters */
	public String getNome(){return nome;}
	public String setNome(String nome){return this.nome = nome;}

	public int getXp(){return xp;}
	public int setXp(int xp){return this.xp = xp;}

	public int getLevel(){return level;}
	public int setLevel(int level){return this.level = level;}

	public int getForca(){return forca;}
	public int setForca(int forca){return this.forca = forca;}

	public int getDestreza(){return destreza;}
	public int setDestreza(int destreza){return this.destreza = destreza;}

	public int getAgilidade(){return agilidade;}
	public int setAgilidade(int agilidade){return this.agilidade = agilidade;}

	public int getInteligencia(){return inteligencia;}
	public int setInteligencia(int inteligencia){return this.inteligencia = inteligencia;}

	public int getSorte(){return sorte;}
	public int setSorte(int sorte){return this.sorte = sorte;}

	public int getVitalidade(){return vitalidade;}
	public int setVitalidade(int vitalidade){return this.vitalidade = vitalidade;}

	public int getPoder(){return poder;}
	public int setPoder(int poder){return this.poder = poder;}

	/* incrementadores de atributos */
	public void incrForca(int i){ forca+=i; }
	public void incrDestreza(int i){ destreza+=i; }
	public void incrAgilidade(int i){ agilidade+=i; }
	public void incrInteligencia(int i){ inteligencia+=i; }
	public void incrSorte(int i){ sorte+=i; }
	public void incrVitalidade(int i){ vitalidade+=i; }


}
