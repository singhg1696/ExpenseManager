package com.example.expensemanager.Controllers;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.expensemanager.Classes.TabHistory_Week_List;
import com.example.expensemanager.R;

import java.text.DecimalFormat;
import java.util.List;


public class TabHistory_Week_Adapter extends BaseAdapter {
    Context context;
    List<TabHistory_Week_List> listWeek;


    public TabHistory_Week_Adapter(Context context, List<TabHistory_Week_List> listWeek){
        this.context = context;
        this.listWeek = listWeek;

    }

    @Override
    public int getCount() {
        return listWeek.size();
    }

    @Override
    public Object getItem(int position) {
        return listWeek.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = View.inflate(context, R.layout.tab_history_week_list, null);

        TextView txtName = view.findViewById(R.id.tbhw_name);
        TextView txtDate = view.findViewById(R.id.tbhw_date);
        TextView txtAmount = view.findViewById(R.id.tbhw_amount);
        TextView txtNote = view.findViewById(R.id.tbhw_note);

        txtName.setText(listWeek.get(position).getName());
        DecimalFormat precision = new DecimalFormat("0.00");
        txtAmount.setText(precision.format(listWeek.get(position).getAmount()));
        txtDate.setText(listWeek.get(position).getDate());
        txtNote.setText(listWeek.get(position).getNote());


        return view;
    }
    }


