package com.example.admin.onedemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by wl on 2016/10/13.
 */
public class UserAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<User> users;

    public UserAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_adapter, null);
            viewHolder.tv_firstCharacter = (TextView) convertView.findViewById(R.id.tv_firstCharacter);
            viewHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        if (position == 0) {
            viewHolder.tv_firstCharacter.setText(users.get(position).getFirstCharacter());
            viewHolder.tv_name.setText(users.get(position).getUsername());
        } else {
            if (CharacterUtils.getCnAscii(users.get(position).getFirstCharacter().charAt(0)) > CharacterUtils.getCnAscii(users.get(position - 1).getFirstCharacter().charAt(0))) {
                viewHolder.tv_firstCharacter.setVisibility(View.VISIBLE);
                viewHolder.tv_firstCharacter.setText(users.get(position).getFirstCharacter());
                viewHolder.tv_name.setText(users.get(position).getUsername());
            } else {
                viewHolder.tv_firstCharacter.setVisibility(View.GONE);
                viewHolder.tv_name.setText(users.get(position).getUsername());
            }

        }
        return convertView;
    }

    private class ViewHolder {
        private TextView tv_firstCharacter;
        private TextView tv_name;
    }

    //通过字符查找位置
    public int getSelection(String s){
        Log.d("CCC",s);
        for(int i=0;i<getCount();i++){
            String firStr = users.get(i).getFirstCharacter();
            Log.d("CCC",firStr+"字母");
            if(firStr.equals(s)){
                return i;
            }
        }
        return -1;
    }
}
