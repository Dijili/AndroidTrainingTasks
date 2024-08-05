package com.example.gridview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.androidtraining_tasks.R;

import java.util.List;

public class StatesAdapter extends BaseAdapter {

    private StatesGridViewActivity statesGridViewActivity;
    private List<String> states;

    public StatesAdapter(StatesGridViewActivity statesGridViewActivity, List<String> states) {
        this.statesGridViewActivity = statesGridViewActivity;
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
            convertView = LayoutInflater.from(statesGridViewActivity).inflate(R.layout.states_txtview, parent, false);
        }
        TextView stateList = convertView.findViewById(R.id.textView);
        stateList.setText(getItem(position));
        return convertView;
    }
}

