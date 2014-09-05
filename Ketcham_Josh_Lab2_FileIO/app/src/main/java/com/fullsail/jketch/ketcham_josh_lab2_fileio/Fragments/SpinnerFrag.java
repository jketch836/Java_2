package com.fullsail.jketch.ketcham_josh_lab2_fileio.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.fullsail.jketch.ketcham_josh_lab2_fileio.R;


public class SpinnerFrag extends Fragment {

    public static final String TAG = "SpinnerFragment";

    Spinner spinner;

    public interface SpinnerListener {
        public void getString(String name, String classtype, String race);
    }

    private SpinnerListener mListener;

    public static SpinnerFrag newInstance(String name, String classtype, String race) {
        SpinnerFrag fragment = new SpinnerFrag();

        return fragment;
    }

    public SpinnerFrag() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof SpinnerListener) {
            mListener = (SpinnerListener) activity;
        } else {
            throw new IllegalArgumentException("Attaching class must implement toListView");
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View theSpinnerView = inflater.inflate(R.layout.fragment_spinner, container, false);

        return theSpinnerView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] WoWToons = new String[]{"Tarro", "Lyllyana", "Vera"};

        spinner = (Spinner) getActivity().findViewById(R.id.theSpinner);

        ArrayAdapter<String> toonAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, WoWToons);

        spinner.setAdapter(toonAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                TextView toonName = (TextView) view;
                TextView toonClass = (TextView) view;
                TextView toonSpecies = (TextView) view;

                String name = toonName.getText().toString();
                String classy = toonClass.getText().toString();
                String species = toonSpecies.getText().toString();

                mListener.getString(name, classy, species);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

}
