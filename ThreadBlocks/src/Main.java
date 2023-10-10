import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int x = 6;
        int y = 2;

        Thread f1 = new Thread(new Task("plus", x,y));
        Thread f2 = new Thread(new Task("minus", x, y));
        Thread f3 = new Thread(new Task("multiply", x, y));
        Thread f4 = new Thread(new Task("divide", x, y));
        Thread f5 = new Thread(new Task("plusMult", x, y));

        Thread f6 = new Thread(new Runnable() {
            @Override
            public void run() {

                List<Integer> list = new ArrayList<>();
                int res = 0;

                InputStreamReader reader;
                try {
                    reader = new InputStreamReader(new FileInputStream("data.txt"), "UTF-8");
                    BufferedReader breader = new BufferedReader(reader);

                String line = "";
                while (breader.ready()) {
                    line = breader.readLine();
                    if(!line.isEmpty()) {
                        list.add(Integer.valueOf(line));
                    }
                    System.out.println(line);
                }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                for(int n : list){
                    res = res + n;
                }
                System.out.println(res);
            }

        });

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