package com.example.expensemanager.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    @BindView(R.id.txtEmail)
    TextView txtEmail;
    @BindView(R.id.txtPass)
    TextView txtPass;
    @BindView(R.id.btnLogin)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        setBtnLogin(btnLogin);
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
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
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
                        && android.util.Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {

                    mAuth.signInWithEmailAndPassword(emailAddress, txtPass.getText().toString())
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        String e = user.getEmail();
                                        Log.d("tettedtuedte00000f", e);
                                        Toast.makeText(LoginActivity.this, "theek aa", Toast.LENGTH_LONG).show();

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
}
















/*


 */
