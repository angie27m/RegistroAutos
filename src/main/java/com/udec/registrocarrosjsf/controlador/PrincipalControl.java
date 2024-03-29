/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.registrocarrosjsf.controlador;

import com.udec.registrocarrosjsf.modelo.Carro;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.primefaces.event.RowEditEvent;

/**
 * Esta clase contiene los datos que van a ser guardados de los vehiculos
 *
 * @author Cristian Perez, Angie Manrique
 */
@Named(value = "principalControl")
@SessionScoped
public class PrincipalControl implements Serializable {
    /**
     * Listado de carros eliminados
     */
    private ArrayList<Carro> carrosEliminados;
    /**
     * Seleccion de los carros a eliminar
     */
    private boolean seleccion;
    /**
     * variable que guarda el nombre del carro
     */
    private String nombre;
    /**
     * variable que guarda la marca del carro
     */
    private String marca;
    /**
     * variable que guarda el modelo del carro
     */
    @Min(value = 1960, message = "Modelo*: El año debe ser mayor a 1960")
    @Max(value = 2019, message = "Modelo*: El año debe ser menor a 2019")
    private int modelo;
    /**
     * lista de marcas de carros
     */
    private List<String> marcas;
    /**
     * lista de los carros que se registran en el programa
     */
    private List<Carro> listaCarros;
    /**
     * lista que guarda los registros de carros segun el filtro de busqueda
     */
    private List<Carro> carrosfiltrados;
    /*
     Método que llama al método encargado del listado de marcas
     */
    @PostConstruct
    public void init() {
        llenarListaMarcas();
    }

    /**
     * Constructor de la clase, aquí se crea una lista de carros
     */
    public PrincipalControl() {
        listaCarros = new ArrayList();
        carrosEliminados = new ArrayList();            
    }

    /**
     * Método que obtiene la lista de marcas de carros
     *
     * @return
     */
    public List<String> getMarcas() {
        return marcas;
    }

    public ArrayList<Carro> getCarrosEliminados() {
        return carrosEliminados;
    }

    public void setCarrosEliminados(ArrayList<Carro> carrosEliminados) {
        this.carrosEliminados = carrosEliminados;
    }

    public boolean isSeleccion() {
        return seleccion;
    }

    public void setSeleccion(boolean seleccion) {
        this.seleccion = seleccion;
    }

    /**
     * Método que le da valor a la lista de marcas
     *
     * @param marcas
     */
    public void setMarcas(List<String> marcas) {
        this.marcas = marcas;
    }

    /**
     * obtiene el nombre del carro
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * le da valor al nombre del carro
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

    /**
     * Método que obtiene la lista de carros registrados
     *
     * @return
     */
    public List<Carro> getListaCarros() {
        return listaCarros;
    }

    /**
     * Método que le da valor a los parametros de los carros registrados
     *
     * @param listaCarros
     */
    public void setListaCarros(List<Carro> listaCarros) {
        this.listaCarros = listaCarros;
    }

    /**
     * Retorna los carros segun el criterio de buscada usado
     *
     * @return
     */
    public List<Carro> getCarrosfiltrados() {
        return carrosfiltrados;
    }

    /**
     * Le da valor a la lista de carros segun la busqueda
     *
     * @param carrosfiltrados
     */
    public void setCarrosfiltrados(List<Carro> carrosfiltrados) {
        this.carrosfiltrados = carrosfiltrados;
    }

    /**
     * Método que se encarga de agregar las marcas de carros a una lista
     */
    public void llenarListaMarcas() {
        marcas = new ArrayList();
        marcas.add("Renault");
        marcas.add("Chevrolet");
        marcas.add("Mercedes");
        marcas.add("Audi");
        marcas.add("Toyota");
        marcas.add("Renault");
        marcas.add("Ferrari");
        marcas.add("Dodge");
    }
    /**
     * Método que genera de forma randomica el id de los vehiculos
     * @return 
     */
    private String getRandomId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    /**
     * Método que crea los carros y los guarda en una lista
     */
    public void llenarListaCarros() {
        try {
        Carro carro = new Carro(getRandomId(), nombre, marca, modelo);
        listaCarros.add(carro);
        Logger.getLogger(PrincipalControl.class.getName()).log(Level.INFO, 
                "Se ha agregado un carro a la lista: "+getNombre()+" "+getMarca()+" "+getModelo()+" ",carro);
        } catch (Exception e) {
              Logger.getLogger(PrincipalControl.class.getName()).log(Level.SEVERE, 
                "error metodo llenarListaCarros() :"+PrincipalControl.class.getName()+" "+e,e);
        }
      
        
    }

    /**
     * Método que se encarga de la edición de la fila seleccionada
     *
     * @param event
     */
    public void onRowEdit(RowEditEvent event) {
        try{
        FacesMessage msg = new FacesMessage("Vehículo editado con exito",((Carro) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
         Logger.getLogger(PrincipalControl.class.getName()).log(Level.INFO, 
                "Se edito un vehiculo:  "+((Carro) event.getObject()).getId()+
                        " "+getNombre()+" "+getMarca()+" "+getModelo(),msg);
        }catch (Exception e) {
            Logger.getLogger(PrincipalControl.class.getName()).log(Level.SEVERE, 
                "error onRowEdit:"+PrincipalControl.class.getName()+" "+e,e);
        }
    }

    /**
     * Método que cancela la edición de la fila seleccionada
     *
     * @param event
     */
    public void onRowCancel(RowEditEvent event) {
        try {
             FacesMessage msg = new FacesMessage("Edición Cancelada: ", ((Carro) event.getObject()).getId());
             FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            Logger.getLogger(PrincipalControl.class.getName()).log(Level.SEVERE, 
                "error onRowCancel:"+PrincipalControl.class.getName()+" "+e,e);
        }
       
    }
    /**
     * Metodo para eliminar carros de la lista
     */
    public void eliminar(){
        try {
            for(Carro c: listaCarros){
            if(c.isSeleccion()){
                carrosEliminados.add(c);
            }
        }
        if(!carrosEliminados.isEmpty()){
            listaCarros.removeAll(carrosEliminados);
             Logger.getLogger(PrincipalControl.class.getName()).log(Level.INFO, 
                "Se elimino un vehiculo:  "+" "+getNombre()+" "+getMarca()+" "+getModelo(),this);
        }
         FacesMessage msg = new FacesMessage("Vehículos eliminados con exito");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            Logger.getLogger(PrincipalControl.class.getName()).log(Level.SEVERE, 
                "error eliminar():"+PrincipalControl.class.getName()+" "+e,e);
        }
        
    }
    
    
}
