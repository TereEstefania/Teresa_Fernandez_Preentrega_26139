package com.techlab.articulo.menu;

import com.techlab.articulo.model.Articulo;
import com.techlab.articulo.model.Categoria;
import com.techlab.articulo.repository.Repositorio;

public class MenuCategorias extends Menu{

        private Repositorio<Articulo> repositorioArticulos;
        private Repositorio<Categoria> repositorioCategorias;

    public MenuCategorias(java.util.Scanner scanner, Repositorio<Articulo> repositorioArticulos, Repositorio<Categoria> repositorioCategorias){
        super(scanner);
        this.repositorioArticulos = repositorioArticulos;
        this.repositorioCategorias = repositorioCategorias;
    }

    @Override
    public void mostrarMenu(){
        System.out.println("\n**** MENÚ CATEGORÍAS ****");
        System.out.println("1 - Ingresar categoría");
        System.out.println("2 - Listar categorías");
        System.out.println("3 - Consultar categoría");
        System.out.println("4 - Modificar categoría");
        System.out.println("5 - Eliminar categoría");
        System.out.println("0 - Volver");
    }

    @Override
    public void ejecutar(){

        int opcion;

        do{
            mostrarMenu();
            opcion = leerEntero(scanner, "Ingrese una opcion: ");

           switch (opcion) {
                case 1:
                    ingresarCategoria();
                    break;
                case 2:
                    listarCategorias();
                    break;
                case 3:
                    consultarCategoria();
                    break;
                case 4:
                    modificarCategoria();
                    break;
                case 5:
                    eliminarCategoria();
                    break;
                case 0:
                   System.out.println("Saliendo del menú de categorias :)");
                    break;
                default:
                    System.out.println("La opción ingresada no es válida! XP");
            }
        }while(opcion != 0);
    }

    //Agregar
    public static void ingresarCategoria(){

    }
    
    //Listar
    public static void listarCategorias(){

    }

    //consultar
    public static void consultarCategoria(){

    }

    //Modificar
    public static void modificarCategoria(){

    }

    //Eliminar
    public static void eliminarCategoria(){

    }
}
