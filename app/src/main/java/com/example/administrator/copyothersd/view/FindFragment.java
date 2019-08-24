package com.example.administrator.copyothersd.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.copyothersd.R;


public class FindFragment extends Fragment {

View mView;
private ImageView img;
private int count=0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_find,null);
        }

        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        img = mView.findViewById(R.id.changeImg);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;
                if(count==1){
                    img.setImageResource(R.drawable.heart);
                }else if(count==2){
                    img.setImageResource(R.drawable.hand);
                }else if(count==3){
                    img.setImageResource(R.drawable.drink);
                    count=0;

                }else if(count==0){
                    img.setImageResource(R.drawable.hand);
                }
            }
        });
    }
}
