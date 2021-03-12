
package javageneric;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kmalif
 */
public class JavaGeneric {

    
    public static void main(String[] args) {
        
        //list menampung data berupa object
        List L1 = new ArrayList();
        L1.add(100);
        L1.add(new User(20, "Alif"));
        
        for(Object val : L1){
            if (val instanceof User){
                User u = (User) val;
                u.setName("Khafidul");
                System.out.println("Name : "+u.getName());
                System.out.println("Age : "+ u.getAge());
            }else{
                System.out.println(val);
            }
        }
        
    }
    
}
