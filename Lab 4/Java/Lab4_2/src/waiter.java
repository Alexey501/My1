import java.util.concurrent.Semaphore;

public class waiter implements Runnable {
    Main main = new Main();

    public void waiter(){
        main.fork[0].release();
        main.fork[1].release();
    }

    @Override
    public void run() {
        waiter();
    }
}
