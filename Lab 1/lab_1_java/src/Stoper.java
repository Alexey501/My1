public class Stoper implements Runnable{
    @Override
    public void run() {

        Main.canBreak = true;
    }
}
