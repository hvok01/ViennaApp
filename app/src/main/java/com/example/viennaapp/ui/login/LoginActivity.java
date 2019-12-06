package com.example.viennaapp.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.viennaapp.R;
import com.example.viennaapp.ui.main.MainActivity;

public class LoginActivity extends AppCompatActivity {

    private Button btnIngresar;
    private EditText etCorreo, etClave;
    private LoginViewModel lvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inicializar();

    }

    public void inicializar() {
        btnIngresar = findViewById(R.id.btnIngresar);
        etCorreo = findViewById(R.id.etCorreo);
        etClave = findViewById(R.id.etClave);


        lvm = ViewModelProviders.of(this).get(LoginViewModel.class);
        lvm.getTokenLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if(s!=null) {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(LoginActivity.this, "usuario y/o contraseña incorrecta.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void ingresar(android.view.View view){

        Toast.makeText(getApplicationContext(), "Espere...", Toast.LENGTH_SHORT).show();

        if(etCorreo.getText().toString().isEmpty() || etClave.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Campos vacios", Toast.LENGTH_LONG).show();
        }else{
            lvm.traerToken(etCorreo.getText()+"",etClave.getText()+"");
        }

    }
}
