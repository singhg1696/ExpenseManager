package com.example.expensemanager.Fragments;


import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.expensemanager.Classes.Overview_ListView;
import com.example.expensemanager.R;
import com.example.expensemanager.SQLDatabase.DBHelper;
import com.example.expensemanager.Controllers.Overview_List_Adapter;

import java.text.DecimalFormat;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Overview extends androidx.fragment.app.Fragment {

    private ListView listView;
    List<Overview_ListView> listOverview;
    Overview_List_Adapter adapterOverview;
    TextView total;

    public Overview() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_overview, container, false);

        listView = view.findViewById(R.id.list_viewAll);
        total = view.findViewById(R.id.txtAmountOverview);
        getTotal();

        DBHelper db = new DBHelper(getContext());
        listOverview = db.getOverviewList();
        adapterOverview = new Overview_List_Adapter(getContext(), listOverview);
        listView.setAdapter(adapterOverview);
        return view;
    }

    public Cursor getTotal() {
        DBHelper db = new DBHelper(getContext());
        SQLiteDatabase sql = db.getReadableDatabase();
        String query = "SELECT SUM(amount) AS total FROM Add_Expense";

        Cursor c = sql.rawQuery(query, null);
        c.moveToFirst();
        c.getInt(0);

        DecimalFormat precision = new DecimalFormat("0.00 CAD");
        total.setText(precision.format(c.getInt(0)));

        Log.d("Sum",(precision.format(c.getInt(0))));

        Toast.makeText(getContext(), "????????"+total.toString()+">>>>>>>>>>>>>>>>", Toast.LENGTH_SHORT).show();
        Log.d("Error",total.toString());
        return c;
    }



}