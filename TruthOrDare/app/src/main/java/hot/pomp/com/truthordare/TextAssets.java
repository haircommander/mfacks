package hot.pomp.com.truthordare;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owen on 9/12/15.
 */
public abstract class TextAssets {
    public static List<String> TRUTHS;

    private static File truthsFile;

    public static void initialize() {
        TRUTHS = new ArrayList<String>();
        load();
    }

    private static void load() {
        //truthsFile
    }
}
