package mooc.vandy.java4android.calculator.logic;

public class Subtract extends SimpleCalculation{
    public Subtract(int arg1, int arg2){
        super(arg1, arg2);
        answer = arg1 - arg2;
    }

    public String toString(){
        return answer + "";
    }
}
