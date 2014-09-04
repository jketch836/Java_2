package com.fullsail.jketch.fragments.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.fullsail.jketch.fragments.MainActivity;
import com.fullsail.jketch.fragments.R;
import com.loopj.android.image.SmartImageView;


public class SpinnerFragment extends Fragment {

    public Spinner spinner;

    public static final String TAG = "SpinnerFragment";

    MainActivity activity = new MainActivity();

//    WoWAPI wowapi= new WoWAPI();

    public interface toListView {
        public void goToListFragment(String pic, String name, String classtype, String race, String lvl);
    }

    static final String PIC = "pic";
    static final String NAME = "name";
    static final String CLASSTYPE = "class";
    static final String RACE = "race";
    static final String LVL = "level";

    private toListView mListener;

    public static SpinnerFragment newInstance(String pic, String name, String classtype, String race, String lvl) {
        SpinnerFragment fragment = new SpinnerFragment();
        Bundle args = new Bundle();

        args.putString(PIC, pic);
        args.putString(NAME, name);
        args.putString(CLASSTYPE, classtype);
        args.putString(RACE, race);
        args.putString(LVL, lvl);
        fragment.setArguments(args);

        return fragment;
    }

    public SpinnerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof toListView) {
            mListener = (toListView) activity;
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

        spinner = (Spinner) getActivity().findViewById(R.id.theSpinner);

        SmartImageView profilePic = (SmartImageView) getActivity().findViewById(R.id.smartImage);
//        profilePic.setImageUrl("http://us.battle.net/static-render/us/" + );

        TextView name = (TextView) getActivity().findViewById(R.id.name);

        TextView memberclass = (TextView) getActivity().findViewById(R.id.classType);

        TextView race = (TextView) getActivity().findViewById(R.id.race);

        TextView lvl = (TextView) getActivity().findViewById(R.id.lvl);

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

