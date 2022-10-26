package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class Persona {
    
    private String nombre, ap_paterno, ap_materno, dni, codigo, sexo, contrasenia;
    private String ruta = "C:\\Users\\JOSUE CORDOVA\\OneDrive\\Documentos\\ProyectoPoo//RegistroDeLectores.txt";
    File file;

    public Persona(String nombre, String ap_paterno, String ap_materno, String dni, String codigo, String sexo, String contrasenia) {
        this.nombre = nombre;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.dni = dni;
        this.codigo = codigo;
        this.sexo = sexo;
        this.contrasenia = contrasenia;
        file = new File(ruta);
    }
    public Persona(){
       
        file = new File(ruta);      
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public void registrarPersona() {
        
        try{
            FileWriter fw = new FileWriter(ruta,true);           
            String fila= this.dni+"|"+this.nombre +"|"+ this.ap_paterno+"|"+this.ap_materno+"|"+this.sexo+"|"+this.codigo+"|"+this.contrasenia+"\n";          
            fw.write(fila);
            fw.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    public boolean get_validacion(String user_cod, String user_contra) throws FileNotFoundException, IOException{      
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        String fila;
        while((fila=br.readLine())!=null){
            String cod=fila.split("\\|")[5];
            String contra=fila.split("\\|")[6];
            if(cod.equals(user_cod) && contra.equals(user_contra)){
                return true;
            }
                                        
        }      
        br.close();
        return false;
    }
      public boolean get_repetido(String doc) throws FileNotFoundException, IOException{      
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        String fila;
        while((fila=br.readLine())!=null){
            if(doc.equals(fila.split("\\|")[0])){
                return true;
            }                                              
        }      
        br.close();
        return false;
    }
    
     
    
    
}
