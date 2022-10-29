/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

public class Libro {
    private String libro_id;
    private String titulo;
    private String autor;
    private String genero;
    private String a_publicacion;
    private String nombre_editorial;
    private int n_ejemplares;
    private int ejemplares_disponibles;

    public Libro(String libro_id, String titulo, String autor, String genero, String a_publicacion, String nombre_editorial, int n_ejemplares, int ejemplares_disponibles) {
        this.libro_id = libro_id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.a_publicacion = a_publicacion;
        this.nombre_editorial = nombre_editorial;
        this.n_ejemplares = n_ejemplares;
        this.ejemplares_disponibles = ejemplares_disponibles;
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
        return nombre_editorial;
    }

    public void setNombre_editorial(String nombre_editorial) {
        this.nombre_editorial = nombre_editorial;
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
    
}
