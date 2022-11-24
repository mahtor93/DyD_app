package com.example.creacindepersonaje;

import java.io.Serializable;

public class Personaje implements Serializable {



     private String Nombre;
     private String Raza;
     private String Sub_Raza;
     private String Clase;

     public String getRaza() {
         return Raza;
     }
     public void setRaza(String Raza) {
         this.Raza = Raza;
     }

     private Boolean SxP; //Boolean puede tomar valor true, false y 0
     private int Fuerza;
     private int Destreza;
     private int Constitucion;
     private int Inteligencia;
     private int Sabiduria;
     private int Carisma;

     private double ModStr;
     private double ModDes;
     private double ModCon;
     private double ModInt;
     private double ModSab;
     private double ModCar;

     private int Vel;
     private int CA; //Clase de armadura
     private int PG; //Puntos de golpe
     private int PGT; //Puntos de golpe temporales

     private int Level;
     private String Alineamiento;
     private int EXP;

     private int espacioConjuros;


     public int getEspacioConjuros() {
         return espacioConjuros;
     }

     public void setEspacioConjuros(int espacioConjuros) {
         this.espacioConjuros = espacioConjuros;
     }

     //Recursos
     private int PC;//piezas de cobre
     private int PP;//piezas de plata
     private int PE;//piezas de estaño
     private int PO;//piezas de oro
     private int PPT;//¿?

     private boolean AptitudMagica; //true: usa hechizos, false: no usa hechizos
     private int CDSalvConjuro; //Clase dificultad salvacion de conjuro
     private int BonificadorAtaqueConjuro;

     private int Inspiracion;
     private int BonoCompetencia;
     private int Iniciativa;

     public String getNombre() {
         return Nombre;
     }

     public void setNombre(String Nombre) {
         this.Nombre = Nombre;
     }

     public String getSub_Raza() {
         return Sub_Raza;
     }

     public void setSub_Raza(String Sub_Raza) {
         this.Sub_Raza = Sub_Raza;
     }

     public String getClase() {
         return Clase;
     }

     public void setClase(String Clase) {
         this.Clase = Clase;
     }

     public Boolean getSxP() {
         return SxP;
     }

     public void setSxP(Boolean SxP) {
         this.SxP = SxP;
     }

     public int getFuerza() {
         return Fuerza;
     }

     public void setFuerza(int Fuerza) {
         if(this.getRaza().equals(Personaje.Razas.Razas[3])){//HUMANO
             this.Fuerza = Fuerza +1;
         }
         if(SubRazas.SR_enano[1].equals(this.getSub_Raza())){//Enano de las montañas
             this.Fuerza = Fuerza + 2;
         }
         else{
             this.Fuerza = Fuerza;
         }
     }

     public int getDestreza() {
         return Destreza;
     }

     public void setDestreza(int Destreza) {
         if(this.getRaza().equals(Personaje.Razas.Razas[1]) ||
                 this.getRaza().equals(Personaje.Razas.Razas[2])){ //ELFO || MEDIANO
             this.Destreza = Destreza+2;
         }
         if(this.getRaza().equals(Personaje.Razas.Razas[3])||
                 this.getSub_Raza().equals(SubRazas.SR_gnomo[0])){ //HUMANO
             this.Destreza = Destreza +1;
         }
         else{
             this.Destreza = Destreza;
         }
     }

     public int getConstitucion() {
         return Constitucion;
     }

     public void setConstitucion(int Constitucion) {
         if(this.getRaza().equals(Personaje.Razas.Razas[3])||
                 this.getSub_Raza().equals(SubRazas.SR_gnomo[0]) ||
                 this.getSub_Raza().equals(SubRazas.SR_mediano[1])){//HUMANO, MEDIANO FORNIDO
             this.Constitucion = Constitucion+1;
         }
         if(this.getRaza().equals(Personaje.Razas.Razas[0])){//ENANO
             this.Constitucion = Constitucion+2;
         }else{
             this.Constitucion = Constitucion;
         }
     }

     public int getInteligencia() {
         return Inteligencia;
     }

