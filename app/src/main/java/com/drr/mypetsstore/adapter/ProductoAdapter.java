package com.drr.mypetsstore.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.drr.mypetsstore.R;
import com.drr.mypetsstore.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder> {

    private List<Producto> lstProducts = new ArrayList<>();

    public void setProducts(List<Producto> products) {
        this.lstProducts.clear();
        this.lstProducts.addAll(products);
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Producto producto = lstProducts.get(position);
        holder.productName.setText(producto.getNombre());
        holder.addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí deberías manejar la adición del producto al carrito
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstProducts.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView productName;
        ImageButton addToCartButton;

        ViewHolder(View view) {
            super(view);
            productName = view.findViewById(R.id.product_name);
            addToCartButton = view.findViewById(R.id.add_to_cart_button);
            cargarBotonAgregar(view);
        }
    }

    private static void cargarBotonAgregar(View itemView) {
        ImageButton addToCartButton = itemView.findViewById(R.id.add_to_cart_button);
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Manejar el clic del botón aquí
            }
        });
    }

}
