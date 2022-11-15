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

public class Libro {
    private String libro_id;
    private String titulo;
    private String autor;
    private String genero;
    private String a_publicacion;
    private String editorial;
    private int n_ejemplares;
    private int ejemplares_disponibles;
    private String ruta = "C:\\Users\\JOSUE CORDOVA\\OneDrive\\Documentos\\ProyectoPoo//RegistroDeLibros.txt";
    File file;

    public Libro(String libro_id, String titulo, String autor, String genero, String a_publicacion, String nombre_editorial, int n_ejemplares, int ejemplares_disponibles) {
        this.libro_id = libro_id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.a_publicacion = a_publicacion;
        this.editorial = nombre_editorial;
        this.n_ejemplares = n_ejemplares;
        this.ejemplares_disponibles = ejemplares_disponibles;
        file = new File(ruta);
    }
    public Libro(){
       
        file = new File(ruta);      
    }
    

    public String getLibro_id() {
        return libro_id;
    }

    public void setLibro_id(String libro_id) {
        this.libro_id = libro_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getA_publicacion() {
        return a_publicacion;
    }

    public void setA_publicacion(String a_publicacion) {
        this.a_publicacion = a_publicacion;
    }

    public String getNombre_editorial() {
        return editorial;
    }

    public void setNombre_editorial(String nombre_editorial) {
        this.editorial = nombre_editorial;
    }

    public int getN_ejemplares() {
        return n_ejemplares;
    }

    public void setN_ejemplares(int n_ejemplares) {
        this.n_ejemplares = n_ejemplares;
    }

    public int getEjemplares_disponibles() {
        return ejemplares_disponibles;
    }

    public void setEjemplares_disponibles(int ejemplares_disponibles) {
        this.ejemplares_disponibles = ejemplares_disponibles;
    }
    
    public void prestar(){
        
    }
    
    public void consultar_prestamo(){
        
    }
    public void registrarLibro() {
        
        try{
            FileWriter fw = new FileWriter(ruta,true);           
            String fila= this.libro_id+"|"+this.titulo+"|"+ this.autor+"|"+this.genero+"|"+this.a_publicacion+"|"+this.editorial+"|"+this.n_ejemplares+"|"+this.ejemplares_disponibles+"\n";          
            fw.write(fila);
            fw.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public boolean verificarLibroRepetido(String ID, String nombre) throws FileNotFoundException, IOException{
        BufferedReader br=new BufferedReader(new FileReader(ruta));
        String fila = null;
        boolean confirmar = false;
        while((fila=br.readLine())!=null){
            String cod=fila.split("\\|")[0];
            String cod2=fila.split("\\|")[1];
            if(cod.equals(ID) || cod2.equals(nombre)){
                confirmar = true;
                break;
            }
        }
        br.close();
        return confirmar;
    }
    public ArrayList<String> getLibros() throws FileNotFoundException, IOException{
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
