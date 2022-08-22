package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button button = findViewById(R.id.buttonAct3);
        button.setOnClickListener(view -> {
            EditText editText = findViewById(R.id.editTextNombrePersona);
            String texto = editText.getText().toString();

            Intent intent = new Intent();
            intent.putExtra("texto",texto);
            setResult(RESULT_OK,intent);
            finish();
        });
    }
}