package br.com.fiap.desafiopersistencia;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sp;

    EditText edtNome;
    EditText edtSenha;
    CheckBox continuarConectado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getPreferences(MODE_PRIVATE);

        edtNome = findViewById(R.id.edtNome);
        edtSenha = findViewById(R.id.edtSenha);
        continuarConectado = findViewById(R.id.continuarConectado);

        String usuario = sp.getString("usuario", "");
        String senha = sp.getString("senha", "");
        Boolean manter = sp.getBoolean("manter", false);

        edtNome.setText(usuario);
        edtSenha.setText(senha);
        continuarConectado.setChecked(manter);

    }

    public void fazerLogin(View view) {

        if(continuarConectado.isChecked()){
            SharedPreferences.Editor e = sp.edit();
            e.putString("usuario", edtNome.getText().toString());
            e.putString("senha", edtSenha.getText().toString());
            e.commit();
        }
    }
}
