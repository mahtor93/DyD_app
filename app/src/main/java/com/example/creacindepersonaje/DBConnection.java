package com.example.creacindepersonaje;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBConnection extends SQLiteOpenHelper {

    private final String createArmas = "CREATE TABLE armas ("+
            "idArma INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+
            "nombre TEXT NOT NULL,"+
            "damage INTEGER NOT NULL,"+
            "tipoArma STRING NOT NULL,"+
            "tipoDamage STRING NOT NULL," +
            "descripcion STRING NOT NULL);";

    private final String createArmaduras = "CREATE TABLE armaduras ("+
            "idArmadura INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+
            "nombre TEXT NOT NULL,"+
            "claseArmadura INTEGER NOT NULL,"+
            "peso INTEGER NOT NULL,"+
            "fuerzaRequerida INTEGER,"+
            "descripcion STRING NOT NULL);";

    private final String createPersonaje ="CREATE TABLE personajes("+
            "";

    public DBConnection(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createArmaduras);
        db.execSQL(createArmas);
        poblarItems(db);
    }

    private void poblarItems(SQLiteDatabase db){
        //Inserción de las armas básicas.
        db.execSQL("INSERT INTO armas (nombre,damage,tipoArma,tipoDamage,descripcion) VALUES ('Daga',4,'Ligera','Perforante','Pequeña daga ligera que también puede ser arrojada');");
        db.execSQL("INSERT INTO armas (nombre,damage,tipoArma,tipoDamage,descripcion) VALUES ('Lanza',6,'A Distancia','Perforante','Lanza que puede ser utilizada a una mano, dos manos o ser arrojada');");
        db.execSQL("INSERT INTO armas (nombre,damage,tipoArma,tipoDamage,descripcion) VALUES ('Arco Corto',6,'A Distancia','Perforante','Arco de poca potencia que requiere un uso a dos manos');");
        db.execSQL("INSERT INTO armas (nombre,damage,tipoArma,tipoDamage,descripcion) VALUES ('Ballesta',8,'A Distancia','Perforante','Ballesta que puede ser utilizada con una mano');");
        db.execSQL("INSERT INTO armas (nombre,damage,tipoArma,tipoDamage,descripcion) VALUES ('Espada Corta',6,'Una mano','Perforante','Espada ligera que puede ser utilizada por una mano o ambas manos');");
        db.execSQL("INSERT INTO armas (nombre,damage,tipoArma,tipoDamage,descripcion) VALUES ('Espada Larga',8,'Versatil','Cortante','Espada larga que puede ser utilizada con una mano o ambas manos para mayor cantidad de daño');");
        db.execSQL("INSERT INTO armas (nombre,damage,tipoArma,tipoDamage,descripcion) VALUES ('Hacha de mano',6,'Ligera','Cortante','Hacha simple que puede ser utilizada con una o dos manos');");
        db.execSQL("INSERT INTO armas (nombre,damage,tipoArma,tipoDamage,descripcion) VALUES ('Hacha Guerrera',8,'Pesada','Cortante','Hacha pesada que requiere ser utilizada con dos manos');");
        db.execSQL("INSERT INTO armas (nombre,damage,tipoArma,tipoDamage,descripcion) VALUES ('Martillo de Guerra',8,'Pesada','Contundente','Martillo pesado que requiere ser utilizado con dos manos');");
        db.execSQL("INSERT INTO armas (nombre,damage,tipoArma,tipoDamage,descripcion) VALUES ('Arco Largo',8,'A dos manos','Perforante','Arco de gran potencia que requiere ser utilizado con ambas manos');");

        //Inserción de las armaduras.
        db.execSQL("INSERT INTO armaduras(nombre,claseArmadura,peso,fuerzaRequerida,descripcion) VALUES('Tela',11,8,0,'Armadura de tela ligera');");
        db.execSQL("INSERT INTO armaduras(nombre,claseArmadura,peso,fuerzaRequerida,descripcion) VALUES('Cuero',11,10,0,'Armadura de cuero ligera');");
        db.execSQL("INSERT INTO armaduras(nombre,claseArmadura,peso,fuerzaRequerida,descripcion) VALUES('Cuero tachonado',12,13,0,'Armadura de cuero tachonado. Es ruidosa');");
        db.execSQL("INSERT INTO armaduras(nombre,claseArmadura,peso,fuerzaRequerida,descripcion) VALUES('Camisa de malla',13,13,0,'Armadura de malla metálica');");
        db.execSQL("INSERT INTO armaduras(nombre,claseArmadura,peso,fuerzaRequerida,descripcion) VALUES('Cota de escamas',14,45,0,'Armadura de escamas metálicas. Es ruidosa');");
        db.execSQL("INSERT INTO armaduras(nombre,claseArmadura,peso,fuerzaRequerida,descripcion) VALUES('Coraza',14,20,0,'Coraza de metal. Es ruidosa');");
        db.execSQL("INSERT INTO armaduras(nombre,claseArmadura,peso,fuerzaRequerida,descripcion) VALUES('Armadura de Placas',18,60,15,'Armadura de metal. Dificulta el movimiento');");
        db.execSQL("INSERT INTO armaduras(nombre,claseArmadura,peso,fuerzaRequerida,descripcion) VALUES('Cota de malla',16,55,13,'Armadura de malla pesada');");
        db.execSQL("INSERT INTO armaduras(nombre,claseArmadura,peso,fuerzaRequerida,descripcion) VALUES('Media Armadura',15,40,0,'Armadura semiligera sigilosa');");
        db.execSQL("INSERT INTO armaduras(nombre,claseArmadura,peso,fuerzaRequerida,descripcion) VALUES('Pieles',12,12,0,'Cobertura de pieles para proteger del daño');");

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
