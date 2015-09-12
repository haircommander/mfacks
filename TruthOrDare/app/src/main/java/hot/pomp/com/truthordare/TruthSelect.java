package hot.pomp.com.truthordare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

/**
 * Created by patrickeschbach on 9/12/15.
 */
public class TruthSelect extends Activity {
    public static final String TRUTH = "hot.pomp.com.truthordare.TRUTH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truth_select);
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

    public void openTruthScreen(View view)
    {
        // find out if user wants general, sexy, and alcohol dares
        boolean wantsBasic = ((CheckBox)findViewById(R.id.Basic)).isChecked();
        boolean wantsPersonal = ((CheckBox)findViewById(R.id.Personal)).isChecked();
        boolean wantsRomance = ((CheckBox)findViewById(R.id.Romance)).isChecked();

        // if user didn't check anything, don't do anything
        if(!wantsBasic && !wantsPersonal && !wantsRomance)
            return;

        String truth = TextAssets.getTruth(wantsBasic, wantsPersonal, wantsRomance);

        Intent intent = new Intent(this, TruthScreen.class);
        intent.putExtra(TRUTH, truth);

        startActivity(intent);
    }
}