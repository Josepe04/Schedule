/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Norhan
 */
public class Student {
    private int huecos[][];
    private int id;
    private String genero;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getId() {
        return id;
    }
    
    public Student(int id){
        huecos = new int[Algoritmo.TAMX][Algoritmo.TAMY];
    }
    
    public void ocuparHueco(ArrayList<Tupla> ar , int id){
        for(Tupla t:ar)
            huecos[(Integer)t.x][(Integer)t.y] = id;
    }
    
    public boolean patronCompatible(ArrayList<Tupla> ar){
        for(Tupla t:ar)
            if(huecos[(Integer)t.x][(Integer)t.y]!=0)
                return false;
        return true;
    }
    
    public void mostrarHuecos(){
        for(int i = 0; i < Algoritmo.TAMY;i++){
            for(int j = 0; j < Algoritmo.TAMX;j++){
                System.out.print(" "+huecos[j][i]+" ");
            }
            System.out.println("");
        }
    }
}
