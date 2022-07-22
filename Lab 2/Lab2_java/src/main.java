import javax.swing.*;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        int[] arr= new int[100];
        int border;
        int full=Integer.MAX_VALUE;
        int n_min = 0;
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(0, 1000);
        }
        int num=r.nextInt(0,100);
        arr[num]=-1;
        String str = JOptionPane.showInputDialog(null, "ведите количество потоков");
        int n = Integer.parseInt(str);
        border = arr.length / n;
        int m []=new int[n];
        for (int i = 0; i < n; i++) {
           ThreadMain t = new ThreadMain(n, arr, border * i,i);
           t.run();
           m[i]=t.getmin();
           n_min=t.getN_min();
        }
        System.out.println("Минимальный елемент масива: "+n_min+" значение масива: "+Min(m,n,full));
    }
    public static int Min(int[] m, int n, int full){
        for(int i=0;i<n;i++){
            if(full>m[i]){
              full=m[i];
            }
        }
        return full;
}
}




