package com.example.lernapp;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class SubActivity extends AppCompatActivity  {

    // Sämtliche Werte die der Server an den Client liefert..
    String[]values=new String[15];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        createrandomvalues();

    }

    // Gleicht die vom Nutzer eingetragenen Werte mit den berechneten Werten des Servers ab
    public void calculateresults(View view) throws InterruptedException, ExecutionException {
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
            if (!enteredresults[i].equals(values[10+pointer])) {
                count++;
                pointer++;
            }
            else{
                pointer++;
            }
        }
        if(count==0){
            Toast.makeText(SubActivity.this,
                    "Alles richtig! Glückwunsch", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(SubActivity.this,
                    count+" Ergebniss(e) falsch beantwortet", Toast.LENGTH_LONG).show();
        }
        String[]answer={"A_Sub",""+count, Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID)};
        Client client=new Client();
        client.execute(answer);
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

        String[] s={"Sub"};
        Client client=new Client();
        try {
            values = client.execute(s).get();
            String s1=values[0]; Operand1.setText(s1);
            String s2=values[1]; Operand2.setText(s2);
            String s3=values[2]; Operand3.setText(s3);
            String s4=values[3]; Operand4.setText(s4);
            String s5=values[4]; Operand5.setText(s5);
            String s6=values[5]; Operand6.setText(s6);
            String s7=values[6]; Operand7.setText(s7);
            String s8=values[7]; Operand8.setText(s8);
            String s9=values[8]; Operand9.setText(s9);
            String s10=values[9]; Operand10.setText(s10);
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

