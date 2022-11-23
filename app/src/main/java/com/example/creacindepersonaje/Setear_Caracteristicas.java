package com.example.creacindepersonaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.creacindepersonaje.Dado.Valor;
import com.example.creacindepersonaje.Dado;
import com.example.creacindepersonaje.Personaje;

import java.util.ArrayList;

public class Setear_Caracteristicas extends AppCompatActivity {

    private TextView tvCV1;
    private TextView tvCV2;
    private TextView tvCV3;
    private TextView tvCV4;
    private TextView tvCV5;
    private TextView tvCV6;
    private Button btnLanzar;
    Personaje p = new Personaje();
    private Spinner sp_fuerza;
    private Spinner sp_inteligencia;
    private Spinner sp_destreza;
    private Spinner sp_sabiduria;
    private Spinner sp_constitucion;
    private Spinner sp_carisma;
    private ArrayList<String> valores;
    private ArrayList<String> valoresReset;
    private ArrayAdapter adapterValoresFuerza;
    private ArrayAdapter adapterValoresIntelig;
    private ArrayAdapter adapterValoresDestre;
    private ArrayAdapter adapterValoresSabidu;
    private ArrayAdapter adapterValoresConstitu;
    private ArrayAdapter adapterValoresCarism;
    private Button btnSiguiente;
    private TextView tvSelectedValueSTR;
    private TextView tvSelectedValueINT;
    private TextView tvSelectedValueDES;
    private TextView tvSelectedValueSAB;
    private TextView tvSelectedValueCON;
    private TextView tvSelectedValueCAR;
    int lanzamientos =1;
    private Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setear_caracteristicas);
        iniciarComponentes();
        iniciarEventos();
    }



    private void iniciarComponentes(){
        tvCV1 = findViewById(R.id.tvCV1);
        tvCV2 = findViewById(R.id.tvCV2);
        tvCV3 = findViewById(R.id.tvCV3);
        tvCV4 = findViewById(R.id.tvCV4);
        tvCV5 = findViewById(R.id.tvCV5);
        tvCV6 = findViewById(R.id.tvCV6);

        tvSelectedValueSTR = findViewById(R.id.tvSelectedValueSTR);
        tvSelectedValueINT = findViewById(R.id.tvSelectedValueINT);
        tvSelectedValueDES = findViewById(R.id.tvSelectedValueDES);
        tvSelectedValueSAB = findViewById(R.id.tvSelectedValueSAB);
        tvSelectedValueCON = findViewById(R.id.tvSelectedValueCON);
        tvSelectedValueCAR = findViewById(R.id.tvSelectedValueCAR);

        btnLanzar = findViewById(R.id.btnLanzar);

        sp_fuerza = findViewById(R.id.sp_fuerza);
        sp_inteligencia = findViewById(R.id.sp_intelig);
        sp_destreza = findViewById(R.id.sp_dest);
        sp_sabiduria = findViewById(R.id.sp_sabid);
        sp_constitucion = findViewById(R.id.sp_const);
        sp_carisma = findViewById(R.id.sp_carism);

        btnSiguiente = findViewById(R.id.btnSiguiente);
        btnReset = findViewById(R.id.btnReset);
        btnReset.setEnabled(false);
    }

    private void resetSpinners(){
        tvSelectedValueSTR.setText("");
        tvSelectedValueDES.setText("");
        tvSelectedValueCAR.setText("");
        tvSelectedValueCON.setText("");
        tvSelectedValueSAB.setText("");
        tvSelectedValueINT.setText("");
        sp_fuerza.setSelection(0);
        sp_fuerza.setEnabled(true);
        sp_carisma.setSelection(0);
        sp_carisma.setEnabled(true);
        sp_constitucion.setSelection(0);
        sp_constitucion.setEnabled(true);
        sp_inteligencia.setSelection(0);
        sp_inteligencia.setEnabled(true);
        sp_destreza.setSelection(0);
        sp_destreza.setEnabled(true);
        sp_sabiduria.setSelection(0);
        sp_sabiduria.setEnabled(true);
    }
    private void iniciarEventos(){


        Context context = getApplicationContext();
        valores = new ArrayList<>();
        valoresReset = new ArrayList<>();

        btnLanzar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                resetSpinners();
                btnReset.setEnabled(true);

                lanzamientos++;
                if(lanzamientos==4){
                    btnLanzar.setEnabled(false);
                    Toast.makeText(Setear_Caracteristicas.this, "No más intentos", Toast.LENGTH_LONG).show();
                }
                valores.clear();
                valoresReset.clear();
                int val1 = p.lanzarDadosCaracteristica();
                int val2 = p.lanzarDadosCaracteristica();
                int val3 = p.lanzarDadosCaracteristica();
                int val4 = p.lanzarDadosCaracteristica();
                int val5 = p.lanzarDadosCaracteristica();
                int val6 = p.lanzarDadosCaracteristica();
                tvCV1.setText(val1+" - ");
                tvCV2.setText(val2+" - ");
                tvCV3.setText(val3+" - ");
                tvCV4.setText(val4+" - ");
                tvCV5.setText(val5+" - ");
                tvCV6.setText(val6+"");

                valores.add(0,"Selecciona");
                valores.add(String.valueOf(val1));
                valores.add(String.valueOf(val2));
                valores.add(String.valueOf(val3));
                valores.add(String.valueOf(val4));
                valores.add(String.valueOf(val5));
                valores.add(String.valueOf(val6));

                for(int a =0;a<valores.size();a++){
                    valoresReset.add(valores.get(a));
                }



                adapterValoresFuerza = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, valores);
                adapterValoresFuerza.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp_fuerza.setAdapter(adapterValoresFuerza);
                adapterValoresIntelig = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, valores);
                adapterValoresIntelig.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp_inteligencia.setAdapter(adapterValoresIntelig);
                adapterValoresDestre = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, valores);
                adapterValoresDestre.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp_destreza.setAdapter(adapterValoresDestre);
                adapterValoresSabidu = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, valores);
                adapterValoresSabidu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp_sabiduria.setAdapter(adapterValoresSabidu);
                adapterValoresConstitu = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, valores);
                adapterValoresConstitu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp_constitucion.setAdapter(adapterValoresConstitu);
                adapterValoresCarism = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, valores);
                adapterValoresCarism.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp_carisma.setAdapter(adapterValoresCarism);
            }
        });

        sp_fuerza.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(sp_fuerza.getSelectedItemPosition()!=0) {
                    tvSelectedValueSTR.setText(sp_fuerza.getSelectedItem().toString());
                    valores.remove(sp_fuerza.getSelectedItem());
                    sp_fuerza.setEnabled(false);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp_carisma.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(sp_carisma.getSelectedItemPosition()!=0) {
                    tvSelectedValueCAR.setText(sp_carisma.getSelectedItem().toString());
                    valores.remove(sp_carisma.getSelectedItem());
                    sp_carisma.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp_constitucion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(sp_constitucion.getSelectedItemPosition()!=0) {
                    tvSelectedValueCON.setText(sp_constitucion.getSelectedItem().toString());
                    valores.remove(sp_constitucion.getSelectedItem());
                    sp_constitucion.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp_inteligencia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(sp_inteligencia.getSelectedItemPosition()!=0) {
                    tvSelectedValueINT.setText(sp_inteligencia.getSelectedItem().toString());
                    valores.remove(sp_inteligencia.getSelectedItem());
                    sp_inteligencia.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp_destreza.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(sp_destreza.getSelectedItemPosition()!=0) {
                    tvSelectedValueDES.setText(sp_destreza.getSelectedItem().toString());
                    valores.remove(sp_destreza.getSelectedItem());
                    sp_destreza.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp_sabiduria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(sp_sabiduria.getSelectedItemPosition()!=0) {
                    tvSelectedValueSAB.setText((sp_sabiduria.getSelectedItem().toString()));
                    valores.remove(sp_sabiduria.getSelectedItem());
                    sp_sabiduria.setEnabled(false);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valores.clear();
                for(int a =0;a<valoresReset.size();a++){
                    valores.add(valoresReset.get(a));
                }
                resetSpinners();

            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Añadir intent y pasar datos de un objeto instanciado
            }
        });

    }

}