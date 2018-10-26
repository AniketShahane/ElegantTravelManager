/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tours_n_travel;
import java.util.*;

/**
 *
 * @author shaha
 */
public class User {
    private String id;
    private String name;
    private String email;
    private String fare;
    public User(String id, String name, String email, String fare){
        this.id = id;
        this.name = name;
        this.email = email;
        this.fare = fare;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getFare(){
        return fare;
    }
}
