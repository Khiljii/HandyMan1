package com.example.handyman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Home extends AppCompatActivity {





    ViewPager mViewPager;
    int[] images = {R.drawable.slide1,R.drawable.slide2,R.drawable.slide3};
    Slider mViewPagerAdapter;

    int currentPageCunter = 0;


    String[] itemName = {"Electrician", "Plumber", "Painter","Carpenter","Mason","Tile Fitter","Ac Repair","Car Washer","Decoration","Barber","Maid","Cook","Car Repair","Car Towing","Photographer","Sofa Cleaner","Welder","Ladour"};
 //   String [] itemDesc = {"For electrical work ", "Water related work", "Anything related paint"};
    int[] itemImage ={R.drawable.electrical_services_24,R.drawable.plumbing_24,R.drawable.paint_24,R.drawable.ic_baseline_carpenter_24,R.drawable.mason1,R.drawable.tilefitter,R.drawable.ac,R.drawable.car_wash_24,R.drawable.interier,R.drawable.barber,R.drawable.maid,R.drawable.cook,R.drawable.carrepair,R.drawable.towingcar,R.drawable.phohographer,R.drawable.sohacleaner,R.drawable.welder,R.drawable.labour};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mViewPager = (ViewPager)findViewById(R.id.slide);

        // Initializing the ViewPagerAdapter
        mViewPagerAdapter = new Slider(Home.this, images);

        // Adding the Adapter to the ViewPager
        mViewPager.setAdapter(mViewPagerAdapter);


        CustomAdapter adapter = new CustomAdapter(this, itemImage, itemName);
        GridView gird =(GridView) findViewById(R.id.grid1);
        gird.setAdapter(adapter);
        gird.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View v, int
                    position, long id)
            {
                Toast.makeText(getApplicationContext(), "You Clicked: " +
                        itemName[position], Toast.LENGTH_SHORT).show();
            }
        });

        final Handler handler = new Handler();
        final Runnable update  = new Runnable() {
            @Override
            public void run() {
                if (currentPageCunter == images.length){
                    currentPageCunter = 0 ;

                }

                mViewPager.setCurrentItem(currentPageCunter++,true);
            }
        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },2500,2500);

        gird.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(Home.this,Packages.class));
            }
        });

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

}