/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umfst.oop.tancprojekt;

/**
 *
 * @author edite
 */
public class Dancer extends Person
{
    private String role;
    private int knownDances;

    public Dancer(String name, int age, String role, int dances) {
        super(name, age);
        this.role = role;
        this.knownDances=dances;
    }

    public String getRole() {
        return role;
    }

    public int getKnownDances() {
        return knownDances;
    }

    public void setKnownDances(int knownDances) {
        this.knownDances = knownDances;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
    @Override
    public void intro()
    {
        System.out.println("I am"+ name +", I am "+ age + "years old and I dance as a "+ role);
    }

    public void print()
    {
        System.out.println("Name: "+ name +", age: "+ age + ", role: "+ role + ", known dances: "+ knownDances);
    }
    
    
}
