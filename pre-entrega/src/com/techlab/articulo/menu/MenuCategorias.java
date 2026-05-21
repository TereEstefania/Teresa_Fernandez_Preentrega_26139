package com.techlab.articulo.menu;

import java.util.Scanner;

//import com.techlab.articulo.model.Articulo;
import com.techlab.articulo.model.Categoria;
import com.techlab.articulo.repository.Repositorio;
import com.techlab.articulo.utils.Secuencias;

public class MenuCategorias extends Menu{

      //  private Repositorio<Articulo> repositorioArticulos;
        private Repositorio<Categoria> repositorioCategorias;

    public MenuCategorias(java.util.Scanner scanner,  Repositorio<Categoria> repositorioCategorias){
        super(scanner);
       // this.repositorioArticulos = repositorioArticulos;
        this.repositorioCategorias = repositorioCategorias;
    }

    @Override
    public void mostrarMenu(){
        System.out.println("\n************ MENÚ CATEGORÍAS ***********");
        System.out.println("1 - Ingresar categoría");
        System.out.println("2 - Listar categorías");
        System.out.println("3 - Consultar categoría");
        System.out.println("4 - Modificar categoría");
        System.out.println("5 - Eliminar categoría");
        System.out.println("0 - Volver");
        System.out.println("******************************************");
    }

    @Override
    public void ejecutar(){

        int opcion;

        do{
            mostrarMenu();
            opcion = leerEntero(scanner, "Ingrese una opcion: ");

           switch (opcion) {
                case 1:
                    ingresarCategoria(scanner, repositorioCategorias);
                    break;
                case 2:
                    listarCategorias(repositorioCategorias);
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
    public static void ingresarCategoria(Scanner scanner, Repositorio<Categoria> categorias){
        System.out.println("\n ==== INGRESAR CATEGORIA ====");
        
        String nombre = leerTextoNoVacio(scanner, "Ingrese un nombre para la categoria");
        
        //Primero buscao por nombre para no tener que generar un codigo sin necesidad
        if(categorias.buscarPorNombre(nombre) != null){
            System.out.println("Esa categoria ya existe! XD");
            return;
        }           
        
        //generar el codigo para la categoria
        int codigo = Secuencias.generarCodigoCategoria();
 
        String descripcion = leerTextoNoVacio(scanner, "Ingrese la descripcion de la categoria");

        Categoria categoriaNueva = new Categoria(codigo, nombre, descripcion);

        if(categorias.agregar(categoriaNueva)){
            System.out.println("CATEGORIA AGREGADA! :D");
        }else{
            System.out.println("Se produjo un error, intente nuevamente! XP");
        }

    }
    
    //Listar
    public static void listarCategorias(Repositorio<Categoria> categorias){
        System.out.println("\n========= LISTA DE CATEGORIAS ==========");

        if(categorias.estaVacio()){
            System.out.println("La lista de Categorias esta vacia! :O");
            return;
        }

        for (Categoria categoria : categorias.listar()) {
            System.out.println(categoria.toString());
        }
        System.out.println("\n========================================");
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
