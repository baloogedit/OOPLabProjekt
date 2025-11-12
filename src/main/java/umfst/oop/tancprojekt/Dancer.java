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
    
    private static int dancerCount=0;

    public Dancer(String name, int age, String role, int dances) {
        super(name, age);
        this.role = role;
        this.knownDances=dances;
        dancerCount++;
    }

    public static int getDancerCount() {
        return dancerCount;
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
    
    // overloaded method
    // set role with a reason why it was changed
    public void setRole(String role, String reason)
    {
        this.setRole(role);
        System.out.println("Caution: " + this.name + " 's role changed, because: " + reason);
    }
    
    
    @Override
    public void intro()
    {
        System.out.println("I am"+ name +", I am "+ age + "years old and.In the group I am a "+ role + " and I know "+ knownDances +" dances.");
    }

    public void print()
    {
        System.out.println("Name: "+ name +", age: "+ age + ", role: "+ role + ", known dances: "+ knownDances);
    }
    
    // overriding equals method
    @Override
    public boolean equals(Object obj) {
        // 1. same as itself?
        if (this == obj) {
            return true;
        }
        // 2. null or not same class
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        // type conversion and compare attributes
        Dancer dancer = (Dancer) obj;
        // 2 dancer is the same if both their name and age match
        return age == dancer.age && name.equalsIgnoreCase(dancer.name);
    }
    
    // override hashcode, when equals is overidden
    @Override
    public int hashCode() {
        int result = name != null ? name.toLowerCase().hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}
