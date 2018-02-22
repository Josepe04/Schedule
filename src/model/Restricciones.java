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
public class Restricciones {


    public Restricciones(int idCourse,int tamx,int tamy) {
        this.idCourse = idCourse;
        this.tamx=tamx;
        this.tamy=tamy;
        huecos=new int[tamx][tamy];
        maxBlocksPerDay = 1;
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
    
        public ArrayList<String> getTrestricctions() {
        return trestricctions;
    }

    public void setTrestricctions(ArrayList<String> trestricctions) {
        this.trestricctions = trestricctions;
    }
    
    public int[][] getHuecos() {
        return huecos;
    }
    public ArrayList<Tupla> huecosLibres(){
        ArrayList<Tupla> ret = new ArrayList<>();
        for(int i = 0;i < tamx;i++)
            for(int j = 0;j<tamy;j++){
                if(huecos[i][j]==0)
                    ret.add(new Tupla<Integer,Integer>(i,j));
            }
        return ret;
    } 
    
    public ArrayList<ArrayList<Tupla>> opciones(){
        ArrayList<ArrayList<Tupla>> ret = new ArrayList<>();
        for(int j = 0;j<tamy;j++){
            boolean anadir=false;
            if(excludeBlocks!=null && excludeBlocks.contains(""+j)){
            }else{
                int k;
                int gd= this.minGapDays;
                if(gd==0 && maxBlocksPerDay>0)
                    gd=1;
                for(int i = 0; i < tamx;i++){
                    ArrayList<Tupla> t = new ArrayList<>();
                    int sum=0;
                    k=this.blocksWeek;
                    while(k>0){
                        t.add(new Tupla((i+sum)%tamx,j));
                        sum+=gd;
                        k--;
                    }  
                    ret.add(t);
                }
                
            }
        }
        return ret;
    }
    
    //dimensiones cuadricula
    private int tamx; 
    private int tamy;
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
    private ArrayList<String> trestricctions;

}