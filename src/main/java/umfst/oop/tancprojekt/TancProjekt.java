/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package umfst.oop.tancprojekt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 *
 * @author edite
 */
public class TancProjekt 
{
    
     private static ArrayList <Dancer> dancers=new ArrayList<>();
     private static ArrayList <Dance> dances=new ArrayList<>();
     private static ArrayList <Clothes> costumes=new ArrayList<>();
     private static ArrayList <Event> events=new ArrayList<>();
     private static Scanner sc = new Scanner(System.in);
        

    public static void main(String[] args) 
    {
        
        loadDataFromJson();//load json file
        
              
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
            System.out.println("10. Print one dance's description");
            System.out.println("11. Exit");
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
                case 10 -> descriptionOfDance();
                case 11 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again!");
            }
        }
        while (choice!=11);
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
        saveDataToJson();//insert in json the added dancer
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
        saveDataToJson();
    }
    
    //case 3
    private static void addCostume()
    {
        System.out.print("Enter costume name: ");
        String name = sc.nextLine();

        System.out.print("Enter size(XS, S, M, L, XL): ");
        String sizeInput = sc.nextLine().toUpperCase();
        //if it's lowercase, it will put into uppercase so that it can be converted to enum

        Size size;
        try {
            size = Size.valueOf(sizeInput);  // convert text to enum
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid size. Defaulting to M.");
            size = Size.M; // default size if user types something wrong
        }

        costumes.add(new Clothes(name, size));
        System.out.println("Costume added successfully!");
        saveDataToJson();
    }
    
    //case 4
    private static void addEvent()
    {
        System.out.print("Enter event name: ");
        String event = sc.nextLine();
        
        System.out.print("Enter event date (YYYY-MM-DD): ");
        String dateStr = sc.nextLine();
        Date date = Date.valueOf(dateStr);//convert string into date

        System.out.print("Enter event place: ");
        String place = sc.nextLine();
        
        events.add(new Event(event, date, place));
        saveDataToJson();
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
        
        //for each Dancer in dancers list, it calls the print method
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
        
        //same as dancers
        for (Dance d: dances) 
        {
            d.print();
        }
    }
    
    
    
    //case 7
    private static void assignCostume()
    {
        //if one of the classes involved is empty, it throws an error message
        if (costumes.isEmpty() || dancers.isEmpty()) {
            System.out.println("You need at least one dancer and one costume to assign.");
            return;
        }

        System.out.println("\n--- Costume List ---");
        
        //i is for printing the number of each item, so is easier to select which one you want to assign to dancer
        int i=1;
        for (Clothes c: costumes) {
            System.out.print(i + ". ");
            c.print();
            i++;
        }

        System.out.print("Enter costume number to assign: ");
        int costumeIndex = sc.nextInt() - 1;
        sc.nextLine(); // clear buffer

        System.out.println("\n--- Dancer List ---");
        //j is for printing the number of each item, so is easier to select which dancer you want to assign to the costume
        int j=1;
        for (Dancer d: dancers) {
            //printing the nr.
            System.out.print(j+". ");
            //calls the printing method 
            d.print();
            //increasing number
            j++;
        }

        System.out.print("Enter dancer number: ");
        int dancerIndex = sc.nextInt() - 1;//-1 so that the counting starts from 1, not 0
        sc.nextLine();

        //if the selection was valid( no 0 and no bigger number than the max objects were scanned)
        if (costumeIndex >= 0 && costumeIndex < costumes.size()
                && dancerIndex >= 0 && dancerIndex < dancers.size())
        {

            Clothes selectedCostume = costumes.get(costumeIndex);
            Dancer selectedDancer = dancers.get(dancerIndex);

            //call for the selected costume's assigning method 
            selectedCostume.setAssignedTo(selectedDancer);
            //print out the final costume object
            System.out.println("Costume '" + selectedCostume.getName() + "' assigned to " + selectedDancer.getName() + ".");
            //updates the json from assignedTo=null to the assigned dancer's name
            saveDataToJson();
        } 
        //handle invalid inputs
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
    
    
    //case 10
    private static void descriptionOfDance()
    {
        //list the whole dances list, so it's easier to choose one
        System.out.println("\n--- Dance list ---");
        int i=1;
        for (Dance d: dances) {
            System.out.print(i + ". ");
            d.print();
            i++;
        }
        
        //select one of the dances
        System.out.print("Enter dancer number: ");
        int dancesIndex = sc.nextInt() - 1;
        Dance selectedDance = dances.get(dancesIndex);
        selectedDance.perform();
        selectedDance.showOrigin();
        selectedDance.showDuration();
        selectedDance.describeStyle();  
    }
    
    
    
    
    //load the json file
    private static void loadDataFromJson() {
        try 
        {
            //load the file into memory, parse as json object
            String jsonText = Files.readString(Paths.get("data.json"));
            JSONObject jsonObj = new JSONObject(jsonText);

            // Dancers
            // split into little arrays based on the keys (dancers, dances, etc.)
            JSONArray dancerArr = jsonObj.getJSONArray("dancers");
            //loop through the json array
            for (int i = 0; i < dancerArr.length(); i++) {
                JSONObject d = dancerArr.getJSONObject(i);
                dancers.add(new Dancer(
                        d.getString("name"),
                        d.getInt("age"),
                        d.getString("role"),
                        d.getInt("dances")));
                //recreate each Dancer from the data in Json
            }

            // Dances
            JSONArray danceArr = jsonObj.getJSONArray("dances");
            for (int i = 0; i < danceArr.length(); i++) {
                JSONObject d = danceArr.getJSONObject(i);
                dances.add(new Dance(
                        d.getString("name"),
                        d.getString("region"),
                        d.getInt("minutes")));
            }

            // Costumes
            JSONArray costumeArr = jsonObj.getJSONArray("costumes");
            for (int i = 0; i < costumeArr.length(); i++) {
                JSONObject c = costumeArr.getJSONObject(i);
                Size size;
                try {
                    size = Size.valueOf(c.getString("size").toUpperCase());
                } catch (Exception e) {
                    size = Size.M;
                }
                costumes.add(new Clothes(c.getString("name"), size));
                
                //if assignedTo is not null, assign to a dancer
                if (c.has("assignedTo") && !c.isNull("assignedTo")) 
                {
                    String dancerName = c.getString("assignedTo");
                    for (Dancer d : dancers) 
                    {
                        if (d.getName().equalsIgnoreCase(dancerName)) 
                        {
                            costumes.get(i).setAssignedTo(d);
                            break;
                        }
                    }
                }
            
        
            }

            // Events
            JSONArray eventArr = jsonObj.getJSONArray("events");
            for (int i = 0; i < eventArr.length(); i++) {
                JSONObject e = eventArr.getJSONObject(i);
                Date date = Date.valueOf(e.getString("date"));
                events.add(new Event(
                        e.getString("name"),
                        date,
                        e.getString("place")));
            }

        } 
        catch (IOException e) 
        {
            System.out.println("Cannot read data.json: " + e.getMessage());
        } 
        catch (JSONException e) 
        {
            System.out.println(" Error parsing JSON: " + e.getMessage());
        }
        finally
        {
            System.out.println("JSON exercise completed");
        }
    }
    
    private static void saveDataToJson() 
    {
        try 
        {
            //creating a main "folder" that contains every array
            JSONObject root = new JSONObject();

            //dancers
            JSONArray dancerArr = new JSONArray();//create json array that stoes data
            //loops through all dancer objects
            for (Dancer d : dancers) {
                //turn each one into small Json object
                JSONObject obj = new JSONObject();
                obj.put("name", d.getName());
                obj.put("age", d.getAge());
                obj.put("role", d.getRole());
                obj.put("dances", d.getKnownDances());
                dancerArr.put(obj);//adds the small objects into one array
            }
            root.put("dancers", dancerArr);
            //add the previous array to the main root object
            // under the key:dancers

            //dances
            JSONArray danceArr = new JSONArray();
            for (Dance d : dances) {
                JSONObject obj = new JSONObject();
                obj.put("name", d.getName());
                obj.put("region", d.getRegion());
                obj.put("minutes", d.getMinutes());
                danceArr.put(obj);
            }
            root.put("dances", danceArr);

            //costumes
            JSONArray costumeArr = new JSONArray();
            for (Clothes c : costumes) {
                JSONObject obj = new JSONObject();
                obj.put("name", c.getName());
                obj.put("size", c.getSize().toString());

                //check if assignedTo has value
                if (c.getAssignedTo() != null)
                {
                    //if it is not null, it prints out the dancer name only (string)
                    obj.put("assignedTo", c.getAssignedTo().getName());
                } 
                else 
                {
                    //else, it prints out null value
                    obj.put("assignedTo", JSONObject.NULL);
                }

                costumeArr.put(obj);
            }
            root.put("costumes", costumeArr);

            //events
            JSONArray eventArr = new JSONArray();
            for (Event e : events) {
                JSONObject obj = new JSONObject();
                obj.put("name", e.getEventName());
                //convert Date to string, otherwise it can't be printed
                obj.put("date", e.getDate().toString());
                obj.put("place", e.getPlace());
                eventArr.put(obj);
            }
            root.put("events", eventArr);

            //write to file (file name=data.json)
            Files.writeString(Paths.get("data.json"), root.toString(4));
                    // print with 4 spaces before the text so that is more readable
            System.out.println("Data saved successfully to data.json!");

        }
        catch (IOException e) 
        {
            System.out.println("Error writing to data.json: " + e.getMessage());
        }
    }
    
    
}
