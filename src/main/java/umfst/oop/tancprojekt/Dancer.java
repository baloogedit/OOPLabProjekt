/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umfst.oop.tancprojekt;

/**
 *
 * @author edite
 */
public class Dancer
{
    
    private String name;
    private int age;
    private String role;

    public Dancer(String name, int age, String role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }
    
    public void introduction()
    {
        System.out.println("I'm " +name+ ", I am "+ age+ "years old. I am a " +role+ ".");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
    
}
