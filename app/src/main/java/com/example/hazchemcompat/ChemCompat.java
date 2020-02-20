package com.example.hazchemcompat;

import android.graphics.Color;

public class ChemCompat {
    public static int[] chemNames = {R.string.flammablegas,R.string.nontoxicflammablegas,R.string.toxicgas,R.string.oxidizinggas,
                            R.string.flammableliquid,R.string.flammablesolid,R.string.spontaneouslycombustible,
                            R.string.dangerouswhenwet,R.string.oxidizingagent,R.string.organicperoxide,
                            R.string.toxicsubstance,R.string.corrosivesubstance};
    public static int[] chemImgs = {R.drawable.flammable,R.drawable.nontoxnonflam,R.drawable.toxicgas,R.drawable.oxigas,
                            R.drawable.flammliquids,R.drawable.flamsolids,R.drawable.spontcombust,
                            R.drawable.dangerwet,R.drawable.oxidizagent,R.drawable.orgperox,
                            R.drawable.verytoxic,R.drawable.corrosive};

    public static int[] compatMsg = {R.string.oktostoretogether,R.string.segregate3m,R.string.segregate5m,R.string.fullyisolate,R.string.checkmsdsnotes};
    public static int[] compatColors = {Color.parseColor("#27ae60"),Color.parseColor("#f1c40f"),
                            Color.parseColor("#e67e22"),Color.parseColor("#c0392b"),Color.parseColor("#7f8c8d")};
    public  static  int[] CompatSounds = {R.raw.greensound,R.raw.orangesound,R.raw.orangesound,R.raw.redsound,R.raw.greysound};



    public static int[][] compatTable = {
            {0,0,1,1,2,2,2,2,1,3,1,2},
            {0,0,0,0,2,2,2,2,1,3,1,2},
            {1,0,4,1,2,2,2,2,1,3,1,2},
            {1,0,1,0,2,2,2,2,1,3,1,2},
            {2,2,2,2,0,1,2,2,2,3,2,1},
            {2,2,2,2,1,0,1,2,1,3,1,4},
            {2,2,2,2,2,1,0,2,2,3,1,1},
            {2,2,2,2,2,2,2,0,2,3,1,2},
            {1,1,1,1,2,1,2,2,4,3,1,1},
            {3,3,3,3,3,3,3,3,3,0,3,1},
            {1,1,1,1,2,1,1,1,1,3,0,2},
            {2,2,2,2,1,4,1,2,1,1,2,4}
    };
}
