package com.thebighutch.quizapppruebawh;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FinalActivity extends AppCompatActivity {

    EditText answer;
    Button submit;
    int score;
    int bet;
    MediaPlayer wrong;
    MediaPlayer right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_final);
        bet=getIntent().getIntExtra("USER_BET",0);
        score=getIntent().getIntExtra("USER_SCORE",0);
        answer=findViewById(R.id.answer);
        submit=findViewById(R.id.submit);
        right=MediaPlayer.create(this,R.raw.correct_noise);
        wrong=MediaPlayer.create(this,R.raw.wrong_buzzer);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer.getText().toString().toLowerCase().replaceAll("[^a-zA-Z]","").equals(getString(R.string.shirt))){
                    score+=bet;
                    Toast.makeText(FinalActivity.this,R.string.correct,Toast.LENGTH_SHORT).show();
                    if(right!=null){
                        if(right.isPlaying()){
                            right.seekTo(0);
                        }
                        right.start();
                    }
                }else {
                    score-=bet;
                    Toast.makeText(FinalActivity.this,R.string.incorrect,Toast.LENGTH_SHORT).show();
                    if(wrong!=null){
                        if(wrong.isPlaying()){
                            wrong.seekTo(0);
                        }
                        wrong.start();
                    }
                }
                Intent scorecard=new Intent(FinalActivity.this,ScoreActivity.class);
                scorecard.putExtra("USER_SCORE",score);
                startActivity(scorecard);
            }
        });

    }
}