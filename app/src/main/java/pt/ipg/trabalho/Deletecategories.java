package pt.ipg.trabalho;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Deletecategories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletecategories);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mostraMensagem();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void eliminar(View view){
        Intent intent = new Intent(this, Categories.class);

        String message = "";
        intent.putExtra(AppConsts.MESSAGE2, message);
        Toast.makeText(this, getString(R.string.deleted_w_success), Toast.LENGTH_SHORT).show();
        startActivity(intent);


    }
    public void cancel (View view) {
        finish();
    }
    private void mostraMensagem() {
        Intent intent = getIntent();

        String mensagem = intent.getStringExtra(AppConsts.MESSAGE2);

        TextView textViewUtilizador = (TextView) findViewById(R.id.textViewCategorias);

        textViewUtilizador.setText(mensagem);

    }
}
