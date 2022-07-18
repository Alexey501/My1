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
                }
                main.Min[n_arr]=main.min;
            }
            border = border + arr.length / n;
            System.out.println(main.min);
            Min();
            n_Min();
        }
        public synchronized void Min(){
                if(main.min_full>main.Min[n_arr]){
                    main.min_full=main.Min[n_arr];
                }
        }
        public synchronized void n_Min(){
            int min=Integer.MAX_VALUE;
            for(int i=0;i<arr.length;i++){
                if (min > arr[i]) {
                    min=arr[i];
                    main.n_min=i;
                }
            }
        }
}
