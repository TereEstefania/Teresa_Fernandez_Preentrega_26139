package com.techlab.articulo.repository;

import java.util.ArrayList;
import java.util.List;

import com.techlab.articulo.interfaces.Identificable;

public class Repositorio<T extends Identificable> {

    private  ArrayList<T> lista = new ArrayList<>();

    //Agregar
    public boolean agregar(T obj){
        if(obj == null){
            return false;
        }

        if(buscarPorCodigo(obj.getCodigo()) != null){
            return false;
        }

        return lista.add(obj);
    }

    //listar => retorna una copia de la lista, para resguardar la interna
    public List<T> listar(){
        return new ArrayList<>(lista);
    }

    //Buscar en la lista por codigo
    public T buscarPorCodigo(int codigo){
        for (T obj : lista) {
            if(obj.getCodigo() == codigo){
                return obj;
            }       
        }
        return null;
    }

    //elimina un objeto y retorna true si es que se elimino
    public boolean eliminar(T obj){
        if(obj == null){
            return false;
        }
        return lista.remove(obj);
    }

    //Verifica que la lista este vaci
    public boolean estaVacio(){
        if(lista.isEmpty()){
            return true;
        }
        return false;
    }
}
