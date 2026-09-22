package com.example.dialer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNumber;
    Button btnCall, btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = findViewById(R.id.etNumber);
        btnCall = findViewById(R.id.btnCall);
        btnSave = findViewById(R.id.btnSave);

        btnCall.setOnClickListener(v -> {

            String number = etNumber.getText().toString().trim();

            if (number.isEmpty()) {
                Toast.makeText(this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        });

        btnSave.setOnClickListener(v -> {

            String number = etNumber.getText().toString().trim();

            if (number.isEmpty()) {
                Toast.makeText(this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(Intent.ACTION_INSERT);
            intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

            intent.putExtra(ContactsContract.Intents.Insert.PHONE, number);

            startActivity(intent);
        });
    }
}