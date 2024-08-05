
package com.mycompany.uibscraper;

import java.io.Serializable;


public class Alojamiento implements Serializable{
    private String telefono;
    private String titulo;
    private String descripcion;
    private String dueno;
    private boolean contactado;
    private boolean nuevo;
    private String precio;
    private String direccion;
    private boolean eliminado;

    public Alojamiento(String telefono, String titulo, String descripcion, String dueno, boolean contactado, String precio, String direccion, boolean nuevo) {
        this.telefono = telefono;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.dueno = dueno;
        this.contactado = contactado;
        this.precio = precio;
        this.direccion = direccion;
        this.nuevo = nuevo;
        eliminado = false;
    }
    
    public String getTelefono(){
        return telefono;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDueno() {
        return dueno;
    }

    public boolean isContactado() {
        return contactado;
    }

    public boolean isNuevo() {
        return nuevo;
    }

    public String getPrecio() {
        return precio;
    }

    public String getDireccion() {
        return direccion;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
    
    public void setContactado(boolean contactado) {
        this.contactado = contactado;
    }
    
    public void setNuevo(boolean nuevo){
        this.nuevo = nuevo;
    }
    
    public String toString(){
        return "------------------------------------------\nTitulo:  "+titulo
                + "\nDescripcion: "+descripcion
                + "\nDueño: "+dueno
                + "\nTelefono: "+telefono
                + "\nPrecio: "+precio
                + "\nDireccion: "+direccion
                + "\n"+contactado+"\n";
    }

}
