package com.example.creacindepersonaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private Button btnSiguiente;
    private Spinner spRace;
    private Spinner spVarRace;
    private Spinner spClass;

    private ArrayList<String> race;
    private ArrayAdapter<String> adapterRace;

    private ArrayList<String> selectedRace;
    private ArrayAdapter<String> adapterVarRace;

    private ArrayList<String> enanoVar;
    private ArrayList<String> elfoVar;
    private ArrayList<String> gnomoVar;
    private ArrayList<String> medianoVar;

    private ArrayList<String> ClassPj;
    private ArrayAdapter<String> adapterClass;

    Personaje p = new Personaje();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarComponentes();
        iniciarEventos();
    }


    private void iniciarComponentes(){
            txtNombre = findViewById(R.id.txtNombre);
            btnSiguiente = findViewById(R.id.btnSiguiente);
            spClass = findViewById(R.id.spClass);
            spRace = findViewById(R.id.spRace);
            spVarRace = findViewById(R.id.spVarRace);
    }

    private void iniciarEventos(){

        race = new ArrayList<>();
        selectedRace = new ArrayList<>();
        ClassPj = new ArrayList<>();
        spVarRace.setEnabled(false);

        Context context = getApplicationContext();

        race.add(0,"Selecciona"); //Añade elementos al Spinner Raza
        for (int i = 0; i<Personaje.Razas.Razas.length;i++){
            race.add(i+1,Personaje.Razas.Razas[i]);
        }
        adapterRace = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, race);
        adapterRace.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spRace.setAdapter(adapterRace);

        selectedRace.add(0,"Selecciona"); //añade elementos al Spinner Variante
        adapterVarRace = new ArrayAdapter<>(context,android.R.layout.simple_spinner_item,selectedRace);
        adapterVarRace.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spVarRace.setAdapter(adapterVarRace);


        ClassPj.add(0,"Selecciona"); //Añade elementos al Spinner Clase
        for (int i = 0; i<Personaje.Clases.Clases.length;i++) {
            ClassPj.add(i + 1, Personaje.Clases.Clases[i]);
        }

        adapterClass = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, ClassPj);
        adapterClass.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spClass.setAdapter(adapterClass);

        txtNombre.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                txtNombre.setText("");
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtNombre.getText().length()==0||txtNombre.getText().toString()=="¿Cuál es tu nombre?"){
                    closeKeyboard();
                    Toast.makeText(
                            getApplicationContext(),
                            "No has ingresado un nombre",
                            Toast.LENGTH_LONG
                    ).show();
                }else {
                    p.setNombre(txtNombre.getText().toString());
                    p.setClase(spClass.getSelectedItem().toString());
                    p.setRaza(spRace.getSelectedItem().toString());
                    if(spVarRace.getSelectedItemPosition()!=4 || spVarRace.getSelectedItemPosition()!=0){
                        p.setSub_Raza(spVarRace.getSelectedItem().toString());
                    }else {
                        p.setSub_Raza("");
                    }
                    openActivity();
                    closeKeyboard();
                }

            }
        });

        spRace.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedRace.clear();
                selectedRace.add(0,"Selecciona");
                int SelRaz = spRace.getSelectedItemPosition();
                switch(SelRaz){
                    case 0:
                        spVarRace.setEnabled(false);
                        break;
                    case 1: //ENANO
                        for (int r = 0; r<Personaje.SubRazas.SR_enano.length;r++) {
                            selectedRace.add(Personaje.SubRazas.SR_enano[r]);
                        }
                        spVarRace.setEnabled(true);
                        break;
                    case 2: //ELFO
                        for (int r = 0; r<Personaje.SubRazas.SR_elfo.length;r++) {
                            selectedRace.add(Personaje.SubRazas.SR_elfo[r]);
                        }
                        spVarRace.setEnabled(true);
                        break;
                    case 3://MEDIANO
                        for (int r = 0; r<Personaje.SubRazas.SR_mediano.length;r++) {
                            selectedRace.add(Personaje.SubRazas.SR_mediano[r]);
                        }
                        spVarRace.setEnabled(true);
                        break;
                    case 4://HUMANO
                        spVarRace.setEnabled(false);
                        break;
                    case 5:
                        for (int r = 0; r<Personaje.SubRazas.SR_gnomo.length;r++) {
                            selectedRace.add(Personaje.SubRazas.SR_gnomo[r]);
                        }
                        spVarRace.setEnabled(true);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                spVarRace.setEnabled(false);
            }
        });

    }

    private void closeKeyboard(){
        View view = this.getCurrentFocus();
        if(view!=null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }

    private void openActivity(){
        Intent intent = new Intent(this,Setear_Caracteristicas.class);
        startActivity(intent);
    }



}