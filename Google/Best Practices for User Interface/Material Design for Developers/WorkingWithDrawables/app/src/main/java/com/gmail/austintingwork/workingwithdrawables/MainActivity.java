package com.gmail.austintingwork.workingwithdrawables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tint();

    }

    private void tint() {
        setContentView(R.layout.tint);

    }
}
