package hot.pomp.com.truthordare;

import android.content.Context;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owen on 9/12/15.
 */
public class TextAssets {
    public static List<String> TRUTHS;

    private static File truthsFile;
    private static Context context;

    private static String TRUTHS_FILENAME = "truths.txt";

    public  void initialize(Context context) {
        TRUTHS = new ArrayList<String>();
        this.context = context;
        load();
    }

    private static void load() {
        truthsFile = new File(context.getFilesDir(), TRUTHS_FILENAME);
    }
}
