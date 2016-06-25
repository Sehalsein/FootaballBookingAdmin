package com.sehalsein.footaballbookingadmin.Activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;
import com.sehalsein.footaballbookingadmin.Fragment.BookingRequest;
import com.sehalsein.footaballbookingadmin.Fragment.GroundDetail;
import com.sehalsein.footaballbookingadmin.Fragment.Profile;
import com.sehalsein.footaballbookingadmin.R;

public class AdminHome extends AppCompatActivity {

    private BottomBar mBottomBar;
    private Toolbar toolbar;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        manager = getSupportFragmentManager();

        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.setItems(R.menu.bottombar_menu);
        mBottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                if (menuItemId == R.id.bottombar_ground_detail) {
                    toolbar.setTitle("Ground Detail");
                    Toast.makeText(AdminHome.this, "BUTTON 1 SELECTED", Toast.LENGTH_SHORT).show();
                    FragmentTransaction transaction = manager.beginTransaction();
                    GroundDetail groundList = new GroundDetail();
                    transaction.replace(R.id.fragment_layout, groundList, "GROUND DETIAL");
                    //transaction.addToBackStack(null);
                    transaction.commit();
                } else if (menuItemId == R.id.bottombar_booking) {
                    toolbar.setTitle("Ground Request");
                    Toast.makeText(AdminHome.this, "BUTTON 2 SELECTED", Toast.LENGTH_SHORT).show();
                    FragmentTransaction transaction = manager.beginTransaction();
                    BookingRequest groundList = new BookingRequest();
                    transaction.replace(R.id.fragment_layout, groundList, "GROUND DETIAL");
                    //transaction.addToBackStack(null);
                    transaction.commit();
                } else if (menuItemId == R.id.bottombar_profile) {
                    toolbar.setTitle("Profile");
                    Toast.makeText(AdminHome.this, "BUTTON 3 SELECTED", Toast.LENGTH_SHORT).show();
                    FragmentTransaction transaction = manager.beginTransaction();
                    Profile groundList = new Profile();
                    transaction.replace(R.id.fragment_layout, groundList, "GROUND DETIAL");
                    //transaction.addToBackStack(null);
                    transaction.commit();
                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
                if (menuItemId == R.id.bottombar_booking) {
                    // The user reselected item number one, scroll your content to top.
                }
            }
        });

        // Setting colors for different tabs when there's more than three of them.
        // You can set colors for tabs in three different ways as shown below.
        mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorAccent));
        mBottomBar.mapColorForTab(1, 0xFF5D4037);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        mBottomBar.onSaveInstanceState(outState);
    }

}
