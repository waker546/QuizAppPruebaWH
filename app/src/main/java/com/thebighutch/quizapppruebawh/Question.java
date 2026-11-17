package com.thebighutch.quizapppruebawh;

import java.util.ArrayList;

public class Question {
    private String ask;
    private ArrayList<String> choices;
    private int cor;
    private String hint;
    public Question(String q, ArrayList<String> opts, int correct, String riddle ){
        ask=q; choices=opts; cor=correct; hint=riddle;
    }
    public int getCor(){
        return cor;
    }
    public String getAsk(){
        return ask;
    }
    public ArrayList<String> getChoices(){
        return choices;
    }
    public String getHint(){
        return hint;
    }
}
