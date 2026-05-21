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

        MenuArticulos menuArticulos = new MenuArticulos(scanner, repositorioArticulo, repositorioCategoria);
        MenuCategorias menuCategoria = new MenuCategorias(scanner, repositorioCategoria);

        int opcion;

        do{
            System.out.println("*****  MENú PRINCIPAL  *****");
            System.out.println("1: is al menú de articulos");
            System.out.println("2: Ir al menú de categorias");
            System.out.println("0: Salir");

            opcion = Menu.leerEntero(scanner,"Ingrese una opcion: ");

            switch (opcion) {
                case 1:        
                    menuArticulos.mostrarMenu();
                    menuArticulos.ejecutar();
                    break;
                case 2:
                    menuCategoria.mostrarMenu();
                    menuCategoria.ejecutar();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema... Vuelvas Pronto! :D");
                    break;
                default:
                    System.out.println("Esa opcion no existe! XD");          
            }

        }while(opcion != 0);

        scanner.close();
    }
}

