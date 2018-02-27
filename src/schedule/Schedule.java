/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedule;

import model.Algoritmo;
import model.DBConnect;

/**
 *
 * @author Norhan
 */
public class Schedule {

    
    ////////////YEAR ID = 264
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBConnect db = new DBConnect();
        (new Algoritmo()).algo();
    }
    
}
