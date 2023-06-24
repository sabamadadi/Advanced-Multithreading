package sbu.cs.Semaphore;

import java.util.concurrent.Semaphore;

public class Resource {

    private static Semaphore semaphore = new Semaphore(2);

    public static void accessResource() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " Time equals to : " + System.currentTimeMillis());
            Thread.sleep(100);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
