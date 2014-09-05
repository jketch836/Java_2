package com.fullsail.jketch.ketcham_josh_lab2_fileio;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;

import com.fullsail.jketch.ketcham_josh_lab2_fileio.Fragments.DetailFragment;
import com.fullsail.jketch.ketcham_josh_lab2_fileio.Fragments.SpinnerFrag;


public class MainActivity extends Activity implements SpinnerFrag.SpinnerListener {


    NetworkCheck checkNetwork = new NetworkCheck();

    WoWAPI guildMemberInfo = new WoWAPI();

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.SpinnerContainer, new SpinnerFrag(), SpinnerFrag.TAG)
                .commit();


    }

    @Override
    protected void onResume() {
        super.onResume();

        if (findViewById(R.id.theSpinner) != null) {

            getFragmentManager().beginTransaction()
                    .replace(R.id.SpinnerContainer, new SpinnerFrag(), SpinnerFrag.TAG)
                    .replace(R.id.Spinnerdescription, new DetailFragment(), DetailFragment.TAG)
                    .commit();

        } else {

//            getFragmentManager().beginTransaction()
//                    .replace(R.id.ListViewContainer, new ListFrag(), ListFrag.TAG)
//                    .replace(R.id.ListViewDescription, new DetailFragment(), DetailFragment.TAG)
//                    .commit();

        }
    }

    @Override
    public void getString(String name, String classtype, String race) {

        Log.d("HELLO", name);

        guildMemberInfo.execute("http://us.battle.net/api/wow/character/The%20Venture%20Co/" + name + "?fields=appearance");
        fragmentManager.beginTransaction()
                .replace(R.id.DescriptionContainer, DetailFragment.newInstance(name, classtype, race))
                .commit();

    }

}
