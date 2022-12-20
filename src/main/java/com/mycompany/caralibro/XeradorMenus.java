/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caralibro;

import java.util.Scanner;

/**
 *
 * @author a22manuelmf,a22samuelfn
 */
public class XeradorMenus {
    
    //atributos de la clase XeradorMenus 
    private Perfil sesion;
    
    //método que muestra las opciones de incio de sesion y darse de alta
    public void mostrarMenuInicial() {
        int eleccion;
        Scanner num = new Scanner(System.in);
        do {
            System.out.println("Para iniciar sesión escriba 1");
            System.out.println("¿No tienes una cuenta todavía?");
            System.out.println("sí quieres crear una cuenta escribe 2");
            eleccion = num.nextInt();
        } while (eleccion < 1 || eleccion > 2);

        switch (eleccion) {
            case 1 ->
                iniciarSesion();
            case 2 ->
                crearPerfil();
            default ->{
            }
        }
    }

    //El método mostrarMenuPrincipal  muestra por pantalla las opciones que tiene el menú principal y envia al cliente al método correspondiente con la opción selecionada
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
        } while (eleccion < 1 || eleccion > 6);

        switch (eleccion) {
            case 1 ->
                cambiarEstado(sesion);                      //hecho
            case 2 ->
                mostrarBiografia(sesion);             //hecho
            case 3 ->
                mostrarSolicitudesDeAmizade(sesion);        //hecho
            case 4 ->
                mostrarListaAmigos(sesion);                 //hecho
            case 5 ->
                mostrarMensaxes(sesion);                    //hecho
            case 6 ->
                pecharSesion(sesion);                       //hecho
            default -> {
            }
        }
    }

    //método que muestra por pantalla la biografia del perfil
    public void mostrarBiografia(Perfil perfil) {
        int eleccion;
        Scanner num = new Scanner(System.in);
        do {
            System.out.println("Biografia");
            System.out.println("0 para escribir una publicación, 1 para ver las publicaciones");
            eleccion = num.nextInt();
        } while (eleccion < 0 || eleccion > 1);

        if (eleccion == 0) {
            crearPublicacion(perfil);
        } else {

            for (int i = perfil.getPublicacions().size(); i > 0; i--) {
                //recorre publicaciones ↑↑

                if (perfil.getPublicacions().get(i - 1).getAutor().getNome().equals(perfil.getNome())) {
                    // ↑↑si son tuyas

                    System.out.println("Ti escribiches: ");

                } else {

                    // ↓↓si son de otro
                    System.out.println(perfil.getPublicacions().get(i - 1).getAutor().getNome() + " escribiu: ");
                }

                //↓↓ fecha
                System.out.println(perfil.getPublicacions().get(i - 1).getData());
                //↓↓ texto
                System.out.println((i) + ". " + perfil.getPublicacions().get(i - 1).getTexto());

                //recorrer comentarios ↓↓
                if (perfil.getPublicacions().get(i - 1).getComentarios().isEmpty()) {
                    System.out.println("no hay comentarios");
                } else {
                    for (int j = perfil.getPublicacions().get(i - 1).getComentarios().size(); j > 0; j--) {
                        //nombre ↓↓
                        System.out.println(perfil.getPublicacions().get(i - 1).getComentarios().get(j - 1).getAutor().getNome());
                        //texto ↓↓
                        System.out.println(perfil.getPublicacions().get(i - 1).getComentarios().get(j - 1).getTexto());
                    }
                }

                if (perfil.getPublicacions().get(i - 1).getMeGusta().isEmpty()) {
                    System.out.println("Todavía no tiene ningún me gusta");
                } else {
                    System.out.println("Tiene " + perfil.getPublicacions().get(i - 1).getMeGusta().size() + " me gusta");
                }     //numero "me gusta" ↑↑

            }
            do {
                System.out.println("Número para gestionar publicación, 0 para volver al menú principal");
                eleccion = num.nextInt();
            } while (eleccion > perfil.getPublicacions().size());

            if (eleccion == 0) {
                mostrarMenuPrincipal(sesion);
            } else {
                gestionPublicacion(perfil, perfil.getPublicacions().get(eleccion - 1));
            }
        }

    }
    
    //método que crea una nueva publicación en el perfil
    private void crearPublicacion(Perfil autor) {
        String texto;
        Scanner leer = new Scanner(System.in);
        System.out.println("Que quieres escribir");
        texto = leer.nextLine();
        Publicacion pub = new Publicacion(sesion, texto);
        autor.getPublicacions().add(pub);
        mostrarMenuPrincipal(sesion);
    }
    
    //método que gestiona una publicación del perfil
    private void gestionPublicacion(Perfil sesion, Publicacion publicacion) {
        int eleccion;
        Scanner num = new Scanner(System.in);
        do {
            System.out.println("Pulse 1 para darle 'me gusta', 2 para escribir un comentario, 0 para volver al menú principal");
            eleccion = num.nextInt();
        } while (eleccion < 0 || eleccion > 2);

        switch (eleccion) {
            case 1 -> {
                comprobarMeGusta(sesion, publicacion);
            }
            case 2 -> {
                escribirComentario(publicacion, sesion);
            }
            case 0 ->
                mostrarMenuPrincipal(sesion);
            default -> {
            }
        }
    }

    //método que muestra las solicitudes de amistad del perfil
    public void mostrarSolicitudesDeAmizade(Perfil perfil) {
        int eleccion;
        Scanner num = new Scanner(System.in);
        do {
            System.out.println("Solicitudes de amizade");
            System.out.println("Tes " + perfil.getSolicitudes().size() + " solicitudes");
            System.out.println("Para ver las solicitudes pulse 1");
            System.out.println("Para hacer una solicitud pulse 2");
            System.out.println("Pulse 3 para volver");
            eleccion = num.nextInt();
        } while (eleccion < 1 || eleccion > 3);

        switch (eleccion) {
            case 1 ->
                gestionSolicitudes(perfil);
            case 2 ->
                crearSolicitude(perfil);
            case 3 ->
                mostrarMenuPrincipal(perfil);
            default -> {
            }
        }
    }

    //método que gestiona las solcitudes de amistad de un perfil ya sea aceptarlas o rechazarlas
    private void gestionSolicitudes(Perfil perfil) {
        int eleccion;
        Scanner num = new Scanner(System.in);
        for (int i = 0; i < perfil.getSolicitudes().size(); i++) {
            System.out.println("Tienes una solicitud de: " + perfil.getSolicitudes().get(i).getNome());
            do {
                System.out.println("Pulsa 1 para aceptarla o 2 para rechazarla");
                eleccion = num.nextInt();
            } while (eleccion < 1 || eleccion > 2);

            switch (eleccion) {
                case 1 -> {
                    perfil.aceptarSolicitudeAmizade(perfil.getSolicitudes().get(i));
                    perfil.getSolicitudes().get(i).engadirAmigo(perfil);
                }
                case 2 -> {
                    perfil.rexeitarSolicitudeAmizade(perfil.getSolicitudes().get(i));
                }
                default -> {
                }
            }
        }
    }

    //método que crea una solicitud de amistad y se la envia al perfil deseado
    private void crearSolicitude(Perfil perfil) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Que perfil queres engadir de amigo");
        String nome = leer.nextLine();
        if (CaraLibroBD.buscarPerfil(nome) != null) {
            CaraLibroBD.buscarPerfil(nome).solicitudeDeAmizade(perfil);
            System.out.println("Solicitude enviada a: " + CaraLibroBD.buscarPerfil(nome).getNome());
        } else {
            System.out.println("Ese perfil no existe");
            int eleccion;
            do {
                System.out.println("1 para volver a intentar, 2 para volver menu principal");
                eleccion = leer.nextInt();
            } while (eleccion < 1 || eleccion > 2);

            if (eleccion == 1) {
                crearSolicitude(perfil);
            }
            if (eleccion == 2) {
                mostrarMenuPrincipal(perfil);
            }
        }
    }

    //método que muestra la lista de amigos del perfil
    public void mostrarListaAmigos(Perfil perfil) {
        Scanner num = new Scanner(System.in);
        System.out.println("Amigos");

        if (perfil.getAmigos().isEmpty()) {
            System.out.println("Por ahora no tienes amigos");
            mostrarMenuPrincipal(perfil);
        } else {

            for (int i = 0; i < perfil.getAmigos().size(); i++) {
                System.out.println((i + 1) + ". " + perfil.getAmigos().get(i).getNome());
                System.out.println(perfil.getAmigos().get(i).getEstado());
            }

            int eleccion1;
            do {
                System.out.println("Escribe el número para enviar mensaje");
                eleccion1 = (num.nextInt() - 1);
            } while (eleccion1 <= perfil.getAmigos().size());

            int eleccion2;
            do {
                System.out.println("Escribe 1 para enviar una mensaje o 2 para ver su biografía");
                eleccion2 = num.nextInt();
            } while (eleccion2 < 1 || eleccion2 > 2);

            if (eleccion1 == 1) {
                escribirMensaxe(perfil, perfil.getAmigos().get(eleccion1));
            } else if (eleccion1 == 2) {
                mostrarBiografia(perfil.getAmigos().get(eleccion1));
            }
        }
    }

    //Método que muestra los mensajes del perfil
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
        int eleccion;
        do {
            System.out.println("Número para gestionar mensaje, 0 para volver al menú principal");
            eleccion = leer.nextInt();
        } while (eleccion <= perfil.getMensaxes().size());

        if (eleccion == 0) {
            mostrarMenuPrincipal(perfil);
        } else {
            eleccion -= perfil.getMensaxes().size();
            xestionMensaxes(eleccion, perfil);
        }
    }
    
    //método que se encarga de la gestión de los mensajes del perfil 
    private void xestionMensaxes(int MensaxeElexido, Perfil perfil) {
        Scanner leer = new Scanner(System.in);
        int eleccion;
        do {
            System.out.println("Que quieres hacer con el mensaje");
            System.out.println("1. Marcar como lida");
            System.out.println("2. Eliminar a mensaxe");
            System.out.println("3. Responder");
            eleccion = leer.nextInt();
        } while (eleccion < 1 || eleccion > 3);

        switch (eleccion) {
            case 1 -> {
                marcarMensaxeComoLida(perfil.getMensaxes().get(MensaxeElexido));
                mostrarMensaxes(perfil);
            }
            case 2 -> {
                eliminarMensaxe(perfil, perfil.getMensaxes().get(MensaxeElexido));
                mostrarMensaxes(perfil);
            }
            case 3 -> {
                escribirMensaxe(perfil, perfil.getMensaxes().get(MensaxeElexido).getRemitente());
            }
            default -> {
            }
        }
    }

    //método que cierra la sesión del perfil
    public void pecharSesion(Perfil perfil) {        
        mostrarMenuInicial();
    }

    //método que sirve para crear un nuevo perfil
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

    //método para iniciar sesión con un perfil creado anteriormente
    private void iniciarSesion() {
        Scanner leer = new Scanner(System.in);
        String nome;
        String contraseña;
        System.out.println("Escribe tu nombre de usuario");
        nome = leer.nextLine();
        System.out.println("Escribe tu contraseña");
        contraseña = leer.nextLine();
        if (CaraLibroBD.obterPerfil(nome, contraseña) == null) {
            int eleccion;
            do {
                System.out.println("El usuario o contraseña está mal");
                System.out.println("Pulse 0 para volver a intentar o 1 para volver al menu inicial");
                eleccion = leer.nextInt();
                if (eleccion == 0) {
                    iniciarSesion();
                } else if (eleccion == 1) {
                    mostrarMenuInicial();
                }
            } while (eleccion < 0 || eleccion > 1);
        } else {
            sesion=CaraLibroBD.obterPerfil(nome, contraseña);
            mostrarMenuPrincipal(CaraLibroBD.obterPerfil(nome, contraseña));
        }
    }

    //método para cambiar el estado de tú perfil
    private void cambiarEstado(Perfil perfil) {
        Scanner est = new Scanner(System.in);
        Scanner num = new Scanner(System.in);
        System.out.println(perfil.getEstado());
        int eleccion;
        do {
            System.out.println("¿Deseas cambiar el estado? 1:Si, 2:No");
            eleccion = num.nextInt();
        } while (eleccion < 1 || eleccion > 2);
        if (eleccion == 1) {
            System.out.print("Nuevo estado: ");
            perfil.setEstado(est.nextLine());
            mostrarMenuPrincipal(perfil);
        }
        if (eleccion == 2) {
            mostrarMenuPrincipal(perfil);
        }

    }

    //método que sirve para escribir un comentario en una publicación
    private void escribirComentario(Publicacion publicacion, Perfil perfil) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Escribe tu comentario");
        String patata = leer.nextLine();
        Comentario comen = new Comentario(patata);
        comen.setAutor(perfil);
        publicacion.engadirComentario(comen);
        mostrarMenuPrincipal(perfil);
    }
    
    //método que comprueba si una publicación tiene me gustas 
    private void comprobarMeGusta(Perfil autor, Publicacion publicacion) {
        if (publicacion.getAutor().equals(autor)) {
            System.out.println("No puedes dar me gusta a tu propia pubblicación");
            gestionPublicacion(autor, publicacion);
        } else if (publicacion.getMeGusta().contains(autor)) {
            System.out.println("Ya has hecho me gusta a esta publicación");
        } else {
            facerMeGusta(publicacion);
        }
    }

    //método que se encarga de darle me gusta a una publicación
    private void facerMeGusta(Publicacion publicacion) {
        publicacion.engadirMeGusta(sesion);
    }

    //método que se encarga de escribir un mensaje a un perfil
    private void escribirMensaxe(Perfil remitente, Perfil destinatario) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Escribe tu mensaje para" + destinatario.getNome());
        Mensaxe men = new Mensaxe(leer.nextLine(), remitente);
        destinatario.engadirMensaxePrivada(men);
        mostrarMenuPrincipal(remitente);
    }
    
    //método que se encarga de marcar cuando un mensaje ha sido leido
    private void marcarMensaxeComoLida(Mensaxe mensaxe) {
        mensaxe.setLido(true);
    }

    //método que sirve para eliminar un mensaje del chat
    private void eliminarMensaxe(Perfil perfil, Mensaxe mensaxe) {
        perfil.getMensaxes().remove(mensaxe);
    }

}
