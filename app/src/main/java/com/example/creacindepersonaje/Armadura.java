package com.example.creacindepersonaje;

public class Armadura {
    
    private String Nombre;
    private int ClaseArmadura; //Valor base de la armadura + Destreza, armaduras pesadas no añaden destreza.
    private int Peso; //LIGERAS 8lb -> 15lb , Medias 16lb -> 40lb , Pesada 41lb -> 65lb.
    private int fuerzaReq; //Fuerza requerida para usarse. Aplicable a armaduras superiores a 40lb (Pesadas)
    
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    
    
    public int getClaseArmadura() {
        return ClaseArmadura;
    }
    public void setClaseArmadura(int claseArmadura) {
        ClaseArmadura = claseArmadura;
    }
    
    
    public int getFuerzaReq() {
        return fuerzaReq;
    }
    public void setFuerzaReq(int fuerzaReq) {
        fuerzaReq = fuerzaReq;
    }
    
    
    public int getPeso() {
        return Peso;
    }
    public void setPeso(int peso) {
        Peso = peso;
    }

    public static class tipo_Armadura{
        public static String[] tipo_Armadura={"Armadura ligera","Armadura media",
        "Armadura pesada", "Escudo"};
    }
    
}
