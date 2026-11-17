package com.thebighutch.quizapppruebawh;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
TextView ask;
Button ans1;
Button ans2;
Button ans3;
Button ans4;
Button hintB;
int curQ=-1;
int score=0;
MediaPlayer wrong;
MediaPlayer right;
private void nextQ(){
    if(curQ<qList.size()-1) {
        curQ++;
        ask.setText(qList.get(curQ).getAsk());
        ans1.setText(qList.get(curQ).getChoices().get(0));
        ans2.setText(qList.get(curQ).getChoices().get(1));
        ans3.setText(qList.get(curQ).getChoices().get(2));
        ans4.setText(qList.get(curQ).getChoices().get(3));
    }else{
        Intent fj= new Intent(MainActivity.this,BetActivity.class);
        fj.putExtra("USER_SCORE",score);
        startActivity(fj);
    }
}
ArrayList<Question> qList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        right=MediaPlayer.create(this,R.raw.correct_noise);
        wrong=MediaPlayer.create(this,R.raw.wrong_buzzer);
        ask= findViewById(R.id.question);
        ans1= findViewById(R.id.But1);
        ans2= findViewById(R.id.But2);
        ans3= findViewById(R.id.But3);
        ans4= findViewById(R.id.But4);
        hintB= findViewById(R.id.hint);
        ArrayList<String> choices1=new ArrayList<>();
        choices1.add(getString(R.string.estimate));
        choices1.add(getString(R.string.stomach));
        choices1.add(getString(R.string.magic));
        choices1.add(getString(R.string.man));
        ArrayList<String> choices2=new ArrayList<>();
        choices2.add(getString(R.string.soup));
        choices2.add(getString(R.string.scope));
        choices2.add(getString(R.string.soap));
        choices2.add(getString(R.string.map));
        ArrayList<String> choices3=new ArrayList<>();
        choices3.add(getString(R.string.human));
        choices3.add(getString(R.string.hand));
        choices3.add(getString(R.string.hermit));
        choices3.add(getString(R.string.brother));
        ArrayList<String> choices4= new ArrayList<>();
        choices4.add(getString(R.string.mail));
        choices4.add(getString(R.string.male));
        choices4.add(getString(R.string.honey));
        choices4.add(getString(R.string.fear));
        ArrayList<String> choices5=new ArrayList<>();
        choices5.add(getString(R.string.orange));
        choices5.add(getString(R.string.spider));
        choices5.add(getString(R.string.anger));
        choices5.add(getString(R.string.array));


        qList.add(new Question(getString(R.string.q1),choices1,1,getString(R.string.h1)));
        qList.add(new Question(getString(R.string.q2), choices2,0,getString(R.string.h2)));
        qList.add(new Question(getString(R.string.q3), choices3,3,getString(R.string.h3)));
        qList.add(new Question(getString(R.string.q4), choices4,2,getString(R.string.h4)));
        qList.add(new Question(getString(R.string.q5), choices5,1,getString(R.string.h5)));
        nextQ();

        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qList.get(curQ).getCor()==0){
                    Toast.makeText(MainActivity.this, R.string.correct,Toast.LENGTH_SHORT).show();
                    score++;
                    if(right!=null){
                        if(right.isPlaying()){
                            right.seekTo(0);
                        }
                        right.start();
                    }
                }else{
                    Toast.makeText(MainActivity.this, R.string.incorrect,Toast.LENGTH_SHORT).show();
                    if(wrong!=null){
                        if(wrong.isPlaying()){
                            wrong.seekTo(0);
                        }
                        wrong.start();
                    }
                }
                nextQ();
            }
        });
        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qList.get(curQ).getCor()==1){
                    Toast.makeText(MainActivity.this,R.string.correct,Toast.LENGTH_SHORT).show();
                    score++;
                    if(right!=null){
                        if(right.isPlaying()){
                            right.seekTo(0);
                        }
                        right.start();
                    }
                }else{
                    Toast.makeText(MainActivity.this,R.string.incorrect,Toast.LENGTH_SHORT).show();
                    if(wrong!=null){
                        if(wrong.isPlaying()){
                            wrong.seekTo(0);
                        }
                        wrong.start();
                    }
                }
                nextQ();            }
        });
        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qList.get(curQ).getCor()==2){
                    Toast.makeText(MainActivity.this,R.string.correct,Toast.LENGTH_SHORT).show();
                    score++;
                    if(right!=null){
                        if(right.isPlaying()){
                            right.seekTo(0);
                        }
                        right.start();
                    }
                }else{
                    Toast.makeText(MainActivity.this,R.string.incorrect,Toast.LENGTH_SHORT).show();
                    if(wrong!=null){
                        if(wrong.isPlaying()){
                            wrong.seekTo(0);
                        }
                        wrong.start();
                    }
                }
                nextQ();            }
        });
        ans4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qList.get(curQ).getCor()==3){
                    Toast.makeText(MainActivity.this,R.string.correct,Toast.LENGTH_SHORT).show();
                    score++;
                    if(right!=null){
                        if(right.isPlaying()){
                            right.seekTo(0);
                        }
                        right.start();
                    }
                }else{
                    Toast.makeText(MainActivity.this,R.string.incorrect,Toast.LENGTH_SHORT).show();
                    if(wrong!=null){
                        if(wrong.isPlaying()){
                            wrong.seekTo(0);
                        }
                        wrong.start();
                    }
                }
                nextQ();            }
        });
        hintB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hintIntent=new Intent(MainActivity.this, HintActivity.class);
                hintIntent.putExtra("HINT_TEXT",qList.get(curQ).getHint());
                startActivity(hintIntent);
            }
        });

    }
}