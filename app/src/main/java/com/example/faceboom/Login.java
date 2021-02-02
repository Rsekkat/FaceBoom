package com.example.faceboom;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    public Context loginContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginContext = this;

        Button connexionButton = findViewById(R.id.connexion);
        Button registerButton = findViewById(R.id.register);

        connexionButton.setOnClickListener(connexionListener);
        registerButton.setOnClickListener(registeristener);
    }

    private View.OnClickListener connexionListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(loginContext, Home.class));
        }
    };

    private View.OnClickListener registeristener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(loginContext, Register.class));
        }
    };
}
