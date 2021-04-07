package com.example.thelabit.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.thelabit.R;

public class ViewPlanes extends AppCompatActivity {

    Button btnModificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_planes);

        btnModificar    = (Button) findViewById(R.id.btnModificar);

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ViewPlanesDetalle.class);
                startActivity(intent);
            }
        });
    }
}