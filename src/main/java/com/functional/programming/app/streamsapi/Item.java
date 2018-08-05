package com.functional.programming.app.streamsapi;

public class Item {

    private  static int counter = 6;
    private int id;
    private String name;

    public Item(){
        this.id = counter --;
        this.name = "Item-" +id;
    }

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
}
