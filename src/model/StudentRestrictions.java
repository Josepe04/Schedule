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
public class StudentRestrictions {
    private int huecos[][];
    public StudentRestrictions(){
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
}
