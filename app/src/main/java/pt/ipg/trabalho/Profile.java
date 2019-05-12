package pt.ipg.trabalho;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class Profile extends AppCompatActivity {
    private long id;
    private String Nome;
    private String Categorias;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCategorias() {
        return Categorias;
    }

    public void setCategorias(String categorias) {
        Categorias = categorias;
    }

    public ContentValues getContentValues() {
        ContentValues valores = new ContentValues();

        valores.put(BdTableProfile.NOME_UTILIZADOR, Nome);
        valores.put(BdTableProfile.CATEGORIAS_FAVORITAS, Categorias);

        return valores;
    }
    public static Profile fromCursor(Cursor cursor) {
        long id = cursor.getLong(
                cursor.getColumnIndex(BdTableProfile._ID)
        );

        String nome = cursor.getString(
                cursor.getColumnIndex(BdTableProfile.NOME_UTILIZADOR)
        );

        String categorias = cursor.getString(
                cursor.getColumnIndex(BdTableProfile.CATEGORIAS_FAVORITAS)
        );


        Profile perfil = new Profile();

        perfil.setId(id);
        perfil.setNome(nome);
        perfil.setCategorias(categorias);



        return perfil;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mostraMensagem();
    }
    public void AdicionarUtilizador(View view) {
        Intent intent = new Intent(this, EditProfile.class);
        Toast.makeText(this, getString(R.string.add_profile), Toast.LENGTH_SHORT).show();
        TextView editTextMessage = (TextView) findViewById(R.id.textView3);

        String message = editTextMessage.getText().toString();

        TextView editTextMessage1 = (TextView) findViewById(R.id.textView5);
        String message1 = editTextMessage1.getText().toString();

        if (message.trim().length() != 0 && message1.trim().length() != 0) {
            Toast.makeText(this, getString(R.string.profile_advice), Toast.LENGTH_SHORT).show();
            return;
        }


        startActivity(intent);
    }


    public void EditarUtilizador(View view) {
        Intent intent = new Intent(this, EditProfile.class);
        Toast.makeText(this, getString(R.string.title_activity_perfil), Toast.LENGTH_SHORT).show();

        TextView editTextMessage = (TextView) findViewById(R.id.textView3);

        String message = editTextMessage.getText().toString();

        TextView editTextMessage1 = (TextView) findViewById(R.id.textView5);
        String message1 = editTextMessage1.getText().toString();

        if (message.trim().length() == 0 && message1.trim().length() == 0) {
            Toast.makeText(this, getString(R.string.create_profile), Toast.LENGTH_SHORT).show();
            return;
        }

        intent.putExtra(AppConsts.MESSAGE, message);
        intent.putExtra(AppConsts.MESSAGE1, message1);
        startActivity(intent);
    }
    public void EliminarUtilizador(View view){
        Intent intent = new Intent(this, DeleteProfile.class);
        Toast.makeText(this, getString(R.string.delete_profile), Toast.LENGTH_SHORT).show();

        TextView editTextMessage = (TextView) findViewById(R.id.textView3);
        TextView editTextMessage1 = (TextView) findViewById(R.id.textView5);

        String message = editTextMessage.getText().toString();
        String message1 = editTextMessage1.getText().toString();
        if (message.trim().length() == 0 && message1.trim().length() == 0) {
            Toast.makeText(this, getString(R.string.create_profile), Toast.LENGTH_SHORT).show();
            return;
        }
        intent.putExtra(AppConsts.MESSAGE, message);
        intent.putExtra(AppConsts.MESSAGE1, message1);
        startActivity(intent);
    }
    private void mostraMensagem () {
        Intent intent = getIntent();

        String mensagem = intent.getStringExtra(AppConsts.MESSAGE);
        String mensagem1 = intent.getStringExtra(AppConsts.MESSAGE1);


        TextView textViewUtilizador = (TextView) findViewById(R.id.textView3);
        TextView textViewCategorias = (TextView) findViewById(R.id.textView5);

        textViewUtilizador.setText(mensagem);
        textViewCategorias.setText(mensagem1);

    }

    }


