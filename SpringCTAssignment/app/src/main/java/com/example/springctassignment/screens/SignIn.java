package com.example.springctassignment.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.springctassignment.R;
import com.example.springctassignment.models.LoginModel;
import com.example.springctassignment.services.LoginApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignIn extends AppCompatActivity {

    private Button submitBtn;
    private EditText emailET;
    private EditText passwordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        submitBtn = findViewById(R.id.submitBtn);
        emailET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.passwordET);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailToText = emailET.getText().toString();
                String passwordToText = passwordET.getText().toString();

                if (emailToText.isEmpty()){
                    emailValidator(emailET);
                }else if (passwordToText.isEmpty()){
                    passwordValidator(passwordET);
                }
                else {
                    PostData(emailET.getText().toString(),passwordET.getText().toString());
                }
            }
        });

    }

    public void emailValidator(EditText emailET) {
        String emailToText = emailET.getText().toString();

        if (!emailToText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailToText).matches()) {
            Toast.makeText(this,"Email Verified !", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Enter valid email address !", Toast.LENGTH_SHORT).show();
        }
    }

    public void passwordValidator(EditText passwordET) {
        String passwordToText = passwordET.getText().toString();

        if (!passwordToText.isEmpty()){
            Toast.makeText(this,"Password entered!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Enter valid password !", Toast.LENGTH_SHORT).show();
        }
    }

    public void PostData(String Email,String Password) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        LoginApi loginApi = retrofit.create(LoginApi.class);

        LoginModel modal = new LoginModel(Email, Password);

        Call<LoginModel> call = loginApi.createPost(modal);

        call.enqueue(new Callback<LoginModel>() {

            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                Toast.makeText(SignIn.this, "Data added to API", Toast.LENGTH_SHORT).show();
                emailET.setText("");
                passwordET.setText("");
                LoginModel responseFromAPI = response.body();

                Intent i = new Intent(SignIn.this,HomeScreen.class);
                startActivity(i);
                finish();
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Toast.makeText(SignIn.this, "Something Error....", Toast.LENGTH_SHORT).show();
            }
        });
    }
}