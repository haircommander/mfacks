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
}
