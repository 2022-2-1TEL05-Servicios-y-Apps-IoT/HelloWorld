package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.helloworld.entity.Persona;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = this.getIntent();
        String contadorStr = intent.getStringExtra("contador");
        Persona p = (Persona) intent.getSerializableExtra("persona");
        TextView viewById = findViewById(R.id.textView);
        viewById.setText(contadorStr);
        int numero = intent.getIntExtra("numero", 0);
        Log.d("msg", String.valueOf(numero));

    }
}