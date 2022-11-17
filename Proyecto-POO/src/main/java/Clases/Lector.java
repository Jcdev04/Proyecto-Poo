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
    private String estado_lector;
    private String ruta ="C:\\Users\\JOSUE CORDOVA\\OneDrive\\Documentos\\ProyectoPoo//RegistroDeLectores.txt";
    File file ;

    public Lector(String dni, String nombre, String apellidos, String correo, String telefono, String estado_lector) {
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

    public String getEstado_lector() {
        return estado_lector;
    }

    public void setEstado_lector(String estado_lector) {
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
            String fila= get_generar_codigo()+"|"+this.nombres+"|"+ this.apellidos+"|"+this.correo+"|"+this.telefono+"|"+this.dni+"|"+this.estado_lector+"\n";          
            fw.write(fila);
            fw.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
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
    public ArrayList<String> getLectores() throws FileNotFoundException, IOException{
        ArrayList<String> coleccion = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        
        String fila;
        while((fila=br.readLine())!=null){
            coleccion.add(fila);           
        }
        br.close();
        return coleccion;
    }
    public String getLectoresPorDni(String dni) throws FileNotFoundException, IOException{
        String coleccion = "";
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        
        String fila;
        while((fila=br.readLine())!=null){
            if(fila.split("\\|")[5].equals(dni)){
               coleccion = fila; 
               break;
            }                  
        }
        br.close();
        return coleccion;
    }
   
    
    public void modificarLector(String codigo, String dni, String nombre, String apellidos, String telefono, String correo, String estado_lector) throws FileNotFoundException, IOException{
        
        BufferedReader br =new BufferedReader(new FileReader(ruta));
        String linea;
        
        File temporal=new File("C:\\Users\\JOSUE CORDOVA\\OneDrive\\Documentos\\Temporal//Temporal.txt");
        FileWriter fw=new FileWriter(temporal, true);
        
        while((linea=br.readLine())!=null){
            if(linea.split("\\|")[0].equals(codigo)){
                String fila= get_generar_codigo()+"|"+this.nombres+"|"+ this.apellidos+"|"+this.correo+"|"+this.telefono+"|"+this.dni+"|"+this.estado_lector+"\n"; 
                String f_modificado=codigo+"|"+nombre+"|"+apellidos+"|"+correo+"|"+telefono+"|"+dni+"|"+estado_lector+"\n"; 
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

    public void set_eliminarLector(String id) throws FileNotFoundException, IOException{
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
    
    public boolean buscarLector(String dni) throws FileNotFoundException, IOException{
        BufferedReader br=new BufferedReader(new FileReader(ruta));
        String fila;
        while((fila=br.readLine())!= null){
            String igual = fila.split("\\|")[5];
            if(igual.equals(dni)){
                return true;
            }
        }
        return false;
    }
    public boolean get_repetido(String dni) throws FileNotFoundException, IOException{      
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        String fila;
        while((fila=br.readLine())!=null){
            if(dni.equals(fila.split("\\|")[5])){
                return true;
            }                                              
        }      
        br.close();
        return false;
    }
 

       
}
