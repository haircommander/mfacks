package hot.pomp.com.truthordare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by patrickeschbach on 9/12/15.
 */
public class ExitScreen extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit_screen);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }

}
