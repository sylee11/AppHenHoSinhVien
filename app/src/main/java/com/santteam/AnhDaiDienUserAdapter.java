package com.santteam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.santteam.apphenhosinhvien.R;

import java.util.List;

/**
 * Created by nqait on 9/15/2017.
 */

public class AnhDaiDienUserAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<AnhDaiDienUser> anhDaiDienUsers;

    public AnhDaiDienUserAdapter(Context context, int layout, List<AnhDaiDienUser> anhDaiDienUsers) {
        this.context = context;
        this.layout = layout;
        this.anhDaiDienUsers = anhDaiDienUsers;
    }

    @Override
    public int getCount() {
        return anhDaiDienUsers.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public  class ViewHolder{
        ImageView imgAnhDaiDien;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null)
        {
            viewHolder = new ViewHolder();
            //tao context
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout,null);
            //Ánh xạ view
            viewHolder.imgAnhDaiDien = (ImageView)view.findViewById(R.id.imvAnhDaiDien);
            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }
        //Gán giá tri
        AnhDaiDienUser anhDaiDienUser = anhDaiDienUsers.get(i);
        viewHolder.imgAnhDaiDien.setImageResource(anhDaiDienUser.getAnhDaiDien());
        return view;
    }

    //tạo conten

}
