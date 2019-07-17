package com.skichrome.detectiveandroid.inventorymanagement;

import com.skichrome.detectiveandroid.R;

public enum ObjectsAvailable
{
    // Objets
    TROMBONE(0, "un trombone", "Ce trombonne est abïmé, pourquoi ?", R.drawable.ic_trombonne),
    CASE(1, "une valise", "tiens un papier dans la valise retient votre attention, il parle d'une importante somme d'argent cachée dans la maison", R.drawable.ic_business_center_black_24dp),
    KNIFE(2, "couteau", "Un couteau mal rangé ?", R.drawable.ic_knife),
    PAPER(3, "une feuille de papier", "Tiens, il semblerais que quelqu'un cherchais à se débarrasser de ce document.", R.drawable.ic_paper),
    REVOLVER(4, "Un revolver", "peut-être l'arme d'un crime ?", R.drawable.ic_revolver),

    // Clés
    LIBRARY_KEY(100, "une clé", "Une clé étrange, peut-être déverrouille-elle la suite ?", R.drawable.ic_key);

    ObjectsAvailable(int id, String name, String description, int imageId)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageId = imageId;
    }

    private int id;
    private String name;
    private String description;
    private int imageId;

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public int getImageId()
    {
        return imageId;
    }
}