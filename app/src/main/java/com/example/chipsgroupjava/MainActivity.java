package com.example.chipsgroupjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class MainActivity extends AppCompatActivity {

    EditText etProgramacion;
    Button btnAgregar;
    ChipGroup chipGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View vista = inflater.inflate(R.layout.activity_main, null);
        setContentView(vista);

        etProgramacion = findViewById(R.id.etProgramacion);
        btnAgregar = findViewById(R.id.btnAdd);
        chipGroup = findViewById(R.id.cgLenguajes);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Chip chip = new Chip(MainActivity.this);

                chip.setText(etProgramacion.getText().toString());

                chipGroup.addView(chip);

                chip.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chip.setRippleColor(ColorStateList.valueOf(Color.BLUE));
                        Toast.makeText(MainActivity.this, "PRESIONASTE EL CHIP", Toast.LENGTH_LONG).show();
                    }
                });

                setContentView(vista);

            }
        });
    }
}