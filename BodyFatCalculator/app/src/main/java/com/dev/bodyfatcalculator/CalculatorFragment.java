package com.dev.bodyfatcalculator;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.bodyfatcalculator.model.Profile;
import com.dev.bodyfatcalculator.viewmodel.CalculatorViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment {

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_caluclator, container, false);

        setHasOptionsMenu(true);

        // Initialize View Model
        model = new ViewModelProvider
                    .AndroidViewModelFactory(requireActivity().getApplication())
                    .create(CalculatorViewModel.class);

        // Initialize Views
        init(view);

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

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
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
    private void init (View view) {

        age = view.findViewById(R.id.age);
        height = view.findViewById(R.id.height);
        weight = view.findViewById(R.id.weight);

        female = view.findViewById(R.id.female);

        calculate = view.findViewById(R.id.calculate);

        image = view.findViewById(R.id.image);

        result = view.findViewById(R.id.result);

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

        // check if object exists
        if (profile == null) return;

        // Insert object to DB
        model.add(profile);

        Toast.makeText(requireActivity(), "Inserted", Toast.LENGTH_SHORT).show();
    }


}
