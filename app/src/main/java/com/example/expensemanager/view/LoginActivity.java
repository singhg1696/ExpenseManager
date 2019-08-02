package com.example.expensemanager.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.expensemanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {


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
        ButterKnife.bind(LoginActivity.this);
    }

    @OnClick(R.id.btnLogin)
    public void onClick() {

    }
}
