package com.example.uptebeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class colortest extends AppCompatActivity {
    int nb ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colortest);
    }

    public void score(View view) {
        nb=0;
        TextView t1=findViewById(R.id.one);
        String email=t1.getText().toString();
        TextView t2=findViewById(R.id.two);
        String email2=t2.getText().toString();
        TextView t3=findViewById(R.id.three);
        String email3=t3.getText().toString();
        TextView t4=findViewById(R.id.four);
        String email4=t4.getText().toString();
        TextView t5=findViewById(R.id.five);
        String email5=t5.getText().toString();



        if( email.equals("vbr"))
        {nb=nb+1;}

        if(email2.equals("bbv"))
        {nb=nb+1;}

        if( email3.equals("vbv"))
        {nb=nb+1;}

        if( email4.equals("brv"))
        {nb=nb+1;}

        if( email5.equals("vrb"))
        {nb=nb+1;}

        TextView result ;
        result=findViewById(R.id.result);
        result.setText("votre score :"+nb);
    }
}