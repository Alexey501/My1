public class calculation extends Thread {
    Stoper stoper;
    public calculation(Stoper stoper){
        this.stoper=stoper;
        new Thread(new Stoper()).start();
    }
    @Override
    public void run() {
        long sum = 0;
        do{
            sum++;

        } while (Main.canBreak==false);
        System.out.println(sum);
   }

}
