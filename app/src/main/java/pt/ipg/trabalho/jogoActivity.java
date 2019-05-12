package pt.ipg.trabalho;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Toast;

public class jogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private long id;
    private String Categoria;
    private String Perguntas;
    private String Respostas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getPerguntas() {
        return Perguntas;
    }

    public void setPerguntas(String perguntas) {
        Perguntas = perguntas;
    }

    public String getRespostas() {
        return Respostas;
    }

    public void setRespostas(String respostas) {
        Respostas = respostas;
    }
    public ContentValues getContentValues() {
        ContentValues valores = new ContentValues();

        valores.put(BdTableGame.CATEGORIA, Categoria);
        valores.put(BdTableGame.PERGUNTAS, Perguntas);
        valores.put(BdTableGame.RESPOSTAS, Respostas);

        return valores;
    }
    public static jogoActivity fromCursor(Cursor cursor) {
        long id = cursor.getLong(
                cursor.getColumnIndex(BdTableGame._ID)
        );

        String categoria = cursor.getString(
                cursor.getColumnIndex(BdTableGame.CATEGORIA)
        );

        String perguntas = cursor.getString(
                cursor.getColumnIndex(BdTableGame.PERGUNTAS)
        );

        String respostas = cursor.getString(
                cursor.getColumnIndex(BdTableGame.RESPOSTAS)
        );

        jogoActivity jogo = new jogoActivity();

        jogo.setId(id);
        jogo.setCategoria(categoria);
        jogo.setPerguntas(perguntas);
        jogo.setRespostas(respostas);

        return jogo;
    }
}
