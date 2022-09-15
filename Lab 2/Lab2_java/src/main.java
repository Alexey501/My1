import javax.swing.*;
import java.util.Random;

public class main {
    private static int  min=Integer.MAX_VALUE;
    private static int min_n=-1;

    public static void main(String[] args) {
        int array_length=40;
        int[] arr= new int[array_length];
        int border;
        Random r = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(0, 10);
        }
        int num=r.nextInt(0,array_length);
        arr[num]=-1;
        String str = JOptionPane.showInputDialog(null, "ведите количество потоков");
        int n = Integer.parseInt(str);
        border = arr.length / n;
        for (int i = 0; i < n; i++) {
            new ThreadMain(n, arr, border * i).run();
        }
        System.out.println("Минимальный елемент масива: "+ min + " индекс "+ min_n);
    }
    public void setMin(int min){
        this.min=min;
    }

    public int getMin() {
        return min;
    }
    public void setMin_n(int min_n){
        this.min_n=min_n;
    }
}




