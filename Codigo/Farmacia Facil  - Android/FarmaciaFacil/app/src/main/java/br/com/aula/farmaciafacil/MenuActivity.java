package br.com.aula.farmaciafacil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void selecionarOpcao(View view) {
        switch (view.getId()) {

            case R.id.mapa:
                startActivity(new Intent(this, MainActivity.class));

                break;
            case R.id.sair:
                finish();
                //startActivity(new Intent(this, GastoActivity.class)); sair
                break;


            default:
                break;

        }

    }
}

