package com.techlab.articulo.utils;

import java.util.ArrayList;

public final class Validaciones {
    
    public static boolean validarNoNegativo(int valor){
        return valor < 0 ? true : false;
    }

    public static boolean validarNoNegativo(double valor){
        return valor < 0 ? true: false;
    }

    public static boolean validarTextoNoVacio(String texto){
        return texto != null && !texto.trim().isEmpty();
    }

  

    

}
