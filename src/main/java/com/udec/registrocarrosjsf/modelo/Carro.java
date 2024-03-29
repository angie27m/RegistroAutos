/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.registrocarrosjsf.modelo;


/**
 * Esta clase contiene los atributos de los carros
 *
 * @author Cristian Perez, Angie Manrique
 */
public class Carro {
    /**
     * seleccionado pare eliminar
     */
    private boolean seleccion;
    /**
     * id del carro
     */
    private String id;
    /**
     * Variable que guarda el nombre del carro
     */
    private String nombre;
    /**
     * Variable que guarda la marca del carro
     */
    private String marca;
    /**
     * Variable que guarda el modelo del carro
     */
    private int modelo;

    /**
     * Método que obtiene el nombre del carro
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que le da valor al nombre del carro
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que obtiene la marca del carro
     *
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Método que le da valor a la marca del carro
     *
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Método que obtiene el modelo del carro
     *
     * @return
     */
    public int getModelo() {
        return modelo;
    }

    /**
     * Método que le da valor al modelo del carro
     *
     * @param modelo
     */
    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isSeleccion() {
        return seleccion;
    }

    public void setSeleccion(boolean seleccion) {
        this.seleccion = seleccion;
    }
    
         /**
          * 
          * @param id id del carro
          * @param nombre nombre del carro
          * @param marca marca del carro
          * @param modelo modelo del carro
          */  
    public Carro(String id, String nombre, String marca, int modelo) {
        this.id=id;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
    }
}
