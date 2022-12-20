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
public final class CaraLibroBD {

    //atributos de la clase CaraLibroBD
    private static ArrayList<Perfil> perfis = new ArrayList();

    static public Perfil obterPerfil(String nome, String contrasinal) {
        for (int i = 0; i < perfis.size(); i++) {
            //Recorrer Array perfiles ↑↑
            if (perfis.get(i).getNome().equals(nome)) {
                //Comparar nome ↑↑
                if (perfis.get(i).getContrasinal().equals(contrasinal)) {
                    //Comparar contrasinal ↑↑
                    return perfis.get(i);
                }
            }
        }
        return null;
    }
    
    //método encargado de buscar un perfil
    static public Perfil buscarPerfil(String nome){
        for (int i = 0; i < perfis.size(); i++) {
             //Recorrer Array perfiles ↑↑
             if (perfis.get(i).getNome().equals(nome)) {
                 //Comparar nome ↑↑
                 return perfis.get(i);
             }
        }
        return null;
    }
    
    //este método se encarga de añadir un perfil nuevo a el arraylist de perfiles
    static public void engadirPerfil(Perfil novoPerfil){
        perfis.add(novoPerfil);
    }
}
