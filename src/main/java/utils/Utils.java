package utils;

import datas.Data;

public class Utils implements PlayerInput {

    private Data data = new Data();

    // Constructor
    public Utils() {

    }


    //******************************************************************************************************************
    //                                                   UTILS
    //******************************************************************************************************************

    public Boolean ifSaving() {
        return data.loadRoom() != '\0';
    }
}
