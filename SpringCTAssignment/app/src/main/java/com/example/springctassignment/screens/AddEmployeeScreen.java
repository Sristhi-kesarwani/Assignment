package com.example.springctassignment.screens;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.springctassignment.R;

public class AddEmployeeScreen extends AppCompatActivity {

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee_screen);

        Toolbar toolbar = findViewById(R.id.appbar_layout_tool_bar);
        toolbar.setTitle("Add Employee");
        setSupportActionBar(toolbar);

        EditText empName = findViewById(R.id.empNameET);
        EditText ageET = findViewById(R.id.ageET);
        EditText addressET = findViewById(R.id.addressET);
        Button saveBtn = findViewById(R.id.saveBtn);

        builder = new AlertDialog.Builder(this);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String empNameToString = empName.getText().toString();
                String ageToString = ageET.getText().toString();
                String addressToString = addressET.getText().toString();

                if (empNameToString.isEmpty()) {
                    Toast.makeText(AddEmployeeScreen.this,"Enter employee name",Toast.LENGTH_SHORT).show();
                } else if(ageToString.isEmpty()) {
                    Toast.makeText(AddEmployeeScreen.this,"Enter Age",Toast.LENGTH_SHORT).show();
                } else if (addressToString.isEmpty()) {
                    Toast.makeText(AddEmployeeScreen.this,"Enter Address",Toast.LENGTH_SHORT).show();
                }else {
                    Intent i = new Intent(AddEmployeeScreen.this,HomeScreen.class);
                    i.putExtra("EmployeeName",empNameToString);
                    i.putExtra("Age",empNameToString);
                    i.putExtra("Address",empNameToString);
                    finish();
                }
            }
        });

    }
}