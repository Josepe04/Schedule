/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Norhan
 */
public class Algoritmo {
    public static int TAMX = 5;
    public static int TAMY = 6;
    private List<Object> tabla;
    public Algoritmo(){
        tabla = new ArrayList<>();
        tabla.add(new int[TAMX][TAMY]);
    }
    public boolean esSolucion(boolean[] asignados){
        for(int i = 0; i < asignados.length;i++){
            if(!asignados[i])
                return false;
        }
        return true;
    }
    
    public ArrayList<ArrayList<Tupla>> compatibles(ArrayList<ArrayList<Tupla>> l1, ArrayList<ArrayList<Tupla>> l2){
        ArrayList<ArrayList<Tupla>> lista = new ArrayList<>();
        for(ArrayList<Tupla> t:l1){
            for(ArrayList<Tupla> t2:l2)
                if(t.toString().equals(t2.toString()))
                    lista.add(t);
        }
        return lista;
    }
    
    public void algo(){
        Consultas cs = new Consultas();
        ArrayList<Restricciones> rst = cs.getRestricciones();
        for(Restricciones r : rst){
            ArrayList<ArrayList<Tupla>> w = r.opciones();
            System.out.println(w.toString());
        }
                
    }
}