     public void setInteligencia(int Inteligencia) {
         if(this.getRaza().equals(Personaje.Razas.Razas[4])){//Gnomo
             this.Inteligencia = Inteligencia +2;
         }
         if(this.getRaza().equals(Personaje.Razas.Razas[3])||                 //HUMANO
                 this.getSub_Raza().equals(SubRazas.SR_elfo[1])){ //ALTO ELFO
             this.Inteligencia = Inteligencia +1;
         }else{
             this.Inteligencia = Inteligencia;
         }
     }

     public int getSabiduria() {
         return Sabiduria;
     }

     public void setSabiduria(int Sabiduria) {
         if(this.getRaza().equals(Personaje.Razas.Razas[3])||                //HUMANO
                 this.getSub_Raza().equals(SubRazas.SR_enano[0])||
                 this.getSub_Raza().equals(SubRazas.SR_enano[1])){//ENANO DE LAS COLINAS
             this.Sabiduria = Sabiduria +1;
         }else{
             this.Sabiduria = Sabiduria;
         }

     }

     public int getCarisma() {
         return Carisma;
     }

     public void setCarisma(int Carisma) {
         if(this.getRaza().equals(Personaje.Razas.Razas[3])||//HUMANO
                 this.getSub_Raza().equals(SubRazas.SR_elfo[2]) || //Elfo oscuro
                 this.getSub_Raza().equals(SubRazas.SR_mediano[0])){ //Mediano piesligeros
             this.Carisma = Carisma +1;
         }else{
             this.Carisma = Carisma;
         }
     }


     public double getModStr() {
         return ModStr;
     }

     public void setModStr() {
         this.ModStr = calcModCaract(this.getFuerza());
     }

     public int getModDes() {
         return (int) ModDes;
     }

     public void setModDes() {
         this.ModDes = (int) calcModCaract(this.getDestreza());
     }

     public int getModCon() {
         return (int) ModCon;
     }

     public void setModCon() {
         this.ModCon = (int) calcModCaract(this.getConstitucion());
     }

     public double getModInt() {
         return ModInt;
     }

     public void setModInt() {
         this.ModInt = calcModCaract(this.getInteligencia());
     }

     public double getModSab() {
         return ModSab;
     }

     public void setModSab() {
         this.ModSab = calcModCaract(this.getSabiduria());
     }

     public double getModCar() {
         return ModCar;
     }

     public void setModCar() {
         this.ModCar = calcModCaract(this.getCarisma());
     }

     public int getVel() {
         return Vel;
     }

     public void setVel() {

         if(Personaje.Razas.Razas[0].equals(this.getRaza())|| //Enano
                 Personaje.Razas.Razas[2].equals(this.getRaza())|| //Mediano
                 Personaje.Razas.Razas[4].equals(this.getRaza())){ //Gnomo
             this.Vel = 25;
         }

         if(Personaje.Razas.Razas[1].equals(this.getRaza())){
             this.Vel = 30;
             if(SubRazas.SR_elfo[1].equals(this.getRaza())){ //Elfo de los bosques
                 this.Vel = this.getVel()+5;
             }
         }
         if(Personaje.Razas.Razas[3].equals(this.getRaza())){
             this.Vel=30;
         }
     }

     public int getCA() {
         return CA;
     }

     public void setCA(int CA) {
         this.CA = CA;
     }

     public int getPG() {
         return PG;
     }

     public void setPG() {
         int PG = 0;
         Dado dGolpe = new Dado();
         if(Personaje.Clases.Clases[0].equals(this.getClase())){ //Picaro
             dGolpe.setValorDado(Dado.Valor.d8);
             for (int i = 0; i < this.getLevel(); i++) {
                 PG = dGolpe.lanzarDado()+this.getModCon();
             }
             this.PG = PG;
         }
         if(Personaje.Clases.Clases[1].equals(this.getClase())){//Guerrero
             dGolpe.setValorDado(Dado.Valor.d10);
             for (int i = 0; i < this.getLevel(); i++) {
                 PG = dGolpe.lanzarDado()+this.getModCon();
             }
             this.PG = PG;
         }
         if(Personaje.Clases.Clases[2].equals(this.getClase())){//Hechicero
             dGolpe.setValorDado(Dado.Valor.d6);
             for (int i = 0; i < this.getLevel(); i++) {
                 PG = dGolpe.lanzarDado()+this.getModCon();
             }
             this.PG = PG;
         }
         if(Personaje.Clases.Clases[3].equals(this.getClase())){//
             dGolpe.setValorDado(Dado.Valor.d8);
             for (int i = 0; i < this.getLevel(); i++) {
                 PG = dGolpe.lanzarDado()+this.getModCon();
             }
             this.PG = PG;
         }
         if(Personaje.Clases.Clases[4].equals(this.getClase())){//Hechicero
             dGolpe.setValorDado(Dado.Valor.d8);
             for (int i = 0; i < this.getLevel(); i++) {
                 PG = dGolpe.lanzarDado()+this.getModCon();
             }
             this.PG = PG;
         }
     }

