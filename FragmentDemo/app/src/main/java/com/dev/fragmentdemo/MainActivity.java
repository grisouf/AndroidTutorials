package com.dev.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements LoginFragment.OnClickListener {

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

    // this method in Interface that in Login Fragment
    @Override
    public void onClick() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainContainer, new LoggedFragment()).commit();
    }
}
