package com.techlab.articulo.menu;

import java.util.ArrayList;
import java.util.Scanner;
import com.techlab.articulo.utils.*;

public abstract class Menu {
    protected Scanner scanner;

    public Menu(Scanner scanner){
        this.scanner = scanner;
    }

    public abstract void mostrarMenu();

    public abstract void ejecutar();

    public static int leerEntero(Scanner scanner, String mensaje){
        while (true) {
            try {
                System.out.println(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero entero valido");
            }       
        } 
    };

    public static int leerEnteroNoNegativo(Scanner scanner, String mensaje){
        while(true){
            int valor = leerEntero(scanner, mensaje);

            if(Validaciones.validarNoNegativo(valor)){
                System.out.println("El valor no puede ser un valor negativo");
                continue;
            }
            return valor;
        }
    }

    public static double leerDoubleNoNegativo(Scanner scanner, String mensaje){
       while (true) {
                try{
                    System.out.print(mensaje);
                    double valor = Double.parseDouble(scanner.nextLine());

                    if(Validaciones.validarNoNegativo(valor)){
                        System.out.println("El precio no puede ser negativo.");
                        continue;
                    }
                    return valor;
                } catch (NumberFormatException e){
                    System.out.println("Ingrese un valor decimal valido!");
                }
            }
       }
    

    public static String leerTextoNoVacio(Scanner scanner, String mensaje){
        while(true){
            System.out.println(mensaje);
            String texto = scanner.nextLine();

            if(Validaciones.validarTextoNoVacio(texto)){               
                return texto.trim();                
            }
            
            System.out.println("El texto no puede estar vacío :(");         
        }

    }


}