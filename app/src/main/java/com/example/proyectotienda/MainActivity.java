package com.example.proyectotienda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectotienda.Adaptadores.ProductoAdaptador;
import com.example.proyectotienda.DB.Firebase;
import com.example.proyectotienda.Entidades.Producto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listviewProducts;
    private ProductoAdaptador productoAdaptador;
    private ArrayList<Producto> arrayProductos;
    private Firebase firebase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebase = new Firebase();

        listviewProducts = (ListView) findViewById(R.id.listviewProducts);
        arrayProductos = new ArrayList<>();
        productoAdaptador = new ProductoAdaptador(this,arrayProductos);
        listviewProducts.setAdapter(productoAdaptador);

        /*arrayProductos = new ArrayList<>();

        Producto producto1 = new Producto("Producto 1", "Vino", "50.000", R.drawable.producto1);
        Producto producto2 = new Producto("Producto 2", "Queso", "20.000", R.drawable.producto2);
        Producto producto3 = new Producto("Producto 3", "Galletas", "10.000", R.drawable.producto3);
        Producto producto4 = new Producto("Producto 4", "Vino", "80.000", R.drawable.producto1);
        Producto producto5 = new Producto("Producto 5", "Queso", "40.000", R.drawable.producto2);
        Producto producto6 = new Producto("Producto 6", "Galletas", "25.000", R.drawable.producto3);

        arrayProductos.add(producto1);
        arrayProductos.add(producto2);
        arrayProductos.add(producto3);
        arrayProductos.add(producto4);
        arrayProductos.add(producto5);
        arrayProductos.add(producto6);*/



        productoAdaptador = new ProductoAdaptador(this,arrayProductos);

        listviewProducts.setAdapter(productoAdaptador);
        firebase.getData(productoAdaptador);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemAdd:
                Intent intent = new Intent(getApplicationContext(), Form.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Agregar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemFavorite:
                Toast.makeText(getApplicationContext(),"Favorito", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemShare:
                Toast.makeText(getApplicationContext(),"Compartir", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}