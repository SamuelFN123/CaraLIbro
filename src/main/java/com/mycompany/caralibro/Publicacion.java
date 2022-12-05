/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caralibro;

import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 *
 * @author a22manuelmf
 */
public class Publicacion {

    private String texto;
    private ArrayList<Comentario> comentarios = new ArrayList();
    private LocalDateTime data;
    private Perfil Autor;
    private ArrayList<Perfil> MeGusta = new ArrayList();

    public Publicacion(Perfil autor, String texto) {
        this.texto = texto;
        this.data = data.now().withSecond(0).withNano(0);
        this.Autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Perfil getAutor() {
        return Autor;
    }

    public void engadirComentario(Comentario comentario) {
        comentarios.add(comentario);
    }

    public ArrayList<Perfil> getMeGusta() {
        return MeGusta;
    }

}
