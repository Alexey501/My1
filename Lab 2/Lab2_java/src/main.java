import javax.swing.*;
import java.util.Random;

public class main {
    private static Thread[] art;
    private static int n;
    public static int min_full=0;
    private static int border;
    private static int[] arr;
    public static int min=Integer.MAX_VALUE;
    public static int [] Min;
    public static int n_min;

    public static void main(String[] args) {
        arr = new int[100];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(0, 1000);
        }
        int num=r.nextInt(0,100);
        arr[num]=-1;
        String str = JOptionPane.showInputDialog(null, "ведите количество потоков");
        n = Integer.parseInt(str);
        border = arr.length / n;
        art = new Thread[n];

        for (int i = 0; i < n; i++) {
            art[i] =new Thread( new ThreadMain(n, arr, border * i,i));
            art[i].start();
            try {
                art[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Минимальное число масива: "+main.min_full+" номер елемента: "+n_min+"");
    }

}



