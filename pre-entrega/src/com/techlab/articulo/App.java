package com.techlab.articulo;

import java.util.Scanner;

import com.techlab.articulo.menu.*;
import com.techlab.articulo.model.*;
import com.techlab.articulo.repository.Repositorio;

public class App {
    public static void main(String[] args) throws Exception {
        
        //scanner compartido
        Scanner scanner = new Scanner(System.in);
        
        //repositorios 
        Repositorio<Articulo> repositorioArticulo = new Repositorio<>();
        Repositorio<Categoria> repositorioCategoria = new Repositorio<>();

        scanner.close();
    }
}

