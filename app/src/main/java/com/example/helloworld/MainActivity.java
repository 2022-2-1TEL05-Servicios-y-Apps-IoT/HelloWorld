package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helloworld.entity.Persona;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        Log.d("msg","Start!!!");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("msg","Resume!!!");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.d("msg","OnRestart!!!");
        super.onRestart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("msg","Create!!!");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btnDespide);
        btn.setOnClickListener(view -> {
            //aquí
            Toast.makeText(MainActivity.this, "Chau!!!", Toast.LENGTH_SHORT).show();
        });

        Button btnSumar = (Button) findViewById(R.id.btnSumar);

        btnSumar.setOnClickListener(view -> {
            TextView contadorStr = findViewById(R.id.labelContador);
            int contador = Integer.parseInt(contadorStr.getText().toString());
            contador++;
            Log.d("msg", String.valueOf(contador));
            contadorStr.setText(String.valueOf(contador));
        });

        Button btnAbreP2 = findViewById(R.id.btnAbrePantalla2);
        btnAbreP2.setOnClickListener(view -> {
            TextView contadorStr = findViewById(R.id.labelContador);
            Persona persona = new Persona();
            persona.setNombre("Juan");
            Persona[] listaPersonas = new Persona[3];
            listaPersonas[0] = new Persona();
            listaPersonas[1] = new Persona();
            listaPersonas[2] = new Persona();

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("contador", contadorStr.getText().toString());
            intent.putExtra("numero", 5);
            intent.putExtra("persona", persona);
            intent.putExtra("lista", listaPersonas);
            startActivity(intent);
        });

    }

    public void saluda(View view) {
        //aquí
        Toast.makeText(this, "Hola!!!", Toast.LENGTH_SHORT).show();
    }

    public void restar(View view) {
        TextView contadorStr = findViewById(R.id.labelContador);
        int contador = Integer.parseInt(contadorStr.getText().toString());
        contador--;
        Log.d("msg", String.valueOf(contador));
        contadorStr.setText(String.valueOf(contador));
    }

    public void abrirAct3(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity3.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    @Nullable Intent data) {

        if (requestCode == 1 && resultCode == RESULT_OK) {
            String texto = data.getStringExtra("texto");
            Log.d("msg",texto);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}