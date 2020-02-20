package com.example.hazchemcompat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Space;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    LinearLayout compatList;
    ImageView imv1, imv2;
    Intent myIntent;
    int selectedChem1 = 99, selectedChem2 = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compatList = findViewById(R.id.listofchems);
        imv1 = findViewById(R.id.imageView1);
        imv2 = findViewById(R.id.imageView2);
        LoadChemListing();
    }

    public int i2;
    private void LoadChemListing(){
        for(int i=0; i<12; i++){
            LinearLayout parentlinlayout = new LinearLayout(this);
            parentlinlayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            parentlinlayout.setOrientation(LinearLayout.HORIZONTAL);

            LinearLayout.LayoutParams paramss = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            ImageView iv = new ImageView(this);
            iv.setImageResource(ChemCompat.chemImgs[i]);
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(192, 192);
            iv.setLayoutParams(layoutParams);
            TextView ti = new TextView(this);
            ti.setText("i"+i);
            ti.setLayoutParams(paramss);
            TextView tv = new TextView(this);
            tv.setPadding(16,32,0,0);
            tv.setText(ChemCompat.chemNames[i]);
            tv.setTextSize(24);
            tv.setLayoutParams(paramss);

            parentlinlayout.addView(ti);
            parentlinlayout.addView(iv);
            parentlinlayout.addView(tv);
            i2 = i;
            parentlinlayout.setOnClickListener(new View.OnClickListener() {
                int i3 = i2;
                @Override
                public void onClick(View v) {
                    Log.d("LinLayout", "onClick: "+i3);
                    Toast.makeText(MainActivity.this,"Selected i"+i3, Toast.LENGTH_SHORT).show();
                    if(selectedChem1 > 12){
                        selectedChem1 = i3;
                        imv1.setImageResource(ChemCompat.chemImgs[i3]);
                    }
                    else{
                        selectedChem2 = i3;
                        imv2.setImageResource(ChemCompat.chemImgs[i3]);
                        ShowCompatPopup(selectedChem1, selectedChem2);
                    }
                }
            });

            compatList.addView(parentlinlayout);
            compatList.addView(new Space(this));
        }
    }

    private void ShowCompatPopup(int schem1, int schem2) {
        Intent intent = new Intent(this, CompatPop.class);
        intent.putExtra("chem1", schem1);
        intent.putExtra("chem2", schem2);
        startActivity(intent);
        selectedChem1 = 99;

    }
}
