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
    
    public String danceName;
    public String region;
    public int minutes;

    public Dance(String name, String region, int minutes) {
        this.danceName = name;
        this.region = region;
        this.minutes = minutes;
    }
    
    public void print()
    {
        System.out.println("Dance: " +danceName+" from: " +region+ ", duration: " +minutes+ " minutes." );
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
