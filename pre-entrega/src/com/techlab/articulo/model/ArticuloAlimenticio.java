package com.techlab.articulo.model;

public class ArticuloAlimenticio extends Articulo {
    private int diasParaVencimiento;
    
    public ArticuloAlimenticio(int codigo, String nombre, double precio, Categoria categoria, int diasParaVencimiento){
        super(codigo, nombre, precio, categoria);
        this.diasParaVencimiento = diasParaVencimiento;
    }
    
     @Override
    public int getCodigo(){
        return codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public double getPrecio(){
        return precio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public Categoria getCategoria(){
        return categoria;
    }

    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
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
