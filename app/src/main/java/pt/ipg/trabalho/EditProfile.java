package pt.ipg.trabalho;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mostraMensagem();

    }


    public void guardar (View view) {

        EditText editTextMessage = (EditText) findViewById(R.id.EditTextUtilizador);

        String message = editTextMessage.getText().toString();

        EditText editTextMessage1 = (EditText) findViewById(R.id.EditTextCategorias);
        String message1 = editTextMessage1.getText().toString();

        if(message.trim().length()== 0 ){
            editTextMessage.setError(getString(R.string.Enter_user_name));

            editTextMessage.requestFocus();

            return;
        } else if(message1.trim().length()== 0 ){
            editTextMessage1.setError(getString(R.string.enter_favorite_categories));

            editTextMessage1.requestFocus();

            return;
        }

        Intent intent = new Intent(this, Profile.class);
        intent.putExtra(AppConsts.MESSAGE, message);
        intent.putExtra(AppConsts.MESSAGE1, message1);

        Toast.makeText(this, getString(R.string.profile_edited), Toast.LENGTH_SHORT).show();

        startActivity(intent);
    }
    public void cancel (View view) {
        finish();
    }
    private void mostraMensagem () {

        Intent intent = getIntent();

        String mensagem = intent.getStringExtra(AppConsts.MESSAGE);
        String mensagem1 = intent.getStringExtra(AppConsts.MESSAGE1);


        EditText EditTextUtilizador = (EditText) findViewById(R.id.EditTextUtilizador);
        EditText EditTextCategorias = (EditText) findViewById(R.id.EditTextCategorias);

        EditTextUtilizador.setText(mensagem);
        EditTextCategorias.setText(mensagem1);

    }
}
