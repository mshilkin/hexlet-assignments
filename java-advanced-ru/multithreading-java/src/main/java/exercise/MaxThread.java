package exercise;

// BEGIN
    public  class MaxThread extends  Thread {

        private int[] numbers;

        public MaxThread(int[] numbers) {
            this.numbers = numbers;
        }

        @Override
        public void run() {
            System.out.println("Thread: MaxThread");
        }
    }
// END
