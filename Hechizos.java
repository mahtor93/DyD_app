package hechizos;
/**
 *
 * @author anton
 */
public class Hechizos {

    
    private String nombre;
    private int nivelHechizo;
    private int damage;
    private String descripcion;
    private String tipoHechizo
    
    
    public static class tipoHechizo{
        public static String[] tipoHechizo={"Abjuracion","Alteracion",
        "Conjuracion", "Adivinacion", "Encantamiento", "Ilusion", "Invocacion", "Necromancia"};
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivelHechizo() {
        return nivel;
    }

    public void setNivelHechizo(int nivel) {
        this.nivelHechizo = nivel;
    }

    public int getDamage(){
        return damage
    }
    
    public void setDamage(int damage){
        this.damage = damage
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public String getTipoHechizo(){
        return tipoHechizo;
    }
    public void setTipoHechizo(String tipoHechizo){
        this.tipoHechizo = tipoHechizo;
    }
    
    
    
}
