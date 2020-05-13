package com.dev.bodyfatcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.dev.bodyfatcalculator.model.Profile;
import com.dev.bodyfatcalculator.viewmodel.CalculatorViewModel;
import com.dev.bodyfatcalculator.views.CalculatorFragment;
import com.dev.bodyfatcalculator.views.HistoryFragment;
import com.dev.bodyfatcalculator.views.HomeFragment;

public class MainActivity extends AppCompatActivity {

    // Views
    private EditText age;
    private EditText height;
    private EditText weight;

    private RadioButton female;

    private Button calculate;

    private ImageView image;

    private TextView result;

    // Variables
    private Profile profile = null;

    private int min;
    private int max;

    private CalculatorViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeFragment home = new HomeFragment();
        home.setOnHomeFragmentListener(new HomeFragment.OnHomeFragmentListener() {
            @Override
            public void onCalculatorClick() {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.mainContainer, new CalculatorFragment())
                        .addToBackStack("calculator")
                        .commit();

            }

            @Override
            public void onHistoryClick() {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.mainContainer, new HistoryFragment())
                        .addToBackStack("calculator")
                        .commit();
            }
        });

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.mainContainer, home)
                .commit();

    }


}
