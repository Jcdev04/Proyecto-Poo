/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author User
 */
public class Libro {
    private String ID_Libro;
    private String titulo;
    private String autor;
    private String categoria;
    private int stock;
    private int libros_disponibles;

    public Libro(String ID_Libro, String titulo, String autor, String categoria, int stock, int libros_disponibles) {
        this.ID_Libro = ID_Libro;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.stock = stock;
        this.libros_disponibles = libros_disponibles;
    }

    public String getID_Libro() {
        return ID_Libro;
    }

    public void setID_Libro(String ID_Libro) {
        this.ID_Libro = ID_Libro;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getLibros_disponibles() {
        return libros_disponibles;
    }

    public void setLibros_disponibles(int libros_disponibles) {
        this.libros_disponibles = libros_disponibles;
    }
    
    
    
}
