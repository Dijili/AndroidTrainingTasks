package com.example.listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.androidtraining_tasks.R;

import java.util.List;


public class CountryListviewAdaptor extends BaseAdapter {
    private CountryListActivity countryListActivity;
    private List<Country> countries;

    public CountryListviewAdaptor(CountryListActivity countryListActivity, List<Country> countries) {
        this.countryListActivity = countryListActivity;
        this.countries = countries;
    }

    @Override
    public int getCount() {
        return countries.size();
    }


    @Override
    public Country getItem(int position) {
        return countries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(countryListActivity).inflate(R.layout.country_txtview, parent, false);
        }
        TextView countryList = convertView.findViewById(R.id.countries_textView);
        countryList.setText(((Country) getItem(position)).countryName);
        return convertView;
    }
}










