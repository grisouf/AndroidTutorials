package com.dev.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements LoginFragment.OnLoginFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginFragment loginFragment = new LoginFragment();
        loginFragment.setOnclickListener(this);

        // Get Fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainContainer, loginFragment).commit();

    }

    @Override
    public void onLogin() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainContainer, new LoggedFragment()).addToBackStack("logged").commit();
    }

    @Override
    public void onRegister() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainContainer, new RegisterFragment()).addToBackStack("register").commit();
    }

}
