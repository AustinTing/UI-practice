package com.gmail.austintingwork.definingshadowsandclippingviews;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.graphics.Outline;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity {

    static final String TAG = "debug";

    private ViewOutlineProvider mOutlineProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z);
        //  Z值解說範例
        z();
        //  陰影和外框解說範例
//        shadowAndOutline();
        //  裁切範例
//        clip();
    }




    private void z() {
        TextView textView = (TextView) findViewById(R.id.text1);
        //  利用setElevation()設定靜態高度
//        textView.setElevation(2);
        Log.d(TAG, "elevation = " + textView.getElevation());
        textView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getActionMasked();

                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d(TAG, "ACTION_DOWN on view.");
                        //  利用setTranslationZ()設定動態高度
                        view.setTranslationZ(10);
                        return true;
                    case MotionEvent.ACTION_UP:
                        Log.d(TAG, "ACTION_UP on view.");
                        view.setTranslationZ(0);
                        return true;
                    default:
                        return false;
                }

            }

        });

    }


    private void shadowAndOutline() {
        TextView textView = (TextView) findViewById(R.id.textShadow);
//        如果不想有陰影的話
//        textView.setOutlineProvider(null);
    }

    private void clip() {
        mOutlineProvider = new ClipOutlineProvider();
        final View clippedView = findViewById(R.id.frame);
        clippedView.setOutlineProvider(mOutlineProvider);
        Button btnClip = (Button) findViewById(R.id.btnClip);
        btnClip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clippedView.getClipToOutline()) {

                    clippedView.setClipToOutline(false);

                    ((Button) view).setText("clip it!");
                } else {

                    clippedView.setClipToOutline(true);


                    ((Button) view).setText("unclip it");
                }
            }
        });
    }


    private class ClipOutlineProvider extends ViewOutlineProvider {
        @Override
        public void getOutline(View view, Outline outline) {
            final int margin = Math.min(view.getWidth(), view.getHeight()) / 10;
            outline.setRoundRect(
                    margin,
                    margin,
                    view.getWidth() - margin,
                    view.getHeight() - margin,
                    margin / 2);
        }
    }

}
