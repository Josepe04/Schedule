/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Norhan
 */
public class Consultas {
    protected ArrayList<Restricciones> getRestricciones(){
        ArrayList<Restricciones> ret = new ArrayList<>();
        String consulta = "";
        try {
            consulta="select top 10 udd.id\n" +
                    "        from uddata udd\n" +
                    "        inner join udfield udf\n" +
                    "            on udd.fieldid = udf.fieldid\n" +
                    "        inner join udgroup udg\n" +
                    "            on udg.groupid = udf.groupid\n" +
                    "            and udg.grouptype = 'course'\n" +
                    "            and udg.groupname = 'Schedule'\n" +
                    "            and udf.fieldName = 'Schedule'\n" +
                    "            and udd.data = '1'";
            ResultSet rs=DBConnect.st.executeQuery(consulta);
            while(rs.next()){
                Restricciones r=new Restricciones(rs.getInt(1),5,6);
                ret.add(r);
            }
            for(int i = 0; i < ret.size();i++){
                consulta = "select udd.data\n" +
                "                from uddata udd\n" +
                "                inner join udfield udf\n" +
                "                    on udd.fieldid = udf.fieldid\n" +
                "                inner join udgroup udg\n" +
                "                    on udg.groupid = udf.groupid\n" +
                "                    and udg.grouptype = 'course'\n" +
                "                    and udg.groupname = 'Schedule'\n" +
                "                    and udf.fieldName = 'BlocksPerWeek'\n" +
                "                where udd.id ="+ret.get(i).getIdCourse();

                rs=DBConnect.st.executeQuery(consulta);
                while(rs.next()){
                    ret.get(i).setBlocksWeek(rs.getInt(1));
                }

                consulta="select udd.data\n" +
                "                from uddata udd\n" +
                "                inner join udfield udf\n" +
                "                    on udd.fieldid = udf.fieldid\n" +
                "                inner join udgroup udg\n" +
                "                    on udg.groupid = udf.groupid\n" +
                "                    and udg.grouptype = 'course'\n" +
                "                    and udg.groupname = 'Schedule'\n" +
                "                    and udf.fieldName = 'GR'\n" +
                "                where udd.id="+ret.get(i).getIdCourse();

                rs=DBConnect.st.executeQuery(consulta);
                while(rs.next()){
                    ret.get(i).setGR(rs.getBoolean(1));
                }

                consulta = "select udd.data\n" +
                "                from uddata udd\n" +
                "                inner join udfield udf\n" +
                "                    on udd.fieldid = udf.fieldid\n" +
                "                inner join udgroup udg\n" +
                "                    on udg.groupid = udf.groupid\n" +
                "                    and udg.grouptype = 'course'\n" +
                "                    and udg.groupname = 'Schedule'\n" +
                "                    and udf.fieldName = 'MaxSections'\n" +
                "                where udd.id ="+ret.get(i).getIdCourse();

                rs=DBConnect.st.executeQuery(consulta);
                while(rs.next()){
                    ret.get(i).setMaxSections(rs.getString(1));

                }

                consulta="select udd.data\n" +
                "                from uddata udd\n" +
                "                inner join udfield udf\n" +
                "                    on udd.fieldid = udf.fieldid\n" +
                "                inner join udgroup udg\n" +
                "                    on udg.groupid = udf.groupid\n" +
                "                    and udg.grouptype = 'course'\n" +
                "                    and udg.groupname = 'Schedule'\n" +
                "                    and udf.fieldName = 'MinGapBlocks'\n" +
                "                where udd.id ="+ret.get(i).getIdCourse();

                rs=DBConnect.st.executeQuery(consulta);
                while(rs.next()){
                    ret.get(i).setMinGapBlocks(rs.getString(1));
                }

                consulta="select udd.data\n" +
                "                from uddata udd\n" +
                "                inner join udfield udf\n" +
                "                    on udd.fieldid = udf.fieldid\n" +
                "                inner join udgroup udg\n" +
                "                    on udg.groupid = udf.groupid\n" +
                "                    and udg.grouptype = 'course'\n" +
                "                    and udg.groupname = 'Schedule'\n" +
                "                    and udf.fieldName = 'MinGapDays'\n" +
                "                where udd.id ="+ret.get(i).getIdCourse();

                rs=DBConnect.st.executeQuery(consulta);
                while(rs.next()){
                    ret.get(i).setMinGapDays(rs.getInt(1));
                }

                consulta="select udd.data\n" +
                "                from uddata udd\n" +
                "                inner join udfield udf\n" +
                "                    on udd.fieldid = udf.fieldid\n" +
                "                inner join udgroup udg\n" +
                "                    on udg.groupid = udf.groupid\n" +
                "                    and udg.grouptype = 'course'\n" +
                "                    and udg.groupname = 'Schedule'\n" +
                "                    and udf.fieldName = 'Rank'\n" +
                "                where udd.id ="+ret.get(i).getIdCourse();

                rs=DBConnect.st.executeQuery(consulta);
                while(rs.next()){
                    try{
                    ret.get(i).setRank(rs.getInt(1));
                    }catch(Exception e){
                    }
                }
                consulta="select udd.data\n" +
                "                from uddata udd\n" +
                "                inner join udfield udf\n" +
                "                    on udd.fieldid = udf.fieldid\n" +
                "                inner join udgroup udg\n" +
                "                    on udg.groupid = udf.groupid\n" +
                "                    and udg.grouptype = 'course'\n" +
                "                    and udg.groupname = 'Schedule'\n" +
                "                    and udf.fieldName = 'Teachers'\n" +
                "                where udd.id ="+ret.get(i).getIdCourse();

                rs=DBConnect.st.executeQuery(consulta);
                String[] s=new String[2];
                while(rs.next()){
                    s=rs.getString(1).split(",");
                }
                ArrayList<String> ar = new ArrayList<>();
                for(String s2:s){
                    ar.add(s2);
                }
                ret.get(i).setTrestricctions(ar);
                
                consulta="select udd.data\n" +
                "                from uddata udd\n" +
                "                inner join udfield udf\n" +
                "                    on udd.fieldid = udf.fieldid\n" +
                "                inner join udgroup udg\n" +
                "                    on udg.groupid = udf.groupid\n" +
                "                    and udg.grouptype = 'course'\n" +
                "                    and udg.groupname = 'Schedule'\n" +
                "                    and udf.fieldName = 'ExcludeBlocks'\n" +
                "                where udd.id ="+ret.get(i).getIdCourse();

                rs=DBConnect.st.executeQuery(consulta);
                while(rs.next()){
                    ret.get(i).setExcludeBlocks(rs.getString(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Restricciones> borrar = new ArrayList<>();
        for(int i=0;i<ret.size();i++){
            if(i>=ret.size())
                return ret;
            else{
                if(ret.get(i).getTrestricctions().get(0).equals("")){
                    borrar.add(ret.get(i));
                }
            }
        }
        for(Restricciones r:borrar)
            ret.remove(r);
        return ret;
    } 
    
    public TeacherRestrictions restriccionesTeacher(String id){
        TeacherRestrictions ret = new TeacherRestrictions();
        String consulta = "";

        ResultSet rs;
        if(id!=null && id.length()>1)
        try {
            consulta="select udd.data\n" +
"                from uddata udd\n" +
"                inner join udfield udf\n" +
"                    on udd.fieldid = udf.fieldid\n" +
"                inner join udgroup udg\n" +
"                    on udg.groupid = udf.groupid\n" +
"                    and udg.grouptype = 'Staff'\n" +
"                    and udg.groupname = 'Schedule'\n" +
"                    and udf.fieldName = 'MaxSections'\n" +
"                where udd.id ="+id;
            rs = DBConnect.st.executeQuery(consulta);
            while(rs.next()){
                ret.MaxSections=rs.getInt(1);
            }
            
            consulta="select udd.data\n" +
"                from uddata udd\n" +
"                inner join udfield udf\n" +
"                    on udd.fieldid = udf.fieldid\n" +
"                inner join udgroup udg\n" +
"                    on udg.groupid = udf.groupid\n" +
"                    and udg.grouptype = 'Staff'\n" +
"                    and udg.groupname = 'Schedule'\n" +
"                    and udf.fieldName = 'Preps'\n" +
"                where udd.id ="+id;
            rs = DBConnect.st.executeQuery(consulta);
            while(rs.next()){
                ret.Preps=rs.getInt(1);
            }
            
            consulta="select udd.data\n" +
"                from uddata udd\n" +
"                inner join udfield udf\n" +
"                    on udd.fieldid = udf.fieldid\n" +
"                inner join udgroup udg\n" +
"                    on udg.groupid = udf.groupid\n" +
"                    and udg.grouptype = 'Staff'\n" +
"                    and udg.groupname = 'Schedule'\n" +
"                    and udf.fieldName = 'MaxBxD'\n" +
"                where udd.id ="+id;
            rs = DBConnect.st.executeQuery(consulta);
            while(rs.next()){
                ret.MaxBxD=rs.getInt(1);
            }
            
            consulta="select udd.data\n" +
"                from uddata udd\n" +
"                inner join udfield udf\n" +
"                    on udd.fieldid = udf.fieldid\n" +
"                inner join udgroup udg\n" +
"                    on udg.groupid = udf.groupid\n" +
"                    and udg.grouptype = 'Staff'\n" +
"                    and udg.groupname = 'Schedule'\n" +
"                    and udf.fieldName = 'ExcludedBlocks'\n" +
"                where udd.id="+id;
            rs = DBConnect.st.executeQuery(consulta);
            while(rs.next()){
                ret.ExcludeBlocks=rs.getString(1);
            }
            
        } catch (Exception ex ) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
}
