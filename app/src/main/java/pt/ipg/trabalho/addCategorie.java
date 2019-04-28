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

public class addCategorie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_categorie);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mostraMensagem();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void save(View view) {
        EditText editTextCategories = (EditText) findViewById(R.id.editTextCategories);
        String textoCategorias = editTextCategories.getText().toString();


        if (textoCategorias.isEmpty()) {
            editTextCategories.setError(getString(R.string.enter_categories));
            editTextCategories.requestFocus();
            return;

        }

        Intent intent = new Intent(this, Categories.class);

        Toast.makeText(this, getString(R.string.categories_saved), Toast.LENGTH_SHORT).show();
        intent.putExtra(AppConsts.MESSAGE2, textoCategorias);
        startActivity(intent);
    }
    public void cancel(View view) {

        finish();
    }

    private void mostraMensagem () {
        Intent intent = getIntent();
        String textoCategorias = intent.getStringExtra(AppConsts.MESSAGE2);
        EditText EditTextUtilizador = (EditText) findViewById(R.id.editTextCategories);
        EditTextUtilizador.setText(textoCategorias);

    }
}
