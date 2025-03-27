package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");
    private int[] numbers = {10, -4, 67, 100, -100, 8};

    // BEGIN
    public static void main(String[] args) {
        MaxThread thread = new MaxThread(numbers);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
        }

        System.out.println("...");
    }
    // END
}
