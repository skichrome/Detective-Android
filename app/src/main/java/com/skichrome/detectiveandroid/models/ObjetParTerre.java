package com.skichrome.detectiveandroid.models;

public class ObjetParTerre
{
    private int id;
    private String name;
    private String description;
    private int imageId;

    public ObjetParTerre() { }
    public ObjetParTerre(int id, String name, String description, int imageId)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageId = imageId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getImageId() { return imageId; }
    public void setImageId(int imageId) { this.imageId = imageId; }
}