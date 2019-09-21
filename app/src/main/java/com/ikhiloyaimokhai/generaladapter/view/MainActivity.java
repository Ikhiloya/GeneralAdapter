package com.ikhiloyaimokhai.generaladapter.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.ikhiloyaimokhai.generaladapter.R;
import com.ikhiloyaimokhai.generaladapter.adapter.GeneralAdapter;
import com.ikhiloyaimokhai.generaladapter.model.GeneralModel;

import java.util.ArrayList;
import java.util.List;

import static com.ikhiloyaimokhai.generaladapter.model.Constant.LAYOUT_A;
import static com.ikhiloyaimokhai.generaladapter.model.Constant.LAYOUT_A_TYPE;
import static com.ikhiloyaimokhai.generaladapter.model.Constant.LAYOUT_B;
import static com.ikhiloyaimokhai.generaladapter.model.Constant.LAYOUT_B_TYPE;
import static com.ikhiloyaimokhai.generaladapter.model.Constant.LAYOUT_C_TYPE;

public class MainActivity extends AppCompatActivity implements GeneralAdapter.ListItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        List<GeneralModel> modelList = new ArrayList<>();
        modelList.add(new GeneralModel("Layout A"));
        modelList.add(new GeneralModel("Layout B"));
        modelList.add(new GeneralModel("Layout C"));

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        GeneralAdapter adapter = new GeneralAdapter(this, modelList, this);

        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onListItemClick(int adapterPosition) {

        switch (adapterPosition + 1) {
            case LAYOUT_A_TYPE:
                startActivity(new Intent(MainActivity.this, ActivityA.class));
                break;
            case LAYOUT_B_TYPE:
                startActivity(new Intent(MainActivity.this, ActivityB.class));
                break;
            case LAYOUT_C_TYPE:
                startActivity(new Intent(MainActivity.this, ActivityC.class));
                break;
            default:
                throw new RuntimeException("No View Found");
        }

    }
}
