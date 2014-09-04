package com.fullsail.jketch.fragments.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fullsail.jketch.fragments.R;
import com.loopj.android.image.SmartImageView;


public class DetailFragment extends Fragment {

    public static final String TAG = "DetailFragment";

    static final String NAME = "name";
    static final String CLASSTYPE = "class";
    static final String RACE = "race";
    static final String LVL = "level";

    public static DetailFragment newInstance(String name, String classtype, String race, String lvl) {
        DetailFragment fragment = new DetailFragment();
//        Bundle args = new Bundle();
//        args.putString(NAME, name);
//        args.putString(CLASSTYPE, classtype);
//        args.putString(RACE, race);
//        args.putString(LVL, lvl);
//        fragment.setArguments(args);
        return fragment;
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
        View theReturnView = inflater.inflate(R.layout.fragment_detail, container, false);

        return theReturnView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SmartImageView profilePic = (SmartImageView) getActivity().findViewById(R.id.smartImage);
//        profilePic.setImageUrl("http://us.battle.net/static-render/us/" + );

        TextView name = (TextView) getActivity().findViewById(R.id.name);

        TextView memberclass = (TextView) getActivity().findViewById(R.id.classType);

        TextView lvl = (TextView) getActivity().findViewById(R.id.lvl);

//        Bundle args = getArguments();
//        if (args.containsKey(NAME)) {
//            name.setText(args.getString(NAME));
//        } else if (args.containsKey(CLASSTYPE)) {
//            memberclass.setText(args.getString(CLASSTYPE));
//        } else if (args.containsKey(LVL)) {
//            lvl.setText(args.getString(LVL));
//        }


    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

}
