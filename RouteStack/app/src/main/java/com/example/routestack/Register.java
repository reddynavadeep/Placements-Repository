package com.example.routestack;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity implements View.OnClickListener {
    EditText name,uname,password,phone,mail;
    Button register;
    String nam;

    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.name);
        uname=findViewById(R.id.uname);
        password=findViewById(R.id.pwd);
        phone=findViewById(R.id.phone);
        mail=findViewById(R.id.mail);
        register=findViewById(R.id.register);

        register.setOnClickListener(this);


        db = openOrCreateDatabase("register", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS register(name VARCHAR,uname VARCHAR,password VARCHAR,phone VARCHAR,mail VARCHAR);");

    }

    @Override
    public void onClick(View view) {
        String email = mail.getText().toString().trim();
        nam = name.getText().toString().trim();
        String namepattern = "[a-zA-Z]+(([.][a-zA-Z ])?[a-zA-Z]*)*";

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (view == register) {
            // Checking empty fields
            if (name.getText().toString().trim().length() == 0 || uname.getText().toString().trim().length() == 0 ||
                    password.getText().toString().trim().length() == 0 || phone.getText().toString().trim().length() == 0 ||mail.getText().toString().trim().length() == 0 ) {
                showMessage("Error", "Please enter all values");
                return;
            }
            // Inserting record 
            if(email.matches(emailPattern) &&  nam.matches(namepattern) && phone.length()==10) {
                db.execSQL("INSERT INTO register VALUES('" + name.getText() + "','" + uname.getText() +
                        "','" + password.getText() + "','" + phone.getText() + "','" + mail.getText() + "');");
                showMessage("Success", "Registration Successful");
                clearText();
            }
            else
                showMessage("Invalid Entry", "Enter Valid Details");
        }


    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void clearText(){

        name.setText("");
        uname.setText("");
        password.setText("");
        phone.setText("");
        mail.setText("");

    }

}
