package com.skichrome.detectiveandroid.inventorymanagement;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class StorageSharedPrefs
{
    private static StorageSharedPrefs storagePrefs = new StorageSharedPrefs();
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    private static final String PREFS_NAME = "Inventory";
    private static final String OBJ = "object store";

    private StorageSharedPrefs() { }

    public static StorageSharedPrefs getInstance(Context context)
    {
        if (sharedPreferences == null)
        {
            sharedPreferences = context.getSharedPreferences(PREFS_NAME, Activity.MODE_PRIVATE);
            editor = sharedPreferences.edit();
        }
        return storagePrefs;
    }

    public void storeInInventory(/*ObjectOnFloor objectOnFloor*/)
    {
        editor.putString(OBJ, "");
        editor.commit();
    }

    public ObjectsAvailable getFromInventory()
    {
        return null;//sharedPreferences.getString(OBJ, "");
    }

    public void removeFromInventory(/*ObjectOnFloor objectOnFloor*/)
    {
        editor.remove("");
        editor.commit();
    }

    public void clearAllSharedPrefs()
    {
        editor.clear();
        editor.commit();
    }
}