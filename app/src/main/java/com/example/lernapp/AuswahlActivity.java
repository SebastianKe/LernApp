package com.example.lernapp;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class AuswahlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auswahl);
        fillstats();
    }

    public void switchActivity(View view){
        switch (view.getId()) {
            case R.id.Mult:
                Intent intent = new Intent(this, MultActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.Sub:
                Intent intent1 = new Intent(this, SubActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.Add:
                Intent intent2 = new Intent(this, AddActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.Div:
                Intent intent3 = new Intent(this, DivActivity.class);
                startActivity(intent3);
                finish();
                break;
        }
    }

    public void fillstats(){
        TextView stats = (TextView) findViewById(R.id.Stats);
        Client client = new Client();
        String[] s = {"Stats", Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID)};
        int i=1;
        String suggestion="";
        stats.setText("Deine bisherigen Leistungen:"+"\r\n");
        try {
            String[] dbStats= client.execute(s).get();
            for(String stat:dbStats)
            {
                if(stat!=null)
                {
                    String current_text= (String) stats.getText();
                    current_text.replace("TextView","");
                    stats.setText(current_text+ " "+i+". "+stat+"\r\n");
                    suggestion=dbStats[i-1];
                }
                i++;
            }
            stats.setText(stats.getText()+ " Versuch dich doch mal wieder an einer: "+"\r\n"+" "+suggestion);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
