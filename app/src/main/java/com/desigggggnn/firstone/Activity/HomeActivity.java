package com.desigggggnn.firstone.Activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import me.relex.circleindicator.CircleIndicator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.desigggggnn.firstone.Adapter.ImageAdapter;
import com.desigggggnn.firstone.Adapter.RecyclerViewAdapter;
import com.desigggggnn.firstone.Fragments.AboutFragment;
import com.desigggggnn.firstone.Fragments.AcheivementFragment;
import com.desigggggnn.firstone.Fragments.AwardFragment;
import com.desigggggnn.firstone.Fragments.GalleryFragment;
import com.desigggggnn.firstone.Fragments.HomeeFragment;
import com.desigggggnn.firstone.Fragments.MilestoneFragment;
import com.desigggggnn.firstone.Fragments.ProfileFragment;
import com.desigggggnn.firstone.R;
import com.desigggggnn.firstone.Fragments.SchemeFragment;
import com.desigggggnn.firstone.Fragments.WorkFragment;
import com.desigggggnn.firstone.Adapter.ViewPagerAdapter;
import com.desigggggnn.firstone.model.ImageModel;
import com.desigggggnn.firstone.model.Model;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;

    RecyclerView recyclerView,recyclerView1;
    List<Model> developmentList;
    List<ImageModel> imageList;
    private static final Integer[] IMAGES= {R.drawable.bjjp,R.drawable.bjp,R.drawable.logo,R.drawable.bjjp};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    ActionBarDrawerToggle toggle;
    BottomNavigationView bottomNavigationView;
    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;
    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
//        bottomNavigationView = findViewById(R.id.bottomnavigation);

        recyclerView = findViewById(R.id.recycler_view_development);
        recyclerView1 = findViewById(R.id.recycler_view_images);
        developmentList = new ArrayList<>();
        imageList=new ArrayList<>();
        DrawerLayout drawerLayout=(DrawerLayout)findViewById(R.id.navDrawer);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        developmentList = new ArrayList<>();
        imageList=new ArrayList<>();
        imageList.add(new ImageModel(R.drawable.bluebackground));
        imageList.add(new ImageModel(R.drawable.background));
        imageList.add(new ImageModel(R.drawable.bluebackground));
        imageList.add(new ImageModel(R.drawable.background));

        developmentList.add(new Model(R.drawable.jajji,"HEADING OF WORK 1"));
        developmentList.add(new Model(R.drawable.background,"HEADING OF WORK 2 "));
        developmentList.add(new Model(R.drawable.backgroundd,"HEADING OF WORK 3"));
        developmentList.add(new Model(R.drawable.jajji,"HEADING OF WORK 4"));

        LinearLayoutManager manager1 = new LinearLayoutManager(this);
        manager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager1);

        LinearLayoutManager manager2 = new LinearLayoutManager(this);
        manager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView1.setLayoutManager(manager2);

        RecyclerViewAdapter adaptor1 = new RecyclerViewAdapter(this,developmentList);
        recyclerView.setAdapter(adaptor1);

        ImageAdapter adaptor2 = new ImageAdapter(this,imageList);
        recyclerView1.setAdapter(adaptor2);


// This is the id you used during the menu declaration
//        View centerSectionItem = bottomNavigationView.findViewById(R.id.bottomitemShikayat);
//        TextView largeTextView = centerSectionItem.findViewById(com.google.android.material.R.id.largeLabel);
//        TextView smallTextView = centerSectionItem.findViewById(com.google.android.material.R.id.smallLabel);
//
//        smallTextView.setSingleLine(false);
//        largeTextView.setSingleLine(false);
//
//        smallTextView.setGravity(Gravity.CENTER);
//        largeTextView.setGravity(Gravity.CENTER);



//        viewPager = (ViewPager) findViewById(R.id.viewPager);
//      sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);
//
//        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
//
//        viewPager.setAdapter(viewPagerAdapter);
//
//        dotscount = viewPagerAdapter.getCount();
//        dots = new ImageView[dotscount];
//
//        for(int i = 0; i < dotscount; i++){
//
//            dots[i] = new ImageView(this);
//            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
//
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//
//            params.setMargins(8, 0, 8, 0);
//
//            sliderDotspanel.addView(dots[i], params);
//
//        }
//
//        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
//
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//                for(int i = 0; i< dotscount; i++){
//                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
//                }
//
//                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });




        NavigationView navigationView=(NavigationView)findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.itemHome:
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.rel_layout,new HomeeFragment()).commit();
                        break;
                    case R.id.itemAbout:
                        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction1.replace(R.id.rel_layout,new AboutFragment()).commit();
                        break;
                    case R.id.itemSchemes:
                        FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction2.replace(R.id.rel_layout,new SchemeFragment()).commit();
                        break;
                    case R.id.itemWorks:
                        FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction3.replace(R.id.rel_layout,new WorkFragment()).commit();
                        break;
                    case R.id.itemGallery:
                        FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction4.replace(R.id.rel_layout,new GalleryFragment()).commit();
                        break;
                    case R.id.itemAward:
                        FragmentTransaction fragmentTransaction5 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction5.replace(R.id.rel_layout,new AwardFragment()).commit();
                        break;
                    case R.id.itemMilestone:
                        FragmentTransaction fragmentTransaction6 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction6.replace(R.id.rel_layout,new MilestoneFragment()).commit();
                        break;
                    case R.id.itemAcheivements:
                        FragmentTransaction fragmentTransaction7 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction7.replace(R.id.rel_layout,new AcheivementFragment()).commit();
                        break;
                    case R.id.itemProfile:
                        FragmentTransaction fragmentTransaction8 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction8.replace(R.id.rel_layout,new ProfileFragment()).commit();
                        break;
                    case R.id.itemContactUs:
                        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                        startActivity(intent);
                        break;
//                        FragmentTransaction fragmentTransaction9 = getSupportFragmentManager().beginTransaction();
//                        fragmentTransaction9.replace(R.id.container,new ContactUsFragment()).commit();

                }
                DrawerLayout d1=(DrawerLayout)findViewById(R.id.navDrawer);
                if(d1.isDrawerOpen(GravityCompat.START)){
                    d1.closeDrawer(GravityCompat.START);
                }
                return false;
            }
        });

    }



    private void init() {
        for(int i=0;i<IMAGES.length;i++)
            ImagesArray.add(IMAGES[i]);

        mPager = (ViewPager) findViewById(R.id.pager);


        mPager.setAdapter(new ViewPagerAdapter(HomeActivity.this,ImagesArray));

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);


//        CirclePageIndicator indicator = (CirclePageIndicator)
//                findViewById(R.id.indicator);
//
//        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

//Set circle indicator radius
    //       indicator.setRadius(5 * density);

        NUM_PAGES =IMAGES.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
//        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//
//            @Override
//            public void onPageSelected(int position) {
//                currentPage = position;
//
//            }
//
//            @Override
//            public void onPageScrolled(int pos, float arg1, int arg2) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int pos) {
//
//            }
//        });

    }



    @Override    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}