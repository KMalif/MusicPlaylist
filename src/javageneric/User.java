/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javageneric;

/**
 *
 * @author kmalif
 */
public class User {

    private String Name;
    private int Age;

   public User(int Age, String Name){
       this.Age = Age;
       this.Name = Name;
   }
   

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    
}
