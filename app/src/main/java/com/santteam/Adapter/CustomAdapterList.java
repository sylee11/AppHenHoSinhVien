package com.santteam.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.santteam.AnhDaiDienUserAdapter;
import com.santteam.apphenhosinhvien.R;
import com.santteam.model.ContactList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 9/16/2017.
 */

public class CustomAdapterList extends ArrayAdapter<ContactList>{
    private Context context;
    private int resource;
    private List<ContactList> arrContact;
    Button btn_backchat;


    public CustomAdapterList(Context context, int resource,  ArrayList<ContactList> arrContact) {
        super(context, resource, arrContact);
        this.context = context;
        this.resource = resource;
        this.arrContact = arrContact;
    }
    public class ViewHolder {
        TextView tv_namelist;
        TextView tv_avatar;
        TextView tv_contentlist;
    }
    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.show_listchat, parent, false);
            viewHolder.tv_namelist = (TextView) convertView.findViewById(R.id.tv_namelist);
            viewHolder.tv_avatar = (TextView) convertView.findViewById(R.id.tv_avatar);
            viewHolder.tv_contentlist = (TextView) convertView.findViewById(R.id.tv_contentlist);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ContactList contactList = arrContact.get(position);
        viewHolder.tv_avatar.setBackgroundColor(contactList.getAvatar());
        viewHolder.tv_avatar.setText(String.valueOf(position+1));
        viewHolder.tv_namelist.setText(contactList.getName());
        viewHolder.tv_contentlist.setText(contactList.getContent());
        return convertView;
    }
}
