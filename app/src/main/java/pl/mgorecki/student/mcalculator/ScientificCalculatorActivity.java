package pl.mgorecki.student.mcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.EmptyStackException;

import pl.mgorecki.student.mcalculator.utils.InfixExpressionEvaluator;
import pl.mgorecki.student.mcalculator.utils.SimpleCalculator;

public class ScientificCalculatorActivity extends AppCompatActivity {

    public static final String EMPTY_STRING = "";
    private StringBuilder currentString = new StringBuilder();
    private Button currentButton;
    TextView textView;
    private InfixExpressionEvaluator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific_calculator);
        calculator = new InfixExpressionEvaluator();
        textView = (TextView) findViewById(R.id.textView);
    }


    public void insertOnClick(View v){
        currentButton = (Button) v;
        currentString.append(currentButton.getText().toString());
        textView.setText(currentString.toString());
    }

    public void equalsOnClick(View v){
        try{
            currentString = new StringBuilder(textView.getText().toString());
            String result = calculator.evaluateExpression(currentString.toString());
            textView.setText(result.toString());
            currentString = new StringBuilder(result);
            textView.setText(currentString);
        }catch(EmptyStackException e){
            textView.setText("Invalid expression");
        }

    }

    public void cOnClick(View v){
        calculator = new InfixExpressionEvaluator();
        currentString = new StringBuilder();
        textView.setText(currentString);
    }


    public void backspaceOnClick(View v){
        if(currentString.length() > 0) {
            currentString.deleteCharAt(currentString.length() - 1);
        }
        textView.setText(currentString);
    }
}
