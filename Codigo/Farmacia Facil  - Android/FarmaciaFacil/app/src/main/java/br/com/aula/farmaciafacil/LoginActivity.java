package br.com.aula.farmaciafacil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Aluno on 26/11/2015.
 */
public class LoginActivity extends Activity{

    private EditText usuario;
    private EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuario = (EditText) findViewById(R.id.usuario);
        senha = (EditText) findViewById(R.id.senha);

    }

    public void entrarOnClick(View view){
        String usuarioInformado = usuario.getText().toString();
        String senhaInformada = senha.getText().toString();

        if(("admin".equals(usuarioInformado)) && ("admin".equals(senhaInformada))){
            //vai para outra activity
            startActivity(new Intent(this,MenuActivity.class));
        }else{
            //exibe uma mensagem de erro
            String mensagemErro = getString(R.string.erro_autenticacao);
            Toast toast = Toast.makeText(this, mensagemErro,Toast.LENGTH_SHORT);

            toast.show();

        }

    }

}
