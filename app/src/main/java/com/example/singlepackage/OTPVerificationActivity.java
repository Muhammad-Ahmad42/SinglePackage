package com.example.singlepackage;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OTPVerificationActivity extends AppCompatActivity {
EditText inpuCode1,inpuCode2,inpuCode3,inpuCode4,inpuCode5,inpuCode6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_otpverification);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void init(){
        inpuCode1=findViewById(R.id.inputcode1);
        inpuCode2=findViewById(R.id.inputcode2);
        inpuCode3=findViewById(R.id.inputcode3);
        inpuCode4=findViewById(R.id.inputcode4);
        inpuCode5=findViewById(R.id.inputcode5);
        inpuCode6=findViewById(R.id.inputcode6);
    }
    private  void setUoOtpInputs(){
        inpuCode1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                  if(!s.toString().trim().isEmpty()){
                  inpuCode2.requestFocus();
     }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}