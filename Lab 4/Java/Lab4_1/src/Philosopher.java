import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {
    private int id;
    private int n;
    Main main=new Main();
    public  Philosopher(int id, int n){
        this.id=id;
        this.n=n;
    }

    @Override
    public void run() {
        int diner=n-1;
        if(id<diner){
            System.out.println("philosopher "+ id +" thinking");
            System.out.println("philosopher "+id+" await fork");
            try {
                main.fork[id].acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                main.fork[id+1].acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("philosopher "+id+" took fork");
            main.fork[id].release();
            main.fork[id+1].release();
            System.out.println("philosopher "+id+" put down the fork");
       }

        else {
            System.out.println("philosopher "+ id +" thinking");
            System.out.println("philosopher "+id+" await fork");
            try {
                main.fork[id-1].acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                main.fork[id].acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("philosopher "+id+" took fork");
            main.fork[id-1].release();
            main.fork[id].release();
            System.out.println("philosopher "+id+" put down the fork");
        }
    }
}
