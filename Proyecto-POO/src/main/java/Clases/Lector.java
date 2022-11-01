/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Lector {
    private String dni;
    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;
    private boolean estado_lector;
    private String ruta ="C:\\Users\\JOSUE CORDOVA\\OneDrive\\Documentos\\ProyectoPoo//RegistroDeLectores.txt";
    File file;

    public Lector(String dni, String nombre, String apellidos, String correo, String telefono, boolean estado_lector) {
        this.dni = dni;
        this.nombres = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.estado_lector = estado_lector;
        file = new File(ruta);
    }
    public Lector(){
       
        file = new File(ruta);      
    }
    

    public String getNombres() {
        return nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public boolean getEstado_lector() {
        return estado_lector;
    }

    public void setEstado_lector(boolean estado_lector) {
        this.estado_lector = estado_lector;
    }

    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombres;
    }

    public void setNombre(String nombre) {
        this.nombres = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void registrarLector() {
        
        try{
            FileWriter fw = new FileWriter(ruta,true);           
            String fila= this.dni+"|"+this.nombres+"|"+ this.apellidos+"|"+this.correo+"|"+this.telefono+"|"+this.estado_lector+"\n";          
            fw.write(fila);
            fw.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    public ArrayList<String> getLectores() throws FileNotFoundException, IOException{
        ArrayList<String> coleccion = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        
        String fila;
        while((fila=br.readLine())!=null){
            coleccion.add(fila);
            System.out.println(fila);
        }
        br.close();
        return coleccion;
    }
       
}
