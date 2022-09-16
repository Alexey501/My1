public class ThreadMain implements Runnable {
    int n;
    int[] arr;
    int border;
    int min = Integer.MAX_VALUE;
    int min_n;
    int count;
    int [] array;
    main main= new main();

    public ThreadMain(int n, int[] arr, int border,int count) {
        this.n = n;
        this.arr = arr;
        this.border = border;
        this.count=count;
    }
    public void run() {
        for (int i = border; i < border + arr.length / n; i++) {
            if (min > arr[i]) {
                min = arr[i];
                min_n = i;
            }
        }
        main.setElem_min(min,count);
        main.setElem_min_n(min_n,count);
        System.out.println("Минимальное значение потока: " + main.getElem_min(count) + " индекс " + main.getElem_min_n(count));
        main.setThreadCount(count);
        array=stop();
        min();
    }
    public synchronized int[] stop(){
        while (main.getThreadCount() < n-1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return main.getElem_min_array();
    }
    public void min() {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (min > array[i]) {
                    min = array[i];
                    min_n = main.getElem_min_n(i);
                }
            }
            System.out.println("Минимальный елемент масива: " + min + " индекс " + min_n);
        }
}

