package com.example.lernapp;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class DivActivity extends MultActivity {

    // Sämtliche Werte die der Server an den Client liefert..
    String[]values=new String[15];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_div);
        createrandomvalues("Div");
    }
}
