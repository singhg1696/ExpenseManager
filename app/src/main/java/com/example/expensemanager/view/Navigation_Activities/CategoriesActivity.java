package com.example.expensemanager.view.Navigation_Activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.expensemanager.Classes.Categories;
import com.example.expensemanager.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoriesActivity extends AppCompatActivity {

    ArrayList<Categories> categoriesArrayList;
    Categories categories;
    @BindView(R.id.listViewCategories)
    ListView listViewCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        ButterKnife.bind(this);

        categories.setCategory("Clothes");
        categories.setCategory("Bus Fair");
        categories.setCategory("College Fee");
        categories.setCategory("Shoes");
        categories.setCategory("PSP");

        categoriesArrayList.add(categories);
/*
        ArrayAdapter<Categories> itemsAdapter = new ArrayAdapter<Categories>(CategoriesActivity.this, android.R.layout.simple_list_item_1, categoriesArrayList);
        listViewCategories.setAdapter(itemsAdapter);*/
    }
}
