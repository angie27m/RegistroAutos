/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.registrocarrosjsf.controlador;

import com.udec.registrocarrosjsf.modelo.Carro;
import java.awt.Desktop;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;


/**
 *
 * @author ASUS
 */
@Named(value = "principalControl")
@SessionScoped
public class PrincipalControl implements Serializable{
    private String nombre;
    private String marca;
    private int modelo;
    private List<String> marcas;
    private List<Carro> listaCarros;
    
    @PostConstruct
    public void init() {
        llenarListaMarcas();
    }
    public PrincipalControl() {
        listaCarros=new ArrayList();
    }

    public List<String> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<String> marcas) {
        this.marcas = marcas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public List<Carro> getListaCarros() {
        return listaCarros;
    }

    public void setListaCarros(List<Carro> listaCarros) {
        this.listaCarros = listaCarros;
    }
    
    public void llenarListaMarcas(){
        marcas= new ArrayList();
            marcas.add("Renault");
            marcas.add("Chevrolet");
            marcas.add("Mercedes");
            marcas.add("Audi");
            marcas.add("Toyota");
            marcas.add("Renault");
            marcas.add("Ferrari"); 
            marcas.add("Dodge"); 
    }
    public void llenarListaCarros(){
      Carro carro=new Carro(nombre, marca, modelo);
      listaCarros.add(carro);
        System.out.println(""+carro.getMarca());
    }
    
}
