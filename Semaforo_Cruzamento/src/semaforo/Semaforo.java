package semaforo;

import java.util.concurrent.Semaphore;

import cruzamento.CruzamentoThread;

public class Semaforo {
	public static Semaphore semaforo;
	
	public static void main(String[] args) {
		
		int totalCarros = 4, cruzando = 1;
		String sentido[] = {"norte", "sul", "leste", "oeste"};
		semaforo = new Semaphore(cruzando);
		for(int i = 0; i<totalCarros;i++) {
			Thread cruzamento = new CruzamentoThread(i+1, sentido[i], semaforo);
			cruzamento.start();
		}
	}
}
