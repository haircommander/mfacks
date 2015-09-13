package hot.pomp.com.truthordare;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.logging.Handler;

public class SelectionSplash extends Activity {

    // Splash screen timer in milliseconds
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_splash);
        ((TextView) findViewById(R.id.resultTextView)).setText(getIntent().getStringExtra(MainMenu.RESULT));

        new android.os.Handler().postDelayed(new Runnable() {
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {

                Intent intent = null;

                // This method will be executed once the timer is over
                // Start your app main activity
                if (MainMenu.RESULT.equals("Truth")) {
                    intent = new Intent(SelectionSplash.this, TruthSelect.class);
                    startActivity(intent);
                }

                else if (MainMenu.RESULT.equals("Dare")) {
                    intent = new Intent(SelectionSplash.this, DareSelect.class);
                    startActivity(intent);
                }

                else {
                    Log.d("here", "it sucked");
                }

                finish();
                
            }
        }, SPLASH_TIME_OUT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selection_splash, menu);
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
}
