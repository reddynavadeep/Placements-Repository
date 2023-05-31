package com.example.routestack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AdminLogin extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String values[] = {"Uploads/","Cisco/","Microsoft/"};
    ArrayAdapter<String> adapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        lv=findViewById(R.id.companylist);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent in = new Intent(AdminLogin.this,CompanyIntent.class);
        in.putExtra("pos",i);
        startActivity(in);

    }
}
