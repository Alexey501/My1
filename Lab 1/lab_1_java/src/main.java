import javax.swing.*;

public class Main {
   public static boolean canBreak=false;
        public static void main(String[] args) {
            Stoper stoper = new Stoper();
        String str = JOptionPane.showInputDialog(null, " введите количество потоков: ");
        int n = Integer.parseInt(str);
        for(int i=0;i<n;i++) {
            new Thread(new calculation(stoper)).start();
        }
}}

