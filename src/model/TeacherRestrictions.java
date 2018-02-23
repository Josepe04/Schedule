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
class TeacherRestrictions{
    private int[][] huecos;
    protected int idTeacher;
    protected int MaxSections; // maxima secciones
    private int secsComplete;
    protected int Preps;//maximo asignaturas
    private ArrayList<Integer> prepsComplete;
    protected int MaxBxD;//max blocksperday
    protected String ExcludeBlocks;
    public TeacherRestrictions(){
        huecos = new int[Algoritmo.TAMX][Algoritmo.TAMY];
        secsComplete = 0;
        prepsComplete = new ArrayList<>();
    }
    public String toString(){
        return idTeacher +" sections: "+ MaxSections+" preps: "+ Preps+" maxbxd: "+ MaxBxD +" exclude: "+ExcludeBlocks;
    }
    public int[][] getHuecos(){
        return huecos;
    }
    public boolean ocuparHueco(ArrayList<Tupla> ar,int id){
        if(secsComplete >= MaxSections)
            return false;
        else if(!prepsComplete.contains(id) && prepsComplete.size()>=Preps)
            return false;
        int[] aux = new int[Algoritmo.TAMX];
        for(Tupla t:ar){
            if(huecos[(Integer)t.x][(Integer)t.y]!=0){
                return false;
            }
            aux[(Integer)t.x]++;
            
        }
        if(!prepsComplete.contains(id))
            prepsComplete.add(id);
        secsComplete++;
        return true;
    }
}
