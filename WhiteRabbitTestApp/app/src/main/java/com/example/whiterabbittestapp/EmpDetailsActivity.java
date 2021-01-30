package com.example.whiterabbittestapp;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class EmpDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_list_item);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        EmpData empDataSelected = (EmpData) intent.getExtras().getSerializable("EmpDetails");
        ImageView imgPic = findViewById(R.id.profileImg);
        TextView txtName = findViewById(R.id.aNametxt);
        TextView txtUName = findViewById(R.id.aUNametxt);
        TextView txtEmail = findViewById(R.id.aEmailtxt);
        TextView txtAdd = findViewById(R.id.aAddtxt);
        TextView txtPhone = findViewById(R.id.aPhonetxt);
        TextView txtWebsite = findViewById(R.id.aWebSitetxt);
        TextView txtCompany = findViewById(R.id.aCompanytxt);
        txtName.setText(empDataSelected.getName());
        txtUName.setText(empDataSelected.getUsername());
        txtEmail.setText(empDataSelected.getEmail());
        //txtAdd.setText(empDataSelected.getAddress());
        txtPhone.setText(empDataSelected.getPhone());
        txtWebsite.setText(empDataSelected.getWebsite());
        txtCompany.setText(empDataSelected.getCompanyName());
        Glide
                .with(EmpDetailsActivity.this)
                .load(empDataSelected.getProfile_image())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(imgPic);
        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/



    }

}