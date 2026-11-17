package com.thebighutch.quizapppruebawh;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ScoreActivity extends AppCompatActivity {
    int score;
    TextView scoreboard;
    EditText mailEntry;
    Button sendButton;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_score);
        score=getIntent().getIntExtra("USER_SCORE",0);
        scoreboard=(TextView) findViewById(R.id.scoreText);
        scoreboard.setText(getString(R.string.points)+score);
        mailEntry=(EditText) findViewById(R.id.userEmail);
        sendButton=(Button) findViewById(R.id.sendButton);
        reset=findViewById(R.id.resetB);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent send= new Intent(Intent.ACTION_SENDTO);
                send.setData(Uri.parse("mailto:"));
                send.putExtra(Intent.EXTRA_EMAIL,new String[]{mailEntry.getText().toString()});
                send.putExtra(Intent.EXTRA_SUBJECT,getString(R.string.subject));
                send.putExtra(Intent.EXTRA_TEXT,getString(R.string.recibes)+score+getString(R.string.body));
                startActivity(Intent.createChooser(send,getString(R.string.pick_app)));

            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reset=new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(reset);
            }
        });


    }
}