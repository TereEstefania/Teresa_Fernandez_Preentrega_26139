package com.techlab.articulo.menu;

import com.techlab.articulo.model.*;
import com.techlab.articulo.repository.Repositorio;

public class MenuArticulos extends Menu {
    private Repositorio<Articulo> repositorioArticulos;
    private Repositorio<Categoria> repositorioCategorias;

    public MenuArticulos(java.util.Scanner scanner, Repositorio<Articulo> repositorioArticulos, Repositorio<Categoria> repositorioCategorias){
        super(scanner);
        this.repositorioArticulos = repositorioArticulos;
        this.repositorioCategorias = repositorioCategorias;
    }

    @Override
    public void mostrarMenu(){
        System.out.println("\n**** MENÚ ARTÍCULOS ****");
        System.out.println("1 - Ingresar artículo");
        System.out.println("2 - Listar artículos");
        System.out.println("3 - Consultar artículo");
        System.out.println("4 - Modificar artículo");
        System.out.println("5 - Eliminar artículo");
        System.out.println("0 - Volver");
    }

    @Override
    public void ejecutar(){
        int opcion;
        

        do{
            mostrarMenu();
            opcion = leerEntero(scanner, "Ingresa una opción: ");

            switch (opcion) {
                case 1:
                    ingresarArticulo();
                    break;
                case 2:
                    listarArticulos();
                    break;
                case 3:
                    consultarArticulo();
                    break;
                case 4:
                    modificarArticulo();
                    break;
                case 5:
                    eliminarArticulo();
                    break;
                case 0:
                   System.out.println("Saliendo del menú de artículos :)");
                    break;
                default:
                    System.out.println("La opción ingresada no es válida! XP");
            }

        }while(opcion != 0);
    }

    //Ingresar
    public static void ingresarArticulo(){

    }

    //Listar
    public static void listarArticulos(){

    }

    //Consultar
    public static void consultarArticulo(){

    }

    //Modificar
    public static void modificarArticulo(){

    }

    //Eliminar
    public static void eliminarArticulo(){

    }
}
