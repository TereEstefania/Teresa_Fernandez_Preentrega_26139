package com.techlab.articulo.menu;

public class MenuArticulos extends Menu {
    
    public MenuArticulos(java.util.Scanner scanner){
        super(scanner);
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
