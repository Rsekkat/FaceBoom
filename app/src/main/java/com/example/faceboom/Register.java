package com.example.faceboom;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Register  extends AppCompatActivity {

    public Context registerContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerContext = this;

        Button subscribeButton = findViewById(R.id.btn_subscribe);

        subscribeButton.setOnClickListener(subscribeListener);
    }

    private View.OnClickListener subscribeListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(registerContext, Login.class));
        }
    };
}
