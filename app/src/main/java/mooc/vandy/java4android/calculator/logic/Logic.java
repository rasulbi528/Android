package mooc.vandy.java4android.calculator.logic;

import mooc.vandy.java4android.calculator.logic.Add;
import mooc.vandy.java4android.calculator.logic.Divide;
import mooc.vandy.java4android.calculator.logic.Multiply;
import mooc.vandy.java4android.calculator.logic.Subtract;
import mooc.vandy.java4android.calculator.ui.ActivityInterface;

public class Logic implements LogicInterface {
    protected ActivityInterface mOut;

    public Logic(ActivityInterface out){
        mOut = out;
    }

    public void process(int arg1, int arg2, int operation){
        SimpleCalculation answer = new SimpleCalculation(arg1, arg2, operation);
        mOut.print(answer.toString());
    }
}
