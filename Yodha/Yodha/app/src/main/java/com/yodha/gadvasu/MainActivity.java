package com.yodha.gadvasu;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.navigation.NavigationView;
import com.yodha.gadvasu.Activity.AboutActivity;
import com.yodha.gadvasu.Activity.BaseActivity;
import com.yodha.gadvasu.Activity.ContactsusActivity;
import com.yodha.gadvasu.Activity.LoginActivity;
import com.yodha.gadvasu.Activity.NotificationActivity;
import com.yodha.gadvasu.Activity.ProfileActivity;
import com.yodha.gadvasu.Activity.TermscondiActivity;
import com.yodha.gadvasu.Fragmentdata.FragDashboard;
import com.yodha.gadvasu.Otherdatacls.Sharepredata;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private DrawerLayout drawer;
    LinearLayout about,terms,userprofiles,logout,contacts,dashboard;
    TextView username,mobile;
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        FrameLayout frameLayout =findViewById(R.id.FLnotification);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.sidenav_view);
        View headerLayout = navigationView.getHeaderView(0);

        terms = headerLayout.findViewById(R.id.terms);
        about = headerLayout.findViewById(R.id.about);
        userprofiles = headerLayout.findViewById(R.id.userprofiles);
        logout = headerLayout.findViewById(R.id.logout);
        contacts = headerLayout.findViewById(R.id.contacts);
        dashboard = headerLayout.findViewById(R.id.dashboard);
        username = headerLayout.findViewById(R.id.username);
        mobile = headerLayout.findViewById(R.id.mobile);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.getDrawerArrowDrawable()
                .setColor(getResources().getColor(R.color.white));
        toggle.syncState();

        displayView();


        frameLayout.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
            startActivity(intent);
        });

        String Username =sharepreference.getData(Sharepredata.USERNAME);
        String Usermobile =sharepreference.getData(Sharepredata.USERMOBILE);
        if(Username !=null){
            username.setText(Username);
            mobile.setText(Usermobile);
        }
        setClickListenerOnAll(dashboard,userprofiles,contacts,terms,about,logout);
    }


    private void setClickListenerOnAll(View... views) {

        for (View view : views) {
            view.setOnClickListener(this);
        }
    }


    public void displayView() {
        removeAllStack();
        Fragment fragment = new FragDashboard();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().addToBackStack(null).replace(R.id.nav_host_fragment, fragment).commit();
    }


    public void removeAllStack() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        int count = fragmentManager.getBackStackEntryCount();
        for (int i = 0; i < count; i++) {
            fragmentManager.popBackStack();
        }
    }


    @Override
    public void onBackPressed() {
        exitApp();
    }

    public void exitApp() {
        if ((System.currentTimeMillis() - exitTime) > 1000) {
            Toast.makeText(this, getString(R.string.get_msg_exit), Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.dashboard:
              displayView();
                break;

            case R.id.userprofiles:
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
                break;

            case R.id.contacts:
                Intent intent1 = new Intent(MainActivity.this, ContactsusActivity.class);
                startActivity(intent1);
                break;

          /*  case R.id.rate:
                Uri uri = Uri.parse("market://details?id=" + getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                }
                break;*/


            case R.id.terms:
                startActivity(new Intent(MainActivity.this, TermscondiActivity.class));
                break;

            case R.id.about:
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                break;


            case R.id.logout:
                logout();
                break;
        }

        closeDrawer();
    }


    public void closeDrawer() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    private void logout(){
        sharepreference.Dataclear();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }
}