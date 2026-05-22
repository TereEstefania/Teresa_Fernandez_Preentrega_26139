package com.techlab.articulo.menu;

import java.util.Scanner;

import com.techlab.articulo.model.*;
import com.techlab.articulo.repository.Repositorio;
import com.techlab.articulo.utils.Secuencias;

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
                    consultarArticulo(scanner,repositorioArticulos);
                    break;
                case 4:
                    modificarArticulo(scanner, repositorioArticulos, repositorioCategorias);
                    break;
                case 5:
                    eliminarArticulo(scanner, repositorioArticulos);
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
    public static void ingresarArticulo(Scanner scanner, Repositorio<Articulo> articulos, Repositorio<Categoria> categorias){

        System.out.println("====== INGRESAR ARTÍCULO ======");
        int tipo = eleccionTipoArticulo(scanner);

        //si tipo es -1 vuelve al menu principal
        if(tipo == -1){
            return;
        }

        String nombre = leerTextoNoVacio(scanner, "Ingrese el nombre del articulo: ");

        if(articulos.buscarPorNombre(nombre) != null){
            System.out.println("Ya existe un artículo con ese nombre XD");
            return;
        }

        int codigo = Secuencias.generarCodigoArticulo();
        double precio = leerDoubleNoNegativo(scanner, "Ingrese el precio del aticulo: ");

        Categoria categoria = new Categoria();
        categoria = pedirCategoriaExistente(scanner, categorias);

        Articulo articulo;

        if(tipo == 1){
            int garantiaMeses = leerEnteroNoNegativo(scanner, "Ingrese la garantía en meses: ");
            articulo = new ArticuloElectronico(codigo, nombre, precio, categoria, garantiaMeses);
        } else{
            int diasParaVencimiento = leerEnteroNoNegativo(scanner, "Ingrese los días para vencimiento: ");
            articulo = new ArticuloAlimenticio(codigo, nombre, precio, categoria, diasParaVencimiento);
        }

         if(articulos.agregar(articulo)){
            System.out.println("ARTÍCULO AGREGADO! :D");
        }else{
            System.out.println("Se produjo un error, intente nuevamente! XP");
        }

    }

    //Listar
    public static void listarArticulos(Repositorio<Articulo> articulos){
        System.out.println("\n============ LISTADO DE ARTÍCULOS ===============");
        if(articulos.estaVacio()){
            System.out.println("La lista de Categorias esta vacia! :O");
            return;
        }

        for (Articulo articulo : articulos.listar()) {
            System.out.println(articulo.toString());
        }
        System.out.println("\n========================================");
    }

    //Consultar
    public static void consultarArticulo(Scanner scanner, Repositorio<Articulo> articulos){
        System.out.println("\n===============  CONSULTAR ARTÍCULO ==================");
        if(articulos.estaVacio()){
            System.out.println("No hay artículos cargados :(");
            return;
        }
        int codigo = leerEntero(scanner, "Ingrese el codigo del articulo a consultar");
        
        Articulo articulo = articulos.buscarPorCodigo(codigo);
        
        if(articulo == null){
            System.out.println("Ese articulo no existe :(");
        }
            System.out.println("Artículo encontrado:");
            System.out.println(articulo);
    }

    //Modificar
    public static void modificarArticulo(Scanner scanner, Repositorio<Articulo> articulos, Repositorio<Categoria> categorias){
        System.out.println("================ MODIFICAR ARTÍCULO ================");

        if(articulos.estaVacio()){
            System.out.println("No hay artículos cargados :(");
            return;
        }
        int codigo = leerEntero(scanner, "Ingrese el codigo del articulo a consultar");
        
        Articulo articulo = articulos.buscarPorCodigo(codigo);
        if(articulo == null){
            System.out.println("Ese articulo no existe :(");
        }

        String nombreNuevo = leerTextoNoVacio(scanner, "Ingrese el nuevo nombre del articulo");
        double precioNuevo = leerDoubleNoNegativo(scanner, "Ingrese el nuevo precio: ");

        Categoria categoriaNueva = new Categoria();
        categoriaNueva = pedirCategoriaExistente(scanner, categorias);

        articulo.setNombre(nombreNuevo);
        articulo.setPrecio(precioNuevo);
        articulo.setCategoria(categoriaNueva);

        if (articulo instanceof ArticuloElectronico) {
            ArticuloElectronico electronico = (ArticuloElectronico) articulo;
            int nuevaGarantia = leerEnteroNoNegativo(scanner, "Ingrese la nueva garantía en meses: ");
            electronico.setGarantiaMeses(nuevaGarantia);
        }

        if (articulo instanceof ArticuloAlimenticio) {
            ArticuloAlimenticio alimenticio = (ArticuloAlimenticio) articulo;
            int nuevosDias = leerEnteroNoNegativo(scanner, "Ingrese los nuevos días para vencimiento: ");
            alimenticio.setDiasParaVencimiento(nuevosDias);
        }

        System.out.println("Artículo modificado correctamente :)");
        System.out.println(articulo);
    }

    //Eliminar
    public static void eliminarArticulo(Scanner scanner, Repositorio<Articulo> articulos){
        System.out.println("\n=============== ELIMINAR ARTÍCULO ================");
        
        if(articulos.estaVacio()){
            System.out.println("No hay artículos cargados :(");
            return;
        }

        int codigo = leerEntero(scanner, "Ingrese el codigo del articulo a eliminar: ");
        
        Articulo articulo = articulos.buscarPorCodigo(codigo);
        if(articulo == null){
            System.out.println("Ese articulo no existe :(");
        }

         if(articulos.eliminar(articulo)){
             System.out.println("El articulo se ha eliminado correctamente! :D");
             System.out.println("\n===================================================");
          }else{
            System.out.println("Ocurrio un error, no se pudo eliminar el artículo! :(");
            System.out.println("\n===================================================");
          }
        
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

    //Metodo pedir categoria
    public static Categoria pedirCategoriaExistente(Scanner scanner,Repositorio<Categoria> categorias) {
        while (true) {
            int codigoCategoria = leerEntero(scanner, "Ingrese el código de la categoría: ");
            Categoria categoria = categorias.buscarPorCodigo(codigoCategoria);

            if (categoria != null) {
                return categoria;
            }

            System.out.println("La categoría no existe.");
        }
    }

    
}
