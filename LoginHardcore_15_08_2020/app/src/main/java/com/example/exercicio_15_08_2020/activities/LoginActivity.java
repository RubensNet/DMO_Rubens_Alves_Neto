package com.example.exercicio_15_08_2020.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.exercicio_15_08_2020.R;
import com.example.exercicio_15_08_2020.model.Login;

public class LoginActivity extends AppCompatActivity{

    private TextView usuarioText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuarioText = findViewById(R.id.textview_usuario);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        verificarLogin();
    }

    private void verificarLogin() {
        Intent intent = getIntent();
        Bundle embrulho = intent.getExtras();

        if(embrulho != null) {
            int usuario = embrulho.getInt(MainActivity.KEY_USUARIO);
            int senha = embrulho.getInt(MainActivity.KEY_SENHA);
            Login login = new Login();

            if( login.verificaLogin( usuario,senha ) ) {
                usuarioText.setText("Bem vindo " + login.getUsuario() );

            } else {
                usuarioText.setText("Erro no login");
            }
        }
    }
}
