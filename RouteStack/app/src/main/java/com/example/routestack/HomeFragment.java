package com.example.routestack;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class HomeFragment extends Fragment implements View.OnClickListener {
    TextView viewUploads;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_home,container,false);
       viewUploads = (TextView)v.findViewById(R.id.textViewUploads1);
       viewUploads.setOnClickListener(this);
       return v;

        //return inflater.inflate(R.layout.fragment_home, container, false);


    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
       // viewUploads.findViewById(R.id.textViewUploads1);

    }

    private void setContentView(int fragment_home) {
    }


    public void onBackPressed() {


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textViewUploads1:
                startActivity(new Intent(getActivity(), ViewUploadsActivity.class));

                break;
        }
    }
}
