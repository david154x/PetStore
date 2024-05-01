package com.drr.mypetsstore.viewholder;

import android.view.View;
import android.widget.ImageButton;

import androidx.recyclerview.widget.RecyclerView;

import com.drr.mypetsstore.R;

public class ProductoViewHolder {

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageButton addToCartButton;

        public ProductViewHolder(View itemView) {
            super(itemView);
            addToCartButton = itemView.findViewById(R.id.add_to_cart_button);
            addToCartButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Manejar el clic del botón aquí
                }
            });
        }
    }

}
