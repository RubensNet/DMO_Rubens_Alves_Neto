package com.example.exercicio_15_08_2020.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exercicio_15_08_2020.R;
import com.example.exercicio_15_08_2020.model.Login;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String KEY_USUARIO = "usuario";
    public static final String KEY_SENHA = "senha";

    private EditText usuarioEditText;
    private EditText senhaEditText;
    private Button loginButton;
    private Login login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioEditText = findViewById( R.id.edittext_usuario );
        senhaEditText = findViewById( R.id.edittext_senha );
        loginButton = findViewById( R.id.button_login );

        loginButton.setOnClickListener((View.OnClickListener) this);

        login = new Login();
    }

    @Override
    protected void onResume(){
        super.onResume();
        usuarioEditText.setText("");
        senhaEditText.setText("");
    }

    @Override
    public void onClick(View v){
        if( v == loginButton ){
            verificarConta();
        }
    }

    private void verificarConta(){
        int usuario, senha;
         try{
             usuario = Integer.valueOf( usuarioEditText.getText().toString() );
             senha = Integer.valueOf( senhaEditText.getText().toString() );
         }catch (NumberFormatException ex){
             usuario = 0;
             senha = 0;
         }

        if( usuario !=  0  && senha !=  0 ){
            Bundle args = new Bundle();
            args.putInt(KEY_USUARIO, usuario);
            args.putInt(KEY_SENHA, senha);

            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtras(args);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Preencha os campos corretamente", Toast.LENGTH_SHORT ).show();
        }
    }
}
