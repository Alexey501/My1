import javax.swing.*;

public class MyThread implements Runnable {
    private int id;
    private int step;
    private int sum;
    private int end;
    private int count;
    @Override
    public void run() {
for(int i=0;i<end;i+=step) {
    sum+=i;
    count++;
}
        System.out.println(toString());
    }
    public  MyThread(int id, int step,int end){
    this.id=id;
    this.step=step;
    this.end=end;
    }

    @Override
    public String toString() {

        return "id: "+id+" сумма: "+sum+" количество операций: "+count+"";
    }
}
