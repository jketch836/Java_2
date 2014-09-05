package com.fullsail.jketch.ketcham_josh_lab2_fileio;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class WoWAPI extends AsyncTask<String, Integer, String> {

    Context mContext;

    public ArrayList<WoWToonClass> toonInfo = new ArrayList<WoWToonClass>();

    WoWToonClass characterClass;

    int theClass;
    int theRace;
    int theLvL;

    String aName;
    String aClass;
    String aRace;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();


    }

    @Override
    protected String doInBackground(String... strings) {


        try {

            URL wowURL = new URL(strings[0]);

            HttpURLConnection blizzardConnection = (HttpURLConnection) wowURL.openConnection();

            blizzardConnection.connect();

            InputStream inputStream = blizzardConnection.getInputStream();

            String wowjsonString = IOUtils.toString(inputStream);

            inputStream.close();

            blizzardConnection.disconnect();

            JSONObject jsonObject = new JSONObject(wowjsonString);

            aName = jsonObject.getString("name");

            theClass = jsonObject.getInt("class");

            classSwitch(theClass);

            Log.d("TOON CLASS", "The Toon Class: " + aClass);

            theRace = jsonObject.getInt("race");

            raceSwitch(theRace);

            Log.d("TOON RACE", "The Toon Race: " + aRace);

            theLvL = jsonObject.getInt("level");

            Log.d("TOON LVL", "The Toon lvl: " + theLvL);


        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } catch (JSONException e) {

            e.printStackTrace();

        }

        return null;

    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        toonInfo.add(new WoWToonClass(aClass, aRace, theLvL));


        MainActivity activity2 = (MainActivity) mContext;


//        FragmentManager fragmentManager = activity2.getFragmentManager();
//        fragmentManager.beginTransaction()
//                .replace(R.id.DescriptionContainer, DetailFragment.newInstance(aName, aClass, aRace))
//                .commit();



        File external = activity2.getExternalFilesDir(null);
        File file = new File(external, "WoW Character Info");

        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(characterClass);
            oos.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }


    protected void classSwitch(int theSwitch) {

        switch (theSwitch) {

            case 1:
                aClass = "Warrior";
                break;
            case 2:
                aClass = "Paladin";
                break;
            case 3:
                aClass = "Hunter";
                break;
            case 4:
                aClass = "Rogue";
                break;
            case 5:
                aClass = "Priest";
                break;
            case 6:
                aClass = "Death Knight";
                break;
            case 7:
                aClass = "Shaman";
                break;
            case 8:
                aClass = "Mage";
                break;
            case 9:
                aClass = "Warlock";
                break;
            case 10:
                aClass = "Monk";
                break;
            case 11:
                aClass = "Druid";
                break;

        }

    }


    protected void raceSwitch(int theSwitch) {

        switch (theSwitch) {

            case 1:
                aRace = "Human";
                break;
            case 2:
                aRace = "Orc";
                break;
            case 3:
                aRace = "Dwarf";
                break;
            case 4:
                aRace = "Night Elf";
                break;
            case 5:
                aRace = "Undead";
                break;
            case 6:
                aRace = "Tauren";
                break;
            case 7:
                aRace = "Gnome";
                break;
            case 8:
                aRace = "Troll";
                break;
            case 9:
                aRace = "Goblin";
                break;
            case 10:
                aRace = "Blood Elf";
                break;
            case 11:
                aRace = "Draenei";
                break;
            case 22:
                aRace = "Worgen";
                break;
            case 25:
                aRace = "Pandaren";
                break;
            case 26:
                aRace = "Pandaren";
                break;

        }
    }

}
