package com.example.faceboom;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NewPost extends AppCompatActivity {

    public Context loginContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpost);
        loginContext = this;

        Button homeButton = findViewById(R.id.button_home);
        Button addButton = findViewById(R.id.button_add);

        homeButton.setOnClickListener(homeListener);
        addButton.setOnClickListener(addistener);
    }

    private View.OnClickListener homeListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(loginContext, Home.class));
        }
    };

    private View.OnClickListener addistener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(loginContext, NewPost.class));
        }
    };
}
