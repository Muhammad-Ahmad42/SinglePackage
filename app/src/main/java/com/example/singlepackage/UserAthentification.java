package com.example.singlepackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class UserAthentification extends AppCompatActivity {
    private CardView ic_moveToInformationPage;
    private EditText etUserPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_athentification);

        init();

        ic_moveToInformationPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = etUserPhoneNumber.getText().toString().trim();
                if (phoneNumber.length() == 11) {
                    Intent intent = new Intent(UserAthentification.this, OTPVerificationActivity.class);
                    intent.putExtra("mobile",etUserPhoneNumber.getText().toString().trim());
                    startActivity(intent);
                } else {

                    Toast.makeText(UserAthentification.this, "Please enter a valid phone number (11 digits)", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Method to initialize views
    private void init() {
        ic_moveToInformationPage = findViewById(R.id.ic_moveToInformationPage);
        etUserPhoneNumber = findViewById(R.id.etUserPhoneNumber); // Corrected the ID here
    }
}
