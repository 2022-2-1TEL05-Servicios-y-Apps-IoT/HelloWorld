package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ActivityClase3 extends AppCompatActivity {

    public void validarCheckBox(View view){
        CheckBox checkBox = (CheckBox) view; //findViewById(R.id.[ID]);
        Log.d("msg", String.valueOf(checkBox.isChecked()));
    }

    public void eventoToggleButton(View view){
        ToggleButton toggleButton = (ToggleButton) view;
        boolean estado = toggleButton.isChecked();
        Toast.makeText(this, "estado Toggle: " + estado, Toast.LENGTH_SHORT).show();
    }

    public void eventoSwitchButton(View view){
        Switch sw = (Switch) view;
        boolean estado = sw.isChecked();
        Log.d("msg", String.valueOf(estado));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clase3);

        //obtenido de un webservice
        /* ------ obteniendo -----*/
        String[] nombreAlumnos = {"Javier","leonardo","darwin","katherine","piero","lizbeth"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, nombreAlumnos);
        Spinner spinner = findViewById(R.id.spinner2);
        spinner.setAdapter(adapter);

        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean estado) {
                Log.d("msg", String.valueOf(estado));
            }
        });



        SeekBar seekBar = findViewById(R.id.seekBar1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progres, boolean b) {
                TextView textView = findViewById(R.id.textViewValorSb1);
                textView.setText(String.valueOf(progres));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar seekBar2 = findViewById(R.id.seekBar2);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progres, boolean b) {
                TextView textView = findViewById(R.id.textViewValorSb2);
                textView.setText(String.valueOf(progres-20));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void validarTelefono(View view) {
        EditText editText = findViewById(R.id.editTextPhone);
        String numero = editText.getText().toString();
        if(numero.equals("99966333")){
            Toast.makeText(this, "Número correcto", Toast.LENGTH_SHORT).show();
        }else{
            editText.setError("Número incorrecto");
        }
    }
}