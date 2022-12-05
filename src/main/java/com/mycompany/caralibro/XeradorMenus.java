/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caralibro;

import java.util.Scanner;

/**
 *
 * @author a22manuelmf
 */
public class XeradorMenus {

    public void mostrarMenuInicial() {
        int eleccion;
        Scanner num = new Scanner(System.in);
        do {
            System.out.println("Para iniciar sesión escriba 1");
            System.out.println("¿No tienes una cuenta todavía?");
            System.out.println("sí quieres crear una cuenta escribe 2");
            eleccion = num.nextInt();
            switch (eleccion) {
                case 1 ->
                    iniciarSesion();
                case 2 ->
                    crearPerfil();
                default ->
                    System.out.println("Ese número no es válido");
            }

        } while (eleccion != 1 && eleccion != 2);

    }

    public void mostrarMenuPrincipal(Perfil perfil) {
        int eleccion;
        Scanner num = new Scanner(System.in);

        do {
            System.out.println("1.Estado actual: " + perfil.getEstado());
            System.out.println("2.Biografía");
            System.out.println("3.Solicitudes de amistad: " + perfil.getSolicitudes().size());
            System.out.println("4.Lista de amigos");
            System.out.println("5.Mensaxes: " + perfil.getMensaxes().size());
            System.out.println("6.Cerrar sesión");
            eleccion = num.nextInt();
            switch (eleccion) {
                case 1 ->
                    cambiarEstado(perfil);                      //hecho
                case 2 ->
                    mostrarBiografia(perfil);
                case 3 ->
                    mostrarSolicitudesDeAmizade(perfil);        //hecho
                case 4 ->
                    mostrarListaAmigos(perfil);                 //falta bio
                case 5 ->
                    mostrarMensaxes(perfil);                    //hecho
                case 6 ->
                    pecharSesion(perfil);                       //hecho
                default -> {
                }
            }

        } while (eleccion < 1 || eleccion > 6);

    }

    public void mostrarBiografia(Perfil perfil) {
        int eleccion;
        Scanner num = new Scanner(System.in);
        System.out.println("Biografia");
        for (int i = perfil.getPublicacions().size(); i > 0; i--) {
            if (perfil.getPublicacions().get(i).getAutor().getNome().equals(perfil.getNome())) {
                System.out.println("Ti escribiches: ");
            } else {
                System.out.println(perfil.getPublicacions().get(i).getAutor().getNome() + " escribiu: ");
            }
            System.out.println(perfil.getPublicacions().get(i).getData());
            System.out.println((i + 1) + ". " + perfil.getPublicacions().get(i).getTexto());
            for (int j = perfil.getPublicacions().get(i).getComentarios().size(); j >= 0; j++) {
                System.out.println(perfil.getPublicacions().get(i).getComentarios().get(j).getAutor().getNome());
                System.out.println(perfil.getPublicacions().get(i).getComentarios().get(j).getTexto());
            }
            System.out.println("Tiene " + perfil.getPublicacions().get(i).getMeGusta().size() + " me gusta");
        }
        System.out.println("Número para gestionar publicación, 0 para volver al menú principal");
        eleccion = num.nextInt();
        if(eleccion==0){
            mostrarMenuPrincipal(perfil);
        } else{
            gestionPublicacion(perfil,eleccion);
        }
        //escribirComentario(perfil, publicacion);

    }

    private void gestionPublicacion(Perfil perfil, int eleccion){
        System.out.println();
    }
    
    public void mostrarSolicitudesDeAmizade(Perfil perfil) {
        int eleccion;
        Scanner num = new Scanner(System.in);
        System.out.println("Solicitudes de amizade");
        System.out.println("Tes " + perfil.getSolicitudes().size() + " solicitudes");
        System.out.println("Para ver las solicitudes pulse 3");
        System.out.println("Para hacer una solicitud pulse 4");
        System.out.println("Pulse 5 para volver");
        do {
            eleccion = num.nextInt();
            switch (eleccion) {
                case 3 ->
                    gestionSolicitudes(perfil);
                case 4 ->
                    crearSolicitude(perfil);
                case 5 ->
                    mostrarMenuPrincipal(perfil);
                default -> {
                }
            }
        } while (eleccion < 3 || eleccion > 5);
    }

    private void gestionSolicitudes(Perfil perfil) {
        int eleccion;
        Scanner num = new Scanner(System.in);
        for (int i = 0; i < perfil.getSolicitudes().size(); i++) {
            System.out.println("Tienes una solicitud de: " + perfil.getSolicitudes().get(i).getNome());
            System.out.println("Pulsa 1 para aceptarla o 2 para rechazarla");
            eleccion = num.nextInt();
            switch (eleccion) {
                case 1 -> {
                    perfil.aceptarSolicitudeAmizade(perfil.getSolicitudes().get(i));
                    perfil.getSolicitudes().get(i).engadirAmigo(perfil);
                }
                case 2 ->
                    perfil.rexeitarSolicitudeAmizade(perfil.getSolicitudes().get(i));
                default ->
                    System.out.println("La solicitud permanecerá sin aceptar");
            }
        }
    }

