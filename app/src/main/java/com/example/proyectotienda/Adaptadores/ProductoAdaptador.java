package com.example.proyectotienda.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectotienda.Entidades.Producto;
import com.example.proyectotienda.Information;
import com.example.proyectotienda.R;

import java.util.ArrayList;

public class ProductoAdaptador extends BaseAdapter {

    private Context context;
    private ArrayList<Producto> arrayProductos;

    public ProductoAdaptador(Context context, ArrayList<Producto> arrayProductos) {
        this.context = context;
        this.arrayProductos = arrayProductos;

    }

    public ArrayList<Producto> getArrayProductos() {
        return arrayProductos;
    }

    public void setArrayProductos(ArrayList<Producto> arrayProductos) {
        this.arrayProductos = arrayProductos;
    }

    @Override
    public int getCount() {
        return arrayProductos.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayProductos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        view = layoutInflater.inflate(R.layout.productos_templates,null);

        Producto producto = arrayProductos.get(i);

        ImageView imgProduct = (ImageView) view.findViewById(R.id.imgProduct);
        TextView textName = (TextView)  view.findViewById(R.id.textName);
        TextView textDescription = (TextView)  view.findViewById(R.id.textDescription);
        TextView textPrice = (TextView)  view.findViewById(R.id.textPrice);

        imgProduct.setImageResource(Integer.parseInt(producto.getImage()));
        textName.setText(producto.getName());
        textDescription.setText(producto.getDescription());
        textPrice.setText(producto.getPrice());

        imgProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context.getApplicationContext(), Information.class);
                intent.putExtra("id", producto.getId());
                intent.putExtra("name", producto.getName());
                intent.putExtra("description", producto.getDescription());
                intent.putExtra("price", producto.getPrice());
                intent.putExtra("image", producto.getImage());
                context.startActivity(intent);

            }
        });


        return view;
    }
}
