package model;

public class Jogador {
	private int dado1;
	private int dado2;
	private int pontos;

	public Jogador() {
		super();
	}

	public int getDado1() {
		return dado1;
	}

	public void setDado1(int dado1) {
		this.dado1 = dado1;
	}

	public int getDado2() {
		return dado2;
	}

	public void setDado2(int dado2) {
		this.dado2 = dado2;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos() {
		this.pontos = pontos + 1;
	}
}
