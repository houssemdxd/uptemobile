package com.example.uptebeta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private Button signin;
private FirebaseAuth mAuth;
private EditText editTextemail,password;
private TextView register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        register=(TextView) findViewById((R.id.textView2));
        register.setOnClickListener(this);
        signin=(Button) findViewById(R.id.login);
        signin.setOnClickListener(this);
        editTextemail=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.pass);
        mAuth=FirebaseAuth.getInstance();





    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.textView2:
                startActivity(new Intent(this, register.class));
            case R.id.login:
                userLogin();
                break;

        }


    }

    private void userLogin() {

        String email1= editTextemail.getText().toString().trim();
        String pass1= password.getText().toString().trim();
        if(email1.isEmpty())
        {
            editTextemail.setError("email is required");
            editTextemail.requestFocus();
            return ;
        }

        if(pass1.isEmpty())
        {
            password.setError("password is required");
            password.requestFocus();
            return ;
        }

    mAuth.signInWithEmailAndPassword(email1,pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Intent intent = new Intent(MainActivity.this, tests.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(MainActivity.this,"there is a problem with your account",Toast.LENGTH_SHORT).show();
        }
    });
    }



}