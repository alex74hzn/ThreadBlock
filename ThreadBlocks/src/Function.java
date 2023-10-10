public class Function {

    public Function() {
    }



    public int plus(int x, int y){
        return x + y;
    }

    public int minus(int x, int y){
        return x - y;
    }

    public int multiply(int x, int y){
        return x * y;
    }

    public int divide(int x, int y){
        if(y == 0){
            y = 1;
        }
        return x / y;
    }

    public int plusMult(int x, int y){
       return x + y * x;
    }

}