package com.sai.quotes.quotes;

import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by DELL on 23-04-2017.
 */

public class ListFragment extends Fragment {

    RecyclerView recyclerView;
    String[] strings;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1, null);

        //adding toolbar
        Toolbar toolbar= (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("Categories");
        toolbar.setTitleTextColor(ContextCompat.getColor(getActivity(),R.color.white));
       /* toolbar.setNavigationIcon(R.drawable.ic_menu_back1);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              onBackPressed();
            }
        });
*/

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_viewtab1);
        strings = getResources().getStringArray(R.array.categories);
        AdapaterListsFragment adapaterListsFragment = new AdapaterListsFragment(getActivity(), strings);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapaterListsFragment);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        adapaterListsFragment.notifyDataSetChanged();
        return view;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.mipmap.ic_launcher:
                onBackPressed();
        }


        return super.onOptionsItemSelected(item);
    }

    private void onBackPressed() {
        Intent intent=new Intent(getActivity(),MainActivity.class);
        intent.putExtra("fragmentValue",true);
        getActivity().startActivity(intent);
        getActivity().getFragmentManager().popBackStack();
    }



}
