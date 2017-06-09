package com.example.lernapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class GrundrechenartenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grundrechenarten);
        createrandomvalues();
    }

    public void calculateresults(View view) {
        EditText Operand1 = (EditText) findViewById(R.id.Operand1);
        EditText Operand2 = (EditText) findViewById(R.id.Operand2);
        TextView Operator1 = (TextView) findViewById(R.id.Operator1);
        EditText Result1= (EditText) findViewById(R.id.Result1);
        if(Operator1.getText().toString().equals("X") && !(Result1.getText().toString().equals(""))) {
            String resulttext= Result1.getText().toString();
            String operand1text = Operand1.getText().toString();
            String operand2text = Operand2.getText().toString();
            int operand1number = Integer.parseInt(operand1text);
            int operand2number = Integer.parseInt(operand2text);
            int expected=Integer.parseInt(resulttext);
            if(operand1number*operand2number==expected){
                Toast.makeText(GrundrechenartenActivity.this,
                        "Richtig!", Toast.LENGTH_LONG).show();
                        switchBack(view);
                        Client client = new Client();
                        client.execute("5");
            }
            else {
                Toast.makeText(GrundrechenartenActivity.this,
                        "Falsch!", Toast.LENGTH_LONG).show();
            }
            //Toast.makeText(GrundrechenartenActivity.this,
            //        "Your Message", Toast.LENGTH_LONG).show();
            //Operator1.setText("T");
        }
        else {
            Toast.makeText(GrundrechenartenActivity.this,
                    "Tragen Sie bitte erst alle Ergebnisse ein!", Toast.LENGTH_LONG).show();
        }
    }

    public void createrandomvalues(){
        EditText Operand1 = (EditText) findViewById(R.id.Operand1);
        EditText Operand2 = (EditText) findViewById(R.id.Operand2);
        Operand1.setKeyListener(null);
        Operand2.setKeyListener(null);
        String randomvalue1= ""+Math.round(Math.random()*8+1);
        String randomvalue2= ""+Math.round(Math.random()*8+1);
        Operand1.setText(randomvalue1);
        Operand2.setText(randomvalue2);
    }


    public void switchBack(View view){
        Intent intent = new Intent(this, AuswahlActivity.class);
        startActivity(intent);
    }
}
