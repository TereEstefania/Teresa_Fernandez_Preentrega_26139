package com.techlab.articulo.menu;

import java.util.Scanner;

public abstract class Menu {
    protected Scanner scanner;

    public Menu(Scanner scanner){
        this.scanner = scanner;
    }

    public abstract void mostrarMenu();

    public abstract void ejecutar();

    public int leerEntero(Scanner scanner, String mensaje){
        return 0;
    };

    public int leerEnteroNoNegativo(){
        return 0;
    }

    public double leerDoubleNoNegativo(){
        return 0;
    }
}
