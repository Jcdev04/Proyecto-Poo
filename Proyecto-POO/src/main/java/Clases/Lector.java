
package Clases;


public class Lector extends Persona {
    
    private boolean estado;

    public Lector(boolean estado, String nombre, String ap_paterno, String ap_materno, String dni, String codigo, String sexo, String contraseña) {
        super(nombre, ap_paterno, ap_materno, dni, codigo, sexo, contraseña);
        this.estado = estado;
    }
    
    
}
