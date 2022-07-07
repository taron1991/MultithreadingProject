package semaphorexample;

import java.util.concurrent.Semaphore;

/**
 * semaphore example
 */
public class Start {

    public static void main(String[] args) {

        Semaphore sem = new Semaphore(2);
        new Philosophers(sem,"Сократ").start();
        new Philosophers(sem,"Платон").start();
        new Philosophers(sem,"Аристотель").start();
        new Philosophers(sem,"Фалес").start();
        new Philosophers(sem,"Пифагор").start();
    }

}

