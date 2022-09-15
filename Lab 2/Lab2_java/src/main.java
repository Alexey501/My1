import javax.swing.*;
import java.util.Random;

public class main {
    private static int  min=Integer.MAX_VALUE;
    private int threadCount;
    private static int [] elem_min;
    private static int [] elem_min_n;
    public static void main(String[] args) {
        int array_length=1000;
        int[] arr= new int[array_length];
        int border;
        Random r = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(0, 100);
        }
        int num=r.nextInt(0,array_length);
        arr[num]=-1;
        String str = JOptionPane.showInputDialog(null, "ведите количество потоков");
        int n = Integer.parseInt(str);
        elem_min = new int[n];
        elem_min_n=  new int[n];
        border = arr.length / n;
        for (int i = 0; i < n; i++) {
           Thread thread=new Thread( new ThreadMain(n, arr, border * i,i));
           thread.start();
        }
    }
    public void setThreadCount(int count){
        this.threadCount=count;
    }
    public int getThreadCount() {
        return threadCount;
    }
    public int getElem_min(int index){
        return elem_min[index];
    }
    public void setElem_min(int elem_min,int index){
        this.elem_min[index]=elem_min;
    }
    public int getElem_min_n(int index){
        return elem_min_n[index];
    }
    public void setElem_min_n(int elem_min_n,int index){
        this.elem_min_n[index]=elem_min_n;
    }
    public int [] getElem_min_array(){
        return elem_min;
    }
}




