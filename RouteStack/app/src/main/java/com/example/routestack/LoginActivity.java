package com.example.routestack;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView bookIconImageView;
    private TextView bookITextView;
    private ProgressBar loadingProgressBar;
    private RelativeLayout rootView, afterAnimationView;
    Button login;


    EditText username,password;
    TextView sign,forgot;
    SQLiteDatabase db;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        initViews();
        new CountDownTimer(5000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                bookITextView.setVisibility(GONE);
                loadingProgressBar.setVisibility(GONE);
                rootView.setBackgroundColor(ContextCompat.getColor(LoginActivity.this, R.color.colorSplashText));
                bookIconImageView.setImageResource(R.drawable.pic1);
                startAnimation();
            }

            @Override
            public void onFinish() {

            }
        }.start();


        username=findViewById(R.id.emailEditText);
        password=findViewById(R.id.passwordEditText);
        sign=findViewById(R.id.signup);
        forgot=findViewById(R.id.forgot);
        login=findViewById(R.id.loginButton);
        sign.setOnClickListener(this);
        forgot.setOnClickListener(this);
        login.setOnClickListener(this);

        db = openOrCreateDatabase("register", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS register(name VARCHAR,uname VARCHAR,password VARCHAR,phone VARCHAR,mail VARCHAR);");

    }

    private void initViews() {
        bookIconImageView = findViewById(R.id.bookIconImageView);
        bookITextView = findViewById(R.id.bookITextView);
        loadingProgressBar = findViewById(R.id.loadingProgressBar);
        rootView = findViewById(R.id.rootView);
        afterAnimationView = findViewById(R.id.afterAnimationView);
    }

    private void startAnimation() {
        ViewPropertyAnimator viewPropertyAnimator = bookIconImageView.animate();
        viewPropertyAnimator.x(500f);
        viewPropertyAnimator.y(100f);
        viewPropertyAnimator.setDuration(1000);
        viewPropertyAnimator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                afterAnimationView.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }


    @Override
    public void onClick(View view) {

        if (view == login) {
            Cursor c = db.rawQuery("SELECT * FROM register WHERE uname='" + username.getText() + "'", null);

            String d = "Password";
            String dummyPassword;
            if (c.moveToFirst()){
                String dum = c.getString(1);
                dummyPassword = c.getString(2);
                //Toast.makeText(getApplicationContext(), dummyPassword, Toast.LENGTH_SHORT).show();

                if (password.getText().toString().equals(dummyPassword)) {
                    Toast.makeText(getApplicationContext(), "Welcome "+dum, Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(this, HomeActivity.class);
                    in.putExtra("username", dum);
                    startActivity(in);
                }


            }
            if(username.getText().toString().equals("admin") && password.getText().toString().equals("bhn@999")){
                Toast.makeText(this,"Welcome Adminitrator",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(this,AdminLogin.class);
                startActivity(i);
            }
            //else
            //  Toast.makeText(this,"Invalid Credentials",Toast.LENGTH_LONG).show();
        }
        if (view == sign) {
            Intent i = new Intent(this, Register.class);
            startActivity(i);
        }
        if(view == forgot)
        {
            Intent f=new Intent(this,Forgot.class);
            startActivity(f);

        }



    }


}

