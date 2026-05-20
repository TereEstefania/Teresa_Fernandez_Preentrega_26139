package com.techlab.articulo.menu;

import java.util.ArrayList;
import java.util.Scanner;

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
                    ingresarArticulo(scanner, repositorioArticulos, repositorioCategorias);
                    break;
                case 2:
                    listarArticulos(repositorioArticulos);
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

    //Metodo para la seleccion de el submenu de articulos
    public static int eleccionTipoArticulo(Scanner scanner){

        System.out.println("1 - Artículo electrónico");
        System.out.println("2 - Artículo alimenticio");
        System.out.println("0 - Volver al menú Articulos");

        int tipo;
        do{
            tipo = leerEntero(scanner, "Seleccione el tipo de artículo: ");
            if(tipo == 0){
                return -1;
            }

            if (tipo != 1 && tipo != 2) {
                System.out.println("Error: debe elegir 1 o 2.");
            }
        }while(tipo != 1 && tipo != 2);

        return tipo;
    }
    

    //Ingresar
    public static void ingresarArticulo(Scanner scanner, Repositorio<Articulo> articulos, Repositorio<Categoria> categorias){

        System.out.println("====== INGRESAR ARTÍCULO ======");
        int tipo = eleccionTipoArticulo(scanner);

        //si tipo es -1 vuelve al menu principal
        if(tipo == -1){
            return;
        }

        

    }

    //Listar
    public static void listarArticulos(Repositorio<Articulo> articulos){

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
