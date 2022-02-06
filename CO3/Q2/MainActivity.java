package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    EditText Name;
    EditText address;
    EditText email;
    Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);
        Submit = findViewById(R.id.button);

    }

    public void callSecondActivity(View view) {
        Intent i = new Intent(getApplicationContext(), MainActivity2.class);
        String str = "Name     :         "+ Name.getText().toString();
        i.putExtra("Value1", str);
        String str1 ="Address  :         "+ address.getText().toString();
        i.putExtra("Value2", str1);
        String str2 = "Email   :         "+ email.getText().toString();
        i.putExtra("Value3", str2);

        startActivity(i);
    }


}