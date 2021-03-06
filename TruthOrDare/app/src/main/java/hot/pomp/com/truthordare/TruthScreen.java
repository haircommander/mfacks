package hot.pomp.com.truthordare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * Created by patrickeschbach on 9/12/15.
 */
public class TruthScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truth_screen);
        ((TextView)findViewById(R.id.truthTextView)).setText(getIntent().getStringExtra(TruthSelect.TRUTH));
    }

    public void openMainMenu(View view)
    {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }

    public void openExitScreen(View view)
    {
        Intent intent = new Intent(this, ExitScreen.class);
        startActivity(intent);
    }
}
