package com.example.bottomnavigation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class HomeFragment extends Fragment {


    private ArrayList<RCModel> modelArrayList;
    private String[] title;
    private int[] image;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        RCAdapter rcAdapter = new RCAdapter(getContext(),modelArrayList);
        recyclerView.setAdapter(rcAdapter);
        rcAdapter.notifyDataSetChanged();
    }

    private void dataInitialize() {

        modelArrayList = new ArrayList<>();

        title = new String[]{
                "Longest Distance",
                "Best Pace",
                "Longest Duration"
        };


        image = new int[]{
                R.drawable.road,
                R.drawable.success,
                R.drawable.clock
        };

        for (int i = 0; i < title.length; i++){
            RCModel rcModel = new RCModel(title[i],image[i]);
            modelArrayList.add(rcModel);

        }
    }
}