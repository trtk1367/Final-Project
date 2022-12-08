package com.example.knockoutdice;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment {
Button palybtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        palybtn=view.findViewById(R.id.playbtn);
        palybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v==palybtn){
                    Intent go =new Intent(getActivity(),game.class);
                    startActivity(go);
                }

            }
        });
        return view;



    }

}