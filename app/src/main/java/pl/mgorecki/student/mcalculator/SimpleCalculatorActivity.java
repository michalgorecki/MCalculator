package pl.mgorecki.student.mcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pl.mgorecki.student.mcalculator.utils.SimpleCalculator;

public class SimpleCalculatorActivity extends AppCompatActivity {
    public static final String EMPTY_STRING = "";
    private StringBuilder currentString = new StringBuilder();
    private Button currentButton;
    private SimpleCalculator calculator;


    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calculator);
        calculator = new SimpleCalculator();
        textView = (TextView)findViewById(R.id.textView);
        textView.setText(EMPTY_STRING);
    }

    public void digitOnClick(View v){
        currentButton = (Button) v;
        if(currentButton.getText().equals(".") && currentString.toString().contains(".")){
            Toast.makeText(SimpleCalculatorActivity.this,"Dot already inserted",Toast.LENGTH_SHORT).show();
        }else{
            currentString.append(currentButton.getText().toString());
            textView.setText(currentString.toString());
        }
    }


    public void operatorOnClick(View v){
        calculator.calculationStep(currentString.toString());
        currentButton = (Button) v;

        calculator.calculationStep(((Button) v).getText().toString());
        currentString = new StringBuilder();
        textView.setText(calculator.getCurrentResult());
    }

    public void cOnClick(View v){
        calculator.calculationStep("C");
        currentString = new StringBuilder();
        textView.setText("");
    }
    public void ceOnClick(View v){
        calculator.calculationStep("CE");
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