     public int getPGT() {
         return PGT;
     }

     public void setPGT(int PGT) {
         this.PGT = PGT;
     }

     public int getLevel() {
         return Level;
     }

     public void setLevel(int Level) {
         this.Level = 1;
     }

     public String getAlineamiento() {
         return Alineamiento;
     }

     public void setAlineamiento(String Alineamiento) {
         this.Alineamiento = Alineamiento;
     }

     public int getEXP() {
         return EXP;
     }

     public void setEXP(int EXP) {
         this.EXP = EXP;
     }

     public int getPC() {
         return PC;
     }

     public void setPC(int PC) {
         this.PC = PC;
     }

     public int getPP() {
         return PP;
     }

     public void setPP(int PP) {
         this.PP = PP;
     }

     public int getPE() {
         return PE;
     }

     public void setPE(int PE) {
         this.PE = PE;
     }

     public int getPO() {
         return PO;
     }

     public void setPO(int PO) {
         this.PO = PO;
     }

     public int getPPT() {
         return PPT;
     }

     public void setPPT(int PPT) {
         this.PPT = PPT;
     }

     public boolean getAptitudMagica() {
         return AptitudMagica;
     }

     public void setAptitudMagica(boolean AptitudMagica) {
         this.AptitudMagica = AptitudMagica;
     }

     public int getCDSalvConjuro() {
         return CDSalvConjuro;
     }

     public void setCDSalvConjuro(int CDSalvConjuro) {
         this.CDSalvConjuro = CDSalvConjuro;
     }

     public int getBonificadorAtaqueConjuro() {
         return BonificadorAtaqueConjuro;
     }

     public void setBonificadorAtaqueConjuro(int BonificadorAtaqueConjuro) {
         this.BonificadorAtaqueConjuro = BonificadorAtaqueConjuro;
     }

     public int getInspiracion() {
         return Inspiracion;
     }

     public void setInspiracion(int Inspiracion) {
         this.Inspiracion = Inspiracion;
     }

     public int getBonoCompetencia() {
         return BonoCompetencia;
     }

     public void setBonoCompetencia(int BonoCompetencia) {
         this.BonoCompetencia = BonoCompetencia;
     }

     public int getIniciativa() {
         return Iniciativa;
     }

     public void setIniciativa() {
         Dado d20 = new Dado();
         d20.setValorDado(Dado.Valor.d20);
         int ini = d20.lanzarDado();
         this.Iniciativa = (int) Math.round(ini+this.getModDes());
     }

        public static class Razas{
            public static String[] Razas={"Enano","Elfo","Mediano","Humano","Gnomo"};
        }

        public static class SubRazas{
            public static String[] SR_enano={" de las Montañas"," de las Colinas"};
            public static String[] SR_elfo={"Alto"," de los Bosques"," Oscuro"};
            public static String[] SR_gnomo={" de los Bosques"," de las Rocas"};
            public static String[] SR_mediano={" Piesligeros"," Fornido"};
        }

        public static class Clases{
            public static String[] Clases={"Picaro","Guerrero","Hechicero","Druida","Bardo"};
        }

     private int calcModCaract(int val){ //calcula el modificador de característica de cada Característica en función de su valor
         double res = (double)val;
         res = Math.floor((res-10)/2);
         return (int) Math.floor(res);
     }

        public int lanzarDadosCaracteristica(){
        
            Dado dado1 = new Dado();
            dado1.setValorDado(Dado.Valor.d6);
            int resultDado=0;
            
            for(int i = 0; i<3;i++){
                resultDado = dado1.lanzarDado()+resultDado; //cada vez que se invoca la función lanzarDado() se genera un número al azar entre 1 y el valor máximo del dado
            }
            return resultDado;     
        }



    }
