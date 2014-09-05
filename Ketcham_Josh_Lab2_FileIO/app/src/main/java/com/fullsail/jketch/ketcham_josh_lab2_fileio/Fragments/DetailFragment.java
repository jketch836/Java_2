package com.fullsail.jketch.ketcham_josh_lab2_fileio.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fullsail.jketch.ketcham_josh_lab2_fileio.R;


public class DetailFragment extends Fragment {

    public static final String TAG = "DetailFragment";

    private static String theName;
    private static String theClass;
    private static String theRace;



    public static DetailFragment newInstance(String name, String classtype, String race) {
        DetailFragment detailFrag = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(theName, name);
        args.putString(theClass,classtype);
                args.putString(theRace,race);




        return detailFrag;
    }

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

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
        View theDetailView = inflater.inflate(R.layout.fragment_detail, container, false);

        return theDetailView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        TextView name = (TextView) getActivity().findViewById(R.id.toonName);

        TextView memberclass = (TextView) getActivity().findViewById(R.id.toonClass);

        TextView race = (TextView) getActivity().findViewById(R.id.toonRace);

        Bundle args = getArguments();

        if(args != null){
            name.setText(args.getString(theName));
            memberclass.setText(args.getString(theClass));
            race.setText(args.getString(theRace));
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }
}
