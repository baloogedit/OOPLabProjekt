/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umfst.oop.tancprojekt;

/**
 *
 * @author edite
 */
public class Dance implements DanceStructure{
    
    public String danceName;
    public String region;
    public int minutes;

    public Dance(String name, String region, int minutes) {
        this.danceName = name;
        this.region = region;
        this.minutes = minutes;
    }
    
    @Override
    public void print()
    {
        System.out.println("Dance: " +danceName+" from: " +region+ ", duration: " +minutes+ " minutes." );
    }
    
    @Override
    public void perform() {
        System.out.println("Performing the dance '" + danceName + "' energetically on stage!");
    }

    @Override
    public void showOrigin() {
        System.out.println("This dance originates from the region of " + region + ".");
    }

    @Override
    public void showDuration() {
        System.out.println("The dance '" + danceName + "' lasts about " + minutes + " minutes.");
    }

    @Override
    public void describeStyle() {
        if (minutes < 3) {
            System.out.println(danceName + " is a short, lively dance.");
        } else if (minutes < 7) {
            System.out.println(danceName + " is a traditional medium-length folk dance.");
        } else {
            System.out.println(danceName + " is a long ceremonial performance.");
        }
    }
    
    
    
    
    

    public String getName() {
        return danceName;
    }

    public void setName(String name) {
        this.danceName = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
    
    
    
}
