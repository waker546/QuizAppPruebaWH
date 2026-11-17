package com.thebighutch.quizapppruebawh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class BetActivity extends AppCompatActivity {
    TextView msg;
    NumberPicker betPicker;
    int score;
    Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bet);
        msg=findViewById(R.id.scoreText);
        betPicker=findViewById(R.id.betPicker);
        score=getIntent().getIntExtra("USER_SCORE",0);
        betPicker.setMaxValue(score);
        betPicker.setMinValue(0);
        betPicker.setValue(score);

        next=findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next=new Intent(BetActivity.this,FinalActivity.class);
                next.putExtra("USER_BET",betPicker.getValue());
                next.putExtra("USER_SCORE",score);
                startActivity(next);
            }
        });


    }
}