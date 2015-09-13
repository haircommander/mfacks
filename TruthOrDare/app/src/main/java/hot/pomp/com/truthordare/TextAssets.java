package hot.pomp.com.truthordare;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Owen AND MEREDITH on 9/12/15.
 */
public abstract class TextAssets {

    // use an array list of strings to categorize truths/dares
    private static List<String> basicTruths = new ArrayList<String>();
    private static List<String> personalTruths = new ArrayList<String>();
    private static List<String> romanceTruths = new ArrayList<String>();

    private static List<String> generalDares = new ArrayList<String>();
    private static List<String> sexyDares = new ArrayList<String>();
    private static List<String> alcoholDares = new ArrayList<String>();

    // files for reading in
    private static File basicTruthsText;
    private static File personalTruthsText;
    private static File romanceTruthsText;

    private static File generalDaresText;
    private static File sexyDaresText;
    private static File alcoholDaresText;

    public static boolean basicTruthsAvailable = true;
    public static boolean personalTruthsAvailable = true;
    public static boolean romanceTruthsAvailable = true;

    public static boolean generalDaresAvailable = true;
    public static boolean sexyDaresAvailable = true;
    public static boolean alcoholDaresRemaining = true;


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

    /////////////////////////////////////////////////////////////////////////

    /**
     * Gets the class ready for action
     */
    public static void initialize(Context context_) {

        context = context_;

        try {
            loadFiles();
        } catch (FileNotFoundException e) {
            // you done messed up A-A-ron
        }

        basicTruthsAvailable = true;
        personalTruthsAvailable = true;
        romanceTruthsAvailable = true;

        generalDaresAvailable = true;
        sexyDaresAvailable = true;
        alcoholDaresRemaining = true;
    }

    /**
     * Reads in one file into an array list<br>
     * Stores each file line into a string, then stores string into list
     * @param inputStream
     * @param list
     * @throws FileNotFoundException
     */
    private static void readIn(InputStream inputStream, List<String> list) throws FileNotFoundException {

        Scanner scanner = new Scanner(inputStream); // set up file for reading

        // read in lines to the list
        while (scanner.hasNextLine())
            list.add(scanner.nextLine());

        scanner.close(); // close scanner for safety <3
    }

    /**
     * loads text files and reads in their input
     * @throws FileNotFoundException
     */
    private static void loadFiles() throws FileNotFoundException {

        ;

        // loads .txt files in raw to the file objects of the class
//        basicTruthsText = new File(context.getFilesDir(), "raw/" + basicTruthsFileName);
//        personalTruthsText = new File(context.getFilesDir(), "raw/" + personalTruthsFileName);
//        romanceTruthsText = new File(context.getFilesDir(), "raw/" + romanceTruthsFileName);
//        generalDaresText = new File(context.getFilesDir(), "raw/" + generalDaresFileName);
//        sexyDaresText = new File(context.getFilesDir(), "raw/" + sexyDaresFileName);
//        alcoholDaresText = new File(context.getFilesDir(), "raw/" + alcoholDaresFileName);
        
        // read in truths and dares
        readIn(context.getResources().openRawResource(R.raw.basic_truths), basicTruths);
        readIn(context.getResources().openRawResource(R.raw .personal_truths), personalTruths);
        readIn(context.getResources().openRawResource(R.raw.romance_truths), romanceTruths);
        readIn(context.getResources().openRawResource(R.raw.general_dares), generalDares);
        readIn(context.getResources().openRawResource(R.raw.sexy_dares), sexyDares);
        readIn(context.getResources().openRawResource(R.raw.alcohol_dares), alcoholDares);
    }

    /**
     * a = 1, b = 2, c = 3
     * Randomly selects 1, 2, or 3 based on the truth values of them
     * @param a
     * @param b
     * @param c
     * @return
     */
    private static int categorySelector(boolean a, boolean b, boolean c)
    {
        // set category to -1 for error tracking
        // an if branch below SHOULD execute, if not error occurred
        int category = -1;

        // if user selected only one category
        if (a && !b && !c) category = 1;
        else if (!a && b && !c) category = 2;
        else if (!a && !b && c) category = 3;

            // if user selected 2 or more categories
        else if (a && b && !c) category = 1 + rand.nextInt(2);
        else if (!a && b && c) category = 2 + rand.nextInt(2);
        else if (a && !b && c) category = 3 - 2 * rand.nextInt(2);
        else if (a && b && c) category = 1 + rand.nextInt(3);
        
        return category;
    }
    
    /**
     * First randomly selects a category or truth based on boolean values
     * then randomly selects a truth from the given category (arraylist)
     * @param basic
     * @param personal
     * @param romance
     * @return a truth according to what user specified
     */
    public static String getTruth(boolean basic, boolean personal, boolean romance) {
        
        int category = categorySelector(basic, personal, romance);
        
        // category 1 is basic truths
        if (category == 1) {
            int index = rand.nextInt(basicTruths.size());
            String out = basicTruths.get(index);
            basicTruths.remove(index);
            if (basicTruths.size() == 0) basicTruthsAvailable = false;
            return out;
        }
        // category 2 is personal truths
        else if (category == 2) {
            int index = rand.nextInt(personalTruths.size());
            String out = personalTruths.get(index);
            personalTruths.remove(index);
            if (personalTruths.size() == 0) personalTruthsAvailable = false;
            return out;
        }
        // category 3 is romance truths
        else if (category == 3){
            int index = rand.nextInt(romanceTruths.size());
            String out = romanceTruths.get(index);
            romanceTruths.remove(index);
            if (romanceTruths.size() == 0) romanceTruthsAvailable = false;
            return out;
        }

        return "oh shit, a bug!"; // should never execute
    }

    /**
     * First randomly selects a category or truth based on boolean values
     * then randomly selects a truth from the given category (arraylist)
     * @param general
     * @param sexy
     * @param alcohol
     * @return
     */
    public static String getDare(boolean general, boolean sexy, boolean alcohol) {

        int category = categorySelector(general, sexy, alcohol);

        if (category == 1) {
            int index = rand.nextInt(generalDares.size());
            String out = generalDares.get(index);
            generalDares.remove(index);
            if (generalDares.size() == 0) generalDaresAvailable = false;
            return out;
        } else if (category == 2) {
            int index = rand.nextInt(sexyDares.size());
            String out = sexyDares.get(index);
            sexyDares.remove(index);
            if (sexyDares.size() == 0) sexyDaresAvailable = false;
            return out;
        } else if (category == 3) {
            int index = rand.nextInt(alcoholDares.size());
            String out = alcoholDares.get(index);
            alcoholDares.remove(index);
            if (alcoholDares.size() == 0) alcoholDaresRemaining = false;
            return out;
        }

        return "oh shit, a bug!";
    }


}
