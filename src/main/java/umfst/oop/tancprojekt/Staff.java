/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umfst.oop.tancprojekt;

/**
 *
 * @author edite
 */
public class Staff extends Person{
    
    private String department; //ex. "jelmeztar", "logisztika", "technika", "konyveles"
    
    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    // overriding Person's abstract intro method
    @Override
    public void intro() {
        System.out.println("I am a staff member, my name is: " + name + " I am " + age + " years old. I work in the " + department + " department.");
    }
    
    public void print()
    {
        System.out.println(this.toString());
    }
    
    //override toString method
    @Override
    public String toString() {
        return "Staff [Name: " + name + ", Age: " + age + ", Department: " + department + "]";
    }

}
