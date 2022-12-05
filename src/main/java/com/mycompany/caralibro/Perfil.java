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

    private String nome;
    private String contrasinal;
    private String estado;

    private ArrayList<Perfil> amigos = new ArrayList();
    private ArrayList<Publicacion> publicacions = new ArrayList();
    private ArrayList<Perfil> solicitudes = new ArrayList();
    private ArrayList<Mensaxe> mensaxes = new ArrayList();

    public Perfil(String nome, String contrasinal) {
        this.nome = nome;
        this.contrasinal = contrasinal;
        this.estado = "Nuevo en CaraLibro";
    }

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

    public void engadirAmigo(Perfil perfil) {
        amigos.add(perfil);
    }

    public void engadirPublicacion(Publicacion nuevaPubl) {
        publicacions.add(nuevaPubl);
    }

    public void solicitudeDeAmizade(Perfil solicitud) {
        solicitudes.add(solicitud);
    }

    public void aceptarSolicitudeAmizade(Perfil solicitud) {
        amigos.add(solicitud);
        solicitudes.remove(solicitud);
    }

    public void rexeitarSolicitudeAmizade(Perfil solicitud) {
        solicitudes.remove(solicitud);
    }

    public void engadirMensaxePrivada(Mensaxe mensaxe) {
        mensaxes.add(mensaxe);
    }

    public void rexeitarMensaxePrivada(Mensaxe mensaxe) {
        mensaxes.remove(mensaxe);
    }

}
