import javax.swing.*;
        import java.util.concurrent.Semaphore;

public class Main {
   public static Semaphore fork[];
    public static void main(String[] args) {
        String str= JOptionPane.showInputDialog(null,"enter the number of philosophers and forks");
        int n=Integer.parseInt(str);
        fork=new Semaphore[n];
        for (int i = 0; i < n; i++)
        {
            fork[i] = new Semaphore(1);
        }
        for (int i = 0; i < n; i++)
        {
            new Thread(new Philosopher(i, n)).run();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
