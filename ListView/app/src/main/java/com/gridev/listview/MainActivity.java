package com.gridev.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<User> userList = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userList.add(new User("Name 1", 22));
        userList.add(new User("Name 2", 23));
        userList.add(new User("Name 3", 20));
        userList.add(new User("Name 4", 24));

        ListView listView = findViewById(R.id.mainListView);

        UserItemAdapter adapter =
                new UserItemAdapter(this, R.layout.card_item_user, userList);
        listView.setAdapter(adapter);

    }
}
