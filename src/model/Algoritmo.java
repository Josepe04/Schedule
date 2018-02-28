/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xml.XMLWriterDOM;

/**
 *
 * @author Norhan
 */
public class Algoritmo {
    public final static int TAMX = 6;
    public final static int TAMY = 5;
    public final static int CHILDSPERSECTION = 20;
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
        int[] idsprueba = {739,688,796,733,676,837,718,702,717,846,690,
                            721,735,722,680,706,755,746,872,873,935,650};
        ArrayList<CoursesRestrictions> rst = cs.getRestricciones(idsprueba);
        ArrayList<Teacher> trst = cs.teachersList();
        HashMap<String,ArrayList<Tupla>> seccionesExistentes = new HashMap<>();
        HashMap<Integer,ArrayList<Student>> studentsCourse = new HashMap<>();
        HashMap<Integer,Student> students = new HashMap<>();
        
        int [] numst = new int[2];
        for(CoursesRestrictions c : rst){
            ArrayList<Student> st = cs.restriccionesStudent(c.getIdCourse(), numst);
            studentsCourse.put(c.getIdCourse(), st);
            for(Student s:st)
                students.put(s.getId(), s);
        }
        boolean[] asignados = new boolean[idsprueba.length];
        int i = 0;
        Student st = new Student(2);
        for(CoursesRestrictions course: rst){
            int minsections = 1 + studentsCourse.get(course.getIdCourse()).size()/CHILDSPERSECTION;
            course.setSections(minsections);
            for(int j = 0;j<minsections;j++){
                for(Teacher teacher:trst){
                    int id = course.getIdCourse();
                    if(teacher.asignaturaCursable(id)){
                        for(ArrayList<Tupla> ar: course.opciones()){
                            int numberStudents = 0;
                            ArrayList<Integer> stAux = new ArrayList<>(); 
                            for(Student st2 :studentsCourse.get(course.getIdCourse()))
                                if(course.getTrestricctions().contains(teacher.idTeacher) 
                                        && teacher.patronCompatible(ar) && st2.patronCompatible(ar)){
                                        stAux.add(st2.getId());
                                        numberStudents++;
                                }
                            int size = studentsCourse.get(course.getIdCourse()).size();
                            if(numberStudents > size/minsections -1){
                                teacher.ocuparHueco(ar, id*100+j);1
                                for(Integer k:stAux)
                                    students.get(k).ocuparHueco(ar, id*100+j);
                                seccionesExistentes.put(""+course.getIdCourse()+course.getSections(),ar);
                                asignados[i] = true;
                                break;
                            }
                        }
                    }
                    if(asignados[i])
                        break;
                }
                asignados[i] = false;
            }
            i++;
        }
        
        XMLWriterDOM.xmlCreate(trst, null);
        
        for(Teacher teacher:trst){
            teacher.mostrarHuecos();
            System.out.println("");
        }
        for(Map.Entry<Integer, Student> entry : students.entrySet()) {
            entry.getValue().mostrarHuecos();
            System.out.println("");
        }
        System.out.println("estudiante: ");
        st.mostrarHuecos();
                
    }
}
