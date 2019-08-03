package com.example.expensemanager.view;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.expensemanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity {

    @BindView(R.id.txtName)
    EditText txtName;
    @BindView(R.id.txtEmail)
    EditText txtEmail;
    @BindView(R.id.txtPass)
    EditText txtPass;
    @BindView(R.id.txtRepeatPass)
    EditText txtRepeatPass;
    @BindView(R.id.txtPhoneNo)
    EditText txtPhoneNo;
    @BindView(R.id.btnSignUp)
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);


        setBtnSignUp(btnSignUp);
    }

    public void setBtnSignUp(Button btnSignUp) {
        this.btnSignUp = btnSignUp;
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName = txtName.getText().toString().trim();
                String userEmail = txtEmail.getText().toString().trim();
                String userPass = txtPass.getText().toString().trim();
                String userRepeatPass = txtRepeatPass.getText().toString().trim();
                String userContact = txtPhoneNo.getText().toString().trim();

                if (txtPass.getText().toString().length() < 6) {
                    txtPass.setError("password minimum contain 6 character");
                    txtPass.requestFocus();
                }
                if (txtPass.getText().toString().equals("")) {
                    txtPass.setError("please enter password");
                    txtPass.requestFocus();
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
                    txtEmail.setError("please enter valid email address");
                    txtEmail.requestFocus();
                }
                if (txtEmail.getText().toString().equals("")) {
                    txtEmail.setError("please enter email address");
                    txtEmail.requestFocus();
                }
                if (txtName.getText().toString().equals("")) {
                    txtName.setError("please enter your name");
                    txtName.requestFocus();
                }

                if (txtPhoneNo.getText().toString().equals("")) {
                    txtPhoneNo.setError("please enter your name");
                    txtPhoneNo.requestFocus();
                }

                if (userContact.matches("[0-9]+")) {
                    if (userContact.length() < 10) {
                        userContact.length();
                    }
                }
                if(!userPass.equals(userRepeatPass))
                {
                    txtRepeatPass.setText("");
                    txtPass.setError("Password should be same");
                    txtPass.requestFocus();
                }
                    if (!userEmail.equals("") &&
                            txtPass.getText().toString().length() >= 6 &&
                            !txtPass.getText().toString().trim().equals("")
                            && Patterns.EMAIL_ADDRESS.matcher(userEmail).matches() && !txtPhoneNo.getText().toString().trim().equals("") && !txtName.getText().toString().trim().equals("") && txtPass.equals(txtRepeatPass) && userContact.matches("[0-9]+") && userContact.length() == 10) {
                            Toast.makeText(SignUpActivity.this,"Wworking",Toast.LENGTH_SHORT).show();
                    }

            }
        });
    }
}
