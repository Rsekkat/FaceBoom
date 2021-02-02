package com.example.faceboom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class NewPost extends AppCompatActivity {

    public Context loginContext;
    ImageView imageview;
    private static final int PHOTO = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpost);
        loginContext = this;

        Button homeButton = findViewById(R.id.button_home);
        Button addButton = findViewById(R.id.button_add);

        homeButton.setOnClickListener(homeListener);
        addButton.setOnClickListener(addistener);

        imageview = findViewById(R.id.image_Camera);
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

    public void OpenGalerie(View view) {
        Intent i = new Intent(Intent.ACTION_PICK);
        i.setType("image/*");
        startActivityForResult(i, PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == PHOTO) {
            if (requestCode == RESULT_OK) {
                Uri selectImage = data.getData();
                InputStream inputstream = null;
                try {
                    assert selectImage != null;
                    inputstream = getContentResolver().openInputStream(selectImage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                BitmapFactory.decodeStream(inputstream);
                imageview.setImageURI(selectImage);
            }
        }
    }
}
