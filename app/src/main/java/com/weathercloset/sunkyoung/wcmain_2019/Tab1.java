package com.weathercloset.sunkyoung.wcmain_2019;

/**
 * Created by SunKyoung on 2019-03-10.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.weathercloset.sunkyoung.wcmain_2019.Request.GetClothesRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static android.support.v7.content.res.AppCompatResources.getDrawable;


public class Tab1 extends Fragment {
    private Activity ctx;
    TextView  cityField, detailsField, currentTemperatureField, humidity_field, wind_field, weatherIcon, updatedField;
    ImageButton BtnLocation;
//    ProgressBar loader;
    Typeface weatherFont;
    String city = "Seoul, KR";
    ListView listforecastview;

    ScrollView scrollView;

    String wc_1 = null;
    String wc_2 = null;
    String wc_3 = null;
    String wc_4 = null;
    String wc_5 = null;
    String wc_6 = null;
    String wc_7 = null;
    String wc_8 = null;
    String wc_9 = null;
    String wc_10 = null;

    RecyclerView recyclerView1, recyclerView2, recyclerView3, recyclerView4;
    /* Please Put your API KEY here */
    private String OPEN_WEATHER_MAP_API = "c546ec57ad58273d9e4c1bbea6f1c672";

    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Activity) {
            ctx = (Activity) context;
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View v = inflater.inflate(R.layout.fragment_tab1, container, false);
//
        scrollView = (ScrollView) inflater.inflate(R.layout.fragment_tab1, container, false);
//        recyclerView1 = scrollView.findViewById(R.id.recyclerview1) ;
//        recyclerView2 = scrollView.findViewById(R.id.recyclerview2) ;
//        recyclerView3 = scrollView.findViewById(R.id.recyclerview3) ;
//        recyclerView4 = scrollView.findViewById(R.id.recyclerview4) ;
//        ListView listview ;
//        ListViewAdapter adapter;
//
//        // Adapter 생성
//        adapter = new ListViewAdapter() ;
//
//        // 리스트뷰 참조 및 Adapter달기
//        listview = scrollView.findViewById(R.id.listview1);
        listforecastview = scrollView.findViewById(R.id.listforecastview);
//        listview.setAdapter(adapter);
//
//        // 첫 번째 아이템 추가.
//        adapter.addItem(getDrawable(ctx, R.drawable.cardigan_col),
//                getDrawable(ctx, R.drawable.jumper_col),getDrawable(ctx, R.drawable.coat_col),
//                getDrawable(ctx, R.drawable.coat),getDrawable(ctx, R.drawable.cardigan),
//                "OUTER") ;
//        // 두 번째 아이템 추가.
//        adapter.addItem(getDrawable(ctx, R.drawable.shirt_col),
//                getDrawable(ctx, R.drawable.tshirt_col),getDrawable(ctx, R.drawable.hoodie_col),
//                getDrawable(ctx, R.drawable.hoodie),getDrawable(ctx, R.drawable.tshirt),
//                "TOP") ;
//        // 세 번째 아이템 추가.
//        adapter.addItem(getDrawable(ctx, R.drawable.dungarees_col),
//                getDrawable(ctx, R.drawable.trousers_col),getDrawable(ctx, R.drawable.shorts_col),
//                getDrawable(ctx, R.drawable.dungarees),getDrawable(ctx, R.drawable.trousers),
//                "BOTTOM") ;
//        adapter.addItem(getDrawable(ctx, R.drawable.umbrella_col),
//                getDrawable(ctx, R.drawable.umbrella),getDrawable(ctx, R.drawable.gasmask_col),
//                getDrawable(ctx, R.drawable.gasmask),getDrawable(ctx, R.drawable.gasmask),
//                "ETC ITEM") ;

//
//        Response.Listener<String> responseListener = new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
//                    Log.d("responseee", "out");
//                    JSONObject jsonResponse = new JSONObject(response);
//                    boolean success = jsonResponse.getBoolean("success");
//
//
//                    if (success) {
//                        Log.d("success!!", "s");
//                        wc_1 = jsonResponse.getString("wc_1");
//                        wc_2 = jsonResponse.getString("wc_2");
//                        wc_3 = jsonResponse.getString("wc_3");
//                        wc_4 = jsonResponse.getString("wc_4");
//                        wc_5 = jsonResponse.getString("wc_5");
//                        wc_6 = jsonResponse.getString("wc_6");
//                        wc_7 = jsonResponse.getString("wc_7");
//                        wc_8 = jsonResponse.getString("wc_8");
//                        wc_9 = jsonResponse.getString("wc_9");
//                        wc_10 = jsonResponse.getString("wc_10");
//                        Log.d("table1:", wc_1);
//                        Log.d("table2:", wc_2);
//                        Log.d("table3:", wc_3);
//                        Log.d("table4:", wc_4);
//                        Log.d("table5:", wc_5);
//                        Log.d("table6:", wc_6);
//                        Log.d("table7:", wc_7);
//                        Log.d("table8:", wc_8);
//                        Log.d("table9:", wc_9);
//                        Log.d("table10:", wc_10);
//
//                        //setRecyclerView(wc_1,wc_2,wc_3,wc_4,wc_5,wc_6,wc_7,wc_8,wc_9,wc_10);
//
//                    } else {
//                        Log.d("fail!!", "f");
//                        Toast.makeText(getContext(),"no data", Toast.LENGTH_SHORT).show();
//                    }
//
//                } catch (JSONException e) {
//                    Log.d("exception!!", "f");
//                    e.printStackTrace();
//                }
//            }
//        };
//
//
//        GetClothesRequest getRequest = new GetClothesRequest("-15", "3", responseListener);
//        RequestQueue queue = Volley.newRequestQueue(getContext());
//        queue.add(getRequest);
//        queue.start();






        // 날씨
        cityField = (TextView) scrollView.findViewById(R.id.city_field);
        updatedField = (TextView) scrollView.findViewById(R.id.updated_field);
        detailsField = (TextView) scrollView.findViewById(R.id.details_field);
        currentTemperatureField = (TextView) scrollView.findViewById(R.id.current_temperature_field);
        wind_field = (TextView) scrollView.findViewById(R.id.wind_field);
        humidity_field = (TextView) scrollView.findViewById(R.id.humidity_field);
        weatherIcon = (TextView) scrollView.findViewById(R.id.weather_icon);
        Typeface weatherFont = getResources().getFont(R.font.weathericons_regular_webfont);
        weatherIcon.setTypeface(weatherFont);
        BtnLocation = scrollView.findViewById(R.id.btn_location);



        BtnLocation.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);
                alertDialog.setTitle("Change City");
                final EditText input = new EditText(ctx);
                input.setText(city);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);

                alertDialog.setPositiveButton("Change",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                city = input.getText().toString();
                                taskLoadUp(city);
                            }
                        });
                alertDialog.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                alertDialog.show();
            }
        });

        taskLoadUp(city);
      taskforecastLoadUp(city);

        return scrollView;
    }

    // current weather
    public void taskLoadUp(String query) {
        if (Function.isNetworkAvailable(ctx.getApplicationContext())) {
            DownloadWeather task = new DownloadWeather();
            task.execute(query);
        } else {
            Toast.makeText(ctx.getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
        }
    }

    class DownloadWeather extends AsyncTask< String, Void, String > {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }
        protected String doInBackground(String...args) {
            String xml = Function.excuteGet("http://api.openweathermap.org/data/2.5/weather?q=" + args[0] +
                    "&units=metric&lang=kr&appid=" + OPEN_WEATHER_MAP_API);

            return xml;
        }
        @Override
        protected void onPostExecute(String xml) {

            try {
                    JSONObject json = new JSONObject(xml);
                if (json != null) {
                    JSONObject details = json.getJSONArray("weather").getJSONObject(0);
                    JSONObject main = json.getJSONObject("main");
                    JSONObject wind = json.getJSONObject("wind");
                    DateFormat df = DateFormat.getDateTimeInstance();

                    cityField.setText(json.getString("name").toUpperCase(Locale.KOREA) + ", " + json.getJSONObject("sys").getString("country"));
                    detailsField.setText(details.getString("description").toUpperCase(Locale.KOREA));
                    currentTemperatureField.setText(String.format("%.2f", main.getDouble("temp")) + "°");

                    wind_field.setText("풍속: "+wind.getString("speed")+"m/s");
                    humidity_field.setText("습도: " + main.getString("humidity") + "%");

                    updatedField.setText(Function.convertUnixToDate(json.getLong("dt")));
                    weatherIcon.setText(Html.fromHtml(Function.setWeatherIcon(details.getInt("id"),
                            json.getJSONObject("sys").getLong("sunrise") * 1000,
                            json.getJSONObject("sys").getLong("sunset") * 1000)));

                    String avg_temp = String.valueOf((main.getDouble("temp_max")+main.getDouble("temp_min"))/2);
                    String weather_param = String.format("%d", main.getInt("temp"));
                    String wind_param = wind.getString("speed");

                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                Log.d("responseee", "out");
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");


                                if (success) {
                                    Log.d("success!!", "s");
                                    String wc_1 = jsonResponse.getString("wc_1");
                                    String wc_2 = jsonResponse.getString("wc_2");
                                    String wc_3 = jsonResponse.getString("wc_3");
                                    String wc_4 = jsonResponse.getString("wc_4");
                                    String wc_5 = jsonResponse.getString("wc_5");
                                    String wc_6 = jsonResponse.getString("wc_6");
                                    String wc_7 = jsonResponse.getString("wc_7");
                                    String wc_8 = jsonResponse.getString("wc_8");
                                    String wc_9 = jsonResponse.getString("wc_9");
                                    String wc_10 = jsonResponse.getString("wc_10");
                                    Log.d("table1:", wc_1);
                                    Log.d("table2:", wc_2);
                                    Log.d("table3:", wc_3);
                                    Log.d("table4:", wc_4);
                                    Log.d("table5:", wc_5);
                                    Log.d("table6:", wc_6);
                                    Log.d("table7:", wc_7);
                                    Log.d("table8:", wc_8);
                                    Log.d("table9:", wc_9);
                                    Log.d("table10:", wc_10);
                                    setRecyclerView(wc_1,wc_2,wc_3,wc_4,wc_5,wc_6,wc_7,wc_8,wc_9,wc_10);

                                } else {
                                    Log.d("fail!!", "f");
                                    Toast.makeText(getContext(),"no data", Toast.LENGTH_SHORT).show();
                                }

                            } catch (JSONException e) {
                                Log.d("exception!!", "f");
                                e.printStackTrace();
                            }
                        }
                    };

                    String weather_param1 =  "-15"; String wind_param1 = "3";
                    GetClothesRequest getRequest = new GetClothesRequest(weather_param1, wind_param1, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(getContext());
                    queue.add(getRequest);
                    queue.start();


                }
            } catch (JSONException e) {
                Toast.makeText(ctx.getApplicationContext(), "Error, Check City", Toast.LENGTH_SHORT).show();
            }


        }

    }

    public void setRecyclerView( String wc_1,String wc_2,String wc_3,String wc_4,String wc_5,String wc_6,String wc_7,String wc_8,String wc_9,String wc_10){


        recyclerView1 = scrollView.findViewById(R.id.recyclerview1) ;
        recyclerView2 = scrollView.findViewById(R.id.recyclerview2) ;
        recyclerView3 = scrollView.findViewById(R.id.recyclerview3) ;
        recyclerView4 = scrollView.findViewById(R.id.recyclerview4) ;
        ///////////////////////////////////////////////////////////////////////////
        //Outer recyclerview
        ///////////////////////////////////////////////////////////////////////////
        recyclerView1.setLayoutManager(new LinearLayoutManager(ctx , LinearLayoutManager.HORIZONTAL, false)) ;


        ArrayList<RecyclerViewItem> list_item1= new ArrayList<RecyclerViewItem> ();
        list_item1.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.cardigan_col), wc_1));
        list_item1.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.jumper_col), wc_2));
        list_item1.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.coat_col), wc_3));
        list_item1.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.coat), wc_4));


        RecyclerViewAdapter recycler_adapter1 = new  RecyclerViewAdapter(list_item1) ;
        recyclerView1.setAdapter(recycler_adapter1) ;


        ///////////////////////////////////////////////////////////////////////////
        //Top recyclerview
        ///////////////////////////////////////////////////////////////////////////
        recyclerView2.setLayoutManager(new LinearLayoutManager(ctx , LinearLayoutManager.HORIZONTAL, false)) ;

        ArrayList<RecyclerViewItem> list_item2= new ArrayList<RecyclerViewItem> ();
        list_item2.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.shirt_col), wc_5));
        list_item2.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.tshirt_col), wc_6));
        list_item2.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.hoodie_col), wc_7));
        list_item2.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.hoodie), wc_8));

        RecyclerViewAdapter recycler_adapter2 = new  RecyclerViewAdapter(list_item2) ;
        recyclerView2.setAdapter(recycler_adapter2) ;

        ///////////////////////////////////////////////////////////////////////////
        //Bottom recyclerview
        ///////////////////////////////////////////////////////////////////////////
        recyclerView3.setLayoutManager(new LinearLayoutManager(ctx , LinearLayoutManager.HORIZONTAL, false)) ;

        ArrayList<RecyclerViewItem> list_item3 = new ArrayList<RecyclerViewItem> ();
        list_item3.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.dungarees_col), wc_9));
        list_item3.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.trousers_col), wc_10));

        RecyclerViewAdapter recycler_adapter3 = new  RecyclerViewAdapter(list_item3) ;
        recyclerView3.setAdapter(recycler_adapter3) ;


        ///////////////////////////////////////////////////////////////////////////
        //ETC recyclerview
        ///////////////////////////////////////////////////////////////////////////
        recyclerView4.setLayoutManager(new LinearLayoutManager(ctx , LinearLayoutManager.HORIZONTAL, false)) ;

        ArrayList<RecyclerViewItem> list_item4 = new ArrayList<RecyclerViewItem> ();
        list_item4.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.umbrella_col), "0"));
        list_item4.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.umbrella), "0"));
        list_item4.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.gasmask_col), "0"));

        RecyclerViewAdapter recycler_adapter4 = new  RecyclerViewAdapter(list_item4) ;
        recyclerView4.setAdapter(recycler_adapter4) ;

    }




    // forecast weather
    public void taskforecastLoadUp(String query) {
        if (Function.isNetworkAvailable(ctx.getApplicationContext())) {
            DownloadWeatherForecast task = new DownloadWeatherForecast();
            task.execute(query);
        } else {
            Toast.makeText(ctx.getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
        }
    }

    class DownloadWeatherForecast extends AsyncTask< String, Void, String > {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }
        protected String doInBackground(String...args) {
            String xml = Function.excuteGet("http://api.openweathermap.org/data/2.5/forecast?q=" + args[0] +
                    "&units=metric&lang=kr&appid=" + OPEN_WEATHER_MAP_API);

            return xml;
        }
        @Override
        protected void onPostExecute(String xml) {

            try {
                JSONObject json = new JSONObject(xml);
                if (json != null) {
                    JSONArray details = json.getJSONArray("list");

                    Log.d("json", String.valueOf(json));
                    ListViewForecastAdapter listViewForecastAdapter;
                    listViewForecastAdapter = new ListViewForecastAdapter();
                    listforecastview.setAdapter(listViewForecastAdapter);
                    String dt_diff = new SimpleDateFormat("yyyy년 MM월 dd일 EEE").format(new Date());
                    Log.d("today",dt_diff);
                    for(int i=0; i<details.length(); i++){
                        JSONObject jsonObject = details.getJSONObject(i);
                        if(dt_diff.equals(Function.convertUnixToDate(jsonObject.getLong("dt")))) continue;
                        listViewForecastAdapter.addItem(
                                Function.convertUnixToDay(jsonObject.getLong("dt")),
                                Html.fromHtml(Function.setForecastWeatherIcon(jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id"))),
                                String.format("%d",jsonObject.getJSONObject("main").getInt("temp_min"))+"/"+String.format("%d",jsonObject.getJSONObject("main").getInt("temp_max"))
                            );
                        dt_diff = Function.convertUnixToDate(jsonObject.getLong("dt"));
                    }

                }
            } catch (JSONException e) {
                Toast.makeText(ctx.getApplicationContext(), "Error, Check City", Toast.LENGTH_SHORT).show();
            }


        }

    }

}

