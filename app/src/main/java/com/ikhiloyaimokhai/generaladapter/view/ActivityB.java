package com.ikhiloyaimokhai.generaladapter.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ikhiloyaimokhai.generaladapter.R;
import com.ikhiloyaimokhai.generaladapter.adapter.GeneralAdapter;
import com.ikhiloyaimokhai.generaladapter.model.GeneralModel;

import java.util.ArrayList;
import java.util.List;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        List<GeneralModel> modelList = new ArrayList<>();
        modelList.add(new GeneralModel( "Anthony Joshua", "Boxer", "Born 20th, Sept. 1986"));
        modelList.add(new GeneralModel( "Anthony Joshua", "Boxer", "Born 20th, Sept. 1986"));
        modelList.add(new GeneralModel( "Anthony Joshua", "Boxer", "Born 20th, Sept. 1986"));
        modelList.add(new GeneralModel( "Anthony Joshua", "Boxer", "Born 20th, Sept. 1986"));
        modelList.add(new GeneralModel( "Anthony Joshua", "Boxer", "Born 20th, Sept. 1986"));


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        GeneralAdapter adapter = new GeneralAdapter(this, modelList);

        recyclerView.setAdapter(adapter);


    }
}
