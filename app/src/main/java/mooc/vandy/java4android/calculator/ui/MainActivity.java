package mooc.vandy.java4android.calculator.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Arrays;

import mooc.vandy.java4android.calculator.R;
import mooc.vandy.java4android.calculator.logic.Logic;
import mooc.vandy.java4android.calculator.logic.LogicInterface;

public class MainActivity extends Activity implements ActivityInterface {
    private Spinner mMathSpinner;
    private Button mCalculate;
    private EditText mValueOne;
    private EditText mValueTwo;
    private EditText mResult;
    private LogicInterface mLogic;
    private ArrayAdapter<CharSequence> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Call up to the super class.
        super.onCreate(savedInstanceState);
        initializeUI();
        mLogic = (LogicInterface) new Logic(this);
    }

    /**
     * Initialize the UI.
     */
    private void initializeUI(){
        // Set the layout.
        setContentView(R.layout.activity_main);

        // Store a reference to the mCalculate button.
        mCalculate = (Button) findViewById(R.id.calculate_button);

        // Store references to the two values entered by the user.
        mValueOne = (EditText) findViewById(R.id.valueOneEditText);
        mValueTwo = (EditText) findViewById(R.id.valueTwoEditText);

        // Store a reference to the MathSpinner.
        mMathSpinner = (Spinner) findViewById(R.id.mathSpinner);

        // Store a reference to the EditText containing the result.
        mResult = (EditText) findViewById(R.id.results);

        // Initialize the adapter.
        mAdapter =
            ArrayAdapter.createFromResource(this,
                                            R.array.math_options,
                                            android.R.layout.simple_spinner_item);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Associate the ArrayAdapter with the Spinner.
        mMathSpinner.setAdapter(mAdapter);

        // Set the default selection of the mMathSpinner to be "add".
        mMathSpinner.setSelection(mAdapter.getPosition("add"));
    }

    /**
     * Called back by the Android UI framework when the user presses
     * the "Calculate" button.
     */
    public void buttonPressed(View view){
        // Operation selected by the user.
        final int operation = getOperationNumber();

        // First argument specified by the user.
        final int argOne = getValueOne();

        // Second argument specified by the user.
        int argTwo = getValueTwo();

        // Perform the operation on the two arguments.
        mLogic.process(argOne, argTwo, operation);
    }

    /**
     * Get the value of the first user input operand.
     */ 
    @Override
    public int getValueOne() {
        return Integer.valueOf(mValueOne.getText().toString());
    }

    /**
     * Get the value of the second user input operand.
     */ 
    @Override
    public int getValueTwo() {
        return Integer.valueOf(mValueTwo.getText().toString());
    }

    /**
     * Get the value of the user input operation.
     */
    @Override
    public int getOperationNumber() {
        return Arrays.asList(getResources()
                     .getStringArray(R.array.math_options))
                     // Added 1 to start the selected operation from 1 rather than 0.
                     .indexOf(mMathSpinner.getSelectedItem().toString()) + 1;
    }

    /**
     * Print the result to the user's display.
     */
    @Override
    public void print(String resultString) {
        mResult.setText(resultString);
    }
}
