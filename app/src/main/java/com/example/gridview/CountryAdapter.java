package com.example.gridview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.androidtraining_tasks.R;

import java.util.List;

public class CountryAdapter extends BaseAdapter {

    private CountryGridViewActivity countryListActivity;
    private List<Country> countries;

    public CountryAdapter(CountryGridViewActivity countryListActivity, List<Country> countries) {
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
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(countryListActivity).inflate(R.layout.countries_txtview, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.countryList.setText(((Country) getItem(position)).countryName);
        return convertView;

    }
    private class ViewHolder {
        TextView countryList;
        public ViewHolder(View view) {
            countryList = (TextView) view.findViewById(R.id.textView);
        }
    }

}
