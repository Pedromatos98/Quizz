package pt.ipg.trabalho;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Categories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        categories ();
    }
    public void save(View view) {
        EditText editTextCategories = (EditText) findViewById(R.id.editTextCategories);
        String textoCategorias = editTextCategories.getText().toString();

        if (textoCategorias.isEmpty()) {
            editTextCategories.setError("Enter Categories");
            editTextCategories.requestFocus();
            return;

        }
        Intent intent = new Intent(this, MainActivity.class);

        Toast.makeText(this, "Categories Saved", Toast.LENGTH_SHORT).show();

        startActivity(intent);
    }
    public void cancel (View view) {

        finish();
    }
    public void delete (View view) {
        Intent intent = new Intent(this, Delete.class);
        intent.putExtra(AppConsts.MESSAGE, "delete page");

        startActivity(intent);
    }
    private void categories () {
        Intent intent = getIntent();

        String message = intent.getStringExtra(AppConsts.MESSAGE);

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
