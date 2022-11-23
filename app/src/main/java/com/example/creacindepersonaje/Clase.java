package com.example.creacindepersonaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.Toast;

import com.example.creacindepersonaje.Personaje;

import java.util.ArrayList;

public class Clase extends AppCompatActivity {


    private Spinner spClase;
    private Button btnSiguiente;
    private ArrayList<String> Clases;
    private ArrayAdapter<String> adapterClase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clase);
        iniciarComponentes();
        iniciarEventos();
    }


    private void iniciarComponentes(){
        spClase = findViewById(R.id.spClase);

        btnSiguiente = findViewById(R.id.btnSiguiente);

        Clases = new ArrayList<>();
        Clases.add(0,"Selecciona");
        for(int i =0;i<Personaje.Clases.Clases.length;i++){
            Clases.add(i+1,Personaje.Clases.Clases[i]);
        }

        Context context = getApplicationContext();
        adapterClase = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, Clases);
        adapterClase.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spClase.setAdapter(adapterClase);

    }

    private void iniciarEventos(){
        btnSiguiente.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                try {
                    if (spClase.getSelectedItem().toString() == "Selecciona") {
                        Toast.makeText(
                                getApplicationContext(),
                                "Selecciona una Clase",
                                Toast.LENGTH_LONG
                        ).show();
                    } else {
                        Toast.makeText(
                                getApplicationContext(),
                                "abrir Dados",
                                Toast.LENGTH_LONG
                        ).show();
                        openActivity_Dados();

                    }
                }catch(Exception ex){
                    Toast.makeText(
                            getApplicationContext(),
                            "algo falló"+ex,
                            Toast.LENGTH_LONG
                    ).show();
                }
            }
        });
    }

    private void openActivity_Dados(){
        Intent intentDados = new Intent(getApplicationContext(),Setear_Caracteristicas.class);
        startActivity(intentDados);
    }


}