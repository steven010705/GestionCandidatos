/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.model;

/**
 *
 * @author sedel
 */
public class Candidato {
    
    private int id;
    private Caracteristica caracteristicas;
    
    public Candidato(int id){
        this.id = id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
}
