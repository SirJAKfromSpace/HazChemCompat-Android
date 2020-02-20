package com.example.hazchemcompat;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class CompatPop extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_compat);

//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//        int width = dm.widthPixels, height = dm.heightPixels;
//        getWindow().setLayout((int)(width),(int)(height*0.5));

        Intent intent = getIntent();
        int chem1 = intent.getIntExtra("chem1", 0);
        int chem2 = intent.getIntExtra("chem2", 0);

        TextView t1 = findViewById(R.id.textChemleft);
        t1.setText(ChemCompat.chemNames[chem1]);
        ImageView v1 = findViewById(R.id.imageViewleft);
        v1.setImageResource(ChemCompat.chemImgs[chem1]);

        TextView t2 = findViewById(R.id.textChemright);
        t2.setText(ChemCompat.chemNames[chem2]);
        ImageView v2 = findViewById(R.id.imageViewright);
        v2.setImageResource(ChemCompat.chemImgs[chem2]);

        int result = ChemCompat.compatTable[chem1][chem2];
        TextView tr = findViewById(R.id.textResult);
        tr.setText(ChemCompat.compatMsg[result]);
        ImageButton imr = findViewById(R.id.imResultColor);
        imr.setBackgroundColor(ChemCompat.compatColors[result]);
        MediaPlayer mp = MediaPlayer.create(this,ChemCompat.CompatSounds[result]);
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
//        tr.setTextColor(ChemCompat.compatColors[result]);
    }


    public void GoBack(View view) {
        finish();
    }
}
