package com.example.exercicio_15_08_2020.model;

import java.io.Serializable;

public class Login implements Serializable {
    private int usuario = 3001423;
    private int senha = 3241003;

    public int getUsuario() {
        return usuario;
    }

    public int getSenha() {
        return senha;
    }

    public boolean verificaLogin(int usuario, int senha){
        if( this.usuario == usuario && this.senha == senha ){
            return true;
        }
        return false;
    }
}
