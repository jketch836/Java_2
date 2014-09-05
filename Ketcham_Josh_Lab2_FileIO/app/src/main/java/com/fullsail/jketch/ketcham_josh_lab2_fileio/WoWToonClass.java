package com.fullsail.jketch.ketcham_josh_lab2_fileio;

import java.io.Serializable;

/**
 * Created by jketch on 9/5/14.
 */
public class WoWToonClass implements Serializable {

    String toonClass;
    String toonRace;
    int toonLvL;

    public WoWToonClass(String tClass, String race, int lvl) {

        toonClass = tClass;
        toonRace = race;
        toonLvL = lvl;

    }

}
