package com.example.uptebeta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {
    private FirebaseAuth mAuth;
    public EditText name,email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();

        name=(EditText)findViewById(R.id.rname);
        email=(EditText)findViewById(R.id.remail);
        password=(EditText)findViewById(R.id.rpassword);
    }

    public  void onClick(View v)
    {
        registerUser();
        startActivity(new Intent(register.this,MainActivity.class));
    }
    public void registerUser()
    {
        String name1=name.getText().toString().trim();
        String email1=email.getText().toString().trim();
        String password1=password.getText().toString().trim();
        if (name1.isEmpty())
        {
            name.setError("full name is empty ");
            name.requestFocus();
            return ;

        }

        if (email1.isEmpty())
        {
            email.setError("email is empty ");
            email.requestFocus();
            return ;

        }
        if (password1.isEmpty())
        {
          password.setError("password empty ");
            password.requestFocus();
            return ;

        }

    mAuth.createUserWithEmailAndPassword(email1,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if(task.isSuccessful()) {
                User user = new User(name1, email1);
                FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()) {
                                    Toast.makeText(register.this,"user have been registred successfully",Toast.LENGTH_LONG).show();
                                }
                                else
                                {
Toast.makeText(register.this,"user have been registred successfully",Toast.LENGTH_LONG).show();


                                }
                            }
                        });
            }
            else{
                Toast.makeText(register.this,"reconnect to the firebase",Toast.LENGTH_LONG).show();

            }
        }
    });

    }

}
