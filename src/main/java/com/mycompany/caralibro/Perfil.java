/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caralibro;

import java.util.ArrayList;

/**
 *
 * @author a22samuelfn
 */
public class Perfil {

    //atributos de la clase Perfil
    private String nome;
    private String contrasinal;
    private String estado;

    private ArrayList<Perfil> amigos = new ArrayList();
    private ArrayList<Publicacion> publicacions = new ArrayList();
    private ArrayList<Perfil> solicitudes = new ArrayList();
    private ArrayList<Mensaxe> mensaxes = new ArrayList();

    //contructor de la clase Perfil
    public Perfil(String nome, String contrasinal) {
        this.nome = nome;
        this.contrasinal = contrasinal;
        this.estado = "Nuevo en CaraLibro";
    }

    //geter y seter de la clase Perfil
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContrasinal() {
        return contrasinal;
    }

    public void setContrasinal(String contrasinal) {
        this.contrasinal = contrasinal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<Perfil> getAmigos() {
        return amigos;
    }

    public ArrayList<Publicacion> getPublicacions() {
        return publicacions;
    }

    public ArrayList<Perfil> getSolicitudes() {
        return solicitudes;
    }

    public ArrayList<Mensaxe> getMensaxes() {
        return mensaxes;
    }

    //método que añade un amigo
    public void engadirAmigo(Perfil perfil) {
        amigos.add(perfil);
    }

    //método encargado de añadir una nueva publicación
    public void engadirPublicacion(Publicacion nuevaPubl) {
        publicacions.add(nuevaPubl);
    }

    //método encargado de enviar una solicitud de amistad
    public void solicitudeDeAmizade(Perfil solicitud) {
        solicitudes.add(solicitud);
    }

    //método encargado de aceptar una solicitud de amistad
    public void aceptarSolicitudeAmizade(Perfil solicitud) {
        amigos.add(solicitud);
        solicitudes.remove(solicitud);
    }

    //método encargado de rechazar una solicitud de amistad
    public void rexeitarSolicitudeAmizade(Perfil solicitud) {
        solicitudes.remove(solicitud);
    }

    //método encargado de añadir una mensaje privada
    public void engadirMensaxePrivada(Mensaxe mensaxe) {
        mensaxes.add(mensaxe);
    }

    //método encargado de rechazar un mensaje 
    public void rexeitarMensaxePrivada(Mensaxe mensaxe) {
        mensaxes.remove(mensaxe);
    }

}
