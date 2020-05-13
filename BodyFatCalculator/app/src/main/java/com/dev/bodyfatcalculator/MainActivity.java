package com.dev.bodyfatcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.bodyfatcalculator.model.Profile;
import com.dev.bodyfatcalculator.viewmodel.CalculatorViewModel;

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

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.mainContainer, new CalculatorFragment())
                .commit();

    }


}
