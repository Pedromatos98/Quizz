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

public class Categories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mostraMensagem();
    }
    public void AdicionarCategorias(View view) {
        Intent intent = new Intent(this,addCategorie.class);
        Toast.makeText(this, getString(R.string.Add_Categories), Toast.LENGTH_SHORT).show();
        TextView editTextMessage = (TextView) findViewById(R.id.textViewCategorias);

        String message = editTextMessage.getText().toString();


        if (message.trim().length() != 0 ) {
            Toast.makeText(this, getString(R.string.categories_advice), Toast.LENGTH_SHORT).show();
            return;
        }
       startActivity(intent);
    }
    public void EditarCategorias(View view) {
        Intent intent = new Intent(this, addCategorie.class);
        Toast.makeText(this, getString(R.string.edit_categories), Toast.LENGTH_SHORT).show();

        TextView editTextMessage = (TextView) findViewById(R.id.textViewCategorias);

        String textoCategorias = editTextMessage.getText().toString();

        if (textoCategorias.trim().length() == 0) {
            Toast.makeText(this,getString(R.string.add_categories), Toast.LENGTH_SHORT).show();
            return;
        }
        intent.putExtra(AppConsts.MESSAGE2, textoCategorias);
        startActivity(intent);
    }
    public void EliminarCategorias (View view){
        Intent intent = new Intent(this, Deletecategories.class);
        Toast.makeText(this, getString(R.string.delete_categories), Toast.LENGTH_SHORT).show();

        TextView editTextMessage = (TextView) findViewById(R.id.textViewCategorias);

        String message = editTextMessage.getText().toString();
        if (message.trim().length() == 0) {
            Toast.makeText(this, getString(R.string.add_categories), Toast.LENGTH_SHORT).show();
            return;
        }
        intent.putExtra(AppConsts.MESSAGE2, message);
        startActivity(intent);
    }

    private void mostraMensagem () {
        Intent intent = getIntent();
        String textoCategorias = intent.getStringExtra(AppConsts.MESSAGE2);
        TextView textViewUtilizador = (TextView) findViewById(R.id.textViewCategorias);
        textViewUtilizador.setText(textoCategorias);

    }
}
