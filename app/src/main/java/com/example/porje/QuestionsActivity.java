package com.example.porje;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity{
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "We ___ American.",
            "___ this magazine before?",
            "This is our new teacher. ___ name is Mark",
            "He ___ the newspaper every day",
            "Is Mont Blanc ___ mountain in Europe?",
            "British people ___ tea with milk.",
            "___ you like Chinese food?",
            "It’s my ___ computer.",
            "Could we ___ the bill, please?",
            "The people ___ in room 12.",
            "He ___ jeans.",
            "I ___ my new job last week",
            "There isn’t ___ pasta in the kitchen.",
            "She ___ to cook for her boyfriend",
            "The elephant is ___ land animal in the world.",
            "___ yesterday?",
            "James would like ___ basketball.",
            "I always ___.",
            "We ___ to Canada.",
            "He ___ follow instructions.",

    };
    String answers[] = {"aren't","Have you read","His","reads","the highest","drink","Do","parents'",
            "have","are","doesn’t usually wear","began","any","isn’t going","the biggest",
            "Did you study","to play","work hard","haven’t been","can’t"};
    String opt[] = {
            "not","not are","aren't","isn't ",
            "Do you read","Are you going to read","Are you reading","Have you read",
            "His","Her","Its","He",
            "read","reads","doesn’t reads","don’t reads",
            "the higher","the most highest","the more high","the highest",
            "to drink","drink","drinks*","are drink",
            "Do","Does","Are","Is",
            "parents","parents'","parent","parent's",
            "take","want","have","ask",
            "is","am","are","be",
            "doesn’t usually wear","isn’t usually wearing","wears usually","doesn’t wear usually",
            "have begun","began","am begin","begin",
            "some","any","a","any",
            "isn’t going","isn’t go","aren’t going","doesn’t go",
            "the bigger","the most big","biggest","the biggest",
            "You studied","Did you studied","Did you study","Studied you",
            "playing","to play","play","to playing",
            "work hard","hard work","hardly work","work hardly",
            "haven’t be","hasn’t been","hasn’t be","haven’t been",
            "doesn’t can","not can","isn’t can","can’t",
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_questions);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Merhaba Denek");
        else
            textView.setText("Merhaba " + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Lütfen Bir Şık Seçiniz", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Doğru", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Yanlış", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }
}
