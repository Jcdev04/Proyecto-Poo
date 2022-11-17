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
 * @author Jesus
 */
public class Ejemplar {
   private int ejemplar_id;
   private String libro_id;
   private boolean estado;
   private String ruta = "C:\\Users\\JOSUE CORDOVA\\OneDrive\\Documentos\\ProyectoPoo//Ejemplares.txt";

   private File file;

    public Ejemplar(int ejemplar_id, String libro_id, boolean estado) {
        this.ejemplar_id = ejemplar_id;
        this.libro_id = libro_id;
        this.estado = estado;
        file = new File(ruta);
    }
     public Ejemplar(){
       
        file = new File(ruta);      
    }

    public int getEjemplar_id() {
        return ejemplar_id;
    }

    public void setEjemplar_id(int ejemplar_id) {
        this.ejemplar_id = ejemplar_id;
    }

    public String getLibro_id() {
        return libro_id;
    }

    public void setLibro_id(String libro_id) {
        this.libro_id = libro_id;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public void registrarEjemplar() {

        try{
            FileWriter fw = new FileWriter(ruta,true);
            String fila= this.ejemplar_id+this.libro_id+"|"+this.estado;
            fw.write(fila);
            fw.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String> getEjemplares() throws FileNotFoundException, IOException{
        ArrayList<String> coleccion = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(ruta));

        String fila;
        while((fila=br.readLine())!=null){
            coleccion.add(fila);
        }
        br.close();
        return coleccion;
    } 
    
    
}
