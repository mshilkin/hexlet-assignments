package exercise;

// BEGIN
public class MinThread extends Thread {
    private int[] numbers;
    private static Integer min;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        System.out.println("INFO: Thread: " + Thread.currentThread().getName() + " started");
        min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        System.out.println("INFO: Thread: " + Thread.currentThread().getName() + " finished");
    }

    public static Integer getMin() {
        return min;
    }
}
// END
