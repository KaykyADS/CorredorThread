package view;

import java.util.concurrent.Semaphore;

import controller.ThreadController;

public class Principal {
    public static void main(String[] args) {
        int permissoes = 1;
        Semaphore semaforo = new Semaphore(permissoes);

        for (int idCorredor = 1; idCorredor < 5; idCorredor++) {
            Thread tCont = new ThreadController(idCorredor, semaforo);
            tCont.start();
        }
    }
}
