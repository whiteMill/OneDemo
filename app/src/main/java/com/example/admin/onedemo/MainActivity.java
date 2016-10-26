package com.example.admin.onedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.umeng.message.PushAgent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    private TextView mTextView;
    private ListView mListView;
    private HandVew mHandView;
    private ArrayList<User> userArrayList = null;
    private UserAdapter userAdapter;

    private String[] name = new String[]{
            "潘粤明", "戴军", "薛之谦", "蓝雨", "任泉", "张杰", "秦俊杰",
            "陈坤", "田亮", "夏雨", "保剑锋", "陆毅", "乔振宇", "吉杰", "郭敬明", "巫迪文", "欢子", "井柏然",
            "左小祖咒", "段奕宏", "毛宁", "樊凡", "汤潮", "山野", "陈龙", "侯勇", "俞思远", "冯绍峰", "崔健",
            "杜淳", "张翰", "彭坦", "柏栩栩", "蒲巴甲", "凌潇肃", "毛方圆", "武艺", "耿乐", "钱泳辰"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PushAgent.getInstance(this).onAppStart();
        initView();
        initDate();
        mHandView.setmTextView(mTextView);
        mHandView.setOnTouchCharacterListener(new HandVew.onTouchCharacterListener() {
            @Override
            public void touchCharacterListener(String s) {
                    int position = userAdapter.getSelection(s);
                    Log.d("DDD",position+"");
                    if(position!=-1){
                        mListView.setSelection(position);
                    }
            }
        });
    }

    private void initView(){
        mEditText = (EditText) findViewById(R.id.mEditText);
        mTextView = (TextView) findViewById(R.id.mTextView);
        mListView = (ListView) findViewById(R.id.mListView);
        mHandView = (HandVew) findViewById(R.id.mHandView);
    }

    private void initDate(){
        userArrayList = new ArrayList<>();
        for(int i=0;i<name.length;i++){
          userArrayList.add(new User(name[i],CharacterUtils.getFirstSpell(name[i]).toUpperCase()));
        }
        Collections.sort(userArrayList, new Comparator<User>() {
            @Override
            public int compare(User userOne, User userTwo) {
                return userOne.getFirstCharacter().compareTo(userTwo.getFirstCharacter());
            }
        });
        userAdapter  =  new UserAdapter(this,userArrayList);
        mListView.setAdapter(userAdapter);
    }
}
