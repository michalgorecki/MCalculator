package pl.mgorecki.student.mcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void menuOnClick(View v){
        Intent intent = new Intent();
        switch(v.getId()){
            case R.id.simpleCalcButton :
                intent = new Intent(this,SimpleCalculatorActivity.class);
                break;
            case R.id.scientificCalcButton :
                intent = new Intent(this,ScientificCalculatorActivity.class);
                break;
            case R.id.aboutButton :
                intent = new Intent(this,AboutActivity.class);
                break;
            default:
                break;

        }
        MainActivity.this.startActivity(intent);
    }

}
