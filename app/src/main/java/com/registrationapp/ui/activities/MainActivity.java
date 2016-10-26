package com.registrationapp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.registrationapp.R;
import com.registrationapp.model.FragmentDrawer;
import com.registrationapp.prefrences.PrefsConstants;
import com.registrationapp.prefrences.RegistrationPrefrence;
import com.registrationapp.ui.fragments.AboutUsFragment;
import com.registrationapp.ui.fragments.HomeFragment;
import com.registrationapp.ui.fragments.NotificationFragment;
import com.registrationapp.ui.fragments.PhotosFragment;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {
    protected RegistrationPrefrence registrationPrefrence;
    private FragmentDrawer drawerFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registrationPrefrence = new RegistrationPrefrence(this);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        drawerFragment = (FragmentDrawer) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
        displayView(0);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:


                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }



    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new NotificationFragment();

                break;
            case 2:
                fragment = new PhotosFragment();

                break;
            case 3:
                fragment = new AboutUsFragment();
                break;
            case 4:
                logout();
                Toast.makeText(this, "Logout is clicked", Toast.LENGTH_SHORT).show();
                break;

        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
    }
    private void logout() {
        registrationPrefrence.addOrUpdateBoolean(PrefsConstants.MEMBER_LOGGED_IN, false);
        Intent intentLogout = new Intent(this, LoginActivity.class);
        startActivity(intentLogout);
        finish();
    }

}
