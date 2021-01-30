package com.example.whiterabbittestapp;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class EmpData  implements Serializable
    {
        String name;
        String companyName;
        int id;
        String username;
        String email;
        String profile_image;
        String phone;
        String website;
        ArrayList address;
        JSONObject company;
        public String getName()
        {
            return name;
        }
        public void setName(String albumId)
        {
            this.name = albumId;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getProfile_image() {
            return profile_image;
        }

        public void setProfile_image(String profile_image) {
            this.profile_image = profile_image;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        public ArrayList getAddress() {
            return address;
        }

        public void setAddress(ArrayList address) {
            this.address = address;
        }

        public JSONObject getCompany() {
            return company;
        }

        public void setCompany(JSONObject company) {
            this.company = company;
        }

        public int getId()
        {
            return id;
        }
        public void setId(int id)
        {
            this.id = id;
        }

    }