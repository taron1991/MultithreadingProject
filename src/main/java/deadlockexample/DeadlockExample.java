package deadlockexample;

/**
 * ideal deadlock example
 */
public class DeadlockExample {

    public static void main(String[] args) {
        String a = "ABC";
        String b = "CDE";

        new Thread(() -> {
            synchronized (a) {
                System.out.println("A synchronized from thread 1");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (b) {
                    System.out.println("B synchronized from thread 1");
                }
            }
        }).start();


       new Thread(() -> {
            synchronized (b) {
                System.out.println("B synchronized from thread 2");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (a) {
                    System.out.println("A synchronized from thread 2");
                }
            }
        }).start();
    }

}

