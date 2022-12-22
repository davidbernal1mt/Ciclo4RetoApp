package com.example.proyectotienda.DB;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.proyectotienda.Adaptadores.ProductoAdaptador;
import com.example.proyectotienda.Entidades.Producto;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Firebase {
    private FirebaseFirestore db;

    public Firebase(){
      this.db = FirebaseFirestore.getInstance();
    }

    public void insertData (Producto producto){
        // Create a new user with a first and last name
        Map<String, Object> prod = new HashMap<>();
        prod.put("id", producto.getId());
        prod.put("name", producto.getName());
        prod.put("description", producto.getDescription());
        prod.put("price", producto.getPrice());
        prod.put("image", producto.getImage());
        db.collection("products").add(prod);
    }

    public void getData (ProductoAdaptador adapter){
        db.collection("products")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<Producto> list = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Producto producto = new Producto(
                                        document.getData().get("id").toString(),
                                        document.getData().get("name").toString(),
                                        document.getData().get("description").toString(),
                                        document.getData().get("price").toString(),
                                        document.getData().get("image").toString()
                                );
                                list.add(producto);
                            }
                            adapter.setArrayProductos(list);
                            adapter.notifyDataSetChanged();
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    public void deleteData(String id){
        db.collection("products")
                .document(id)
                .delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                    //cualquier cosa
                    }
                });

    }


    public void updateData(Producto producto){
        db.collection("products")
                .document(String.valueOf(producto.getId()))
                .update(
                        "name",producto.getName(),
                                    "description",producto.getDescription(),
                        "price", producto.getPrice()
                )
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("MainActivity","Error",e);
                    }
                });
    }

}
