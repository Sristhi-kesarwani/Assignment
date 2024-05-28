package com.example.springctassignment.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.springctassignment.R;
import com.example.springctassignment.models.AddEmployeeModel;
import com.example.springctassignment.screens.HomeScreen;

import java.util.List;

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListAdapter.empHolder> {
    HomeScreen homeScreen;
    List<AddEmployeeModel> addEmployeeModels;

    public EmployeeListAdapter(HomeScreen homeScreen, List<AddEmployeeModel> addEmployeeModels){
        this.homeScreen = homeScreen;
        this.addEmployeeModels = addEmployeeModels;
    }

    @NonNull
    @Override
    public empHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new empHolder(LayoutInflater.from(homeScreen).inflate(R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull empHolder holder, int position) {
        holder.empName.setText(addEmployeeModels.get(position).getEmpName());
        holder.age.setText(addEmployeeModels.get(position).getAge());
        holder.address.setText(addEmployeeModels.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return addEmployeeModels.size();
    }

    class empHolder extends RecyclerView.ViewHolder {
        TextView empName;
        TextView age;
        TextView address;
        public empHolder(@NonNull View itemView) {
            super(itemView);
            empName = itemView.findViewById(R.id.empNameET);
            age = itemView.findViewById(R.id.ageET);
            address = itemView.findViewById(R.id.addressET);
        }
    }
}
