package com.example.creacindepersonaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class CreatedPersonaje extends AppCompatActivity {

    private TextView tvNombre,tvRaza,tvSubRaza,tvClase,
            tvVidaShow,tvCAShow,tvVELShowCreate,tvSTR,
            tvBonoSTR,tvDES,tvBonoDES,tvCON,tvBonoCON,
            tvCAR,tvBonoCAR,tvINT,tvBonoINT,tvSAB,tvBonoSAB,tvATQShow;

    private Button btnCrearPersonaje,btnCancelCreation;

    private Spinner spArma,spArmadura;

    Personaje p = new Personaje();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_created_personaje);
        iniciarComponentes();
        iniciarEventos();
    }

    private void iniciarActividad(Class clase){
        Intent i = new Intent(CreatedPersonaje.this,clase);
        startActivity(i);
    }

    private void iniciarComponentes(){

        btnCancelCreation = findViewById(R.id.btnCancelCreation);
        btnCrearPersonaje = findViewById(R.id.btnCrearPersonaje);

        tvNombre = findViewById(R.id.tvNombre);

        tvRaza = findViewById(R.id.tvRaza);
        tvClase = findViewById(R.id.tvClase);
        tvSubRaza = findViewById(R.id.tvSubRaza);

        tvVidaShow = findViewById(R.id.tvVidaShow);
        tvCAShow = findViewById(R.id.tvCAShow);

        tvATQShow = findViewById(R.id.tvATQShow);
        tvVELShowCreate = findViewById(R.id.tvVELShowCreate);

        tvSTR = findViewById(R.id.tvSTR);
        tvBonoSTR = findViewById(R.id.tvBonoSTR);

        tvDES = findViewById(R.id.tvDES);
        tvBonoDES = findViewById(R.id.tvBonoDES);

        tvCON = findViewById(R.id.tvCON);
        tvBonoCON = findViewById(R.id.tvBonoCON);

        tvCAR = findViewById(R.id.tvCAR);
        tvBonoCAR = findViewById(R.id.tvBonoCAR);

        tvINT = findViewById(R.id.tvINT);
        tvBonoINT = findViewById(R.id.tvBonoINT);

        tvSAB = findViewById(R.id.tvSAB);
        tvBonoSAB = findViewById(R.id.tvBonoSAB);

        spArma = findViewById(R.id.spArma);
        spArmadura = findViewById(R.id.spArmadura);
    }

    private void iniciarEventos(){

        Intent intent = this.getIntent();
        Bundle extra = intent.getExtras();

        String name = extra.getString("Nombre");
        p.setNombre(name);
        String race = extra.getString("Raza");
        p.setRaza(race);
        String variant = extra.getString("Variante");
        p.setSub_Raza(variant);
        String cla = extra.getString("Clase");
        p.setClase(cla);

        String STR = extra.getString("STR");
        int fuerza = Integer.parseInt(STR);
        p.setFuerza(fuerza);
        p.setModStr();
        String SAB = extra.getString("SAB");
        int sabiduria = Integer.parseInt(SAB);
        p.setSabiduria(sabiduria);
        p.setModSab();
        String DES = extra.getString("DES");
        int destreza = Integer.parseInt(DES);
        p.setDestreza(destreza);
        p.setModDes();
        String CON = extra.getString("CON");
        int constitucion = Integer.parseInt(CON);
        p.setConstitucion(constitucion);
        p.setModCon();
        String CAR = extra.getString("CAR");
        int carisma =Integer.parseInt(CAR);
        p.setCarisma(carisma);
        p.setModCar();
        String INT = extra.getString("INT");
        int inteligencia = Integer.parseInt(INT);
        p.setInteligencia(inteligencia);
        p.setModInt();
        p.setLevel(1);
        p.setPG();
        p.setVel();
        p.setCA(0);


        tvNombre.setText(name);
        tvRaza.setText(race);
        tvSubRaza.setText(variant);
        tvClase.setText(cla);
        tvVELShowCreate.setText(p.getVel()+"");
        tvVidaShow.setText(p.getPG()+"");
        tvCAShow.setText(p.getCA()+"");

        tvSTR.setText(p.getFuerza()+"");
        tvSAB.setText(p.getSabiduria()+"");
        tvDES.setText(p.getDestreza()+"");
        tvCON.setText(p.getConstitucion()+"");
        tvCAR.setText(p.getCarisma()+"");
        tvINT.setText(p.getInteligencia()+"");

        tvBonoINT.setText((int) p.getModInt()+"");
        tvBonoCAR.setText((int) p.getModCar()+"");
        tvBonoSTR.setText((int) p.getModStr()+"");
        tvBonoCON.setText((int) p.getModCon()+"");
        tvBonoDES.setText((int) p.getModDes()+"");
        tvBonoSAB.setText((int) p.getModSab()+"");






        btnCrearPersonaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Añadir a la BD
                iniciarActividad(List_Personajes.class);
            }
        });

        btnCancelCreation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarActividad(Jugador.class);
            }
        });
    }


}