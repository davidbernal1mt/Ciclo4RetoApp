package com.example.proyectotienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.proyectotienda.DB.Firebase;
import com.example.proyectotienda.Entidades.Producto;

public class Form extends AppCompatActivity {

    private Button btnForm;
    private EditText editNameForm, editDescriptionForm, editPriceForm;
    private Firebase firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        btnForm = (Button) findViewById(R.id.btnForm);
        editNameForm = (EditText)  findViewById(R.id.editNameForm);
        editDescriptionForm = (EditText)  findViewById(R.id.editDescriptionForm);
        editPriceForm = (EditText)  findViewById(R.id.editPriceForm);

        firebase = new Firebase();

        btnForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Producto producto = new Producto(
                        editNameForm.getText().toString(),
                        editDescriptionForm.getText().toString(),
                        editPriceForm.getText().toString(),
                        String.valueOf(R.drawable.producto2)
                );

                firebase.insertData(producto);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });



    }
}