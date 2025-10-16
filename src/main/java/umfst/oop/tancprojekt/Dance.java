/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umfst.oop.tancprojekt;

/**
 *
 * @author edite
 */
public class Dance {
    
    public String name;
    public String region;
    public int minutes;

    public Dance(String name, String region, int minutes) {
        this.name = name;
        this.region = region;
        this.minutes = minutes;
    }
    
    public void print()
    {
        System.out.println("Dance: " +name+" from: " +region+ ", duration: " +minutes+ " minutes." );
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
