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

    public Libro(String titulo, String autor, String genero, String a_publicacion, String nombre_editorial, int n_ejemplares, int ejemplares_disponibles) {
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
    
    public void prestar(String titulo, String dni) throws FileNotFoundException, IOException{
        BufferedReader br=new BufferedReader(new FileReader(ruta));
        String fila = null;
        String genero="",autor="",anio="",cod="",edito="",name="";
        Boolean confirmar = false;
        int cantidad=0, ejemplares=0;
        while((fila=br.readLine())!=null){
            name=fila.split("\\|")[1];           
            if(name.equals(titulo)){
                genero = fila.split("\\|")[3];
                autor = fila.split("\\|")[2];
                anio = fila.split("\\|")[4];
                cod = fila.split("\\|")[0];
                edito = fila.split("\\|")[5];
                cantidad = Integer.parseInt(fila.split("\\|")[6]);
                ejemplares = Integer.parseInt(fila.split("\\|")[7]);
                ejemplares -= 1;            
                System.out.println("SI");
                confirmar =true;
                break;
            }
        }
        br.close();
        if(confirmar){
            Libro obj2 = new Libro();    
            obj2.modificarLibro(cod,titulo,autor,genero,anio,edito,cantidad,ejemplares);
        }
    }
    
    public boolean verificarPrestamo(String dni, String titulo) throws FileNotFoundException, IOException{
        BufferedReader br=new BufferedReader(new FileReader(ruta));
        String fila = null;
        Lector lector = new Lector();
        boolean confirmar = false;
        int cantidad = 0;
        while((fila=br.readLine())!=null){
            String[] cod = fila.split("\\|");
            if(cod[1].equals(titulo)){
                cantidad = Integer.parseInt(cod[7]);
                cantidad--;
                if(cantidad>=0){
                    if(lector.buscarPorDNI(dni)){
                        confirmar = true;
                        break;
                    }
                }
            }
        }
        br.close();
        return confirmar;
    }
    
    public void devolver(String titulo) throws FileNotFoundException, IOException{
        BufferedReader br=new BufferedReader(new FileReader(ruta));
        String fila = null;
        String genero="",autor="",anio="",cod="",edito="",name="";
        int cantidad=0, ejemplares=0;
        Lector obj = new Lector();    
        Boolean confirmar = false;
        while((fila=br.readLine())!=null){
            name=fila.split("\\|")[1];           
            if(name.equals(titulo)){
                
                genero = fila.split("\\|")[3];
                autor = fila.split("\\|")[2];
                anio = fila.split("\\|")[4];
                cod = fila.split("\\|")[0];
                edito = fila.split("\\|")[5];
                cantidad = Integer.parseInt(fila.split("\\|")[6]);
                ejemplares = Integer.parseInt(fila.split("\\|")[7]);
                ejemplares += 1;            
                System.out.println("SI");
                confirmar = true;
            }
        }
        if(confirmar){
            Libro obj2 = new Libro();
            obj2.modificarLibro(cod,titulo,autor,genero,anio,edito,cantidad,ejemplares);
        }
    }
 
    public boolean verificarDevolucion(String dni, String titulo) throws FileNotFoundException, IOException{
        BufferedReader br=new BufferedReader(new FileReader(ruta));
        String fila = null;
        Lector lector = new Lector();
        boolean confirmar = false;
        int cantidad = 0;
        while((fila=br.readLine())!=null){
            String[] cod = fila.split("\\|");
            if(cod[1].equals(titulo)){
                cantidad = Integer.parseInt(cod[7]);
                cantidad++;
                if(cantidad<=Integer.parseInt(cod[6])){
                    if(lector.buscarPorDNI(dni)){
                        confirmar = true;
                        break;
                    }
                }
            }
        }
        br.close();
        return confirmar;
    }
    
    
    public void registrarLibro() {
        
        try{
            FileWriter fw = new FileWriter(ruta,true);           
            String fila= get_generar_codigo()+"|"+this.titulo+"|"+ this.autor+"|"+this.genero+"|"+this.a_publicacion+"|"+this.editorial+"|"+this.n_ejemplares+"|"+this.ejemplares_disponibles+"\n";          
            fw.write(fila);
            fw.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    public void eliminarLibro(String id) throws FileNotFoundException, IOException{
        BufferedReader br=new BufferedReader(new FileReader(ruta));
        String linea;
        //Creando un archivo temporal
        File temporal=new File("C:\\Users\\JOSUE CORDOVA\\OneDrive\\Documentos\\Temporal//Temporal.txt");
        FileWriter fw=new FileWriter(temporal, true);
        
        while((linea=br.readLine())!=null){
            String nam=linea.split("\\|")[0];
            if(!nam.equals(id)){
                fw.write(linea+"\n");
            }
        }
        br.close();
        fw.close(); 
        file.delete();
        File lector =new File(ruta);
        temporal.renameTo(lector);    
        this.file=lector;
    }
    
    public boolean verificarLibroRepetido(String nombre) throws FileNotFoundException, IOException{
        BufferedReader br=new BufferedReader(new FileReader(ruta));
        String fila = null;
        boolean confirmar = false;
        while((fila=br.readLine())!=null){
            String name=fila.split("\\|")[1];
            if(name.equals(nombre)){
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
     public int get_generar_codigo() throws IOException{
        //BufferedReader br = new BufferedReader(get_archivo());
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        String fila; int codigo=0;
        while((fila=br.readLine())!=null){
            codigo=Integer.parseInt(fila.split("\\|")[0]);
        }
        br.close();
        return codigo+1;        
    }
     public void modificarLibro(String codigo, String titulo,String autor, String genero, String anio, String editorial, int cantidad, int ejemplares) throws FileNotFoundException, IOException{
        
        BufferedReader br =new BufferedReader(new FileReader(ruta));
        String linea;
        
        File temporal=new File("C:\\Users\\JOSUE CORDOVA\\OneDrive\\Documentos\\Temporal//Temporal.txt");
        FileWriter fw=new FileWriter(temporal, true);
        
        while((linea=br.readLine())!=null){
            if(linea.split("\\|")[0].equals(codigo)){
                String fila= get_generar_codigo()+"|"+this.titulo+"|"+ this.autor+"|"+this.genero+"|"+this.a_publicacion+"|"+this.editorial+"|"+this.n_ejemplares+"|"+this.ejemplares_disponibles+"\n";
                String f_modificado=codigo+"|"+titulo+"|"+autor+"|"+genero+"|"+anio+"|"+editorial+"|"+cantidad+"|"+ejemplares+"\n"; 
                fw.write(f_modificado);               
            }else{
                fw.write(linea+"\n");
            }
        }
        br.close();
        fw.close(); 
        file.delete();
        File lector=new File(ruta);
        temporal.renameTo(lector);    
        this.file=lector;
    }
    public String get_registro(String codigo) throws FileNotFoundException, IOException{
        
        BufferedReader br=new BufferedReader(new FileReader(ruta));
        String fila, registro = null;
        while((fila=br.readLine())!=null){
            String cod=fila.split("\\|")[0];
            if(cod.equals(codigo)){
                registro=fila; break;
            }
        }
        br.close();
        return registro;
    }
 
    
    
    
    
    
    
    
    
    
    
    
    
    
}
