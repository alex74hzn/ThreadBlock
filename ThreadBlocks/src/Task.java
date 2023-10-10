import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Task implements Runnable{
    String name;
    int x;
    int y;
    int res;
    Function function = new Function();
    public Task(String fName,int x, int y) {
        this.name = fName;
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        switch(name){
            case "plus":
                res = function.plus(x, y);
                break;
            case "minus":
                res = function.minus(x,y);
                break;
            case "multiply":
                res = function.multiply(x,y);
                break;
            case "divide":
                res = function.divide(x,y);
                break;
            case "plusMult":
                res = function.plusMult(x,y);
                break;
            default: break;
        }

        writeToFile();
    }
    public void writeToFile(){
        try {

            BufferedWriter fw = new BufferedWriter(new FileWriter("data.txt",true));
            fw.write(String.valueOf(res + "\n"));
            fw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}