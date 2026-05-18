package com.techlab.articulo.menu;

public class MenuArticulos extends Menu {
    
    public MenuArticulos(java.util.Scanner scanner){
        super(scanner);
    }

    @Override
    public void mostrarMenu(){
        System.out.println("\n*** MENÚ ARTÍCULOS ***");
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
            
        }while(opcion != 0);
    }
}
