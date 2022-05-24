package com.cookandroid.android_10part_project6num;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);


        Button btnStart, btnStop;
        final ViewFlipper vFlipper;
        setTitle("투표 결과");

        // 앞 화면에서 보낸 투표 결과 값을 받는다.
        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");

        Integer imageFileId[] = { R.drawable.pic1, R.drawable.pic2,
                R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
                R.drawable.pic6, R.drawable.pic7, R.drawable.pic8,
                R.drawable.pic9 };

        // 1등 그림 이름과 그림 파일을 보여준다.
        TextView tvTop = (TextView) findViewById(R.id.tv1);
        ImageView ivTop = (ImageView) findViewById(R.id.iv1);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        vFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);

        vFlipper.setFlipInterval(1000);


        btnStart.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                vFlipper.startFlipping();
                int maxEntry = 0;
        for (int i = 1; i < voteResult.length; i++) {
            if (voteResult[maxEntry] < voteResult[i])
                maxEntry = i;
        }
        tvTop.setText(imageName[maxEntry]);
        ivTop.setImageResource(imageFileId[maxEntry]);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                vFlipper.stopFlipping();
            }
        });




    }
}