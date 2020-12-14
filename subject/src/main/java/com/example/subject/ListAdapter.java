package com.example.subject;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    LayoutInflater inflater = null;
    private ArrayList<ItemData> myData = null;
    private int listCnt = 0;

    public ListAdapter(ArrayList<ItemData> data) {
        myData = data;
        listCnt = myData.size();
    }

    @Override
    public int getCount() {
        return listCnt;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int i) {
        return myData.get(i);
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(Drawable icon, String Name, String PhoneNum, String Address) {
        ItemData item = new ItemData();

        item.setIcon(icon);
        item.setStrName(Name);
        item.setStrNum(PhoneNum);
        item.setStrAddr(Address);

        myData.add(item);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            final Context context = viewGroup.getContext();
            if (inflater == null) {
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }
            view = inflater.inflate(R.layout.listview_item, viewGroup, false);
        }

        ImageView Icon = (ImageView) view.findViewById(R.id.icon);
        TextView Name = (TextView) view.findViewById(R.id.Name);
        TextView PhoneNum = (TextView) view.findViewById(R.id.PhoneNum);
        TextView Address = (TextView) view.findViewById(R.id.Address);

        Icon.setImageDrawable(myData.get(i).getIcon());
        Name.setText(myData.get(i).getStrName());
        PhoneNum.setText(myData.get(i).getStrNum());
        Address.setText(myData.get(i).getStrAddr());

        return view;
    }


}
