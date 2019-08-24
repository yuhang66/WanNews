package com.example.administrator.copyothersd.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.copyothersd.R;
import com.example.administrator.copyothersd.adapter.NewsShowAdapter;
import com.example.administrator.copyothersd.entity.NewsEntity;
import com.example.administrator.copyothersd.service.ShowService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class ChatFragment extends Fragment {
    private String link,type,key;
    private RecyclerView recyclerView;
    View mView;
    private List<NewsEntity.ResultBean.DataBean> resultBeans;
    private NewsShowAdapter adapter;
    NewsEntity.ResultBean.DataBean dataBean;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_layout,null);
        }
       // ((TextView)mView.findViewById(R.id.chat)).setText("聊天界面");
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = mView.findViewById(R.id.show_recycler);//列表
        link = getString(R.string.link);
        type = "top";
        key="c953b86602bed455fb3b52e979d09912";
        post(type,key);
    }

    private void post(String type, String key) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(link)//基础URL 建议以 / 结尾
                .addConverterFactory(GsonConverterFactory.create())//设置 Json 转换器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//RxJava 适配器
                .build();
        ShowService workPlaneService = retrofit.create(ShowService.class);
        workPlaneService.getnews(type, key)
                .subscribeOn(Schedulers.io())//IO线程加载数据
                .observeOn(AndroidSchedulers.mainThread())//主线程显示数据
                .subscribe(new Subscriber<NewsEntity>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NewsEntity newsEntity) {
                        if(newsEntity.getReason().equals("成功的返回")){
                            resultBeans = new ArrayList<NewsEntity.ResultBean.DataBean>();
                            for(int i=0;i<newsEntity.getResult().getData().size();i++){
                                resultBeans.add(new NewsEntity.ResultBean.DataBean(newsEntity.getResult().getData().get(i).getTitle(),newsEntity.getResult().getData().get(i).getThumbnail_pic_s(),newsEntity.getResult().getData().get(i).getUrl()));

                            }
                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                             adapter = new NewsShowAdapter(resultBeans,getActivity());

                            recyclerView.setAdapter(adapter);
                        }else {
                            Toast.makeText(getActivity(),"请求失败，请重试",Toast.LENGTH_SHORT).show();
                        }
                       adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                           @Override
                           public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                               dataBean = resultBeans.get(position);
                               Intent intent = new Intent(getActivity(),ShowMore.class);
                               intent.putExtra("wow",dataBean.getUrl());
                               startActivity(intent);
                           }
                       });


                    }
                });
    }

}






