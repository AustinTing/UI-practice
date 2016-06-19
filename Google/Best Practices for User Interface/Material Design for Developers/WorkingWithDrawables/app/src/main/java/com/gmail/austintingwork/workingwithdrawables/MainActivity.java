package com.gmail.austintingwork.workingwithdrawables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tint();
//        vector();
    }



    private void tint() {
        setContentView(R.layout.tint);
    }
    private void vector() {
        setContentView(R.layout.vector);
    }
}
