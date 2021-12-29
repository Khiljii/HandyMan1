package com.example.handyman;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter {
    private final String[] itemName;

    private final int[] imageId;
   // private final String[] itemDescription;
    public CustomAdapter(Activity context, int[] imgId, String[] itemNam) {
        super(context, R.layout.grid, itemNam);
        this.imageId = imgId;
        this.itemName = itemNam;
      //  this.itemDescription = itemDesc;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listItemView = inflater.inflate(R.layout.grid, parent, false);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.icon);
        TextView itemTitle = (TextView) listItemView.findViewById(R.id.item);
       // TextView descTextView = (TextView) listItemView.findViewById(R.id.itemDesc);
        imageView.setImageResource(imageId[position]);
        itemTitle.setText(itemName[position]);
      //  descTextView.setText(itemDescription[position]);
        return listItemView;
    };
}
