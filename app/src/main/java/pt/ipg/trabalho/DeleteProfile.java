package pt.ipg.trabalho;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DeleteProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mostraMensagem();
    }
    public void eliminar(View view){
        Intent intent = new Intent(this, Profile.class);


        String textoCategorias = "";
        intent.putExtra(AppConsts.MESSAGE,textoCategorias);
        intent.putExtra(AppConsts.MESSAGE1, textoCategorias);
        Toast.makeText(this, getString(R.string.deleted_w_success), Toast.LENGTH_SHORT).show();
        startActivity(intent);


    }
    public void cancel (View view) {
        finish();
    }
    private void mostraMensagem() {
        Intent intent = getIntent();

        String mensagem = intent.getStringExtra(AppConsts.MESSAGE);
        String mensagem1 = intent.getStringExtra(AppConsts.MESSAGE1);


        TextView textViewUtilizador = (TextView) findViewById(R.id.textViewUtilizador);
        TextView textViewCategorias = (TextView) findViewById(R.id.textViewCategorias);

        textViewUtilizador.setText(mensagem);
        textViewCategorias.setText(mensagem1);
    }
}
