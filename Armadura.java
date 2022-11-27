public class Armadura {
    
    private String Nombre;
    private int ClaseArmadura; //Valor base de la armadura + Destreza
    private int Peso; //LIGERAS 8lb -> 15lb , Medias 16lb -> 40lb , Pesada 41lb -> 65lb.
    private int Fuerza; //Fuerza requerida para usarse. Aplicable a armaduras superiores a 40lb (Pesadas)
    
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    
    
    public int getClaseArmadura() {
        return ClaseArmadura;
    }
    public void setClase_Armadura(int clase_Armadura) {
        ClaseArmadura = claseArmadura;
    }
    
    
    public int getFuerza() {
        return Fuerza;
    }
    public void setFuerza(int fuerza) {
        Fuerza = fuerza;
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
