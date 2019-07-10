package com.example.firebaselogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    private EditText name,email,password,confirmpassword,mobile;
    private TextView back;
    private Button cont1;
    private String Name,Email,Password,Confpassword,Mobile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        confirmpassword = (EditText) findViewById(R.id.confpassword);
        cont1 = (Button) findViewById(R.id.sign_signup);
        mobile = (EditText) findViewById(R.id.mobile);
        back = (TextView) findViewById(R.id.terms);

        cont1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidate()){
                    startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
                }

            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
            }
        });


    }
    private void SignUp(){

        Name=name.getText().toString().trim();
        Email=email.getText().toString().trim();
        Password=password.getText().toString().trim();
        Confpassword=confirmpassword.getText().toString().trim();
        Mobile=mobile.getText().toString().trim();


    }

    private boolean isValidate(){

        boolean isValidate=true;

        Name=name.getText().toString().trim();
        Email=email.getText().toString().trim();
        Password=password.getText().toString().trim();
        Confpassword=confirmpassword.getText().toString().trim();
        Mobile=mobile.getText().toString().trim();

        if (Name.length()==0){
            name.setError("Enter your name");
            isValidate=false;
        }if (Email.length()==0){
            email.setError("Enter your email");
            isValidate=false;
        }if (Password.length()==0){
            password.setError("Enter password");
            isValidate=false;
        }if (Password.length()<8){
            password.setError("Password must be 8 characters");
            isValidate=false;
        }if (Confpassword.length()==0){
            password.setError("Enter confirmattion password");
            isValidate=false;
        }if (!Confpassword.equals(Password)) {
            password.setError("Password dont match");
            isValidate = false;
        }if (Mobile.length()==0) {
            mobile.setError("Phone no contain 10 chatacters");
            isValidate = false;
        }

        return isValidate;
    }
}
