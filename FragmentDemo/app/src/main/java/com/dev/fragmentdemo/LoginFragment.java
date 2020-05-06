package com.dev.fragmentdemo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class LoginFragment extends Fragment  implements View.OnClickListener {

    private EditText name;
    private EditText password;
    private Button login;
    private Button register;

    //
    private OnLoginFragmentListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        // Initialize Views
        name = view.findViewById(R.id.name);
        password = view.findViewById(R.id.password);
        login = view.findViewById(R.id.button);
        register = view.findViewById(R.id.register);

        login.setOnClickListener(this);
        register.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        //Toast.makeText(requireContext(), name.getText().toString(), Toast.LENGTH_SHORT).show();
        if (listener != null) {
            switch (v.getId()) {
                case R.id.button : listener.onLogin();
                    break;

                case R.id.register: listener.onRegister();
                    break;
            }
        }
    }

    // Inner Interface
    public interface OnLoginFragmentListener {
        void onLogin();
        void onRegister();
    }

    public void setOnclickListener(OnLoginFragmentListener listener) {
        this.listener = listener;
    }
}
