package com.example.expensemanager.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.expensemanager.Classes.TabHistory_Week_List;
import com.example.expensemanager.Controllers.TabHistory_Week_Adapter;
import com.example.expensemanager.R;
import com.example.expensemanager.SQLDatabase.DBHelper;

import java.util.List;



public class History extends Fragment {
    ListView list;
    TabHistory_Week_Adapter adapter;
    List<TabHistory_Week_List> lists;

    public History()

    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tabhistory_week, container, false);
        list = view.findViewById(R.id.listview_week);

        DBHelper db = new DBHelper(getContext());
        lists = db.getHistoryWeek();
        adapter = new TabHistory_Week_Adapter(getContext(), lists);
        list.setAdapter(adapter);

        return view;
    }

/*
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getActivity().getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.edtCategory) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}