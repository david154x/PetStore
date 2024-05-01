package com.drr.mypetsstore;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.TimeUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.drr.mypetsstore.config.RetrofitClient;
import com.drr.mypetsstore.dto.UserDTO;
import com.drr.mypetsstore.service.WelcomeService;
import com.drr.mypetsstore.service.impl.WelcomeServiceImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activiy_login);

        EditText passwordEditText = findViewById(R.id.userPassword);
        passwordEditText.setTransformationMethod(new PasswordTransformationMethod());

        EditText userName = findViewById(R.id.userName);
        EditText userPassword = findViewById(R.id.userPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        comportamientoBtnLogin(userName, userPassword, btnLogin);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void redirigir(String nombreUsuario) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("username", nombreUsuario);
        startActivity(intent);
        finish();
    }

    private void comportamientoBtnLogin(EditText userName, EditText userPassword, Button btnLogin) {
        try {
            WelcomeService welcomeService = new WelcomeServiceImpl(RetrofitClient.getRetrofitInstance());

            btnLogin.setOnClickListener(v -> {

                UserDTO usuario = new UserDTO();
                usuario.setUserName(userName.getText().toString());
                usuario.setUserPassword(userPassword.getText().toString());

                Call<Map<String, String>> todoBienTodoBien = welcomeService.login(usuario);

                todoBienTodoBien.enqueue(new Callback<Map<String, String>>() {

                    @Override
                    public void onResponse(Call<Map<String, String>> call, Response<Map<String, String>> response) {

                        if (response.isSuccessful()) {
                            // Inicio de sesión exitoso
                            String nombreUsuario = response.body().get("nombreUsuario");

                            Toast.makeText(LoginActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                            redirigir(nombreUsuario);
                        } else {
                            // Inicio de sesión fallido
                            Toast.makeText(LoginActivity.this, "Inicio de sesion fallido", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Map<String, String>> call, Throwable throwable) {
                        Toast.makeText(LoginActivity.this, "Error: " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                });

            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
