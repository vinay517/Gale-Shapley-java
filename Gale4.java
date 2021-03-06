/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gale4;
import java.util.*;
import java.util.Random;
/**
 *
 * @author VINAY MOHAN
 */
public class Gale4 extends Gale5{

    public Gale4(String[] m, String[] w, String[][] mp, String[][] wp) {
        super(m, w, mp, wp);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Gale Shapley Marriage Algorithm\n");
        /* men list */
        String[] ml = {"M1", "M2", "M3", "M4", "M5","M6","M7","M8","M9","M10"};
        /* women list */
        String[] wl = {"W1", "W2", "W3", "W4", "W5","W6","W7","W8","W9","W10"};
        /* men preference value*/
        String[][] mpv = {{"W5", "W2", "W3", "W4", "W1","W6","W8","W7","W10","W9"}, 
                         {"W2", "W5", "W1", "W3", "W4","W10","W6","W7","W8","W9"}, 
                         {"W4", "W3", "W2", "W1", "W5","W10","W7","W6","W8","W9"}, 
                         {"W1", "W2", "W3", "W4", "W5","W10","W8","W7","W6","W9"},
                         {"W5", "W2", "W3", "W4", "W1","W10","W9","W7","W8","W6"},
                         {"W2", "W5", "W1", "W3", "W4","W10","W6","W7","W8","W9"},
                         {"W1", "W2", "W3", "W4", "W5","W10","W8","W7","W6","W9"},
                         {"W1", "W2", "W3", "W4", "W5","W6","W7","W8","W9","W10"},
                         {"W4", "W3", "W2", "W1", "W5","W10","W7","W6","W8","W9"},
                         {"W5", "W2", "W3", "W4", "W1","W10","W9","W7","W8","W6"}};     
        /** women preference value **/                      
        String[][] wpv = {{"M5", "M3", "M4", "M1", "M2","M6","M7","M8","M9","M10"}, 
                         {"M1", "M2", "M3", "M5", "M4","M7","M6","M8","M9","M10"}, 
                         {"M4", "M5", "M3", "M2", "M1","M8","M7","M6","M9","M10"},
                         {"M5", "M2", "M1", "M4", "M3","M9","M7","M8","M6","M10"}, 
                         {"M2", "M1", "M4", "M3", "M5","M10","M7","M8","M9","M6"},
                         {"M5", "M3", "M4", "M1", "M2","M6","M7","M8","M9","M10"}, 
                         {"M1", "M2", "M3", "M5", "M4","M7","M6","M8","M9","M10"}, 
                         {"M4", "M5", "M3", "M2", "M1","M8","M7","M6","M9","M10"},
                         {"M5", "M2", "M1", "M4", "M3","M9","M7","M8","M6","M10"}, 
                         {"M2", "M1", "M4", "M3", "M5","M10","M7","M8","M9","M6"}};
        Gale4 gs = new Gale4(ml, wl, mpv, wpv);           
        gs.randomGeneration(mpv,wpv);   
    }    
}
