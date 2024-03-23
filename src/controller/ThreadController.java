package controller;

import java.util.concurrent.Semaphore;

public class ThreadController extends Thread {
    private int idCorredor;
    private Semaphore semaforo;
    private int caminho = 0;

    public ThreadController(int idCorredor, Semaphore semaforo) {
        super();
        this.idCorredor = idCorredor;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        Caminhar();
        try {
            semaforo.acquire();
            Porta();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }
    }

    private void Porta() {
        System.out.println("O corredor " + idCorredor + " está passando pela porta...\n");
        try {
            sleep((int)(Math.random() * 2) + 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("O corredor " + idCorredor + " passou.\n");
    }

    private void Caminhar() {   
        while (caminho < 200) {
            caminho += (int)(Math.random()*3) + 4;
            System.out.println("O corredor " + idCorredor + " caminhou " + caminho + " metros\n");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("O corredor " + idCorredor + " chegou.\n");
    }
}