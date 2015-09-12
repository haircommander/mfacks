package hot.pomp.com.truthordare;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Owen AND MEREDITH on 9/12/15.
 */
public abstract class TextAssets {

    // use an array list of strings to categorize truths/dares
    private static ArrayList<String> basicTruths;
    private static ArrayList<String> personalTruths;
    private static ArrayList<String> romanceTruths;
               
    private static ArrayList<String> generalDares;
    private static ArrayList<String> sexyDares;
    private static ArrayList<String> alcoholDares;

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

    /////////////////////////////////////////////////////////////////////////

    /**
     * Gets the class ready for action
     * @param context_
     */
    public static void initialize(Context context_) {

        context = context_;

        // make array lists for truths and dares
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
     * Reads in one file into an array list<br>
     * Stores each file line into a string, then stores string into list
     * @param file
     * @param list
     * @throws FileNotFoundException
     */
    private static void readIn(File file, ArrayList<String>list) throws FileNotFoundException {

        Scanner scanner = new Scanner(file); // set up file for reading
        String line;

        // read in lines to the list
        while ((line = scanner.nextLine()) != null)
            personalTruths.add(new String(line));

        scanner.close(); // close scanner for safety <3
    }

    /**
     * loads text files and reads in their input
     * @throws FileNotFoundException
     */
    private static void loadFiles() throws FileNotFoundException {

        // loads .txt files in raw to the file objects of the class
        basicTruthsText = new File(context.getFilesDir(), "raw/" + basicTruthsFileName);
        personalTruthsText = new File(context.getFilesDir(), "raw/" + personalTruthsFileName);
        romanceTruthsText = new File(context.getFilesDir(), "raw/" + romanceTruthsFileName);
        generalDaresText = new File(context.getFilesDir(), "raw/" + generalDaresFileName);
        sexyDaresText = new File(context.getFilesDir(), "raw/" + sexyDaresFileName);
        alcoholDaresText = new File(context.getFilesDir(), "raw/" + alcoholDaresFileName);
        
        // read in truths and dares
        readIn(basicTruthsText, basicTruths);
        readIn(personalTruthsText, personalTruths);
        readIn(romanceTruthsText, romanceTruths);
        readIn(generalDaresText, generalDares);
        readIn(sexyDaresText, sexyDares);
        readIn(alcoholDaresText, alcoholDares);
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
        if (category == 1)
            return basicTruths.get(rand.nextInt(basicTruths.size()));
        // category 2 is personal truths
        else if (category == 2)
            return personalTruths.get(rand.nextInt(personalTruths.size()));
        // category 3 is romance truths
        else if (category == 3)
            return romanceTruths.get(rand.nextInt(romanceTruths.size()));
        
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
        int category = -1;

        int category = categorySelector(general, sexy, alcohol);

        if (category == 1) {
            return generalDares.get(rand.nextInt(generalDares.size()));
        } else if (category == 2) {
            return sexyDares.get(rand.nextInt(sexyDares.size()));
        } else if (category == 3){
            return alcoholDares.get(rand.nextInt(alcoholDares.size()));
        }

        return "oh shit, a bug!";
    }
}
