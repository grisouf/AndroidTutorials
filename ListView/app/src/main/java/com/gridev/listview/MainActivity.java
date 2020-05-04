package com.gridev.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

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


        // Spinner
        Spinner spinner = findViewById(R.id.mainSpinner);
        spinner.setAdapter(
                // Create new Adapter
                new ArrayAdapter<User>(this, android.R.layout.simple_list_item_1, userList)
        );


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               String user = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, user, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // do nothing here;
            }
        });
    }
}
