package com.sai.quotes.quotes.allquotes;

/**
 * Created by PrasannakumarA on 5/3/2017.
 */


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sai.quotes.quotes.R;

import java.util.ArrayList;


//Our class extending fragment
public class Tab1 extends Fragment {
    private ArrayList<String> myaraylist;
    private RecyclerView recyclerView;
    String[] strings;


    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes

        myaraylist = new ArrayList<>();
        myaraylist.add(0, "one");
        myaraylist.add(1, "one");
        myaraylist.add(2, "one");
        myaraylist.add(3, "one");
        myaraylist.add(4, "one");
        myaraylist.add(5, "one");
        myaraylist.add(6, "one");
        myaraylist.add(7, "one");
        myaraylist.add(8, "one");
        myaraylist.add(9, "one");
        myaraylist.add(10, "one");

//        myaraylist.add(0,"one");
//        return inflater.inflate(R.layout.tab1, container, false);


        View view = inflater.inflate(R.layout.activity_list_fragment, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_fragment);
        strings = getResources().getStringArray(R.array.categories);
        RecyclerViewAdapter adapaterListsFragment = new RecyclerViewAdapter(getActivity(), strings);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapaterListsFragment);
        adapaterListsFragment.notifyDataSetChanged();
        return view;
    }
}