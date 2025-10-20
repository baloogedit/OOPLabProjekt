/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package umfst.oop.tancprojekt;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author edite
 */
public class TancProjekt {
    
     private static ArrayList <Dancer> dancers=new ArrayList<>();
     private static ArrayList <Dance> dances=new ArrayList<>();
     private static Scanner sc = new Scanner(System.in);
        

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
        
        
        int choice = 0;
        
        do
        {
            System.out.println("--MENU--");
            System.out.println("1. Add dancer");
            System.out.println("2. Add dance");
            System.out.println("3. Add clothes");
            System.out.println("4. Add event");
            System.out.println("5. List dancers");
            System.out.println("6. List dances");
            System.out.println("7. List costumes with assigned dancer");
            System.out.println("8. List upcoming events");
            System.out.println("9. Exit");
            System.out.println("Choose an option: ");
            
            
            
            
        }
        
        while (choice!=7);
        
        
    }
    
}
