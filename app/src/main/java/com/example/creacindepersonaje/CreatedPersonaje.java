package com.example.creacindepersonaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.example.creacindepersonaje.Modelos.Arma;
import com.example.creacindepersonaje.Modelos.Armadura;
import com.example.creacindepersonaje.Modelos.Personaje;

import java.util.ArrayList;

public class CreatedPersonaje extends AppCompatActivity {

    private TextView tvNombre,tvRaza,tvSubRaza,tvClase,
            tvVidaShow,tvCAShow,tvVELShowCreate,tvSTR,
            tvBonoSTR,tvDES,tvBonoDES,tvCON,tvBonoCON,
            tvCAR,tvBonoCAR,tvINT,tvBonoINT,tvSAB,tvBonoSAB,tvATQShow;

    private Button btnCrearPersonaje,btnCancelCreation;

    private Spinner spArma,spArmadura;

    private ArrayList<Arma> armas;
    private ArrayList<String> nameArmas;

    private ArrayList<Armadura> armaduras;
    private ArrayList<String> nameArmaduras;

    private ArrayAdapter<String> adapterArmas,adapterArmaduras;

    Personaje p = new Personaje();
    Arma arma = new Arma();
    Armadura armadura = new Armadura();

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

        try {

        DBConnection connection = new DBConnection(CreatedPersonaje.this,"baseEquipo",null,1);
        SQLiteDatabase db = connection.getReadableDatabase();

        Cursor armasPicaro = db.rawQuery("SELECT nombre,damage,tipoArma,tipoDamage FROM armas WHERE tipoArma IN('Ligera','A Distancia');",null);
        Cursor armadurasPicaro = db.rawQuery("SELECT nombre,claseArmadura,peso,fuerzaRequerida FROM armaduras WHERE peso BETWEEN 8 and 15;",null);
        Cursor armasDruida = db.rawQuery("SELECT nombre,damage,tipoArma,tipoDamage FROM armas WHERE tipoArma <>'Pesada';",null);
        Cursor armadurasDruida = db.rawQuery("SELECT nombre,claseArmadura,peso,FuerzaRequerida FROM armaduras WHERE peso BETWEEN 8 AND 40;",null);
        Cursor armasCursor = db.rawQuery("SELECT nombre,damage,tipoArma,tipoDamage FROM armas",null);
        Cursor armadurasCursor = db.rawQuery("SELECT nombre,claseArmadura,peso,fuerzaRequerida FROM armaduras",null);

            armas = new ArrayList<>();
            nameArmas=new ArrayList<>();
            armaduras = new ArrayList<>();
            nameArmaduras = new ArrayList<>();
            nameArmas.add("Seleccione");
            nameArmaduras.add("Seleccione");
            String nameArma;
            String nameArmadura;


            if(p.getClase().equals(Personaje.Clases.Clases[0]) || p.getClase().equals(Personaje.Clases.Clases[2]) ||p.getClase().equals(Personaje.Clases.Clases[4])){
                if(p.getClase().equals(Personaje.Clases.Clases[2])){
                    nameArmaduras.clear();
                    spArmadura.setEnabled(false);
                    nameArmaduras.add("No usa Armaduras");
                }

                if (armasPicaro.moveToFirst()) {
                    do {
                        nameArma = armasPicaro.getString(0);
                        nameArmas.add(nameArma);
                        arma.setNombre(nameArma);
                        arma.setDamage(armasPicaro.getInt(1));
                        armas.add(arma);
                    } while (armasPicaro.moveToNext());
                }
                if (armadurasPicaro.moveToFirst()){
                    do{
                        nameArmadura = armadurasPicaro.getString(0);
                        nameArmaduras.add(nameArmadura);
                        armadura.setNombre(nameArmadura);
                        armadura.setClaseArmadura(armadurasPicaro.getInt(1));
                        armadura.setFuerzaReq(armadurasPicaro.getInt(3));
                        armaduras.add(armadura);
                    }while(armadurasPicaro.moveToNext());
                }
            }
            if(p.getClase().equals(Personaje.Clases.Clases[1])){ //Guerrero
                if(armasCursor.moveToFirst()){
                    do{
                        nameArma = armasCursor.getString(0);
                        nameArmas.add(nameArma);
                        arma.setNombre(nameArma);
                        arma.setDamage(armasCursor.getInt(1));
                        armas.add(arma);
                    }while(armasCursor.moveToNext());
                }

                if(armadurasCursor.moveToFirst()){
                    do{
                        nameArmadura = armadurasCursor.getString(0);
                        nameArmaduras.add(nameArmadura);
                        armadura.setNombre(nameArmadura);
                        armadura.setClaseArmadura(armadurasCursor.getInt(1));
                        armadura.setFuerzaReq(armadurasCursor.getInt(3));
                        armaduras.add(armadura);
                    }while(armadurasCursor.moveToNext());
                }

            }
            if(p.getClase().equals(Personaje.Clases.Clases[3])){
                if(armasDruida.moveToFirst()){
                    do{
                        nameArma = armasDruida.getString(0);
                        nameArmas.add(nameArma);
                        arma.setNombre(armasDruida.getString(1));
                        arma.setDamage(armasDruida.getInt(2));
                        armas.add(arma);
                    }while(armasDruida.moveToNext());
                }
                if(armadurasDruida.moveToFirst()){
                    do{
                        nameArmadura = armadurasDruida.getString(0);
                        nameArmaduras.add(nameArmadura);
                        armadura.setNombre(nameArmadura);
                        armadura.setClaseArmadura(armadurasDruida.getInt(1));
                        armadura.setFuerzaReq(armadurasDruida.getInt(3));
                        armaduras.add(armadura);
                    }while(armadurasDruida.moveToNext());
                }
            }



            adapterArmas = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,nameArmas);
            adapterArmas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spArma.setAdapter(adapterArmas);

            adapterArmaduras = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,nameArmaduras);
            adapterArmaduras.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spArmadura.setAdapter(adapterArmaduras);

        }catch(Exception ex){
            Toast.makeText(this, "Error"+ex, Toast.LENGTH_SHORT).show();
        }

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