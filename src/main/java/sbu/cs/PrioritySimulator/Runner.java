import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Runner {
    public static List<Message> messages = new ArrayList<>();

    public void run(int blackCount, int blueCount, int whiteCount) throws InterruptedException {
        List<ColorThread> colorThreads = new ArrayList<>();
        CountDownLatch blackLatch = new CountDownLatch(blackCount);
        CountDownLatch blueLatch = new CountDownLatch(blueCount);

        for (int i = 0; i < blackCount; i++) {
            BlackThread blackThread = new BlackThread(blackLatch);
            colorThreads.add(blackThread);
            blackThread.start();
        }

        blackLatch.await();
        for (int i = 0; i < blueCount; i++) {
            BlueThread blueThread = new BlueThread(blueLatch);
            colorThreads.add(blueThread);
            blueThread.start();
        }

        blueLatch.await(); 
        for (int i = 0; i < whiteCount; i++) {
            WhiteThread whiteThread = new WhiteThread();
            colorThreads.add(whiteThread);
            whiteThread.start();
        }
        
        for (ColorThread thread : colorThreads) {
            thread.join();
        }
    }

    synchronized public static void addToList(Message message) {
        messages.add(message);
    }

    public List<Message> getMessages() {
        return messages;
    }

    public static void main(String[] args) throws InterruptedException {
        Runner runner = new Runner();
        runner.run(2, 3, 4);
        List<Message> messages = runner.getMessages();
        for (Message message : messages) {
            System.out.println(message);
        }
    }
}
