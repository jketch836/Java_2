package com.fullsail.jketch.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fullsail.jketch.fragments.Fragments.DetailFragment;
import com.fullsail.jketch.fragments.Fragments.ListFragment;
import com.fullsail.jketch.fragments.Fragments.SpinnerFragment;
import com.fullsail.jketch.fragments.Fragments.dummy.DummyContent;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends Activity implements SpinnerFragment.toListView, ListFragment.toSpinner {

    String apiString = "http://us.battle.net/api/wow/guild/The%20Venture%20Co/The%20Grim%20Covenant?fields=members";

    WoWAPI wowInfo = new WoWAPI();

    String aRace;
    String aClass;

    DummyContent dummyList = new DummyContent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
//            getFragmentManager().beginTransaction()
//                    .replace(R.id.SpinnerContainer, new SpinnerFragment(), SpinnerFragment.TAG)
//                    .commit();
        }

//        wowInfo.execute(apiString);
    }

//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }


    @Override
    protected void onResume() {
        super.onResume();

        if (findViewById(R.id.theSpinner) != null) {

            getFragmentManager().beginTransaction()
                    .replace(R.id.SpinnerContainer, new SpinnerFragment(), SpinnerFragment.TAG)
                    .replace(R.id.Spinnerdescription, new DetailFragment(), DetailFragment.TAG)
                    .commit();
        }else {
            getFragmentManager().beginTransaction()
                    .replace(R.id.ListViewContainer, new SpinnerFragment(), SpinnerFragment.TAG)
                    .replace(R.id.ListViewdescription, new DetailFragment(), DetailFragment.TAG)
                    .commit();

        }
    }

    @Override
    public void goToListFragment(String pic, String name, String classtype, String race, String lvl) {

        ListFragment listFrag = (ListFragment) getFragmentManager().findFragmentByTag(ListFragment.TAG);

        if (listFrag == null) {
            listFrag = ListFragment.newInstance(pic, name, classtype, race, lvl);
            getFragmentManager().beginTransaction()
                    .replace(R.id.ListViewContainer, listFrag, SpinnerFragment.TAG)
                    .commit();
        }

    }

    @Override
    public void goToSpinnerFragment(String pic, String name, String classtype, String race, String lvl) {

        SpinnerFragment spinFrag = (SpinnerFragment) getFragmentManager().findFragmentByTag(SpinnerFragment.TAG);
        if (spinFrag == null) {
            spinFrag = SpinnerFragment.newInstance(pic, name, classtype, race, lvl);
            getFragmentManager().beginTransaction()
                    .replace(R.id.SpinnerContainer, spinFrag, SpinnerFragment.TAG)
                    .commit();
        }

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

    public class WoWAPI extends AsyncTask<String, Integer, String> {


        ProgressDialog progressDialog;

        String name;
        String thumbnail;
        int theClass;
        int theRace;
        int theLvL;

        String aRace;
        String aClass;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setIndeterminate(true);
            progressDialog.setTitle("Loading Guild Members");
            progressDialog.setMessage("Please wait while the Guild Member information is loading");
            progressDialog.show();

//            dummyList..clear();

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

                JSONArray wowJSON = jsonObject.getJSONArray("members");

                for (int i = 0; i < wowJSON.length(); i++) {

                    JSONObject members = wowJSON.getJSONObject(i);

                    JSONObject characters = members.getJSONObject("character");

                    if (characters.has("name")) {

                        name = characters.getString("name");

                    } else {

                        name = "Name: N/A";

                    }

//                    Log.d("TOON NAME", "The Toon Name: " + name);

                    theClass = characters.getInt("class");

                    classSwitch(theClass);

//                    Log.d("TOON CLASS", "The Toon Class: " + aClass);

                    theRace = characters.getInt("race");

                    raceSwitch(theRace);

//                    Log.d("TOON RACE", "The Toon Race: " + aRace);

                    theLvL = characters.getInt("level");

//                    Log.d("TOON LVL", "The Toon lvl: " + theLvL);


                    thumbnail = characters.getString("thumbnail");


//                    dummyList.addItem(name, aClass, aRace, theLvL, thumbnail);

                }

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

            progressDialog.dismiss();

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

