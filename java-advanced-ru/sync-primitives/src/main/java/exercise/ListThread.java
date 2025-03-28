package exercise;

// BEGIN

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ListThread extends Thread{
    private SafetyList list;
    Random random = new Random();

    public ListThread(SafetyList list) {
        this.list = list;
    }

    @Override
    public  void run(){
        for (int i = 0; i < 1000; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list.add(random.nextInt());
        }

    }
}
// END
