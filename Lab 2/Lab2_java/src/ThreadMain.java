public class ThreadMain implements Runnable {
    int n;
    int []arr;
    int border;
    int n_arr;
    int n_min;
    int Min=Integer.MAX_VALUE;
    int min=Integer.MAX_VALUE;
    public  ThreadMain(int n, int[] arr, int border,int n_arr){
        this.n=n;
        this.arr=arr;
        this.border=border;
        this.n_arr=n_arr;
    }
    public void  run(){
            setmin();
        }
        public synchronized void setmin(){
            for (int i = border; i < border + arr.length / n; i++)
            if (min > arr[i]) {
                min = arr[i];
            }
            border = border + arr.length / n;
            System.out.println("Минимальное значение потока: " + min);
            for(int i=0;i<arr.length;i++){
                if(Min>arr[i]){
                    Min=arr[i];
                    n_min=i;
                }
            }
    }
    public int getmin(){return min;
    }
    public int getN_min(){return n_min;
    }
}
