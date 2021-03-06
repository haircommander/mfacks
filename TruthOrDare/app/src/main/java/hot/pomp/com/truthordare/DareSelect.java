package hot.pomp.com.truthordare;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

public class DareSelect extends Activity {
    public static final String DARE = "hot.pomp.com.truthordare.DARE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dare_select);
    }

    @Override
    public void onResume() {
        super.onResume();

        if (TextAssets.generalDaresAvailable) {
            ((CheckBox) findViewById(R.id.General)).setEnabled(true);
            ((CheckBox) findViewById(R.id.General)).setTextColor(Color.WHITE);
        }
        else {
            ((CheckBox) findViewById(R.id.General)).setEnabled(false);
            ((CheckBox) findViewById(R.id.General)).setTextColor(Color.BLACK);
        }

        if (TextAssets.sexyDaresAvailable) {
            ((CheckBox) findViewById(R.id.Sexy)).setEnabled(true);
            ((CheckBox) findViewById(R.id.Sexy)).setTextColor(Color.WHITE);
        }
        else {
            ((CheckBox) findViewById(R.id.Sexy)).setEnabled(false);
            ((CheckBox) findViewById(R.id.Sexy)).setTextColor(Color.BLACK);
        }

        if (TextAssets.alcoholDaresRemaining) {
            ((CheckBox) findViewById(R.id.Alcohol)).setEnabled(true);
            ((CheckBox)findViewById(R.id.Alcohol)).setTextColor(Color.WHITE);
        }

        else {
            ((CheckBox) findViewById(R.id.Alcohol)).setEnabled(false);
            ((CheckBox)findViewById(R.id.Alcohol)).setTextColor(Color.BLACK);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dareview, menu);
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


    public void openDareScreen(View view)
    {
        // find out if user wants general, sexy, and alcohol dares
        boolean wantsGeneral = ((CheckBox)findViewById(R.id.General)).isChecked();
        boolean wantsSexy = ((CheckBox)findViewById(R.id.Sexy)).isChecked();
        boolean wantsAlcohol = ((CheckBox)findViewById(R.id.Alcohol)).isChecked();

        // if user didn't check anything, don't do anything
        if(!wantsGeneral && !wantsSexy && !wantsAlcohol)
            return;

        String dare = TextAssets.getDare(wantsGeneral, wantsSexy, wantsAlcohol);

        Intent intent = new Intent(this, DareScreen.class);
        intent.putExtra(DARE, dare);

        startActivity(intent);
    }
}

