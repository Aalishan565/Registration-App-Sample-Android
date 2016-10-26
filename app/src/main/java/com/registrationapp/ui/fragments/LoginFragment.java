package com.registrationapp.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.registrationapp.R;
import com.registrationapp.databasemanager.DBHelper;
import com.registrationapp.prefrences.PrefsConstants;
import com.registrationapp.prefrences.RegistrationPrefrence;
import com.registrationapp.ui.activities.MainActivity;

import java.sql.SQLException;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends DialogFragment implements View.OnClickListener {
    private EditText mEtUserName;
    private EditText mEtPassword;
    private TextView mEtForgotPwd;
    private Button mBtnCancel;
    private Button mBtnLoginMe;
    private String mUserName;
    private String mPassword;
    RegistrationPrefrence registrationPrefrence;
    private DBHelper dbHelper;


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_login, container, false);
        getDialog().setTitle(R.string.login_frag_tittle);
        initUI(rootView);
        dbHelper = new DBHelper(getActivity());
        mBtnCancel.setOnClickListener(this);
        mBtnLoginMe.setOnClickListener(this);
        mEtForgotPwd.setOnClickListener(this);
        registrationPrefrence = new RegistrationPrefrence(getActivity());

        return rootView;
    }

    private void initUI(View view) {
        mEtUserName = (EditText) view.findViewById(R.id.et_user_name_login);
        mEtPassword = (EditText) view.findViewById(R.id.et_pwd_login);
        mBtnLoginMe = (Button) view.findViewById(R.id.btn_login_dialog);
        mBtnCancel = (Button) view.findViewById(R.id.btn_login_cancel);
        mEtForgotPwd = (TextView) view.findViewById(R.id.tv_forgot_pwd_login);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login_dialog:
                login();
                break;
            case R.id.btn_login_cancel:
                getDialog().cancel();
                break;
            case R.id.tv_forgot_pwd_login:
                Toast.makeText(getActivity(), "Under Implementation", Toast.LENGTH_LONG).show();
                break;
        }

    }
    private void login() {
        if (mEtUserName.getText().toString().matches("") || mEtPassword.getText().toString().matches("")) {
            Toast.makeText(getActivity(), "Please provide user name and password", Toast.LENGTH_LONG).show();
        } else {

            mUserName=mEtUserName.getText().toString();
            mPassword=mEtPassword.getText().toString();
            try {
                if(dbHelper.login(mUserName, mPassword)){
                    registrationPrefrence.addOrUpdateBoolean(PrefsConstants.MEMBER_LOGGED_IN, true);
                    registrationPrefrence.addOrUpdateString(PrefsConstants.USERNAME, mUserName);
                    Intent loginIntent = new Intent(getActivity(), MainActivity.class);
                    startActivity(loginIntent);
                    getActivity().finish();
                }
                else {
                    Toast.makeText(getActivity(), "User name or pwd are mismatch", Toast.LENGTH_LONG).show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }
}
