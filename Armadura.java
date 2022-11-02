public class Armadura {
    
    private String Nombre;
    private int Coste;
    private int Clase_ArmaduraDA;
    private int Fuerza;
    private boolean Sigilo;
    private int Peso;
    
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getCoste() {
        return Coste;
    }
    public void setCoste(int coste) {
        Coste = coste;
    }
    
    public int getClase_ArmaduraDA() {
        return Clase_ArmaduraDA;
    }
    public void setClase_ArmaduraDA(int clase_ArmaduraDA) {
        Clase_ArmaduraDA = clase_ArmaduraDA;
    }
    
    public int getFuerza() {
        return Fuerza;
    }
    public void setFuerza(int fuerza) {
        Fuerza = fuerza;
    }
    
    public boolean isSigilo() {
        return Sigilo;
    }
    public void setSigilo(boolean sigilo) {
        Sigilo = sigilo;
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
