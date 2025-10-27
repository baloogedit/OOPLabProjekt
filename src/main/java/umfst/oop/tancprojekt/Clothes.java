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
    
    private String clothName;
    
    
    //size with enum
    private Size size;
    private Dancer assignedTo;
    
    public Clothes(String name, Size size)
    {
        this.clothName=name;
        this.size=size;
        this.assignedTo=null;
    }

    public Clothes(String name, Size size, Dancer assignedTo) {
        this.clothName = name;
        this.size = size;
        this.assignedTo = null;//not assigned yet
        
    }

    public String getName() {
        return clothName;
    }

    public void setName(String name) {
        this.clothName = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Dancer getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Dancer assignedTo) {
        this.assignedTo = assignedTo;
    }
    
    
    public void print()
    {
        System.out.println("Costume: " + clothName + ", size: " + size + ", assigned to: " + assignedTo);
    
    }
    
    
}
