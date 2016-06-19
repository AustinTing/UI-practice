package com.gmail.austintingwork.workingwithdrawables;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String TAG ="debug";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tint();
//        extractProminentColors();
//        extractMainColor();
//        vector();
    }

    private void tint() {
        setContentView(R.layout.tint);
    }

    private void extractProminentColors() {
        setContentView(R.layout.palette1);
        final TextView vibrant = (TextView) findViewById(R.id.vibrant);
        final TextView vibrantDark = (TextView) findViewById(R.id.vibrantDark);
        final TextView vibrantLight = (TextView) findViewById(R.id.vibrantLight);
        final TextView muted = (TextView) findViewById(R.id.muted);
        final TextView mutedDark = (TextView) findViewById(R.id.mutedDark);
        final TextView mutedLight = (TextView) findViewById(R.id.mutedLight);
        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.boat);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
                vibrant.setBackgroundColor(vibrantSwatch.getRgb());
                Palette.Swatch darkVibrantSwatch = palette.getDarkVibrantSwatch();
                vibrantDark.setBackgroundColor(darkVibrantSwatch.getRgb());
                //  vibrantLight is null in this case
//                Palette.Swatch lightVibrantSwatch = palette.getLightVibrantSwatch();
//                vibrantLight.setBackgroundColor(lightVibrantSwatch.getRgb());
                Palette.Swatch mutedSwatch = palette.getMutedSwatch();
                muted.setBackgroundColor(mutedSwatch.getRgb());
                Palette.Swatch darkMutedSwatch = palette.getDarkMutedSwatch();
                mutedDark.setBackgroundColor(darkMutedSwatch.getRgb());
                Palette.Swatch lightMutedSwatch = palette.getLightMutedSwatch();
                mutedLight.setBackgroundColor(lightMutedSwatch.getRgb());

            }
        });
    }

    private void extractMainColor() {
        setContentView(R.layout.palette2);
        final TextView mainColor = (TextView) findViewById(R.id.mainColor);
        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.boat);

        Palette.Builder builder = new Palette.Builder(bitmap);

        builder.maximumColorCount(1);

        builder.generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch swatch = palette.getSwatches().get(0);
                if (swatch != null) {
                    mainColor.setBackgroundColor(swatch.getRgb());
                } else {
                    Log.e("debug", "swatch is null");
                }
            }
        });
    }


    private void vector() {
        setContentView(R.layout.vector);
    }


}
