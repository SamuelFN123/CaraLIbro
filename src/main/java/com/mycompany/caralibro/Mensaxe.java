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
public class Mensaxe {
    private String texto;
    private boolean lido;
    private Perfil remitente;
    private LocalDateTime data;
    
    public Mensaxe(String texto, Perfil remitente) {
        this.texto = texto;
        this.remitente = remitente;
        this.data = data.now().withSecond(0).withNano(0);
        this.lido = false;
    }    

    public String getTexto() {
        return texto;
    }

    public boolean isLido() {
        return lido;
    }

    public Perfil getRemitente() {
        return remitente;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setLido(boolean lido) {
        this.lido = lido;
    }

    public void setRemitente(Perfil remitente) {
        this.remitente = remitente;
    }

    public LocalDateTime getData() {
        return data;
    }
    
}
