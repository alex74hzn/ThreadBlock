public class Main {
    public static void main(String[] args) {
        int x = 6;
        int y = 2;

        Thread f1 = new Thread(new Task("plus", x,y));
        Thread f2 = new Thread(new Task("minus", x, y));
        Thread f3 = new Thread(new Task("multiply", x, y));
        Thread f4 = new Thread(new Task("divide", x, y));
        Thread f5 = new Thread(new Task("plusMult", x, y));
        Thread f6 = new Thread(new Reader());

        f1.start();
        f2.start();
        f3.start();
        f4.start();
        f5.start();

        try {
            f1.join();
            f2.join();
            f3.join();
            f4.join();
            f5.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        f6.start();

    }

}
