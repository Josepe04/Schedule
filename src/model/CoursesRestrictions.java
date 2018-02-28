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
public class CoursesRestrictions {
    
        //cuadricula
    private int[][] huecos;
    private int idCourse; // id del curso
    private int blocksWeek; //bloques por semana
    private String maxSections; //maximo numero de grupos
    private String minGapBlocks; // espacio minimo entre bloques
    private int minGapDays; //cada cuantos dias entre bloques
    private int rank; // prioridad
    private boolean GR; //
    private String excludeBlocks; // bloques que no se puede
    private int maxBlocksPerDay;
    private int sections;

    public void setSections(int sections) {
        this.sections = sections;
    }
    private ArrayList<Integer> trestricctions;

    public int getSections() {
        return sections;
    }
    
    public CoursesRestrictions(int idCourse) {
        this.idCourse = idCourse;
        huecos=new int[Algoritmo.TAMX][Algoritmo.TAMY];
        maxBlocksPerDay = 1;
        sections = 0;
    }

    public boolean addSection(){
        try{
            if(sections+1 < Integer.parseInt(maxSections))
                sections++;
            return true;
        }catch(Exception e){
            sections++;
            return true;
        }
    }
    
    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public int getBlocksWeek() {
        return blocksWeek;
    }

    public void setBlocksWeek(int blocksWeek) {
        this.blocksWeek = blocksWeek;
    }

    public String getMaxSections() {
        return maxSections;
    }

    public void setMaxSections(String maxSections) {
        this.maxSections = maxSections;
    }

    public String getMinGapBlocks() {
        return minGapBlocks;
    }

    public void setMinGapBlocks(String minGapBlocks) {
        this.minGapBlocks = minGapBlocks;
    }

    public int getMinGapDays() {
        return minGapDays;
    }

    public void setMinGapDays(int minGapDays) {
        this.minGapDays = minGapDays;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public boolean isGR() {
        return GR;
    }

    public void setGR(boolean GR) {
        this.GR = GR;
    }
    
    public int getMaxBlocksPerDay() {
        return maxBlocksPerDay;
    }

    public void setMaxBlocksPerDay(int maxBlocksPerDay) {
        this.maxBlocksPerDay = maxBlocksPerDay;
    }

    public String getExcludeBlocks() {
        return excludeBlocks;
    }

    public void setExcludeBlocks(String excludeBlocks) {
        this.excludeBlocks = excludeBlocks;
    }
    
        public ArrayList<Integer> getTrestricctions() {
        return trestricctions;
    }

    public void setTrestricctions(ArrayList<Integer> trestricctions) {
        this.trestricctions = trestricctions;
    }
    
    public int[][] getHuecos() {
        return huecos;
    }
    public ArrayList<Tupla> huecosLibres(){
        ArrayList<Tupla> ret = new ArrayList<>();
        for(int i = 0;i < Algoritmo.TAMX;i++)
            for(int j = 0;j<Algoritmo.TAMY;j++){
                if(huecos[i][j]==0)
                    ret.add(new Tupla<Integer,Integer>(i,j));
            }
        return ret;
    } 
    
    public ArrayList<ArrayList<Tupla>> opciones(){
        ArrayList<ArrayList<Tupla>> ret = new ArrayList<>();
        for(int j = 0;j<Algoritmo.TAMY;j++){
            boolean anadir=false;
            if(excludeBlocks!=null && excludeBlocks.contains(""+j)){
            }else{
                int k;
                int gd= this.minGapDays;
                gd++;
                for(int i = 0; i < Algoritmo.TAMX;i++){
                    ArrayList<Tupla> t = new ArrayList<>();
                    int sum=0;
                    k=this.blocksWeek;
                    while(k>0){
                        t.add(new Tupla((i+sum)%Algoritmo.TAMX,j));
                        sum+=gd;
                        k--;
                    }  
                    ret.add(t);
                }
                
            }
        }
        return ret;
    }
}
