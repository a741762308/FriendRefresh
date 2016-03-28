package com.jsqix.dq.refresh;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.jsqix.dq.friend.FriendRefreshView;
import com.jsqix.dq.friend.OnRefreshListener;

public class MainActivity extends AppCompatActivity implements OnRefreshListener, FriendRefreshView.OnClickLisenter {
    private FriendRefreshView mWrapListView;
    private BaseAdapter mListAdapter;
    int size = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mListAdapter = new ListAdapter();
        mWrapListView = (FriendRefreshView) findViewById(R.id.wrapview);
        mWrapListView.setAdapter(mListAdapter);
        mWrapListView.setLoadEnable(true);//加载更多
//        mWrapListView.setTopbackground();//修改背景
//        mWrapListView.setTopName();//修改用户名
//        mWrapListView.setTopNameColor();//修改字体颜色
//        mWrapListView.setTopHead();//修改头像
        mWrapListView.setOnRefreshListener(this);
        mWrapListView.setOnItemClickListener(this);
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mWrapListView.stopRefresh();
                size = 10;
                mListAdapter.notifyDataSetChanged();
            }
        }, 2000);
    }

    @Override
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mWrapListView.stopLoadMore();
                if (size >= 50) {
                    Toast.makeText(MainActivity.this, "无更多数据", Toast.LENGTH_LONG).show();
                } else {
                    size += 10;
                    mListAdapter.notifyDataSetChanged();
                }
            }
        }, 2000);
    }

    @Override
    public void OnClick(View v, int position) {
        Toast.makeText(MainActivity.this, "点击" + position, Toast.LENGTH_LONG).show();
    }

    private class ListAdapter extends BaseAdapter {

        public ListAdapter() {

        }

        @Override
        public int getCount() {
            return size;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.list_cell_layout, null);
            }
            return convertView;
        }
    }
}
