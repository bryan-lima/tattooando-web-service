package com.tattooando.project.Cliente;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.tattooando.project.R;
import com.tattooando.project.TipoLoginActivity;

public class LoginClienteActivity extends AppCompatActivity {

    private Button btnCadastrar;
    private Button btnLogin;
    private Context context = LoginClienteActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cli_login);

        configurarNavBar();
        inicializarComponentes();
        eventosClick();
    }

    private void configurarNavBar() {
        setTitle("Login");
        ActionBar actionBar = getSupportActionBar(); // Instancia objeto da BAR
        actionBar.setDisplayHomeAsUpEnabled(true); // Exibe o ícone
        actionBar.setHomeButtonEnabled(true); // Habilita o click
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { // Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(context, TipoLoginActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }
        return true;
    }

    private void inicializarComponentes() {
        btnCadastrar = findViewById(R.id.cli_log_btn_cadastrar);
        btnLogin = findViewById(R.id.cli_log_btn_login);
    }

    private void eventosClick(){
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CadastroClienteActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HomeClienteActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(context, TipoLoginActivity.class);
        startActivity(intent);
        super.onBackPressed();
        finish();
    }
}
