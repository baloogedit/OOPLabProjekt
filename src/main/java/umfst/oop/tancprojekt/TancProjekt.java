/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package umfst.oop.tancprojekt;

import java.util.ArrayList;


/**
 *
 * @author edite
 */
public class TancProjekt {
    
     private static ArrayList <Dancer> dancers=new ArrayList<>();
     private static ArrayList <Dance> dances=new ArrayList<>();
        

    public static void main(String[] args) 
    {
        
        dancers.add(new Dancer("Edit", 19, "female"));
        dancers.add(new Dancer("David", 20, "male"));
        
        dances.add(new Dance("verbunk", "Mezoseg", 3));
        dances.add(new Dance("csardas", "Nyaradmente", 5));
        
        
        for (Dancer d: dancers)
        {
            d.introduction();
        }
        
        for(Dance d: dances)
        {
            d.print();
        }
        
        
    }
    
}
