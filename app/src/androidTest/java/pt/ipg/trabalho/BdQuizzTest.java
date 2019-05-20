package pt.ipg.trabalho;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class BdQuizzTest {
    @Before
    public void apagaBaseDados() {
        getAppContext().deleteDatabase(BdQuizzOpenHelper.NOME_BASE_DADOS);
    }

    @Test
    public void criaBdQuizz() {

        // Context of the app under test.
        Context appContext = getAppContext();

        BdQuizzOpenHelper openHelper = new BdQuizzOpenHelper(appContext);

        SQLiteDatabase db = openHelper.getReadableDatabase();

        assertTrue(db.isOpen());
    }

    private Context getAppContext() { return InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void testCRUD() {
        BdQuizzOpenHelper openHelper = new BdQuizzOpenHelper(getAppContext());
        SQLiteDatabase db = openHelper.getWritableDatabase();

        BdTableCategories tabelaCategorias = new BdTableCategories(db);

        // Teste read categorias (cRud)
        Cursor cursorCategorias = getCategorias(tabelaCategorias);
        assertEquals(0, cursorCategorias.getCount());
        // Teste create/read categorias (CRud)
        String nome = "História";
        long idHistoria= criaCategoria(tabelaCategorias, nome);

        cursorCategorias = getCategorias(tabelaCategorias);
        assertEquals(1, cursorCategorias.getCount());

        Categories categoria = getCategoriaComID(cursorCategorias, idHistoria);

        assertEquals(nome, categoria.getDescricao());

        nome = "Desporto";
        long idDesporto = criaCategoria(tabelaCategorias, nome);

        cursorCategorias = getCategorias(tabelaCategorias);
        assertEquals(2, cursorCategorias.getCount());

        categoria = getCategoriaComID(cursorCategorias, idDesporto);

        assertEquals(nome, categoria.getDescricao());

        // Teste Update/Read categorias (cRUd)
        nome = "História / Desporto";
        categoria.setDescricao(nome);

        int registosAlterados = tabelaCategorias.update(categoria.getContentValues(), BdTableCategories._ID + "=?", new String[]{String.valueOf(idHistoria)});

        assertEquals(1, registosAlterados);

        cursorCategorias = getCategorias(tabelaCategorias);
        categoria = getCategoriaComID(cursorCategorias, idHistoria);

        assertEquals(nome, categoria.getDescricao());

        // Teste Create/Delete/Read categorias (CRuD)
        long id = criaCategoria(tabelaCategorias, "TESTE");
        cursorCategorias = getCategorias(tabelaCategorias);
        assertEquals(3, cursorCategorias.getCount());

        tabelaCategorias.delete(BdTableCategories._ID + "=?", new String[]{String.valueOf(id)});
        cursorCategorias = getCategorias(tabelaCategorias);
        assertEquals(2, cursorCategorias.getCount());

        getCategoriaComID(cursorCategorias, idHistoria);
        getCategoriaComID(cursorCategorias, idDesporto);


    }
    private long criaCategoria(BdTableCategories tabelaCategorias, String nome) {
        Categories categoria = new Categories();
        categoria.setDescricao(nome);

        long id = tabelaCategorias.insert(categoria.getContentValues());
        assertNotEquals(-1, id);

        return id;
    }
    private Cursor getCategorias(BdTableCategories tabelaCategorias) {
        return tabelaCategorias.query(BdTableCategories.TODAS_COLUNAS, null, null, null, null, null);
    }
    private Categories getCategoriaComID(Cursor cursor, long id) {
        Categories categoria = null;

        while (cursor.moveToNext()) {
            categoria = Categories.fromCursor(cursor);

            if (categoria.getId() == id) {
                break;
            }
        }

        assertNotNull(categoria);

        return categoria;
    }
}