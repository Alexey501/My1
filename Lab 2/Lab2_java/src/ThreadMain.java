public class ThreadMain implements Runnable {
    int n;
    int []arr;
    int border;
    int n_arr;
    main main = new main();
        public  ThreadMain(int n, int[] arr, int border,int n_arr){
        this.n=n;
        this.arr=arr;
        this.border=border;
        this.n_arr=n_arr;
        main.Min=new int[n];
    }
 public void  run(){
            setmin();
        }
        public void setmin(){
            main.min=Integer.MAX_VALUE;
            for (int i = border; i < border + arr.length / n; i++) {
                if (main.min > arr[i]) {
                    main.min = arr[i];
                    main.n_min = i;
                }
                main.Min[n_arr]=main.min;
            }
            border = border + arr.length / n;
            System.out.println(main.min);
            Min();
        }
        public synchronized void Min(){
            for(int i=0;i<n;i++) {
                if(main.min_full>main.Min[i]){
                    main.min_full=main.Min[i];
                }
            }
        }
}
