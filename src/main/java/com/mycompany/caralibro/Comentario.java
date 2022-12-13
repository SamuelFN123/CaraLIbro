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

    private String texto;
    private LocalDateTime data;
    private Perfil autor;

    public Comentario(String texto) {
        this.texto = texto;
        this.data = data.now().withSecond(0).withNano(0);
        
    }

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
