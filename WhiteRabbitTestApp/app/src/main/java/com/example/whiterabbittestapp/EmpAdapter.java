package com.example.whiterabbittestapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EmpAdapter extends BaseAdapter
    {
        private Activity activity;
        // private ArrayList<HashMap<String, String>> data;
        private static ArrayList title;
        private static LayoutInflater inflater = null;
        public EmpAdapter(Activity a, ArrayList b)
        {
            activity = a;
            this.title = b;
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        public int getCount()
        {
            return title.size();
        }
        public Object getItem(int position)
        {
            return position;
        }
        public long getItemId(int position)
        {
            return position;
        }
        public View getView(int position, View convertView, ViewGroup parent)
        {
            View vi = convertView;
            if (convertView == null) vi = inflater.inflate(R.layout.listitemlayout, null);
            TextView title2 = (TextView) vi.findViewById(R.id.txt_ttlsm_row); // title
            String song = title.get(position).toString();
            title2.setText(song);
            //TextView title22 = (TextView) vi.findViewById(R.id.txt_ttlcontact_row2); // notice
            //String song2 = title.get(position).toString();
            //title22.setText(song2);
            return vi;
        }
    }
