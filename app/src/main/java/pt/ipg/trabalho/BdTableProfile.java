package pt.ipg.trabalho;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class BdTableProfile implements BaseColumns {
    public static final String NOME_TABELA = "Perfil";

    public static final String NOME_UTILIZADOR = "Nome Utilizador";

    public static final String CATEGORIAS_FAVORITAS = "Categorias Favoritas";

    public static final String[] TODAS_COLUNAS = new String[] { _ID, NOME_UTILIZADOR, CATEGORIAS_FAVORITAS};

    private SQLiteDatabase db;

    public BdTableProfile(SQLiteDatabase db) {
        this.db = db;
    }

    public void cria() {
        db.execSQL(
                "CREATE TABLE " + NOME_TABELA + "(" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        NOME_UTILIZADOR + "TEXT NOT NULL," +
                        CATEGORIAS_FAVORITAS + "TEXT NOT NULL" +
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
