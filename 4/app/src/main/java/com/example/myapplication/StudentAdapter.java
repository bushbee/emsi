package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

// Custom ArrayAdapter for displaying student data in ListView
public class StudentAdapter extends ArrayAdapter<Student> {

    public StudentAdapter(ViewRecordsActivity context, ArrayList<Student> students) {
        super(context, 0, students);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the student data for the current position
        Student student = getItem(position);

        // Populate the data into the TextViews
        TextView text1 = convertView.findViewById(R.id.text1);
        TextView text2 = convertView.findViewById(R.id.text2);
        TextView text3 = convertView.findViewById(R.id.text3);
        TextView text4 = convertView.findViewById(R.id.text4);

        if (student != null) {
            text1.setText("Roll No: " + student.getRollNo());
            text2.setText("Name: " + student.getName());
            text3.setText("Email: " + student.getEmail());
            text4.setText("Course: " + student.getCourse());
        }

        return convertView;
    }
}
