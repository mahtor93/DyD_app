//package;

public class Arma {

    private String nombre;
    private int Damage;
    private String tipo_Arma;
    private boolean tipo_Damage;
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int damage) {
        Damage = damage;
    }


    public boolean isTipo_Damage() {
        return tipo_Damage;
    }

    public void setTipo_Damage(boolean tipo_Damage) {
        this.tipo_Damage = tipo_Damage;
    }

    
    public static class tipo_damage{
        public static String[] tipo_damage={"Contundente","Perforante","Cortante"};
    }

    public static class tipo_Arma{
        public static String[] tipo_Arma={"A dos manos","Una mano","A Distancia","Ligera",
        "Pesada", "Versatil"};
    }



    
}
