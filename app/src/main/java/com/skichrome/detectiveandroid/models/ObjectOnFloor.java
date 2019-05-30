package com.skichrome.detectiveandroid.models;

public class ObjectOnFloor
{
    private int id;
    private String name;
    private String description;
    private int imageId;

    public ObjectOnFloor() { }
    public ObjectOnFloor(int id, String name, String description, int imageId)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageId = imageId;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getImageId() { return imageId; }
}