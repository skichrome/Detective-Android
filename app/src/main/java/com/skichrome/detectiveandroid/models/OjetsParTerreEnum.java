package com.skichrome.detectiveandroid.models;

public enum OjetsParTerreEnum
{
    VALISE("case"),
    TROMBONNE("trombonne");

    private String mId;

    OjetsParTerreEnum(String id) { this.mId = id; }
    public String getId() { return mId; }
}