package com.auca.quizthree;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    private EditText etNames, etEmail, etPhoneNo;
    private Button btnSave, btnViewProfile;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        prefs = getSharedPreferences("ProfilePrefs", MODE_PRIVATE);
        editor = prefs.edit();

        etNames = findViewById(R.id.etNames);
        etEmail = findViewById(R.id.etEmail);
        etPhoneNo = findViewById(R.id.etPhoneNo);
        btnSave = findViewById(R.id.btnSave);
        btnViewProfile = findViewById(R.id.btnViewProfile);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names = etNames.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String phoneNo = etPhoneNo.getText().toString().trim();

                if (names.isEmpty() || email.isEmpty() || phoneNo.isEmpty()) {
                    Toast.makeText(ProfileActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(ProfileActivity.this, "Invalid email format", Toast.LENGTH_SHORT).show();
                    return;
                }

                editor.putString("names", names);
                editor.putString("email", email);
                editor.putString("phoneNo", phoneNo);
                editor.apply();

                Toast.makeText(ProfileActivity.this, "Profile saved successfully", Toast.LENGTH_SHORT).show();
                etNames.setText("");
                etEmail.setText("");
                etPhoneNo.setText("");
            }
        });

        btnViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, DetailActivity.class));
            }
        });
    }
}
