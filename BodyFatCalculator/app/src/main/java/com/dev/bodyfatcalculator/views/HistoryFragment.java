package com.dev.bodyfatcalculator.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dev.bodyfatcalculator.R;
import com.dev.bodyfatcalculator.model.Profile;
import com.dev.bodyfatcalculator.viewmodel.CalculatorViewModel;
import com.dev.bodyfatcalculator.views.adapter.HistoryAdapter;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {

    private CalculatorViewModel model;
    private HistoryAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        ListView listView = view.findViewById(R.id.historyList);

        model = new ViewModelProvider
                .AndroidViewModelFactory(requireActivity().getApplication())
                .create(CalculatorViewModel.class);

        model.getList().observe(this, new Observer<List<Profile>>() {
            @Override
            public void onChanged(List<Profile> profiles) {
                adapter = new HistoryAdapter(requireContext(), R.layout.card_profile, profiles);
            }
        });

        listView.setAdapter(adapter);

        return view;
    }
}
