package com.example.recyclerview;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtraining_tasks.R;

import java.util.ArrayList;

public class EmployeeRecyclerViewActivity extends AppCompatActivity {

    private TextView cart_text_view;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_recyclerview);
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.employee_recyclerview);
        // int Spancount = 2;

        // data to populate the RecyclerView with
        ArrayList<String> employees = new ArrayList<>();
        employees.add("Lalitha");
        employees.add("Ramya");
        employees.add("Laya");
        employees.add("Madhuri");
        employees.add("Dijili");

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.employee_worker_svgrepo_com);
        images.add(R.drawable.employee_svgrepo_com);
        images.add(R.drawable.employee_svgrepo_com__1_);
        images.add(R.drawable.employee_svgrepo_com__2_);
        images.add(R.drawable.employee_svgrepo_com__3_);

//        ArrayList<Employee> employee_details = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            for (String j : employees) {
//                employee_details.add(new Employee(j, i++));
//            }
//        }


        ArrayList<Employee> employee_details = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            String name = employees.get(i % employees.size());
            int image = images.get(i % images.size());
            employee_details.add(new Employee(name, 1 + i, image));
        }

        //LinearLayoutManager
        cart_text_view = findViewById(R.id.cart_text_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        EmployeeRecyclerViewAdapter adapter = new EmployeeRecyclerViewAdapter(employee_details, this);
        recyclerView.setAdapter(adapter);
        //To divide each row object
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    public void updateCartCount(String cartItemCount) {
        cart_text_view.setText(String.valueOf(cartItemCount));
    }
}
