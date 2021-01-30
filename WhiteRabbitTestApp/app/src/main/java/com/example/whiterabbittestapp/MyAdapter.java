package com.example.whiterabbittestapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONObject;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter implements View.OnClickListener{
    //ImageLoader imageLoader;
    private Context ctx;
    ArrayList<EmpData> list;

    public MyAdapter(Context ctx, ArrayList<EmpData> mDataList) {
        list = mDataList;
        this.ctx = ctx;
    }

    public int getCount() {
        return list.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // View vi = convertView;
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.single_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.profilePic);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.aNametxt);
            viewHolder.textViewCompanyName = (TextView) convertView.findViewById(R.id.aTypetxt);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        EmpData data = list.get(position);
        String a = data.getProfile_image();
        if (data != null) {
            viewHolder.textView.setText(data.getName());
            viewHolder.textViewCompanyName.setText(data.getCompanyName());
            String url = data.getProfile_image();

            //Glide.with(ctx).load(url).centerCrop().placeholder(R.drawable.abhi).crossFade().into(viewHolder.imageView);
            if(url != null && url != "null"){
                Glide
                        .with(ctx)
                        .load(url)
                        .centerCrop()
                        .placeholder(R.drawable.ic_launcher_background)
                        .into(viewHolder.imageView);
            }

            /* Picasso.with(ctx)
            .load("http://www.keenthemes.com/preview/conquer/assets/plugins/jcrop/demos/demo_files/image1.jpg")
            .into(viewHolder.imageView);*/
            /* ImageLoader imageLoader = ImageLoader.getInstance();
            imageLoader.displayImage("http://www.keenthemes.com/preview/conquer/assets/plugins/jcrop/demos/demo_files/image1.jpg", viewHolder.imageView);*/
        }
        return convertView;
    }

    @Override
    public void onClick(View v) {
        Log.d("CLICKED in ADA","testing");
        int position=(Integer) v.getTag();
        Object object= getItem(position);
        EmpData dataModel=(EmpData) object;

        Intent n = new Intent(ctx, EmpDetailsActivity.class);
        n.putExtra("EmpDetails", dataModel);
        ctx.startActivity(n);
    }

    public class ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView textViewCompanyName;
    }
}