package com.example.meeno.appprova;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {
    private ListView roomList;
    private HorizontalScrollView roomHistory;
    private LinearLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabs = (LinearLayout) findViewById(R.id.tabs);
        roomList = (ListView) findViewById(R.id.roomList);

        MyAdapter adapter = new MyAdapter();
        roomList.setAdapter(adapter);
        roomList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Erase old view
                //tabs.removeViewAt(tabs.getChildCount() - 1);

                // Add view
                String name = ((TextView) view.findViewById(R.id.roomName)).getText().toString();
                TextView temp = (TextView) View.inflate(MainActivity.this, R.layout.tab_item, null);
                temp.setText(" > " + name);
                tabs.addView(temp);
            }
        });
    }

    private class MyAdapter extends BaseAdapter {
        private String[] strings = {"room1", "room2", "room3", "room4"};
        private Random rand;

        public MyAdapter() {
            rand = new Random();
        }

        @Override
        public int getCount() {
            return strings.length;
        }

        @Override
        public String getItem(int position) {
            return strings[position];
        }

        @Override
        public long getItemId(int position) {
            return strings[position].hashCode();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_item, parent, false);
            }
            ((TextView) convertView.findViewById(R.id.roomName)).setText(strings[position]);
            ((TextView) convertView.findViewById(R.id.numUsers)).setText("Users: " + String.valueOf(rand.nextInt(200)));
            ((TextView) convertView.findViewById(R.id.numRooms)).setText("Rooms: " + String.valueOf(rand.nextInt(10)));
            return convertView;
        }
    }
}
