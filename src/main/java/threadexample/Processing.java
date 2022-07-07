package threadexample;

import java.util.Scanner;

public class Processing {
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("produce method runnin...");
            wait();
            System.out.println("just resumed...");
        }
    }


    public void consume() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(500);

        synchronized (this) {
            System.out.println("waitng for return key...");
            scanner.nextLine();
            System.out.println("return key pressed...");
            notify();
            Thread.sleep(1000);
        }

    }
}
