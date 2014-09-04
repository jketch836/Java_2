package com.fullsail.jketch.fragments.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.fullsail.jketch.fragments.R;

import com.fullsail.jketch.fragments.Fragments.dummy.DummyContent;
import com.loopj.android.image.SmartImageView;

/**
 * A fragment representing a list of Items.
 * <p />
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p />
 * Activities containing this fragment MUST implement the {@link Callbacks}
 * interface.
 */
public class ListFragment extends Fragment implements AbsListView.OnItemClickListener {

    public static final String TAG = "ListViewFragment";



    public interface toSpinner {
        public void goToSpinnerFragment(String pic, String name, String classtype, String race, String lvl);
    }

    static final String PIC = "pic";
    static final String NAME = "name";
    static final String CLASSTYPE = "class";
    static final String RACE = "race";
    static final String LVL = "level";

    private toSpinner mListener;


    public static ListFragment newInstance(String pic, String name, String classtype, String race, String lvl) {

        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(PIC, pic);
        args.putString(NAME, name);
        args.putString(CLASSTYPE, classtype);
        args.putString(RACE, race);
        args.putString(LVL, lvl);
        fragment.setArguments(args);
        return fragment;
    }

    public ListFragment() {
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
        View theListView = inflater.inflate(R.layout.fragment_list_list, container, false);

        return theListView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (null != mListener) {

        }
    }

}
