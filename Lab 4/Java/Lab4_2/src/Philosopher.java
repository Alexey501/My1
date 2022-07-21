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
        System.out.println("philosopher "+ id +" thinking");
        System.out.println("philosopher "+id+" await fork");
        try {
                main.fork[0].acquire();
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
        try {
                main.fork[1].acquire();
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
        System.out.println("philosopher "+id+" took fork");
        System.out.println("philosopher "+id+" put down the fork");
    }
}

