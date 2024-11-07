package com.example.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etRollNo, etName, etEmail, etCourse;
    private Button btnInsert, btnUpdate, btnView, btnDelete;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etRollNo = findViewById(R.id.etRollNo);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etCourse = findViewById(R.id.etCourse);

        btnInsert = findViewById(R.id.btnInsert);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnView = findViewById(R.id.btnView);
        btnDelete = findViewById(R.id.btnDelete);

        dbHelper = new DatabaseHelper(this);
        database = dbHelper.getWritableDatabase();

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertRecord();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRecord();
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ViewRecordsActivity.class));
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteRecord();
            }
        });
    }

    private void insertRecord() {
        String rollNo = etRollNo.getText().toString();
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String course = etCourse.getText().toString();

        ContentValues values = new ContentValues();
        values.put("rollno", rollNo);
        values.put("name", name);
        values.put("email_id", email);
        values.put("course", course);

        long rowId = database.insert("students", null, values);
        if (rowId > 0) {
            Toast.makeText(this, "Record inserted successfully", Toast.LENGTH_SHORT).show();
            clearEditTextFields();
        } else {
            Toast.makeText(this, "Error inserting record", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateRecord() {
        String rollNo = etRollNo.getText().toString();
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String course = etCourse.getText().toString();

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email_id", email);
        values.put("course", course);

        int rowsAffected = database.update("students", values, "rollno=?", new String[]{rollNo});
        if (rowsAffected > 0) {
            Toast.makeText(this, "Record updated successfully", Toast.LENGTH_SHORT).show();
            clearEditTextFields();
        } else {
            Toast.makeText(this, "Error updating record", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteRecord() {
        String rollNoToDelete = etRollNo.getText().toString();

        int rowsDeleted = database.delete("students", "rollno=?", new String[]{rollNoToDelete});
        if (rowsDeleted > 0) {
            Toast.makeText(this, "Record deleted successfully", Toast.LENGTH_SHORT).show();
            clearEditTextFields();
        } else {
            Toast.makeText(this, "Error deleting record", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearEditTextFields() {
        etRollNo.getText().clear();
        etName.getText().clear();
        etEmail.getText().clear();
        etCourse.getText().clear();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (database != null) {
            database.close();
        }
    }
}
