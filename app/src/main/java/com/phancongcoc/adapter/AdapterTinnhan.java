package com.phancongcoc.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.phancongcoc.R;
import com.phancongcoc.model.TinNhan;

import java.util.List;

public class AdapterTinnhan extends ArrayAdapter<TinNhan> {
    Activity context;
    int resource;
    @NonNull List<TinNhan> objects;
    public AdapterTinnhan(@NonNull Activity context, int resource, @NonNull List<TinNhan> objects){
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView (int position, @NonNull View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View row = layoutInflater.inflate(this.resource, null);

        TextView _number = row.findViewById(R.id.txt_phone);
        TextView _time = row.findViewById(R.id.txt_time);
        TextView _body = row.findViewById(R.id.txt_body);

        _number.setText(this.objects.get(position).getNumber());
        _time.setText(this.objects.get(position).getTime());
        _body.setText(this.objects.get(position).getBody());

        return row;
    }
}