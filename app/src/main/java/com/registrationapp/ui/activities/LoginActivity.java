package com.registrationapp.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.registrationapp.R;
import com.registrationapp.ui.fragments.LoginFragment;
import com.registrationapp.ui.fragments.SignUpFragment;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnLogin;
    private Button mBtnSignUp;
    private TextView mTvTermsOfServices;
    private FragmentManager fragmentManager;
    private final String fragmentTag = "Alert Dialog Fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();
    }

    private void initUI() {
        mBtnSignUp = (Button) findViewById(R.id.btn_sign_up);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mTvTermsOfServices = (TextView) findViewById(R.id.tv_terms_and_conditions);
        mBtnSignUp.setOnClickListener(this);
        mBtnLogin.setOnClickListener(this);
        mTvTermsOfServices.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_sign_up:
                signUp();
                break;
            case R.id.tv_terms_and_conditions:
                termsOfServices();
                break;
            default:
        }

    }

    private void termsOfServices() {
        Toast.makeText(this, "Under Implementation", Toast.LENGTH_SHORT).show();

    }

    private void signUp() {
        SignUpFragment signUpFragment = new SignUpFragment();
        fragmentManager = getSupportFragmentManager();
        signUpFragment.show(fragmentManager, fragmentTag);
        signUpFragment.setCancelable(false);
    }

    private void login() {
        LoginFragment loginFragment = new LoginFragment();
        fragmentManager = getSupportFragmentManager();
        loginFragment.show(fragmentManager, fragmentTag);
        loginFragment.setCancelable(false);


    }
}
