package com.drr.mypetsstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.drr.mypetsstore.adapter.ProductoAdapter;
import com.drr.mypetsstore.model.Producto;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ProductoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargarNombreUsuario();
        cargarProductosDisponibles();
        cargarOpcionesDelMenu();

    }

    private void redirigirLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void cargarNombreUsuario() {
        String username = getIntent().getStringExtra("username");

        if (username != null && !username.isEmpty()) {

            TextView welcomeUserTextView = findViewById(R.id.welcome_user_text_view);
            welcomeUserTextView.setText("Bienvenido");

            TextView usernameTextView = findViewById(R.id.username_text_view);
            usernameTextView.setText(username);

        }

    }

    private void cargarProductosDisponibles() {
        RecyclerView productList = findViewById(R.id.product_list);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        productList.setLayoutManager(layoutManager);

        adapter = new ProductoAdapter();
        productList.setAdapter(this.adapter);

        List<Producto> lstProductos = new ArrayList<>();

        lstProductos.add(new Producto("Canario"));
        lstProductos.add(new Producto("Bailarina"));
        lstProductos.add(new Producto("Conejo"));
        lstProductos.add(new Producto("Rana"));
        lstProductos.add(new Producto("Gallina"));

        adapter.setProducts(lstProductos);
    }

    private void cargarOpcionesDelMenu() {
        ImageView menuButton = findViewById(R.id.menu_button);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarMenu(v);
            }
        });
    }

    private void mostrarMenu(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.getMenuInflater().inflate(R.menu.menu_options, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if (item.getItemId() == R.id.login) {
                    redirigirLogin();
                }

                return Boolean.TRUE;
            }
        });

        popup.show();
    }

}