package com.techlab.articulo.model;

public class ArticuloElectronico extends Articulo {
   private int garantiaMeses;

    public ArticuloElectronico(int codigo, String nombre, double precio, Categoria categoria, int garantiaMeses){
        super(codigo, nombre, precio, categoria);
        this.garantiaMeses = garantiaMeses;
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

    public int getGarantiaMeses(){
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses){
        this.garantiaMeses = garantiaMeses;
    }   

    @Override
    public String getTipoArticulo() {
        // TODO:
        return "Electrónico";
    }

    @Override
    public double calcularPrecioFinal() {
        // precio bruto mas IVA, mas impuesto por Importacion
        return (precio * 1.21) + (precio * 1.15);
    }
}
