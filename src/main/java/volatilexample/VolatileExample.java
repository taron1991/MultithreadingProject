package volatilexample;

import java.util.Scanner;

public class VolatileExample {
    public static void main(String[] args) {
        MyThread1 myThread = new MyThread1();
        new Thread(myThread).start();

        new Scanner(System.in).nextLine();
        myThread.shutdown();
    }
}

class MyThread1 implements Runnable {
    /**
     * теоретически без ключевого слова volatile, поток main может прочитать старое значение поля из-за особенностей процессора,
     * чтобы избежать этого следует указать volatile для полей
     */
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("hello");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void shutdown() {
        this.running = false;
    }
}

