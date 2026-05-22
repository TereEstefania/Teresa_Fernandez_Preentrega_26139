package com.techlab.articulo.menu;

import java.util.Scanner;

import com.techlab.articulo.model.Articulo;
import com.techlab.articulo.model.Categoria;
import com.techlab.articulo.repository.Repositorio;
import com.techlab.articulo.utils.Secuencias;

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
                    consultarCategoria(scanner, repositorioCategorias);
                    break;
                case 4:
                    modificarCategoria(scanner, repositorioCategorias);
                    break;
                case 5:
                    eliminarCategoria(scanner, repositorioArticulos, repositorioCategorias);
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
    public static void consultarCategoria(Scanner scanner, Repositorio<Categoria> categorias){
        System.out.println("\n===============  CONSULTAR CATEGORIA  ==================");
        if(categorias.estaVacio()){
            System.out.println("No hay artículos cargados :(");
            return;
        }
        int codigo = leerEntero(scanner, "Ingrese el codigo del articulo a consultar");
        
        Categoria categoria = categorias.buscarPorCodigo(codigo);
        
        if(categoria == null){
            System.out.println("Esa categoria no existe! :(");
            return;
        }

        System.out.println("Categoria encontrada:");
        System.out.println(categoria);
    }

    //Modificar
    public static void modificarCategoria(Scanner scanner, Repositorio<Categoria> categorias){
        System.out.println("\n===============  MODIFICAR CATEGORIA  ==================");
        if(categorias.estaVacio()){
                System.out.println("No hay artículos cargados :(");
                return;
        }

        int codigo = leerEntero(scanner, "Ingrese el codigo del articulo a consultar");
        
        Categoria categoria = categorias.buscarPorCodigo(codigo);
        
        if(categoria == null){
            System.out.println("Esa categoria no existe! :(");
            return;
        }

        String nuevoNombre = leerTextoNoVacio(scanner, "Ingrese el nuevo nombre de la categoria: ");
        String nuevaDescripcion = leerTextoNoVacio(scanner, "INgrese la nueva descripcion: ");

        categoria.setNombre(nuevoNombre);
        categoria.setDescripcion(nuevaDescripcion);

        System.out.println("Categoria modificada correctamente :)");
        System.out.println(categoria);
    }

    //Eliminar
    public static void eliminarCategoria(Scanner scanner,Repositorio<Articulo> articulos, Repositorio<Categoria> categorias){

        System.out.println("\n============== ELIMINAR CATEGORIA =================");

        if(categorias.estaVacio()){
                System.out.println("No hay artículos cargados :(");
                return;
        }

        int codigo = leerEntero(scanner, "Ingrese el codigo de la categoria a eliminar: ");
        
        Categoria categoria = categorias.buscarPorCodigo(codigo);
        
        if(categoria == null){
            System.out.println("Esa categoria no existe! :(");
            return;
        }

        if(buscarCategoriaEnArticulo(categoria, articulos)){
            System.out.println("Existen productos de esta categoria, no es posible su eliminacion! XP");
            return;
        } 
        
        if(categorias.eliminar(categoria)){
            System.out.println("La categoria se ha eliminado correctamente! :D");
            System.out.println("\n===================================================");
        }else{
        System.out.println("Ocurrio un error, no se pudo eliminar la categoria! :(");
        System.out.println("\n===================================================");
        }


    }

    //metodo para verificar si una categoria existe en un articulo
    public static boolean buscarCategoriaEnArticulo(Categoria categoria, Repositorio<Articulo> articulos){
        for (Articulo articulo : articulos.listar()) {
            if (articulo.getCategoria().getCodigo() == categoria.getCodigo()) {
                return true;
            }
        }
        return false;
    }

  
}
