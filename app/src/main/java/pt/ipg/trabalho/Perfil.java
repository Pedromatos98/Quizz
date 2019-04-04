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

public class Perfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        perfil();
    }
    private void perfil () {
        Intent intent = getIntent();

        String message = intent.getStringExtra(AppConsts.MESSAGE);

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    public void guardar (View view) {

        EditText editTextMessage = (EditText) findViewById(R.id.EditTextUtilizador);

        String message = editTextMessage.getText().toString();

        if(message.trim().length()== 0){
            editTextMessage.setError("Enter User Name");

            editTextMessage.requestFocus();

            return;
        }

        Intent intent = new Intent(this, MainActivity.class);

        Toast.makeText(this, "User name added", Toast.LENGTH_SHORT).show();

        startActivity(intent);
    }
    public void cancel (View view) {
        finish();
    }
}
