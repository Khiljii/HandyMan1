package com.example.handyman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    String[] itemName = {"Electrician", "Plumber", "Painter"};
    String [] itemDesc = {"For electrical work ", "Water related work", "Anything related paint"};
    int[] itemImage ={R.drawable.ic_baseline_electrical_services_24,R.drawable.plumbing_24,R.drawable.paint_24};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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

        //ListView list = (ListView)findViewById(R.id.list1);
        //list.setAdapter(adapter);
        /*list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String SelectedItem= itemName[+position];
                Toast.makeText(getApplicationContext(), SelectedItem,
                        Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}