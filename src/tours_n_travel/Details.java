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
public class Details {
    private String start;
    private String end;
    private String hotel;
    private String fare;
    private String id;
    public Details(String id, String start, String end, String hotel, String fare){
        this.start = start;
        this.end = end;
        this.hotel = hotel;
        this.fare = fare;
        this.id = id;
    }
    public String getSource(){
        return start;
    }
    public String getDestination(){
        return end;
    }
    public String getHotelName(){
        return hotel;
    }
    public String getTotalFare(){
        return fare;
    }
    public String getID(){
        return id;
    }
}
