package com.example.lernapp;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AuswahlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auswahl);
        Client client = new Client();
        String[] s = {"Stats", Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID)};
        client.execute(s);
    }

    public void switchActivity(View view){
        switch (view.getId()) {
            case R.id.Mult:
                Intent intent = new Intent(this, GrundrechenartenActivity.class);
                startActivity(intent);
                break;
            case R.id.Sub:
                Intent intent1 = new Intent(this, SubActivity.class);
                startActivity(intent1);
                break;
            case R.id.Add:
                Intent intent2 = new Intent(this, AddActivity.class);
                startActivity(intent2);
                break;
            case R.id.Div:
                Intent intent3 = new Intent(this, DivActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
