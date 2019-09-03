package com.weathercloset.sunkyoung.wcmain_2019;

/**
 * Created by SunKyoung on 2019-03-10.
 */

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.support.v7.content.res.AppCompatResources.getDrawable;

public class Tab2 extends Fragment {
    private Activity ctx;

    RecyclerView recyclerView1;
    RecyclerView recyclerView2;
    RecyclerView recyclerView3;
    RecyclerView recyclerView4;
    ArrayList<RecyclerViewItem> list_item4;
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

        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_tab2, container, false);
//        ListView listview ;
//        ListViewAdapter2 adapter;
//
//        // Adapter 생성
//        adapter = new ListViewAdapter2() ;
//
//        // 리스트뷰 참조 및 Adapter달기
//        listview = linearLayout.findViewById(R.id.listview2);
//        listview.setAdapter(adapter);
//
//        // 첫 번째 아이템 추가.
//        adapter.addItem(getDrawable(ctx, R.drawable.cardigan_col),
//                getDrawable(ctx, R.drawable.jumper_col),getDrawable(ctx, R.drawable.coat_col),
//                getDrawable(ctx, R.drawable.coat),getDrawable(ctx, R.drawable.cardigan),
//                "0","0","0","0","0",
//                "OUTER") ;
//        // 두 번째 아이템 추가.
//        adapter.addItem(getDrawable(ctx, R.drawable.shirt_col),
//                getDrawable(ctx, R.drawable.tshirt_col),getDrawable(ctx, R.drawable.hoodie_col),
//                getDrawable(ctx, R.drawable.hoodie),getDrawable(ctx, R.drawable.tshirt),
//                "0","0","0","0","0",
//                "TOP") ;
//        // 세 번째 아이템 추가.
//        adapter.addItem(getDrawable(ctx, R.drawable.dungarees_col),
//                getDrawable(ctx, R.drawable.trousers_col),getDrawable(ctx, R.drawable.shorts_col),
//                getDrawable(ctx, R.drawable.dungarees),getDrawable(ctx, R.drawable.trousers),
//                "0","0","0","0","0",
//                "BOTTOM") ;
//        adapter.addItem(getDrawable(ctx, R.drawable.umbrella_col),
//                getDrawable(ctx, R.drawable.umbrella),getDrawable(ctx, R.drawable.gasmask_col),
//                getDrawable(ctx, R.drawable.gasmask),getDrawable(ctx, R.drawable.gasmask),
//                "0","0","0","0","0",
//                "ETC") ;
        // Inflate the layout for this fragment

        recyclerView1 = linearLayout.findViewById(R.id.recyclerview_tab2_outer) ;
        recyclerView2 = linearLayout.findViewById(R.id.recyclerview_tab2_top) ;
        recyclerView3 = linearLayout.findViewById(R.id.recyclerview_tab2_bottom) ;
        recyclerView4 = linearLayout.findViewById(R.id.recyclerview_tab2_etc) ;
        ///////////////////////////////////////////////////////////////////////////
        //Outer recyclerview
        ///////////////////////////////////////////////////////////////////////////
        recyclerView1.setLayoutManager(new LinearLayoutManager(ctx , LinearLayoutManager.HORIZONTAL, false)) ;


        ArrayList<RecyclerViewItem> list_item1= new ArrayList<RecyclerViewItem> ();
        list_item1.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.cardigan_col), "0"));
        list_item1.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.jumper_col),"0"));
        list_item1.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.coat_col), "0"));
        list_item1.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.coat), "0"));


        RecyclerViewAdapter2 recycler_adapter1 = new  RecyclerViewAdapter2(list_item1) ;
        recyclerView1.setAdapter(recycler_adapter1) ;


        ///////////////////////////////////////////////////////////////////////////
        //Top recyclerview
        ///////////////////////////////////////////////////////////////////////////
        recyclerView2.setLayoutManager(new LinearLayoutManager(ctx , LinearLayoutManager.HORIZONTAL, false)) ;

        ArrayList<RecyclerViewItem> list_item2= new ArrayList<RecyclerViewItem> ();
        list_item2.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.shirt_col), "0"));
        list_item2.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.tshirt_col),"0"));
        list_item2.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.hoodie_col), "0"));
        list_item2.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.hoodie), "0"));

        RecyclerViewAdapter2 recycler_adapter2 = new  RecyclerViewAdapter2(list_item2) ;
        recyclerView2.setAdapter(recycler_adapter2) ;

        ///////////////////////////////////////////////////////////////////////////
        //Bottom recyclerview
        ///////////////////////////////////////////////////////////////////////////
        recyclerView3.setLayoutManager(new LinearLayoutManager(ctx , LinearLayoutManager.HORIZONTAL, false)) ;

        ArrayList<RecyclerViewItem> list_item3 = new ArrayList<RecyclerViewItem> ();
        list_item3.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.dungarees_col), "0"));
        list_item3.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.trousers_col), "0"));

        RecyclerViewAdapter2 recycler_adapter3 = new  RecyclerViewAdapter2(list_item3) ;
        recyclerView3.setAdapter(recycler_adapter3) ;


        ///////////////////////////////////////////////////////////////////////////
        //ETC recyclerview
        ///////////////////////////////////////////////////////////////////////////
        recyclerView4.setLayoutManager(new LinearLayoutManager(ctx , LinearLayoutManager.HORIZONTAL, false)) ;

        list_item4 = new ArrayList<RecyclerViewItem> ();
        list_item4.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.umbrella_col), "0"));
        list_item4.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.umbrella), "0"));
        list_item4.add(new RecyclerViewItem(getDrawable(ctx, R.drawable.gasmask_col), "0"));

        RecyclerViewAdapter2 recycler_adapter4 = new  RecyclerViewAdapter2(list_item4) ;

        recyclerView4.setAdapter(recycler_adapter4) ;

//        recyclerView4.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
//            @Override
//            public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
//                return false;
//            }
//
//            @Override
//            public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
//
//                View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
//                int position = recyclerView.getChildAdapterPosition(child);
//                Toast.makeText(ctx, "tfffa", Toast.LENGTH_LONG);
//                list_item4.get(position).setCount(String.valueOf(Integer.parseInt(list_item4.get(position).getCount())+1));
//            }
//
//            @Override
//            public void onRequestDisallowInterceptTouchEvent(boolean b) {
//
//            }
//        });

//        recycler_adapter4.setItemClick(new RecyclerViewAdapter.ItemClick() {
//            @Override
//            public void onClick(View view, int position) {
//
//                list_item4.get(position).setCount(String.valueOf(Integer.parseInt(list_item4.get(position).getCount())+1));
//
//            }
//        });

        return linearLayout;
    }

}
