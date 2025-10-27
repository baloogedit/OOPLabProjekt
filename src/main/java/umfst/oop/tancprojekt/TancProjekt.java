/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package umfst.oop.tancprojekt;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author edite
 */
public class TancProjekt {
    
     private static ArrayList <Dancer> dancers=new ArrayList<>();
     private static ArrayList <Dance> dances=new ArrayList<>();
     private static ArrayList <Clothes> costumes=new ArrayList<>();
     private static ArrayList <Event> events=new ArrayList<>();
     private static Scanner sc = new Scanner(System.in);
        

    public static void main(String[] args) 
    {
        
        //dancers.add(new Dancer("Edit", 19, "female",7));
        //dancers.add(new Dancer("David", 20, "male",8));
        
        //dances.add(new Dance("verbunk", "Mezoseg", 3));
        //dances.add(new Dance("csardas", "Nyaradmente", 5));
        
                    
                
        int choice = 0;
        
        do
        {
            System.out.println("--MENU--");
            System.out.println("1. Add dancer");
            System.out.println("2. Add dance");
            System.out.println("3. Add costume");
            System.out.println("4. Add event");
            System.out.println("5. List dancers");
            System.out.println("6. List dances");
            System.out.println("7. Assign costume to dancer");
            System.out.println("8. List costumes with assigned dancer");
            System.out.println("9. List upcoming events");
            System.out.println("10. Exit");
            System.out.println("Choose an option: ");
            choice=sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1 -> addDancer();
                case 2 -> addDance();
                case 3 -> addCostume();
                case 4 -> addEvent();
                case 5 -> listDancers();
                case 6 -> listDances();
                case 7 -> assignCostume();
                case 8 -> listCostumes();
                case 9 -> listEvents();
                case 10 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again!");
            }
        }
        while (choice!=10);
    }
    
    
    
    //case 1
    private static void addDancer()
    {
        System.out.print("Enter dancer name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter role (leader/member/beginner/expert): ");
        String role = sc.nextLine();
        
        System.out.print("Enter known dances number: ");
        int dance=sc.nextInt();

        dancers.add(new Dancer(name, age, role, dance));
        System.out.println("Dancer added successfully!");
    }
    
    //case 2
    private static void addDance()
    {
        System.out.print("Enter dance name: ");
        String name=sc.nextLine();
        
        System.out.print("Enter dance region: ");
        String region=sc.nextLine();
        
        System.out.println("Enter the length of the dance in minutes: ");
        int length=sc.nextInt();
        
        dances.add(new Dance(name, region, length));
    }
    
    //case 3
    private static void addCostume()
    {
        System.out.print("Enter costume name: ");
        String name = sc.nextLine();

        System.out.print("Enter size: ");
        String sizeInput = sc.nextLine().toUpperCase();

        Size size;
        try {
            size = Size.valueOf(sizeInput);  // convert text to enum
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid size. Defaulting to M.");
            size = Size.M; // default size if user types something wrong
        }

        costumes.add(new Clothes(name, size));
        System.out.println("Costume added successfully!");
    }
    
    //case 4
    private static void addEvent()
    {
        System.out.print("Enter event name: ");
        String event = sc.nextLine();
        
        System.out.print("Enter event date (YYYY-MM-DD): ");
        String dateStr = sc.nextLine();
        Date date = Date.valueOf(dateStr);

        System.out.print("Enter event place: ");
        String place = sc.nextLine();
        
        events.add(new Event(event, date, place));
    }
    
    
    //case 5
    private static void listDancers()
    {
        if (dancers.isEmpty()) 
        {
            System.out.println("No dancers yet.");
            return;
        }

        System.out.println("\n--- Dancer list ---");
        for (Dancer d: dancers) 
        {
            d.print();
        }
    }
    
    //case 6
    private static void listDances()
    {
        if(dances.isEmpty())
        {
            System.out.println("No dances yet.");
            return;
        }
        
        System.out.println("\n--- Dances list ---");
        for (Dance d: dances) 
        {
            d.print();
        }
    }
    
    
    
    //case 7
    private static void assignCostume()
    {
        if (costumes.isEmpty() || dancers.isEmpty()) {
            System.out.println("You need at least one dancer and one costume to assign.");
            return;
        }

        System.out.println("\n--- Costume List ---");
        for (int i = 0; i < costumes.size(); i++) {
            System.out.println((i + 1) + ". " + costumes.get(i));
        }

        System.out.print("Enter costume number to assign: ");
        int costumeIndex = sc.nextInt() - 1;
        sc.nextLine(); // clear buffer

        System.out.println("\n--- Dancer List ---");
        for (int i = 0; i < dancers.size(); i++) {
            System.out.println((i + 1) + ". " + dancers.get(i).getName());
        }

        System.out.print("Enter dancer number: ");
        int dancerIndex = sc.nextInt() - 1;
        sc.nextLine();

        if (costumeIndex >= 0 && costumeIndex < costumes.size()
                && dancerIndex >= 0 && dancerIndex < dancers.size())
        {

            Clothes selectedCostume = costumes.get(costumeIndex);
            Dancer selectedDancer = dancers.get(dancerIndex);

            selectedCostume.setAssignedTo(selectedDancer);
            System.out.println("Costume '" + selectedCostume.getName() + "' assigned to " + selectedDancer.getName() + ".");
        } 
        else 
        {
            System.out.println("Invalid selection.");
        }
    }
    
    //case 8
    private static void listCostumes() 
    {
        if (costumes.isEmpty())
        {
            System.out.println("No costumes yet.");
            return;
        }

        System.out.println("\n--- Costume list ---");
        for (Clothes c : costumes)
        {
            c.print();
        }
    }
    
    //case 9
    private static void listEvents()
    {
        if (events.isEmpty())
        {
            System.out.println("No events yet.");
            return;
        }

        System.out.println("\n--- Event list ---");
        for (Event e : events)
        {
            e.print();
        }
    }
    
    
    
}
