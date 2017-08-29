package com.example.hp.prueba2.Model;

import com.orm.SugarRecord;

/**
 * Created by HP on 26-08-2017.
 */

public class Book extends SugarRecord {
    private String titulo;
    private String autor;
    private String comentario;
    private int porcentaje;
    public Book() {
    }

    public Book(String titulo, String autor, String comentario, int porcentaje) {
        this.titulo = titulo;
        this.autor = autor;
        this.comentario = comentario;
        this.porcentaje = porcentaje;
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
}
