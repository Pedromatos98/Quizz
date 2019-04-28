package pt.ipg.trabalho;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void startGame (View view) {
        Intent intent = new Intent(this, jogoActivity.class);
        Toast.makeText(this, getString(R.string.game_started), Toast.LENGTH_SHORT).show();

        startActivity(intent);
    }
    public void perfil (View view) {
        Intent intent = new Intent(this, Profile.class);
        Toast.makeText(this, getString(R.string.profile), Toast.LENGTH_SHORT).show();

        startActivity(intent);
    }
    public void guardar (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        Toast.makeText(this, getString(R.string.User_name_saved), Toast.LENGTH_SHORT).show();

        startActivity(intent);
        }
    public void categories (View view) {
        Intent intent = new Intent(this, Categories.class);
        Toast.makeText(this, getString(R.string.title_activity_categories), Toast.LENGTH_SHORT).show();

        startActivity(intent);
    }
}
