package com.example.BasicBankingSystem.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.BasicBankingSystem.R;

public class HomeScreen extends AppCompatActivity {


    ImageView bankLogo;
    TextView tvBankTitle;
    Button btnAllUsers, btnAllTransactions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        bankLogo = findViewById(R.id.imageView);
        btnAllUsers = findViewById(R.id.all_users);
        btnAllTransactions = findViewById(R.id.all_transactions);
        tvBankTitle = findViewById(R.id.bank_title);

    }

   public void showAllUsers(View view) {
        Intent intent = new Intent(this, AllUsersList.class);
        startActivity(intent);
    }

    public void showAllTransactions(View view) {
        Intent intent = new Intent(this, TransactionHistory.class);
        startActivity(intent);
    }
}