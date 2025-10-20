/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umfst.oop.tancprojekt;

import java.sql.Date;

/**
 *
 * @author edite
 */
public class Event {
    
    private String eventName;
    private Date date;
    private String place;
    private Dance danceName;
    
    public Event (String name, Date date, String place, Dance dancing)
    {
        this.eventName=name;
        this.date=date;
        this.place=place;
        this.danceName=dancing;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Dance getDanceName() {
        return danceName;
    }

    public void setDanceName(Dance danceName) {
        this.danceName = danceName;
    }
    
    
    
}
