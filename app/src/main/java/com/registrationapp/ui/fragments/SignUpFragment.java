package com.registrationapp.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.registrationapp.R;
import com.registrationapp.databasemanager.DBHelper;
import com.registrationapp.prefrences.PrefsConstants;
import com.registrationapp.prefrences.RegistrationPrefrence;
import com.registrationapp.ui.activities.MainActivity;

public class SignUpFragment extends DialogFragment implements View.OnClickListener {
    private EditText mEtFirstName;
    private EditText mEtLastName;
    private EditText mEtContactNumber;
    private EditText mEtEmail;
    private EditText mEtUserName;
    private EditText mEtPassword;
    private EditText mEtConfirmPassword;
    private Button mBtnSignup;
    private Button mBtnCancel;
    private DBHelper dbHelper;
    private RegistrationPrefrence registrationPrefrence;

    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sign_up, container, false);
        getDialog().setTitle(R.string.sign_up_frag_tittle);
        initUI(rootView);
        registrationPrefrence = new RegistrationPrefrence(getActivity());
        dbHelper = new DBHelper(getActivity());
        return rootView;
    }

    private void initUI(View view) {
        mEtFirstName = (EditText) view.findViewById(R.id.et_first_name_sign_up);
        mEtLastName = (EditText) view.findViewById(R.id.et_last_name_sign_up);
        mEtContactNumber = (EditText) view.findViewById(R.id.et_contect_no_sign_up);
        mEtEmail = (EditText) view.findViewById(R.id.et_email_sign_up);
        mEtUserName = (EditText) view.findViewById(R.id.et_user_name_sign_up);
        mEtPassword = (EditText) view.findViewById(R.id.et_password_sign_up);
        mEtConfirmPassword = (EditText) view.findViewById(R.id.et_confirm_password_sign_up);
        mBtnSignup = (Button) view.findViewById(R.id.btn_signup_signup);
        mBtnCancel = (Button) view.findViewById(R.id.btn_cancel_signup);
        mBtnSignup.setOnClickListener(this);
        mBtnCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_signup_signup:
                signUp();
                break;
            case R.id.btn_cancel_signup:
                getDialog().cancel();
                break;
        }
//
    }

    private void signUp() {
        if (mEtFirstName.getText().toString().matches("") || mEtLastName.getText().toString().matches("") || mEtContactNumber.getText().toString().matches("") || mEtEmail.getText().toString().matches("") || mEtUserName.getText().toString().matches("") || mEtPassword.getText().toString().matches("") || mEtConfirmPassword.getText().toString().matches("")
                ) {
            Toast.makeText(getActivity(), "Please fill all the details", Toast.LENGTH_LONG).show();
        } else if (mEtFirstName.getText().toString().length() < 3 || mEtLastName.getText().toString().length() < 3) {
            Toast.makeText(getActivity(), "Fisrt name's and Last name's characters should be more than 5", Toast.LENGTH_LONG).show();

        } else if (!mEtPassword.getText().toString().equals(mEtConfirmPassword.getText().toString())) {

            Toast.makeText(getActivity(), "Password and confirm password are not same", Toast.LENGTH_LONG).show();
        } else {
            String firstName = mEtFirstName.getText().toString();
            String lastName = mEtLastName.getText().toString();
            String mobileNo = mEtContactNumber.getText().toString();
            String emailId = mEtEmail.getText().toString();
            String mUserName = mEtUserName.getText().toString();
            String pwd = mEtPassword.getText().toString();
            dbHelper.addUserProfile(firstName, lastName, mobileNo, emailId, mUserName, pwd);
            Toast.makeText(getActivity(), "Your are signed up", Toast.LENGTH_LONG).show();
            registrationPrefrence.addOrUpdateBoolean(PrefsConstants.MEMBER_LOGGED_IN, true);
            registrationPrefrence.addOrUpdateString(PrefsConstants.USERNAME, mUserName);
            getActivity().finish();
            Intent signUpIntent = new Intent(getActivity(), MainActivity.class);
            startActivity(signUpIntent);
        }
    }
}