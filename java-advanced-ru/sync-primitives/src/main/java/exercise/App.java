package exercise;

class App {

    public static void main(String[] args) {
        // BEGIN
        SafetyList list = new SafetyList();
        Thread thread1 = new Thread(new ListThread(list));
        Thread thread2 = new Thread(new ListThread(list));

        // Запускаем потоки
        thread1.start();
        thread2.start();

        // Дожидаемся окончания выполнения потоков
        try {

            thread1.join();
            thread2.join();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted");
        }
        System.out.println("Size: " + list.getSize());
        // END
    }
}

