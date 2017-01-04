package mooc.vandy.java4android.calculator.logic;

public class SimpleCalculation {
    private String returnAnswer;
    private final int ADDITION = 1;
    private final int SUBTRACTION = 2;
    private final int MULTIPLICATION = 3;
    private final int DIVISION = 4;
    protected int arg1;
    protected int arg2;
    protected int answer;

    SimpleCalculation(int arg1, int arg2){
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    SimpleCalculation(int arg1, int arg2, int operation){
        this(arg1, arg2);
        answer(operation);
    }

    private void answer(int operation){
        String returnAnswer = "";
        switch(operation){
            case 1:
                Add add = new Add(arg1, arg2);
                returnAnswer = add.toString();
                break;
            case 2:
                Subtract subtract = new Subtract(arg1, arg2);
                returnAnswer = subtract.toString();
                break;
            case 3:
                Multiply multiply = new Multiply(arg1, arg2);
                returnAnswer = multiply.toString();
                break;
            case 4:
                Divide divide = new Divide(arg1, arg2);
                returnAnswer = divide.toString();
                break;
        }
        this.returnAnswer = returnAnswer;
    }

    public String toString(){
        return returnAnswer;
    }


}
