package com.techlab.articulo.menu;

import java.util.Scanner;

public abstract class Menu {
    protected Scanner scn;

    public Menu(Scanner scanner){
        this.scn = scanner;
    }

    public abstract void mostrarMenu();

    public abstract void ejecutar();

    public int leerEntero(Scanner scanner, String mensaje){
        return 0;
    };

}
