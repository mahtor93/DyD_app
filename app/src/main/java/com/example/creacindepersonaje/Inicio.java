package com.example.creacindepersonaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {

    private Button btnJugador;
    private Button btnDM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        iniciarComponentes();
        iniciarEventos();
    }

    private void iniciarComponentes(){
        btnJugador = findViewById(R.id.btnJugador);
        btnDM = findViewById(R.id.btnDM);
    }

    private void iniciarActividad(Class clase){
        Intent intent = new Intent(this,clase);
        startActivity(intent);
    }

    private void iniciarEventos(){
        btnJugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarActividad(Jugador.class);
            }
        });
        btnDM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aquí debe ir el intent (iniciarActividad()) que deriva a la interfaz del DM
            }
        });


    }

}