package com.weathercloset.sunkyoung.wcmain_2019;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder> {


    private ArrayList<RecyclerViewItem> mData = null ;

    //아이템 클릭시 실행 함수
    private ItemClick itemClick;
    public interface ItemClick {
        public void onClick(View view,int position);
    }

    //아이템 클릭시 실행 함수 등록 함수
    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder{


        ImageView imageView;
        TextView textView;

        ViewHolder(View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            imageView = itemView.findViewById(R.id.image_item);
            textView = itemView.findViewById(R.id.text_item) ;

            // 하나의 카드뷰마다 클릭 리스너 적용

            imageView.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View view) {

                    // 액티비티 이동

                    // Intent i = new Intent(view.getContext(), SubActivity.class);

                    // view.getContext().startActivity(i);
                    Toast.makeText(view.getContext(), "Click!", Toast.LENGTH_SHORT).show();
                    mData.get( getPosition()).setCount(String.valueOf(Integer.parseInt(mData.get( getPosition()).getCount())+1));
                    textView.setText(mData.get( getPosition()).getCount());

                }

            });

        }

//
    }


    // 생성자에서 데이터 리스트 객체를 전달받음.
    RecyclerViewAdapter2(ArrayList<RecyclerViewItem> item) {
        mData = item;
    }






    @NonNull
    @Override
    public RecyclerViewAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.recycler_item, parent, false) ;
        RecyclerViewAdapter2.ViewHolder vh = new ViewHolder(view) ;

        return vh ;

    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter2.ViewHolder holder, final int position) {
        RecyclerViewItem item = mData.get(position) ;

        holder.imageView.setImageDrawable(item.getIcon());
        holder.textView.setText(item.getCount());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemClick != null){
                    itemClick.onClick(v, position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size() ;
    }
}
