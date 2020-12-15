package com.example.subject;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {
    Context context;
    int layoutId;
    ArrayList<ContactData> contactDataArrayList;
    LayoutInflater Inflater;

    ContactAdapter(Context _context, int _layoutId, ArrayList<ContactData> _ContactDataArr) {
        context = _context;
        layoutId = _layoutId;
        contactDataArrayList = _ContactDataArr;
        Inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return contactDataArrayList.size();
    }

    @Override
    public String getItem(int position) {
        return contactDataArrayList.get(position).name;

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        if (convertView == null) {
            convertView = Inflater.inflate(layoutId, parent, false);
        }
        TextView ContactName = (TextView) convertView.findViewById(R.id.listName);
        ContactName.setText(contactDataArrayList.get(position).name);

        TextView ContactPhone = (TextView) convertView.findViewById(R.id.listPhone);
        ContactPhone.setText(contactDataArrayList.get(position).phone);

        TextView ContactAddress = (TextView) convertView.findViewById(R.id.listAddress);
        ContactAddress.setText(contactDataArrayList.get(position).address);

        return convertView;
    }

}