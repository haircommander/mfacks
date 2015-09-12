package hot.pomp.com.truthordare;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

    // only need one random for class
    private static Random rand = new Random();
    /**
     * loads files in for reading
     */
    public static void initialize(Context context_) {
       // TRUTHS = new ArrayList<String>();
        context = context_;
        basicTruths = new ArrayList<String>();
        personalTruths = new ArrayList<String>();
        romanceTruths = new ArrayList<String>();

        generalDares = new ArrayList<String>();
        sexyDares = new ArrayList<String>();
        alcoholDares = new ArrayList<String>();
        try {
            loadFiles();
        } catch (FileNotFoundException e) {
            // you done messed up A-A-ron
        }

    }

    /**
     * sets up files for reading
     */
    private static void loadFiles() throws FileNotFoundException {

        basicTruthsText = new File(context.getFilesDir(), "raw/" + basicTruthsFileName);
        personalTruthsText = new File(context.getFilesDir(), "raw/" + personalTruthsFileName);
        romanceTruthsText = new File(context.getFilesDir(), "raw/" + romanceTruthsFileName);
        generalDaresText = new File(context.getFilesDir(), "raw/" + generalDaresFileName);
        sexyDaresText = new File(context.getFilesDir(), "raw/" + sexyDaresFileName);
        alcoholDaresText = new File(context.getFilesDir(), "raw/" + alcoholDaresFileName);

        Scanner scanner = new Scanner(basicTruthsText);

        String line;
        while ((line = scanner.nextLine()) != null)
        {
            basicTruths.add(new String(line));
        }

        scanner = new Scanner(personalTruthsText);

        while ((line = scanner.nextLine()) != null)
        {
            personalTruths.add(new String(line));
        }

         scanner = new Scanner(romanceTruthsText);

        while ((line = scanner.nextLine()) != null)
        {
            romanceTruths.add(new String(line));
        }

         scanner = new Scanner(generalDaresText);

        while ((line = scanner.nextLine()) != null)
        {
            generalDares.add(new String(line));
        }

        scanner = new Scanner(sexyDaresText);

        while ((line = scanner.nextLine()) != null)
        {
            sexyDares.add(new String(line));
        }

         scanner = new Scanner(alcoholDaresText);

        while ((line = scanner.nextLine()) != null)
        {
            alcoholDares.add(new String(line));
        }

    }

    public static String getTruth(boolean basic, boolean personal, boolean romance) {

        int range = 0;
        int category = -1; // 1-basic, 2-personal, 3-sexy
        int randInt;

        if (basic) range++;
        if (personal) range++;
        if (romance) range++;

        if (basic) {
            randInt = rand.nextInt(range);
            if (randInt == 0) category = 1;
        }

        if (personal) {
            randInt = rand.nextInt(range);
            if (randInt == 0) category = 2;
        }

        if (romance) {
            randInt = rand.nextInt(range);
            if (randInt == 0) category = 3;
        }

        if (category == -1) category = 1;

        if (category == 1) {
            return basicTruths.get(rand.nextInt(basicTruths.size()));
        }

        if (category == 2) {
            return personalTruths.get(rand.nextInt(personalTruths.size()));
        }

        if (category == 3) {
            return romanceTruths.get(rand.nextInt(romanceTruths.size()));
        }

        return "oh shit, a bug!";
    }

    public static String getDare(boolean general, boolean sexy, boolean alcohol) {

        int range = 0;
        int category = -1; // 1-general, 2-sexy, 3-alcohol
        int randInt;

        if (general) range++;
        if (sexy) range++;
        if (alcohol) range++;

        if (general) {
            randInt = rand.nextInt(range);
            if (randInt == 0) category = 1;
        }

        if (sexy) {
            randInt = rand.nextInt(range);
            if (randInt == 0) category = 2;
        }

        if (alcohol) {
            randInt = rand.nextInt(range);
            if (randInt == 0) category = 3;
        }

        if (category == -1) category = 1;

        if (category == 1) {
            return generalDares.get(rand.nextInt(generalDares.size()));
        }

        if (category == 2) {
            return sexyDares.get(rand.nextInt(sexyDares.size()));
        }

        if (category == 3) {
            return alcoholDares.get(rand.nextInt(alcoholDares.size()));
        }

        return "oh shit, a bug!";
    }
}
