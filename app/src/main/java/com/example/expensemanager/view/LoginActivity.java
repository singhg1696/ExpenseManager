package com.example.expensemanager.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.expensemanager.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btnSignUp)
    Button btnSignUp;
    @BindView(R.id.chkboxRememberMe)
    CheckBox chkboxRememberMe;
    private FirebaseAuth mAuth;
    @BindView(R.id.txtEmail)
    TextView txtEmail;
    @BindView(R.id.txtPass)
    TextView txtPass;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();

        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            txtEmail.setText(loginPreferences.getString("username", ""));
            txtPass.setText(loginPreferences.getString("password", ""));
            chkboxRememberMe.setChecked(true);
        }
        setBtnLogin(btnLogin);
        setBtnSignUp(btnSignUp);
    }

    public void setBtnLogin(Button btnLogin) {
        this.btnLogin = btnLogin;
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailAddress = txtEmail.getText().toString().trim();
                if (txtPass.getText().toString().length() < 6) {
                    txtPass.setError("password minimum contain 6 character");
                    txtPass.requestFocus();
                }
                if (txtPass.getText().toString().equals("")) {
                    txtPass.setError("please enter password");
                    txtPass.requestFocus();
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
                    txtEmail.setError("please enter valid email address");
                    txtEmail.requestFocus();
                }
                if (txtEmail.getText().toString().equals("")) {
                    txtEmail.setError("please enter email address");
                    txtEmail.requestFocus();
                }
                if (!emailAddress.equals("") &&
                        txtPass.getText().toString().length() >= 6 &&
                        !txtPass.getText().toString().trim().equals("")
                        && Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {

                    mAuth.signInWithEmailAndPassword(emailAddress, txtPass.getText().toString())
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        FirebaseUser user = mAuth.getCurrentUser();

                                        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                                        assert imm != null;
                                        imm.hideSoftInputFromWindow(txtEmail.getWindowToken(), 0);


                                        if (chkboxRememberMe.isChecked()) {
                                            loginPrefsEditor.putBoolean("saveLogin", true);
                                            loginPrefsEditor.putString("username", txtEmail.getText().toString());
                                            loginPrefsEditor.putString("password", txtPass.getText().toString());
                                            loginPrefsEditor.commit();
                                        } else {
                                            loginPrefsEditor.clear();
                                            loginPrefsEditor.commit();
                                        }

                                        startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
                                        LoginActivity.this.finish();


                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w("", "signInWithEmail:failure", task.getException());
                                        Toast.makeText(LoginActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }

                                    // ...
                                }
                            });

                }
            }
        });
    }

    public void setBtnSignUp(Button btnSignUp) {
        this.btnSignUp = btnSignUp;
        Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
        startActivity(intent);
        finish();
    }
}
















/*


 */
