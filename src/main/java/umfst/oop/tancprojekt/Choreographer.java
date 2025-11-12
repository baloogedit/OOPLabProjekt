/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umfst.oop.tancprojekt;

/**
 *
 * @author edite
 */
public class Choreographer extends Person{
    private int yearsOfExperience;
    
    public Choreographer(String name, int age, int yearsOfExperience) {
        super(name, age);
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
    
    
    // overriding Person's abstract intro method 
    @Override
    public void intro() {
        System.out.println("I am a choreographer, my name is: " + name + " ,I am  " + age + " years old and I have " + yearsOfExperience + " years of experience.");
    }
    
    // override toString method
    @Override
    public String toString() {
        return "Choreographer [Name: " + name + ", Age: " + age + ", Experience: " + yearsOfExperience + " years]";
    }
    
}
