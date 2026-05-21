package com.techlab.articulo.model;

public class ArticuloAlimenticio extends Articulo {
    private int diasParaVencimiento;
    
    public ArticuloAlimenticio(int codigo, String nombre, double precio, Categoria categoria, int diasParaVencimiento){
        super(codigo, nombre, precio, categoria);
        this.diasParaVencimiento = diasParaVencimiento;
    }
     
    public int getDiasParaVencimiento(){
        return diasParaVencimiento;
    }

    public void setDiasParaVencimiento(int diasParaVencimiento){
        this.diasParaVencimiento = diasParaVencimiento;
    }

        @Override
    public String getTipoArticulo() {
        // TODO:
        return "Alimenticio";
    }

    @Override
    public double calcularPrecioFinal() {
        // TODO:
        // Implementar lógica propia del artículo electrónico.
        return 0;
    }
}
