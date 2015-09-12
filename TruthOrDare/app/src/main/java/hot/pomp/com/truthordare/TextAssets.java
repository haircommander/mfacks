package hot.pomp.com.truthordare;

import android.content.Context;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Owen on 9/12/15.
 */
public abstract class TextAssets {

    // use an array list of strings to categorize truths/dares
    private static List<String> basicTruths;
    private static List<String> personalTruths;
    private static List<String> romanceTruths;

    private static List<String> generalDares;
    private static List<String> sexyDares;
    private static List<String> alcoholDares;

    // files for reading in
    private static File basicTruthsText;
    private static File personalTruthsText;
    private static File romanceTruthsText;

    private static File generalDaresText;
    private static File sexyDaresText;
    private static File alcoholDaresText;

    // file names for reading in, start here add filepath
    private static final String basicTruthsFileName = "basic_truths.txt";
    private static final String personalTruthsFileName = "personal_truths.txt";
    private static final String romanceTruthsFileName = "romance_truths.txt";
    private static final String generalDaresFileName = "general_dares.txt";
    private static final String sexyDaresFileName = "sexy_dares.txt";
    private static final String alcoholDaresFileName = "alcohol_dares.txt";

    // gives access to android assets
    private static Context context;

    /**
     * loads files in for reading
     */
    public static void initialize(Context context_) {
       // TRUTHS = new ArrayList<String>();
        context = context_;
        loadFiles();
    }

    /**
     * sets up files for reading
     */
    private static void loadFiles() {

        basicTruthsText = new File(context.getFilesDir(), "raw/" + basicTruthsFileName);
        personalTruthsText = new File(context.getFilesDir(), "raw/" + personalTruthsFileName);
        romanceTruthsText = new File(context.getFilesDir(), "raw/" + romanceTruthsFileName);
        generalDaresText = new File(context.getFilesDir(), "raw/" + generalDaresFileName);
        sexyDaresText = new File(context.getFilesDir(), "raw/" + sexyDaresFileName);
        alcoholDaresText = new File(context.getFilesDir(), "raw/" + alcoholDaresFileName);

    }

    public static String getTruth() {
        return "placeholder";
    }
}
