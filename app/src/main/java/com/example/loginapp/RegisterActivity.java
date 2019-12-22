package com.example.loginapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.loginapp.database.User;
import com.example.loginapp.database.UserDao;
import com.example.loginapp.database.UserDatabase;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    EditText etFullName, etNickName, etUsername, etPassword;
    Button btnRegister;
    TextView tvError;

    private UserDao userDao;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Registering...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);

        etFullName = findViewById(R.id.full_name_edit_text);
        etNickName = findViewById(R.id.nick_name_edit_text);
        etUsername = findViewById(R.id.username_edit_text);
        etPassword = findViewById(R.id.password_edit_text);
        btnRegister = findViewById(R.id.register_button);
        tvError = findViewById(R.id.error_text_view);

        final String fullName = etFullName.getText().toString();
        final String nickName = etNickName.getText().toString();
        final String userName = etUsername.getText().toString();
        final String password = etPassword.getText().toString();

        tvError.setText("");

        userDao = Room.databaseBuilder(this, UserDatabase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build()
                .getUserDao();


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isEmpty()) {

                    progressDialog.show();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            User user = new User(etFullName.getText().toString(), etNickName.getText().toString(),
                                    etUsername.getText().toString(), etPassword.getText().toString());
                            userDao.insertUser(user);
                            progressDialog.dismiss();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                            finish();
                        }
                    }, 1000);

                } else {
                    tvError.setText("Empty Fields");
                }
            }
        });

    }

    private boolean isEmpty() {
        if (TextUtils.isEmpty(etFullName.getText().toString()) ||
                TextUtils.isEmpty(etNickName.getText().toString()) ||
                TextUtils.isEmpty(etUsername.getText().toString()) ||
                TextUtils.isEmpty(etPassword.getText().toString())
        ) {
            return true;
        } else {
            return false;
        }
    }

}
