package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;
import android.content.Intent;





public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private int loginAttempts = 0;
    private final int MAX_ATTEMPTS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Replace this with your authentication logic
                if (isValidLogin(username, password)) {
                    // Successful login
                    openWelcomePage();
                } else {
                    loginAttempts++;

                    if (loginAttempts >= MAX_ATTEMPTS) {
                        // Disable the login button
                        loginButton.setEnabled(false);

                        // Display a toast message indicating the maximum attempts
                        showToast("You have exceeded the maximum login attempts.");
                    } else {
                        // Display a toast message indicating the failed login attempt
                        showToast("Invalid username or password. Attempts: " + loginAttempts + "/" + MAX_ATTEMPTS);
                    }
                }
            }
        });
    }

    // Replace this with your actual authentication logic
    private boolean isValidLogin(String username, String password) {
        return username.equals("test@email.com") && password.equals("test1234");
    }

    private void openWelcomePage() {
        // Start the WelcomeActivity
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }




    private void showToast(String message) {
        // Display a toast message with the specified message
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}

