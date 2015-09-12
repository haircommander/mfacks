package hot.pomp.com.truthordare;

import android.content.Context;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owen on 9/12/15.
 */
public abstract class TextAssets {
    public static List<String> TRUTHS;

    private static File truthsFile;
    private static Context context;

    private static String TRUTHS_FILENAME = "truths.txt"; //start here, add filepath

    public static void initialize(Context c) {
        TRUTHS = new ArrayList<String>();
        context = c;
        load();
    }

    private static void load() {
        truthsFile = new File(context.getFilesDir(), "raw/" + TRUTHS_FILENAME);

    }

    public static String getTruth() {
        return "placeholder";
    }
}
