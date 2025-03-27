package exercise;

// BEGIN
    public class MaxThread extends Thread {
        private int[] numbers;
        private static Integer max;

        public MaxThread(int[] numbers) {
            this.numbers = numbers;
        }

        @Override
        public void run() {
            System.out.println("INFO: Thread: " + Thread.currentThread().getName() + " started");
            max = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] > max) {
                    max = numbers[i];
                }
            }
            System.out.println("INFO: Thread: " + Thread.currentThread().getName() + " finished");
        }

        public static Integer getMax() {
            return max;
        }
    }
// END
