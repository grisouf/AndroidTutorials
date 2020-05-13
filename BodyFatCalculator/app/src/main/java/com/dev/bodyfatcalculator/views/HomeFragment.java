package com.dev.bodyfatcalculator.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dev.bodyfatcalculator.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private Button calculator;
    private Button history;

    private OnHomeFragmentListener listener = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        calculator = view.findViewById(R.id.homeCalculator);
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener == null) return;

                listener.onCalculatorClick();
            }
        });

        history = view.findViewById(R.id.homeHistory);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener == null) return;

                listener.onHistoryClick();
            }
        });

        return view;
    }

    public interface OnHomeFragmentListener {
        void onCalculatorClick();
        void onHistoryClick();
    }

    public void setOnHomeFragmentListener(OnHomeFragmentListener listener) {
        this.listener = listener;
    }
}
