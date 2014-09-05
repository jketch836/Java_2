package com.fullsail.jketch.ketcham_josh_lab2_fileio.Fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fullsail.jketch.ketcham_josh_lab2_fileio.R;

/**
 * Created by jketch on 9/5/14.
 */
public class ListFrag extends ListFragment {

    public static final String TAG = "ListViewFragment";



    public interface toSpinner {
        public void goToSpinnerFragment(String pic, String name, String classtype, String race, String lvl);
    }

//    static final String NAME = "name";
//    static final String CLASSTYPE = "class";
//    static final String RACE = "race";
//    static final String LVL = "level";

    private toSpinner mListener;


    public static ListFrag newInstance(String pic, String name, String classtype, String race, String lvl) {

        ListFrag fragment = new ListFrag();
        Bundle args = new Bundle();

//        args.putString(NAME, name);
//        args.putString(CLASSTYPE, classtype);
//        args.putString(RACE, race);
//        args.putString(LVL, lvl);
//        fragment.setArguments(args);

        return fragment;
    }

    public ListFrag() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof toSpinner) {
            mListener = (toSpinner) activity;
        } else {
            throw new IllegalArgumentException("Attaching class must implement toSpinner");
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
        View theListView = inflater.inflate(R.layout.activity_main, container, false);

//        ListView listView = (ListView) getActivity().findViewById(R.id.list);

        return theListView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



//        TextView name = (TextView) getActivity().findViewById(R.id.name);
//
//        TextView memberclass = (TextView) getActivity().findViewById(R.id.classType);
//
//        TextView race = (TextView) getActivity().findViewById(R.id.race);
//
//        TextView lvl = (TextView) getActivity().findViewById(R.id.lvl);
//
//        Bundle args = getArguments();
//        if(args.containsKey(NAME)){
//            name.setText(args.getString(NAME));
//        } else if (args.containsKey(CLASSTYPE)){
//            memberclass.setText(args.getString(CLASSTYPE));
//        } else if (args.containsKey(RACE)){
//            race.setText(args.getString(RACE));
//        } else if (args.containsKey(LVL)){
//            lvl.setText(args.getString(LVL));
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

}
