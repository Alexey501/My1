public class ThreadMain implements Runnable {
    int n;
    int[] arr;
    int border;
    int min = Integer.MAX_VALUE;
    int min_n;
    main main = new main();

    public ThreadMain(int n, int[] arr, int border) {
        this.n = n;
        this.arr = arr;
        this.border = border;

    }

    public void run() {
        for (int i = border; i < border + arr.length / n; i++) {
            if (min > arr[i]) {
                min = arr[i];
                min_n = i;
            }
        }
        if (n == 0) {
            main.setMin(min);
            main.setMin_n(min_n);
        }
        System.out.println("Минимальное значение потока: " + min + " индекс " + min_n);
        min();
    }

    public void min() {
       synchronized (this) {
            if (min <= main.getMin()) {
                main.setMin(min);
                main.setMin_n(min_n);
                System.out.println(main.getMin());}
      }
    }
}

