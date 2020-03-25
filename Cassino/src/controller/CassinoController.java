package controller;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import model.Jogador;

public class CassinoController extends Thread {
	Jogador jogador[] = new Jogador[10];
	int pos, soma;

	public CassinoController() {
		for (int i = 0; i < 10; i++) {
			jogador[i] = new Jogador();
		}
	}
	
	@Override
	public void run() {
		int i = 0;
		jogar(i);
	}

	public void jogar(int i) {
		while (i < 10) {
			jogador[i].setDado1(ThreadLocalRandom.current().nextInt(1, 7));
			jogador[i].setDado2(ThreadLocalRandom.current().nextInt(1, 7));

			soma(jogador[i].getDado1(), jogador[i].getDado2(), i);
			pontuacao(i);
		}
	}

	public void soma(int dado1, int dado2, int i) {
		soma = dado1 + dado2;
		if (soma == 7 || soma == 11) {
			jogador[i].setPontos();
		}
	}

	public void pontuacao(int i) {
		if (jogador[i].getPontos() == 5) {
			pos++;
			if (pos < 4) {
				switch (pos) {
				case 1:
					System.out.println("Jogador " + (i + 1) + " ganhou R$5000,00 em 1º lugar!");
					jogador[i].setPontos();
					break;
				case 2:
					System.out.println("Jogador " + (i + 1) + " ganhou R$4000,00 em 2º lugar!");
					jogador[i].setPontos();
					break;
				case 3:
					System.out.println("Jogador " + (i + 1) + " ganhou R$3000,00 em 3º lugar!");
					break;
				}
			} else {
				System.out.println("Agradecemos sua participação");
				System.exit(0);
			}
		}
		if (pos < 3) {
			if (i == 9) {
				i = 0;
			} else {
				i++;
			}
			jogar(i);
		}
	}
}
