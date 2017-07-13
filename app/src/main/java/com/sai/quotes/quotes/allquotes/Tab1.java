package com.sai.quotes.quotes.allquotes;

/**
 * Created by PrasannakumarA on 5/3/2017.
 */


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.sai.quotes.quotes.R;
import com.sai.quotes.quotes.RecyclerAdapterQuotes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


//Our class extending fragment

public class Tab1 extends Fragment implements View.OnClickListener{
    private RecyclerView recyclerView;
    String[] strings;
    View view;
    String itemClicked;
    String[] quotestopass;
    RecyclerView recyclerViewQuotes;
    String arrayName;
    Boolean expandrcollapseval=false;
    View controlView;
    ImageView a2z, z2a, expand, collapse;
    private ArrayList<String> favouritearraySP;

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes


//        myaraylist.add(0,"one");
//        return inflater.inflate(R.layout.tab1, container, false);


      view  = inflater.inflate(R.layout.activity_list_fragment, null);

        controlView = view.findViewById(R.id.control_toolbar);
        a2z = (ImageView) view.findViewById(R.id.a2z_icon);
        z2a = (ImageView) view.findViewById(R.id.z2a_icon);
        expand = (ImageView) view.findViewById(R.id.expand_icon);
        collapse = (ImageView) view.findViewById(R.id.collapse_icon);
        a2z.setOnClickListener(this);
        z2a.setOnClickListener(this);
        expand.setOnClickListener(this);
        collapse.setOnClickListener(this);

        quotestopass = getResources().getStringArray(R.array.strengthislifearray);
        arrayName = "strengthislifearray";

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_fragment);
        recyclerView.setBackgroundResource(R.drawable.ic_vivekananda_bg);
//recyclerView.getBackground().setAlpha(20);

//        recyclerView.getBackground().getBounds().offset(400,400);
        strings = getResources().getStringArray(R.array.onetofiftyarray);
//        RecyclerViewAdapter adapaterListsFragment = new RecyclerViewAdapter(getActivity(), strings);
       RecyclerAdapterQuotes adapaterListsFragment=new RecyclerAdapterQuotes(getActivity(),strings,"onetofiftyarray",expandrcollapseval);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapaterListsFragment);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        adapaterListsFragment.notifyDataSetChanged();
        return view;
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id)
        {
            case R.id.z2a_icon:
            case R.id.a2z_icon:
            case R.id.expand_icon:
            case R.id.collapse_icon:

                Toast.makeText(getActivity(), "toast mas", Toast.LENGTH_SHORT).show();
//                strings = getResources().getStringArray(R.array.onetofiftyarray);
                if (v.getId() == R.id.a2z_icon) {
                    z2a.setVisibility(View.VISIBLE);
                    a2z.setVisibility(View.INVISIBLE);
                    Collections.reverse(Arrays.asList(strings));
//                    Toast.makeText(getActivity(), "toast mas", Toast.LENGTH_SHORT).show();
                } else if (v.getId() == R.id.z2a_icon) {
                    z2a.setVisibility(View.INVISIBLE);
                    a2z.setVisibility(View.VISIBLE);
                    Collections.reverse(Arrays.asList(strings));
//                    Toast.makeText(getActivity(), "toast mas", Toast.LENGTH_SHORT).show();
                }else if (v.getId()==R.id.expand_icon)
                {
                    expand.setVisibility(View.INVISIBLE);
                    collapse.setVisibility(View.VISIBLE);

                }
                else if(v.getId()==R.id.collapse_icon)
                {
                    expand.setVisibility(View.VISIBLE);
                    collapse.setVisibility(View.INVISIBLE);
                }





                if(a2z.getVisibility()==View.VISIBLE){
                    Collections.reverse(Arrays.asList(quotestopass));
                }

                if (collapse.getVisibility() == View.VISIBLE) {
                    expandrcollapseval = true;
                }
                else
                    expandrcollapseval=false;

                LayoutInflater inflater = LayoutInflater.from(getActivity());

                view  = inflater.inflate(R.layout.activity_list_fragment, null);

//                recyclerViewQuotes = (RecyclerView) view.findViewById(R.id.recyclerview_fragment);
//                RecyclerAdapterQuotes adapter = new RecyclerAdapterQuotes(getActivity(), quotestopass, arrayName, expandrcollapseval);
//                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
//                recyclerViewQuotes.setLayoutManager(mLayoutManager);
//                recyclerViewQuotes.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));
//                recyclerViewQuotes.setAdapter(adapter);
//                adapter.notifyDataSetChanged();
//                Toast.makeText(getApplicationContext(),"toast mas",Toast.LENGTH_SHORT).show();

//                strings = getResources().getStringArray(R.array.onetofiftyarray);
//        RecyclerViewAdapter adapaterListsFragment = new RecyclerViewAdapter(getActivity(), strings);
                RecyclerAdapterQuotes adapaterListsFragment=new RecyclerAdapterQuotes(getActivity(),strings,"onetofiftyarray",expandrcollapseval);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setAdapter(adapaterListsFragment);
                recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
                adapaterListsFragment.notifyDataSetChanged();

                break;


        }
        }
    }
