package com.example.porje;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView tv, tv2, tv3;
    Button btnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_result);

        tv = (TextView)findViewById(R.id.tvres);
        tv2 = (TextView)findViewById(R.id.tvres2);
        tv3 = (TextView)findViewById(R.id.tvres3);
        btnRestart = (Button) findViewById(R.id.btnRestart);

        String S1="A1";
        String S2="B1";
        String S3="C1";

        int x= QuestionsActivity.correct;


        StringBuffer sb = new StringBuffer();
        sb.append("Doğru Sayısı: " + QuestionsActivity.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Yanlış Sayısı: " + QuestionsActivity.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        if(x<=7) {
            sb3.append( "Seviye: " + S1 + "\n" );
        }
        else if(x<=14){
            sb3.append( "Seviye: " + S2 + "\n" );
        }
        else{
            sb3.append( "Seviye: " + S3 + "\n" );

        }
        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);

        QuestionsActivity.correct=0;
        QuestionsActivity.wrong=0;

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
        });
    }
}
