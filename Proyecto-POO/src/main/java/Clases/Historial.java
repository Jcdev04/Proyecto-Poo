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
 * @author JOSUE CORDOVA
 */
public class Historial {
    public String dni;
    public String id_libro;
    public String tipo_operacion;
    File archivo;

    private String ruta ="C:\\Users\\JOSUE CORDOVA\\OneDrive\\Documentos\\ProyectoPoo//Historial.txt";


    public Historial(String dni, String id_libro, String tipo_operacion) {
        this.dni = dni;
        this.id_libro = id_libro;
        this.tipo_operacion = tipo_operacion;
        this.archivo = new File(ruta);
    }

    public Historial(){
        this.archivo = new File(ruta);
    }

    public void registrarLector() {

        try{
            FileWriter fw = new FileWriter(ruta,true);
            String fila= get_generar_codigo()+"|"+this.dni+"|"+ this.id_libro+"|"+this.tipo_operacion+"\n";
            fw.write(fila);
            fw.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public int get_generar_codigo() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        String fila; int codigo=0;
        while((fila=br.readLine())!=null){
            codigo=Integer.parseInt(fila.split("\\|")[0]);
        }
        br.close();
        return codigo+1;
    }

    public ArrayList<String> getOperaciones() throws FileNotFoundException, IOException{
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
