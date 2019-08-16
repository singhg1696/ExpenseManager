package com.example.expensemanager.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.expensemanager.Classes.UserDetails;
import com.example.expensemanager.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

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
    @BindView(R.id.btnBackToSignIn)
    Button btnBackToSignIn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);


        setBtnSignUp(btnSignUp);
        setBtnBackToSignIn(btnBackToSignIn);
    }

    public void setBtnSignUp(Button btnSignUp) {

        this.btnSignUp = btnSignUp;
        btnSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mAuth = FirebaseAuth.getInstance();

                final String userName = txtName.getText().toString().trim();
                final String userEmail = txtEmail.getText().toString().trim();
                String userPass = txtPass.getText().toString().trim();
                String userRepeatPass = txtRepeatPass.getText().toString().trim();
                final String userContact = txtPhoneNo.getText().toString().trim();

                if (txtPass.getText().toString().length() < 6) {
                    txtPass.setError("password minimum contain 6 character");
                    txtPass.requestFocus();
                }
                if (txtPass.getText().toString().equals("")) {
                    txtPass.setError("please enter password");
                    txtPass.requestFocus();
                }
                if (txtRepeatPass.getText().toString().length() < 6) {
                    txtRepeatPass.setError("password minimum contain 6 character");
                    txtRepeatPass.requestFocus();
                }
                if (txtRepeatPass.getText().toString().equals("")) {
                    txtRepeatPass.setError("please enter password");
                    txtRepeatPass.requestFocus();
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
                    txtPhoneNo.setError("please enter your Contact Number");
                    txtPhoneNo.requestFocus();
                }

                if (userContact.matches("[0-9]+")) {
                    if (userContact.length() < 10) {
                        userContact.length();
                    }

                }
                if (!userPass.equals(userRepeatPass)) {
                    txtRepeatPass.setText("");
                    txtPass.setError("Password should be same");
                    txtPass.requestFocus();
                }
                if (!userEmail.equals("")/*
                        && txtPass.getText().toString().length() >= 6
                        && !txtPass.getText().toString().trim().equals("")
                        && Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()
                        && !txtPhoneNo.getText().toString().trim().equals("")
                        && !txtName.getText().toString().trim().equals("")
                        && txtPass.equals(txtRepeatPass)
                        && userContact.matches("[0-9]+")
                        && userContact.length() == 10*/) {

                    Toast.makeText(SignUpActivity.this, "2", Toast.LENGTH_LONG).show();

                    mAuth.createUserWithEmailAndPassword(userEmail, userPass)
                            .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Toast.makeText(SignUpActivity.this, "3", Toast.LENGTH_LONG).show();

                                    if (task.isSuccessful()) {
                                        Toast.makeText(SignUpActivity.this, "Done", Toast.LENGTH_LONG).show();

                                        // Sign in success, update UI with the signed-in user's information
                                        UserDetails userDetails = new UserDetails(userName, userEmail, userContact);
                                        FirebaseDatabase.getInstance().getReference("UserDetails").child("users").setValue(userDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Log.d("Succesful","Sign Up completed");
                                                    Toast.makeText(SignUpActivity.this, "Done", Toast.LENGTH_LONG).show();
                                                }
                                            }
                                        });
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();

                                    }

                                    // ...
                                }
                            });
                }
            }
        });
    }

    public void setBtnBackToSignIn(Button btnBackToSignIn) {
        this.btnBackToSignIn = btnBackToSignIn;
        btnBackToSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
