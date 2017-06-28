package com.example.lernapp;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Client client= new Client();
        String[] s = {"login", Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID)};
        client.execute(s);
    }

    public void switchActivity(View view){
        Intent intent = new Intent(this, AuswahlActivity.class);
        startActivity(intent);

    }
}