    private void crearSolicitude(Perfil perfil) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Que perfil queres engadir de amigo");
        String nome = leer.nextLine();
        if (CaraLibroBD.buscarPerfil(nome) != null) {
            CaraLibroBD.buscarPerfil(nome).solicitudeDeAmizade(perfil);
            System.out.println("Solicitude enviada a: " + CaraLibroBD.buscarPerfil(nome).getNome());
        } else {
            System.out.println("Ese perfil no existe");
        }
    }

    public void mostrarListaAmigos(Perfil perfil) {
        Scanner num = new Scanner(System.in);
        System.out.println("Amigos");
        for (int i = 0; i < perfil.getAmigos().size(); i++) {
            System.out.println((i + 1) + ". " + perfil.getAmigos().get(i).getNome());
            System.out.println(perfil.getAmigos().get(i).getEstado());
        }
        System.out.println("Escribe el número para enviar mensaje");
        escribirMensaxe(perfil, perfil.getAmigos().get((num.nextInt() - 1)));
    }

    public void mostrarMensaxes(Perfil perfil) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Mensaxes");
        for (int i = perfil.getMensaxes().size(); i > 0; i--) {
            System.out.println((i + 1) + ". " + perfil.getMensaxes().get(i).getRemitente().getNome() + ":");
            System.out.println("Enviado a: " + perfil.getMensaxes().get(i).getData());
            if (!perfil.getMensaxes().get(i).isLido()) {
                System.out.println("Sen leer");
            } else {
                System.out.println("Mensaxe xa lida");
            }
            System.out.println(perfil.getMensaxes().get(i).getTexto());
        }
        System.out.println("Número para gestionar mensaje, 0 para volver al menú principal");
        int eleccion = leer.nextInt();
        if (eleccion == 0) {
            mostrarMenuPrincipal(perfil);
        } else {
            xestionMensaxes(eleccion, perfil);
        }
    }

    private void xestionMensaxes(int MensaxeElexido, Perfil perfil) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Que quieres hacer con el mensaje");
        System.out.println("1. Marcar como lida");
        System.out.println("2. Eliminar a mensaxe");
        System.out.println("3. Responder");
        switch (leer.nextInt()) {
            case 1 -> {
                marcarMensaxeComoLida(perfil.getMensaxes().get(MensaxeElexido));
                mostrarMensaxes(perfil);
            }
            case 2 -> {
                perfil.getMensaxes().remove(MensaxeElexido);
                mostrarMensaxes(perfil);
            }
            case 3 -> {
                escribirMensaxe(perfil, perfil.getMensaxes().get(MensaxeElexido).getRemitente());
            }
            default -> {
            }
        }
    }

    public void pecharSesion(Perfil perfil) {
        mostrarMenuInicial();
    }

    private void crearPerfil() {
        Scanner leer = new Scanner(System.in);
        String nombre;
        String contraseña;
        String contraseña2;
        do {
            System.out.println("Inserte el nombre");
            nombre = leer.nextLine();
            System.out.println("inserte la contraseña");
            contraseña = leer.nextLine();
            System.out.println("repita la contraseña");
            contraseña2 = leer.nextLine();
            if (contraseña.equals(contraseña2)) {
                Perfil perfil = new Perfil(nombre, contraseña);
                CaraLibroBD.engadirPerfil(perfil);
                mostrarMenuInicial();
            }
        } while (!(contraseña.equals(contraseña2)));
    }

    private void iniciarSesion() {
        Scanner leer = new Scanner(System.in);
        String nome;
        System.out.println("Escribe tu nombre de usuario");
        nome = leer.nextLine();
        System.out.println("Escribe tu contraseña");
        mostrarMenuPrincipal(CaraLibroBD.obterPerfil(nome, leer.nextLine()));
    }

    private void cambiarEstado(Perfil perfil) {
        Scanner est = new Scanner(System.in);
        Scanner num = new Scanner(System.in);
        System.out.println(perfil.getEstado());
        System.out.println("¿Deseas cambiar el estado? 1:Si, 2:No");
        int eleccion = num.nextInt();
        if (eleccion == 1) {
            perfil.setEstado(est.nextLine());
            mostrarMenuPrincipal(perfil);
        }
        if (eleccion == 2) {
            mostrarMenuPrincipal(perfil);
        }
    }

    private void escribirComentario(Publicacion publicacion, Perfil perfil) {
        Scanner leer = new Scanner(System.in);
        String patata = leer.nextLine();
        Comentario texto = new Comentario(patata);
        publicacion.engadirComentario(texto);
    }

    private void facerMeGusta(Publicacion publicacion) {

    }

    private void escribirMensaxe(Perfil remitente, Perfil destinatario) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Escribe tu mensaje para" + destinatario.getNome());
        Mensaxe men = new Mensaxe(leer.nextLine(), remitente);
        destinatario.engadirMensaxePrivada(men);
        mostrarMenuPrincipal(remitente);
    }

    private void marcarMensaxeComoLida(Mensaxe mensaxe) {
        mensaxe.setLido(true);
    }

    private void eliminarMensaxe(Perfil perfil, Mensaxe mensaxe) {

    }

}
