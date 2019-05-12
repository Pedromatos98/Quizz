package pt.ipg.trabalho;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class BdTableGame implements BaseColumns {
    public static final String NOME_TABELA = "Game";

    public static final String CATEGORIA = "Categoria";

    public static final String PERGUNTAS = "Perguntas";

    public static final String RESPOSTAS = "Respostas";

    public static final String[] TODAS_COLUNAS = new String[] { _ID, CATEGORIA, PERGUNTAS, RESPOSTAS};

    private SQLiteDatabase db;

    public BdTableGame(SQLiteDatabase db) {
        this.db = db;
    }

    public void cria() {
        db.execSQL(
                "CREATE TABLE " + NOME_TABELA + "(" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        CATEGORIA + "TEXT NOT NULL," +
                        PERGUNTAS + "TEXT NOT NULL," +
                        RESPOSTAS + "TEXT NOT NULL" +
                        ")"
        );
    }

    public Cursor query(String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return db.query(NOME_TABELA, columns, selection, selectionArgs, groupBy, having, orderBy);
    }

    public long insert(ContentValues values) {
        return db.insert(NOME_TABELA, null, values);
    }

    public int update(ContentValues values, String whereClause, String [] whereArgs) {
        return db.update(NOME_TABELA, values, whereClause, whereArgs);
    }

    public int delete (String whereClause, String[] whereArgs) {
        return db.delete(NOME_TABELA, whereClause, whereArgs);
    }
}
