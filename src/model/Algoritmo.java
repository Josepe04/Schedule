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
    public final static int TAMX = 5;
    public final static int TAMY = 6;
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
    
    
    /**
     * Dada una lista de patrones en los que se puede impartir la clase y 
     * una cuadricula con el horario del profesor o del estudiante
     * @param l1
     * @param huecos
     * @return 
     */
    public ArrayList<ArrayList<Tupla>> opcionesCompatibles(ArrayList<ArrayList<Tupla>> l1, int huecos[][]){
        ArrayList<ArrayList<Tupla>> ret = new ArrayList<>();
        for(ArrayList<Tupla> lista:l1){
                boolean tvalida = true;
                for(Tupla t:lista){
                    if(huecos[(Integer)t.x][(Integer)t.y] != 0)
                        tvalida = false;
                }
                if(tvalida)
                    ret.add(lista);
        }
        return ret;
    }
    
    public void algo(){
        Consultas cs = new Consultas();
        int[] idsprueba = {739,688,796,733,676,837,718,702,717};
        ArrayList<Restricciones> rst = cs.getRestricciones(idsprueba);
        ArrayList<TeacherRestrictions> trst = cs.teachersList();
        System.out.println(trst.toString());
        ArrayList<ArrayList<Tupla>> x = rst.get(0).opciones();
        System.out.println(opcionesCompatibles(x,rst.get(1).getHuecos()));
        //System.out.println(compatibles(x,x2).toString());
//        for(Restricciones r : rst){
//            ArrayList<ArrayList<Tupla>> w = r.opciones();
//            System.out.println(w.toString());
//        }
                
    }
}
