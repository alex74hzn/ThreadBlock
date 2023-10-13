import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Reader  implements Runnable{
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

}