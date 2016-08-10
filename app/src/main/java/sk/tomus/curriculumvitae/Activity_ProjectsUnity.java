package sk.tomus.curriculumvitae;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class Activity_ProjectsUnity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_unity);
        loadBackdrop();
        initToolbar();
        initNavigationDrawer();
        initFabButton();
    }

    private void loadBackdrop() {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(R.drawable.image_unity).centerCrop().into(imageView);
        final ImageView imageView1 = (ImageView) findViewById(R.id.unity_image2);
        Glide.with(this).load(R.drawable.unity_1).centerCrop().into(imageView1);
        final ImageView imageView2 = (ImageView) findViewById(R.id.unity_image1);
        Glide.with(this).load(R.drawable.unity_2).centerCrop().into(imageView2);
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initFabButton() {

        ImageView fabButton = (ImageView) findViewById(R.id.fabButton);
        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_SHORT).show();
                startNextActivity(5);
                finish();
            }
        });
    }

    private void initNavigationDrawer() {

        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                int id = menuItem.getItemId();

                switch (id) {
                    case R.id.about:
                        startNextActivity(0);
                        drawerLayout.closeDrawers();
                        finish();
                        break;
                    case R.id.experience:
                        startNextActivity(1);
                        drawerLayout.closeDrawers();
                        finish();
                        break;
                    case R.id.projects_android:
                        startNextActivity(2);
                        drawerLayout.closeDrawers();
                        finish();
                        break;
                    case R.id.projects_cuda:
                        startNextActivity(3);
                        drawerLayout.closeDrawers();
                        finish();
                        break;
                    case R.id.projects_unity:
                        startNextActivity(4);
                        drawerLayout.closeDrawers();
                        finish();
                        break;
                    case R.id.projects_dota:
                        startNextActivity(5);
                        drawerLayout.closeDrawers();
                        finish();
                        break;
                    case R.id.interests:
                        startNextActivity(6);
                        drawerLayout.closeDrawers();
                        finish();
                        break;
                    case R.id.contact:
                        startNextActivity(7);
                        drawerLayout.closeDrawers();
                        finish();
                        break;
                }
                return true;
            }
        });
        View header = navigationView.getHeaderView(0);
        TextView tv_email = (TextView) header.findViewById(R.id.tv_email);
        tv_email.setText("tomuso.o@gmail.com");

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View v) {
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void startNextActivity(int flag) {
        Intent nextActivity;
        switch (flag) {
            case 0:
                nextActivity = new Intent(this, Activity_About.class);
                break;
            case 1:
                nextActivity = new Intent(this, Activity_Experience.class);
                break;
            case 2:
                nextActivity = new Intent(this, Activity_ProjectsAndroid.class);
                break;
            case 3:
                nextActivity = new Intent(this, Activity_ProjectsCuda.class);
                break;
            case 4:
                nextActivity = new Intent(this, Activity_ProjectsUnity.class);
                break;
            case 5:
                nextActivity = new Intent(this, Activity_ProjectsDota.class);
                break;
            case 6:
                nextActivity = new Intent(this, Activity_Interests.class);
                break;
            case 7:
                nextActivity = new Intent(this, Activity_Contact.class);
                break;

            default:
                nextActivity = new Intent(this, Activity_About.class);
                break;
        }
        Bundle bundleAnimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation, R.anim.animation2).toBundle();
        startActivity(nextActivity, bundleAnimation);
    }
}
