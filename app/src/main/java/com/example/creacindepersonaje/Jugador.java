package com.example.creacindepersonaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Jugador extends AppCompatActivity {


    private Button btnPersonajes;
    private Button btnCrear;
    private Button btnGuild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugador);
        iniciarComponentes();
        iniciarEventos();
    }

    private void iniciarComponentes(){
        btnPersonajes = findViewById(R.id.btnPersonajes);
        btnCrear = findViewById(R.id.btnCrear);
        btnGuild = findViewById(R.id.btnGuild);
    }

    private void iniciarActividad(Class clase){
        Intent intent = new Intent(this,clase);
        startActivity(intent);
    }

    private void iniciarEventos(){
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarActividad(MainActivity.class);
            }
        });

        btnPersonajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarActividad(View_Personaje.class);
            }
        });
    }
}