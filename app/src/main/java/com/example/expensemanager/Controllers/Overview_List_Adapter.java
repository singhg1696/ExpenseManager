package com.example.expensemanager.Controllers;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.expensemanager.Classes.Overview_ListView;
import com.example.expensemanager.R;

import java.text.DecimalFormat;
import java.util.List;



public class Overview_List_Adapter extends BaseAdapter {
    Context context;
    List<Overview_ListView> listOverview;

    public Overview_List_Adapter(Context context, List<Overview_ListView> listOverview){
        this.context = context;
        this.listOverview = listOverview;
    }
    @Override
    public int getCount() {
        return listOverview.size();
    }

    @Override
    public Object getItem(int position) {
        return listOverview.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = View.inflate(context, R.layout.overview_list, null);
        TextView txtName = view.findViewById(R.id.txtOverview_name);
        TextView txtAmount = view.findViewById(R.id.txtOverview_amount);
        ProgressBar progressBar = view.findViewById(R.id.progressBar);

        txtName.setText(listOverview.get(position).getName());
        DecimalFormat precision = new DecimalFormat("0.00");
        txtAmount.setText(precision.format(listOverview.get(position).getAmount()) + " CAD");
        progressBar.setProgress(txtAmount.getAutoLinkMask());
        progressBar.setProgress(0);
        progressBar.setMax(100);

        return view;
    }
}
