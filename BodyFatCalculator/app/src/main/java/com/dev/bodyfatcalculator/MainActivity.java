package com.dev.bodyfatcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        init();

        // Set On Click Listener
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get User Input
               getInput();

               if (profile == null) return;

               // Toast.makeText(MainActivity.this, profile.toString(), Toast.LENGTH_SHORT).show();
                // Show results
                calculate();

            }
        });
    }

    // ctr + O

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.save) {

            saveData();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    // Helper Method

    /**
     *  Views Initialization
     */
    private void init () {

        age = findViewById(R.id.age);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);

        female = findViewById(R.id.female);

        calculate = findViewById(R.id.calculate);

        image = findViewById(R.id.image);

        result = findViewById(R.id.result);

    }

    private void getInput() {

        String mAge = age.getText().toString().trim();
        String mHeight = height.getText().toString().trim();
        String mWeight = weight.getText().toString().trim();

        int mGender;
        if (female.isChecked()) {
            min = 15;
            max = 30;
            mGender = 0;
        }
        else {
            min = 10;
            max = 15;
            mGender = 1;
        }

        // Validate Input
        if (mAge.isEmpty()) {
            age.setError("Enter Age");
            age.requestFocus();
            return;
        }

        if (mHeight.isEmpty()) {
            height.setError("Enter Height");
            height.requestFocus();
            return;
        }

        if (mWeight.isEmpty()) {
            weight.setError("Enter Weight");
            weight.requestFocus();
            return;
        }

        profile = new Profile(Integer.valueOf(mAge), Double.valueOf(mHeight), Double.valueOf(mWeight), mGender);
    }

    private void calculate() {

        double mResult = (1.2 * profile.getWeight() / (profile.getHeight() * profile.getHeight())) +
                0.23 * profile.getAge() - 10.83 * profile.getGender() - 0.54;

        result.setText(String.valueOf(mResult));

        if (mResult < min ) {
            image.setImageResource(R.drawable.ic_sentiment_neutral_24dp);
        }
        if (mResult > max) {
            image.setImageResource(R.drawable.ic_sentiment_very_dissatisfied_24dp);
        }
        else  {
            image.setImageResource(R.drawable.ic_sentiment_very_satisfied_24dp);
        }

    }

    /**
     * Save Data in LocalDB
      */
    private void saveData() {
        Toast.makeText(this, "Save Data", Toast.LENGTH_SHORT).show();
    }


}
