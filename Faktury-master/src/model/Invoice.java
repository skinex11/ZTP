package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Invoice implements Serializable {
    private static int counter = 0;
    private int id;
    private String name;
    private LocalDate date;

    private ArrayList<Item> items;

    public Invoice(String name, ArrayList<Item> items) {
        id = counter;
        counter++;
        this.name = name;
        this.date = LocalDate.now();
        this.items = items;
    }

    public Invoice(int id, String name, ArrayList<Item> items) {
        this.id = id;
        counter = id + 1;
        this.name = name;
        this.date = LocalDate.now();
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date.toString();
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
