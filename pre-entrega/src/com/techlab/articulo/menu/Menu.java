package com.techlab.articulo.menu;

public abstract class Menu {
    protected Scanner scn;

    public Menu(Scanner scanner){
        this.scn = scanner;
    }

    public abstract void mostrarMenu();

    public abstract void ejecutar();
}
