package com.example.lernapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;


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
                        Client client = new Client();
                try {
                    int[] erg= client.execute().get();
                    int i = erg[0];
                    int j = erg[1];
                    int k = erg[10];
                    Toast.makeText(GrundrechenartenActivity.this,
                            "JAAA "+i+" * "+j+"= "+k, Toast.LENGTH_LONG).show();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                //Operand1.setText(""+i);
                //Toast.makeText(GrundrechenartenActivity.this,
                //        ""+i, Toast.LENGTH_LONG).show();
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

    /**
     * Baut Verbindung zum Server auf und weißt die erhaltenen Werte den Felder in der UI zu
     */
    public void createrandomvalues(){
        EditText Operand1 = (EditText) findViewById(R.id.Operand1); Operand1.setKeyListener(null);
        EditText Operand2 = (EditText) findViewById(R.id.Operand2); Operand2.setKeyListener(null);
        EditText Operand3 = (EditText) findViewById(R.id.Operand3); Operand3.setKeyListener(null);
        EditText Operand4 = (EditText) findViewById(R.id.Operand4); Operand4.setKeyListener(null);
        EditText Operand5 = (EditText) findViewById(R.id.Operand5); Operand5.setKeyListener(null);
        EditText Operand6 = (EditText) findViewById(R.id.Operand6); Operand6.setKeyListener(null);
        EditText Operand7 = (EditText) findViewById(R.id.Operand7); Operand7.setKeyListener(null);
        EditText Operand8 = (EditText) findViewById(R.id.Operand8); Operand8.setKeyListener(null);
        EditText Operand9 = (EditText) findViewById(R.id.Operand9); Operand9.setKeyListener(null);
        EditText Operand10 = (EditText) findViewById(R.id.Operand10); Operand10.setKeyListener(null);

        Client client = new Client();
        try {
            int []erg = client.execute().get();
            int i1=erg[0]; Operand1.setText(""+i1);
            int i2=erg[1]; Operand2.setText(""+i2);
            int i3=erg[2]; Operand3.setText(""+i3);
            int i4=erg[3]; Operand4.setText(""+i4);
            int i5=erg[4]; Operand5.setText(""+i5);
            int i6=erg[5]; Operand6.setText(""+i6);
            int i7=erg[6]; Operand7.setText(""+i7);
            int i8=erg[7]; Operand8.setText(""+i8);
            int i9=erg[8]; Operand9.setText(""+i9);
            int i10=erg[9]; Operand10.setText(""+i10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    public void switchBack(View view){
        Intent intent = new Intent(this, AuswahlActivity.class);
        startActivity(intent);
    }
}
