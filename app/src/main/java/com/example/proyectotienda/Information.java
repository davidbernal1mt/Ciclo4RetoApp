package com.example.proyectotienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectotienda.Entidades.Producto;

public class Information extends AppCompatActivity {
    private TextView textNameInfo, textDescriptionInfo, textPriceInfo, textIdInfo;
    private ImageView imgInfo;
    private Button btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        textIdInfo = (TextView) findViewById(R.id.textIdInfo);
        textNameInfo = (TextView) findViewById(R.id.textNameInfo);
        textDescriptionInfo = (TextView) findViewById(R.id.textDescriptionInfo);
        textPriceInfo = (TextView) findViewById(R.id.textPriceInfo);
        imgInfo = (ImageView) findViewById(R.id.imgInfo);
        btnInfo = (Button) findViewById(R.id.btnInfo);

        Intent intentIn = getIntent();
        Producto producto = new Producto(
                intentIn.getStringExtra("id"),
                intentIn.getStringExtra("name"),
                intentIn.getStringExtra("description"),
                intentIn.getStringExtra("price"),
                intentIn.getStringExtra("image")
        );
        textIdInfo.setText(producto.getId());
        textNameInfo.setText(producto.getName());
        textDescriptionInfo.setText(producto.getDescription());
        textPriceInfo.setText(producto.getPrice());
        imgInfo.setImageResource(Integer.parseInt(producto.getImage()));

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}