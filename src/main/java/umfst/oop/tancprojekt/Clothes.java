/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umfst.oop.tancprojekt;

/**
 *
 * @author edite
 */
public class Clothes {
    
    private String name;
    private char size;
    //size with enum
    private Dancer assignedTo;

    public Clothes(String name, char size, Dancer assignedTo) {
        this.name = name;
        this.size = size;
        this.assignedTo = null;//not assigned yet
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public Dancer getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Dancer assignedTo) {
        this.assignedTo = assignedTo;
    }
    
    
    
    
}
