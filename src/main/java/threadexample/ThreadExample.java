package threadexample;

/**
 * wait(),notify(),synchronized example
 */
public class ThreadExample {

    public static void main(String[] args) {
        System.out.println("main thread started" + Thread.currentThread().getName());

        Processing processing = new Processing();

        new Thread(() -> {
            try {
                processing.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();


        new Thread(() -> {
            try {
                processing.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();


        System.out.println("main thread finished" + Thread.currentThread().getName());
    }

}

