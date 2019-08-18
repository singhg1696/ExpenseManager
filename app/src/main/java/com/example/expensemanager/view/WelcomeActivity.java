package com.example.expensemanager.view;

import android.content.Intent;
import android.os.Bundle;

import com.example.expensemanager.Fragments.History;
import com.example.expensemanager.Fragments.Overview;
import com.example.expensemanager.R;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Tab2.class));

            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        setTitle("Overview");
        Overview fragment = new Overview();
        androidx.fragment.app.FragmentManager fragmentManager = getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment, "Overview");
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Overview) {
            setTitle("Overview");
            Overview fragment = new Overview();
            androidx.fragment.app.FragmentManager fragmentManager = getSupportFragmentManager();
            androidx.fragment.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment, "Overview");
            fragmentTransaction.commit();

        } else if (id == R.id.History) {
            setTitle("History");
            History fragment = new History();
            androidx.fragment.app.FragmentManager fragmentManager = getSupportFragmentManager();
            androidx.fragment.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment, "History");
            fragmentTransaction.commit();

        } else if (id == R.id.Itemcategory) {
            Intent i = new Intent(getApplicationContext(), Tab1.class);
            startActivity(i);

        } else if (id == R.id.ItemSettings) {
            startActivity(new Intent(getApplicationContext(), SettingsActivity.class));

        } else if (id == R.id.aboutUs) {
            startActivity(new Intent(getApplicationContext(), About_Us.class));

        } else if (id == R.id.contactUs) {
            startActivity(new Intent(getApplicationContext(), Contact_Us.class));

        } else if (id == R.id.logout) {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
