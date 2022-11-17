/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 *
 * @author Jesus
 */
public class Prestamo extends Operacion{

    private String ruta = "C:\\Users\\JOSUE CORDOVA\\OneDrive\\Documentos\\ProyectoPoo//LibrosPrestados.txt";
    File file;
    
    public Prestamo(String dni, String fecha, String ejemplar_id) {
        super(dni, fecha, ejemplar_id);
        file = new File(ruta);
    }
    
    public void prestar(){
        try{
            FileWriter fw = new FileWriter(ruta,true);
            String fila= this.getDni()+"|"+this.getFecha()+"|"+ this.getEjemplar_id()+"\n";          
            fw.write(fila);
            fw.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void devolucion(){
        
    }
    
}
