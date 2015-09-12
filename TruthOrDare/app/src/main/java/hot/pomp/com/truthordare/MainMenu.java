package hot.pomp.com.truthordare;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import java.util.Random;

public class MainMenu extends AppCompatActivity {

    public static final String RESULT = "hot.pomp.com.truthordare.RESULT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextAssets.initialize(this);
        setContentView(R.layout.activity_main_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
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

    public void openTruthView(View view)
    {
        Intent intent = new Intent(MainMenu.this, TruthSelect.class);
        startActivity(intent);
    }

    public void openDareView(View view)
    {
        Intent intent = new Intent(MainMenu.this, DareSelect.class);
        startActivity(intent);
    }

    public void openRandomView(View view)
    {
        Random rand = new Random();

        // will either be 1 or 0
        int choice = rand.nextInt(2);

        String result;

        if (choice == 0) {
            openTruthView(view);
            result = "Truth";
        }
        else {
            openDareView(view);
            result = "Dare";
        }

        Intent intent = new Intent(MainMenu.this, SelectionSplash.class);
        intent.putExtra(RESULT, result);
        startActivity(intent);
    }
}
