package com.example.expensemanager.view.Navigation_Activities;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.expensemanager.Classes.TabHistory_Week_List;
import com.example.expensemanager.Controllers.TabHistory_Week_Adapter;
import com.example.expensemanager.R;
import com.example.expensemanager.SQLDatabase.DBHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabHistory_week extends AppCompatActivity {

    @BindView(R.id.listview_week)
    ListView listviewWeek;
    List<TabHistory_Week_List> listWeek;
    TabHistory_Week_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_history_week);

        ButterKnife.bind(this);
        loadListView();
    }

    private void loadListView(){
        DBHelper db = new DBHelper(getApplicationContext());
        listWeek = db.getHistoryList();
        adapter = new TabHistory_Week_Adapter(getApplicationContext(), listWeek);
        listviewWeek.setAdapter(adapter);

    }
}
