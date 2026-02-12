package com.auca.quizthree;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private TextView tvNames, tvEmail, tvPhoneNo;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        prefs = getSharedPreferences("ProfilePrefs", MODE_PRIVATE);

        tvNames = findViewById(R.id.tvNames);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhoneNo = findViewById(R.id.tvPhoneNo);

        String names = prefs.getString("names", "No name saved");
        String email = prefs.getString("email", "No email saved");
        String phoneNo = prefs.getString("phoneNo", "No phone saved");

        tvNames.setText("Names: " + names);
        tvEmail.setText("Email: " + email);
        tvPhoneNo.setText("Phone: " + phoneNo);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
