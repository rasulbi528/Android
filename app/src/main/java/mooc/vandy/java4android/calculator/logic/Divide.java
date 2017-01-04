package mooc.vandy.java4android.calculator.logic;

public class Divide extends SimpleCalculation{
    private int remainder;
    public Divide(int arg1, int arg2){
        super(arg1, arg2);
        answer = arg1/arg2;
        remainder = arg1%arg2;
    }
    public String toString(){
        return answer + " R: " + remainder;
    }
}
