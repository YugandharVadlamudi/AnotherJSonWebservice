package com.example.kiran.anotherjsonwebservice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kiran on 04-12-2015.
 */
public class CustomlistAdapter extends BaseAdapter {
    ArrayList<ListData> listData;
    Context context;
    LayoutInflater layoutInflater;
    CustomlistAdapter(Context context,ArrayList<ListData> listData)
    {
        this.context=context;
        this.listData=listData;
        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public ListData getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listData.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HolderClass holderClass;
        if(convertView==null)
        {
            convertView=layoutInflater.inflate(R.layout.listviewstuff,null,false);
            holderClass=new HolderClass(convertView);
            convertView.setTag(holderClass);
        }
        else
        {
            holderClass=(HolderClass)convertView.getTag();
        }
        ListData listData=getItem(position);
        holderClass.tv_title.setText(listData.getTitle());
        holderClass.tv_url.setText(listData.getUrl());
        holderClass.tv_category.setText(listData.getCategory());
        return convertView;
    }
    class HolderClass
    {
        TextView tv_title,tv_url,tv_category,tv_tag_1,tv_tag_2,tv_tag_3;
        HolderClass(View view)
        {
            tv_title=(TextView)view.findViewById(R.id.Tv_title);
            tv_category=(TextView)view.findViewById(R.id.Tv_Catagory);
            tv_url=(TextView)view.findViewById(R.id.Tv_url);
            /*tv_tag_1=(TextView)view.findViewById(R.id.Tv_tag_1);
            tv_tag_2=(TextView)view.findViewById(R.id.Tv_tag_2);
            tv_tag_3=(TextView)view.findViewById(R.id.Tv_tag_3);*/
        }
    }/*holder class*/
}
