import javax.swing.*;
import java.util.Random;

public class main {
    public static void main(String[] args) {
    Random random = new Random();
      String str =  JOptionPane.showInputDialog(null," введите количество потоков: ");
      int n = Integer.parseInt(str);

    for(int i=1;i<=n;i++){
        new Thread(new  MyThread(i,random.nextInt(1,5),random.nextInt(0,999))).run();
    }
    }
}
