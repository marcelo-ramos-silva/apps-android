package com.android.marceloramos.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.idButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), SegundaActivity.class);

                //instanciar objeto
                Usuario usuario = new Usuario("marcelo@gmail.com");

                //passar dados entre activitys
                intent.putExtra("nome", "Marcelo");
                intent.putExtra("idade",26);
                intent.putExtra("objeto", usuario);
                startActivity(intent);
            }
        });
    }
}
