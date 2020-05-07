package cruzamento;

import java.util.concurrent.Semaphore;

public class CruzamentoThread extends Thread{
	private int numCarro;
	private String sentido;
	private Semaphore semaforo;
	
	public CruzamentoThread(int numCarro, String sentido, Semaphore semaforo) {
		this.numCarro = numCarro;
		this.sentido = sentido;
		this.semaforo = semaforo;
	}
	
	public void run() {
		try {
			semaforo.acquire();
			cruzaCarro();
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		finally{
			semaforo.release();
		}
	}
	
	public void cruzaCarro() {
			System.out.println("O carro "+numCarro+" cruzou para "+ sentido);
			atravessaCarro();
	}
		
	public void atravessaCarro() {
		int tempo = (int)(Math.random()+1)*1000;
		try {
			Thread.sleep(tempo);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	}
