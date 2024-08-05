package com.example.listview_countries;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.androidtraining_tasks.R;

import java.util.List;

public class StatesListAdapter extends BaseAdapter {

    private StatesListActivity statesListActivity;
    private List<String> states;

    public StatesListAdapter(StatesListActivity statesListActivity, List<String> states) {
        this.statesListActivity = statesListActivity;
        this.states = states;
    }

    @Override
    public int getCount() {
        return states.size();
    }

    @Override
    public String getItem(int position) {
        return states.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(statesListActivity).inflate(R.layout.states_txtview, parent, false);
        }
        TextView stateList = convertView.findViewById(R.id.textView);
        stateList.setText(getItem(position));
        return convertView;
    }

}


