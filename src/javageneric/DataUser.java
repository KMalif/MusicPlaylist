/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javageneric;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kmalif
 */
public class DataUser {
     public static void main(String[] args) {
         //record data apa saja yang akan disimpan pada List usr
         List<User> usr = new ArrayList<>();
         
         //add ke List usr sebanyak 3 kali dengan value object User
         for (int i = 1; i <= 3; i++) {
              User u = new User(i, "Nama"+i);
              usr.add(u);
         }
         //merubah value index 1 
         usr.get(1).setName("Khafidul Mualif");
         usr.get(1).setAge(20);
         
         //menampilkan data pada list usr
         for (int i = 0; i < usr.size(); i++) {
             User u = usr.get(i);
             System.out.println("Name: "+ u.getName());
             System.out.println("Age: "+ u.getAge());
         }
    }
}
