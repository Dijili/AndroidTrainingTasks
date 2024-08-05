package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtraining_tasks.R;

import java.util.ArrayList;

public class EmployeeRecyclerViewAdapter extends RecyclerView.Adapter<EmployeeRecyclerViewAdapter.ViewHolder> {
    private int cartItemCount = 0;
    private ArrayList<Employee> employee_details;
    private EmployeeRecyclerViewActivity employeeRecyclerViewActivity;
    private ArrayList<Employee> addedEmployees = new ArrayList<>();


    // data is passed into the constructor
    public EmployeeRecyclerViewAdapter(ArrayList<Employee> employee_details, EmployeeRecyclerViewActivity employeeRecyclerViewActivity) {
        this.employee_details = employee_details;
        this.employeeRecyclerViewActivity = employeeRecyclerViewActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(employeeRecyclerViewActivity).inflate(R.layout.employee_txtview, parent, false));
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Employee employee = employee_details.get(position);
        holder.employee_name.setText(String.valueOf(employee.getEmployeeRollNo()));
        holder.employee_id.setText(employee.getEmployeeName());
        holder.employee_image.setImageResource(employee.getImage());
    }

    @Override
    public int getItemCount() {
        return employee_details.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView employee_name, employee_id;
        ImageView employee_image;
        Button addButton, deleteButton;

        ViewHolder(View itemView) {
            super(itemView);
            employee_name = itemView.findViewById(R.id.employee_name);
            employee_id = itemView.findViewById(R.id.employee_id);
            employee_image = itemView.findViewById(R.id.employee_image);
            addButton = itemView.findViewById(R.id.add_button);
            deleteButton = itemView.findViewById(R.id.delete_button);
            itemView.setOnClickListener(this);

            addButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // Add clicked employee to the list of added employees
                    int position = getAdapterPosition();
//                    if(addButton.isClickable()){
//                        deleteButton.setVisibility(View.VISIBLE);
//                    }

                    if (position != RecyclerView.NO_POSITION) {
                        Employee clickedEmployee = employee_details.get(position);
                        addedEmployees.add(clickedEmployee);
                        cartItemCount++;
                        employeeRecyclerViewActivity.updateCartCount(String.valueOf(cartItemCount));
                        Toast.makeText(v.getContext(), "Added: " + clickedEmployee.getEmployeeName(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Remove the clicked employee if it exists in the list of added employees
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Employee clickedEmployee = employee_details.get(position);
                        if (addedEmployees.contains(clickedEmployee)) {
                            addedEmployees.remove(clickedEmployee);
                            cartItemCount--;
                            employeeRecyclerViewActivity.updateCartCount(String.valueOf(cartItemCount));
                            Toast.makeText(v.getContext(), "Removed: " + clickedEmployee.getEmployeeName(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            });
        }



        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Employee clickedEmployee = employee_details.get(position);
                Toast.makeText(v.getContext(), "Selected Employee: " + clickedEmployee.getEmployeeName(), Toast.LENGTH_SHORT).show();
            }
        }
    }

}




