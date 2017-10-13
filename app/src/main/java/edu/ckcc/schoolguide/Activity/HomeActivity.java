package edu.ckcc.schoolguide.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import edu.ckcc.schoolguide.R;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.statusBar));
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        toolbar.setBackgroundColor(this.getResources().getColor(R.color.toolbar));
        setSupportActionBar(toolbar);
        getSupportActionBar();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        int lastSeletedMenu = sharedPreferences.getInt("last-selected-menu", R.id.menu_home);
        MenuItem selectedItem = navigationView.getMenu().findItem(lastSeletedMenu);
        selectedItem.setCheckable(true);
        onNavigationItemSelected(selectedItem);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_home){
            setTitle("Home");
        } else if(id == R.id.menu_university){
            setTitle("University");
        } else if(id == R.id.menu_news){
            setTitle("News");
        } else if(id == R.id.menu_job){
            setTitle("Job");
        } else if(id == R.id.menu_scholarship){
            setTitle("Scholarship");
        } else if(id == R.id.menu_bookmark){
            setTitle("Bookmark");
        } else if(id == R.id.menu_setting){
            setTitle("Setting");
        } else if(id == R.id.menu_help){
            setTitle("Help");
        } else if(id == R.id.menu_about){
            setTitle("About us");
        }
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}