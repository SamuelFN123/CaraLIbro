/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caralibro;

import java.time.LocalDateTime;

/**
 *
 * @author a22manuelmf
 */
public class Comentario {
    
    //atributos de la clase Comentario
    private String texto;
    private LocalDateTime data;
    private Perfil autor;

    //contructor de la clase Comentario
    public Comentario(String texto) {
        this.texto = texto;
        this.data = data.now().withSecond(0).withNano(0);
        
    }

    //geter y seter de la clase Comentario
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Perfil getAutor() {
        return autor;
    }

    public void setAutor(Perfil autor) {
        this.autor = autor;
    }

}
