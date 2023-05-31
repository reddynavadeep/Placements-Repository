package com.example.routestack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    EditText user,pwd;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        user = findViewById(R.id.user);
        pwd = findViewById(R.id.pwd);
        b=findViewById(R.id.login);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==b.getId()){
            //  if(user.getText().toString()=="admin" && pwd.getText().toString()=="admin"){
            Intent i = new Intent(this,ViewUploadsActivity.class);
            startActivity(i);
            //}
        }
    }
}
