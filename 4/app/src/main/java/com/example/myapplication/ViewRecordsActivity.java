package com.example.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewRecordsActivity extends AppCompatActivity {

    private ListView listView;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    private ArrayList<Student> studentRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_records);

        listView = findViewById(R.id.listView);
        dbHelper = new DatabaseHelper(this);
        database = dbHelper.getReadableDatabase();
        studentRecords = new ArrayList<>();

        // Load records from the database
        loadRecords();

        // Set custom adapter for ListView
        StudentAdapter adapter = new StudentAdapter(this, studentRecords);
        listView.setAdapter(adapter);
    }

    private void loadRecords() {
        Cursor cursor = database.rawQuery("SELECT * FROM students", null);

        if (cursor.moveToFirst()) {
            do {
                String rollNo = cursor.getString(cursor.getColumnIndexOrThrow("rollno"));
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String email = cursor.getString(cursor.getColumnIndexOrThrow("email_id"));
                String course = cursor.getString(cursor.getColumnIndexOrThrow("course"));

                // Create Student object for each record
                studentRecords.add(new Student(rollNo, name, email, course));
            } while (cursor.moveToNext());
        }
        cursor.close();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (database != null) {
            database.close();
        }
    }

}
