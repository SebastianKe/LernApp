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

    // Sämtliche Werte die der Server an den Client liefert..
    int[]values=new int[15];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grundrechenarten);
        createrandomvalues();
    }

    // Gleicht die vom Nutzer eingetragenen Werte mit den berechneten Werten des Servers ab
    public String[] calculateresults(View view) {
        EditText Result1 = (EditText) findViewById(R.id.Result1);
        EditText Result2 = (EditText) findViewById(R.id.Result2);
        EditText Result3 = (EditText) findViewById(R.id.Result3);
        EditText Result4 = (EditText) findViewById(R.id.Result4);
        EditText Result5 = (EditText) findViewById(R.id.Result5);
        // Anzahl der falschen Ergebnisse
        int count=0;
        // Pointer auf das nächste vom Server berechnete Ergebnis
        int pointer=0;
        String[] enteredresults={Result1.getText().toString(), Result2.getText().toString(), Result3.getText().toString(),Result4.getText().toString(), Result5.getText().toString()};
        for(int i=0; i<enteredresults.length;i++) {
            if (!enteredresults[i].equals("" + values[10+pointer])) {
                count++;
                pointer++;
            }
           else{
                pointer++;
           }
        }
        if(count==0){
            Toast.makeText(GrundrechenartenActivity.this,
                    "Alles richtig! Glückwunsch", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(GrundrechenartenActivity.this,
                    count+" Ergebniss(e) falsch beantwortet", Toast.LENGTH_LONG).show();
        }
        String[]answer={"A_Mult",""+count};
        return answer;
    }

    /**
     * Baut Verbindung zum Server auf und weist die erhaltenen Werte den Felder in der UI zu
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
            values = client.execute().get();
            int i1=values[0]; Operand1.setText(""+i1);
            int i2=values[1]; Operand2.setText(""+i2);
            int i3=values[2]; Operand3.setText(""+i3);
            int i4=values[3]; Operand4.setText(""+i4);
            int i5=values[4]; Operand5.setText(""+i5);
            int i6=values[5]; Operand6.setText(""+i6);
            int i7=values[6]; Operand7.setText(""+i7);
            int i8=values[7]; Operand8.setText(""+i8);
            int i9=values[8]; Operand9.setText(""+i9);
            int i10=values[9]; Operand10.setText(""+i10);
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
