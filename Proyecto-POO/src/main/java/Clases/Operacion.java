/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Jesus
 */
public class Operacion {
    private String dni;
    private String fecha;
    private String ejemplar_id;

    public Operacion(String dni, String fecha, String ejemplar_id) {
        this.dni = dni;
        this.fecha = fecha;
        this.ejemplar_id = ejemplar_id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEjemplar_id() {
        return ejemplar_id;
    }

    public void setEjemplar_id(String ejemplar_id) {
        this.ejemplar_id = ejemplar_id;
    }
    
}
