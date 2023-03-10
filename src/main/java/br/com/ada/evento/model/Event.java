package br.com.ada.evento.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {

    //attributes
    private int id;
    private String name;
    private String date;

    //constructor
    public Event(String name, String date) throws ParseException {
        this.name = name;
        this.date = date;
    }

    //GetSetMethods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
