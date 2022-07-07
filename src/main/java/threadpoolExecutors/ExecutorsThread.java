package threadpoolExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsThread {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 20; i++) {
            executorService.submit(new MyThread("A"));
            executorService.submit(new MyThread("B"));
            executorService.submit(new MyThread("C"));
            executorService.submit(new MyThread("D"));
        }
        executorService.shutdown();
    }
}

class MyThread extends Thread {

    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            System.out.println(i+" "+name);
        }
    }
}

