package com.sai.quotes.quotes;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by DELL on 23-04-2017.
 */

public class ListFragment extends Fragment {

    RecyclerView recyclerView;
    String[] strings;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_list_fragment, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_fragment);
        strings = getResources().getStringArray(R.array.categories);
        AdapaterListsFragment adapaterListsFragment = new AdapaterListsFragment(getActivity(), strings);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapaterListsFragment);
        adapaterListsFragment.notifyDataSetChanged();
        return view;
    }
}
