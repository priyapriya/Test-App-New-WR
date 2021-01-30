package com.example.whiterabbittestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    //EmpAdapter adapter;
    MyAdapter adapter;
    ArrayList<String> id_array = new ArrayList<String>();
    ArrayList<String> notice_array = new ArrayList<String>();
    ArrayList<EmpData> mDataList;
    Button b1;
    ListView listView;
    private final static String SERVICE_URI = "http://jsonplaceholder.typicode.com/albums/";
    private static final String TAG_QUESTIONS = "Questions";
    private static final String USER_NAME = "username";
    private static final String NAME = "name";
    private static final String ID = "id";
    private static final String WEBSITE = "website";
    JSONArray questions = null;

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_title_list);
        new DownloadFilesTask().execute();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), mDataList.get(position).getCompanyName(), Toast.LENGTH_LONG).show();
                EmpData dataModel=(EmpData) mDataList.get(position);

                Intent n = new Intent(MainActivity.this, EmpDetailsActivity.class);
                n.putExtra("EmpDetails", dataModel);
                startActivity(n);

                //Intent n = new Intent(MainActivity.this, EmpDetailsActivity.class);
                //n.putExtra("id", id_array.get(position));
               // startActivity(n);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }
    class DownloadFilesTask extends AsyncTask< Void, Void, String >
    {
        private final ProgressDialog dialog = new ProgressDialog(MainActivity.this);
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            //this.dialog.setMessage("Logging in WhiteRabbitApp");
            //this.dialog.show();
        }
        @Override
        protected String doInBackground(Void...params)
        {
            ServiceHandler sh = new ServiceHandler();
            //String jsonStr = sh.makeServiceCall("http://jsonplaceholder.typicode.com/albums/", ServiceHandler.GET);
            String jsonStr = sh.makeServiceCall("http://www.mocky.io/v2/5d565297300000680030a986/", ServiceHandler.GET);
            Log.d("res1", jsonStr);
            return jsonStr;
        }
        @Override
        protected void onPostExecute(String response)
        {
            super.onPostExecute(response);
            Log.d("res2", response);
            //dialog.dismiss();
            if (response != null)
            {
                try
                {
                    JSONArray arr = new JSONArray(response);
                    JSONObject jsonObj;
                    //Gson gson = new Gson();
                    //String Json = gson.toJson(response );
                    //String  jsonString =doSthToGetJson(); //http request
                    //EmpData data =new EmpData() ;
                    //data= gson.fromJson(Json,MainActivity.this);
                   // data = gson.fromJson(Json,MainActivity.class);
                    //DataModel mDatModel = new DataModel();
                    EmpData dataModel = new EmpData();
                    mDataList = new ArrayList<>();
                    for (int i = 0; i < arr.length(); i++)
                    {
                        JSONObject c = arr.getJSONObject(i);
                        String id = c.getString(ID);
                        String name = c.getString(NAME);
                        String website = c.getString(WEBSITE);
                        String uname = c.getString(USER_NAME);
                        //id_array.add(name+" : "+website);
                        dataModel = new EmpData();
                        dataModel.setName(c.getString(NAME));
                        dataModel.setId(c.getInt(ID));
                        dataModel.setUsername(c.getString(USER_NAME));
                        JSONObject jObj = arr.getJSONObject(i);
                        String company = jObj.getString("company");
                        String companyName = "Not available";
                        if(company != null  && company != "null") {
                            JSONObject jsonCmny = new JSONObject(company);
                            companyName = jsonCmny.getString("name");
                        }
                        Log.e("COMPANYY",companyName);
                        String picUrl = "https://randomuser.me/api/portraits/men/3.jpg";
                        if(c.getString("profile_image") != null && c.getString("profile_image") != "null"){
                            picUrl = c.getString("profile_image");
                        }
                        dataModel.setProfile_image(picUrl);
                        dataModel.setPhone(c.getString("phone"));
                        dataModel.setEmail(c.getString("email"));
                        dataModel.setWebsite(c.getString("website"));
                        dataModel.setCompanyName(companyName);
                        mDataList.add(dataModel);

                        // Toast.makeText(getApplicationContext(), title, Toast.LENGTH_LONG).show();
                    }
                    //adapter = new EmpAdapter(MainActivity.this, id_array);
                    //l.setAdapter(adapter);

                    adapter = new MyAdapter(MainActivity.this, mDataList);
                    listView.setAdapter(adapter);
                    //adapter= new ListAdapter(mDataList,MainActivity.this);

                    //listView.setAdapter(adapter);

                }
                catch (Exception e)
                {}
            }
        }
    }

}
