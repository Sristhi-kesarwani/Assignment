package com.example.springctassignment.screens;

import static com.example.springctassignment.R.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.springctassignment.Adapter.EmployeeListAdapter;
import com.example.springctassignment.R;
import com.example.springctassignment.models.AddEmployeeModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class HomeScreen extends AppCompatActivity {

    List<String> list = new ArrayList<String>();
    List<AddEmployeeModel> addEmployeeModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


//        if (list.isEmpty()){
//            Intent i = getIntent();
//            String empName = i.getStringExtra("EmployeeName");
//            String age = i.getStringExtra("Age");
//            String address = i.getStringExtra("Address");
//            list.add(String.valueOf(new String[]{empName, age, address}));
//            addEmployeeModels.contains(list);
//        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        final EmployeeListAdapter adapter = new EmployeeListAdapter(HomeScreen.this,addEmployeeModels);
//        recyclerView.setAdapter(adapter);

        Toolbar toolbar = findViewById(id.appbar_layout_tool_bar);
        toolbar.setTitle("Home Screen");
        setSupportActionBar(toolbar);

        FloatingActionButton addEmployeeBtn = findViewById(id.addEmployeeBtn);
        addEmployeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeScreen.this,AddEmployeeScreen.class);
                startActivity(i);
                finish();
            }
        });

    }
}