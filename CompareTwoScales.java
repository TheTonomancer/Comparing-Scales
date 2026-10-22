import java.util.*;

public class Main {
  
  public static void main(String[] args) {
    // -------------------- //
    // Initial Declarations //
    // -------------------- //
      String[] notes = {"C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "B"};
    
      String[] scaleTypes = {"chromatic scale", "major", "minor", "harmonic major", "harmonic minor", "major 6 diminished"};

      int[][] scaleDefinitions = {
        {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, //chromatic scale
        {0, 2, 4, 5, 7, 9, 11},  //major
        {0, 2, 3, 5, 7, 9, 11},  //melodic minor
        {0, 2, 4, 5, 7, 6, 11},  //harmonic major
        {0, 2, 3, 5, 7, 8, 11},  //harmonic minor
        {0, 2, 3, 5, 7, 8, 9, 11} //major 6 diminished
      };
    /* End of Declarations */  



    // --------------- //
    //  GET 1ST SCALE  // 
    // --------------- //
      System.out.println("Choose a scale");
      
      int[] userScaleOne = getUserInput(notes, scaleTypes); /* returns as a rootAndTypeIndeces */
      
      String[] firstChomaticReorder = reOrderingAlgorithm(notes, userScaleOne[0]); /* ReOrder chromatic scale from root 1 */

      String[] scaleOne = generateScale(firstChomaticReorder, scaleDefinitions[userScaleOne[1]]); /* generateScale 1 and print it out */
      
      System.out.println();
    /* End of GET 1ST SCALE */ 



    // --------------- //
    //  GET 2nd SCALE  // 
    // --------------- //
      System.out.println("\nchoose another scale");

      int[] userScaleTwo = getUserInput(notes, scaleTypes); /* returns as rootAndTypeIndeces*/

      String[] secondChromaticReorder = reOrderingAlgorithm(notes, userScaleTwo[0]); /* ReOrder chromatic scale from root 2 */
 
      String[] scaleTwo = generateScale(secondChromaticReorder, scaleDefinitions[userScaleTwo[1]]); /* generateScale 2 and print it out */
    /* End of GET 2ND SCALE */



    // ---------------- //
    //  COMPARE SCALES  // 
    // ---------------- //
      String[] commonTones = scaleComparison(scaleOne, scaleTwo);    /* compareScales ...print results */

      System.out.println();

      printComparison(commonTones,
      /* root 1                 type1 */
       notes[userScaleOne[0]], scaleTypes[userScaleOne[1]],
      /* root 2                 type2 */
       notes[userScaleTwo[0]], scaleTypes[userScaleTwo[1]] );

    // ask if the user wants to reorder the scales based on a common note.

  }

  public static int[] getUserInput(String[] notes, String[] scaleTypes) {
    
    Scanner userEntry = new Scanner(System.in);
    int i = 0;

    System.out.print("Root: ");
    //The User chooses a root note
    String root = userEntry.nextLine();
    //And loop converts it to an index in the "notes" array
    while (i < notes.length) {
      if (notes[i].equals(root)) {break;}
      i++;
    }
    int rootIndex = i;

    //The user chooses a scale type
    System.out.print("Choose a scale type: ");
    String type = userEntry.nextLine();
    //And it's converted to an index of scaleTypes
    i = 0;
    while (i < scaleTypes.length) {
    if (type.equals(scaleTypes[i])) {break;}
    i++;
    }
    int typeIndex = i;
     
    int[] rootAndTypeIndeces = {rootIndex, typeIndex};
    return rootAndTypeIndeces;
  }

  public static String[] generateScale(String[] sortedChromaticScale, int[] scaleType) {
    int i = 0;

    String[] scaleStorage = {"", "", "", "", "", "", "", "", "", "", "", ""};

    while (i < scaleType.length) {
      scaleStorage[i] = sortedChromaticScale[scaleType[i]];
      i++;
    }

    int amountOfScaleNotes = i;
    String[] generatedScale = new String[i];
    
    i = 0;
    while (i < amountOfScaleNotes) {
      generatedScale[i] = scaleStorage[i];
      i++;
    }

    System.out.println();
    
    i = 0;
    //this loop displays the generated scale
    while (i < scaleType.length) {
      System.out.print(generatedScale[i] + " ");
      i++;
    }
    return generatedScale;
  }

  public static String[] reOrderingAlgorithm(String[] scaleToBeReordered, int rootIndex) {
    int i = 0;
    int reOrderIndex = rootIndex;

    String[] reOrderedNotes = {"", "", "", "", "", "", "", "", "", "", "", ""};

    /* This part reorders the chromatic scale to start
    on the users chosen note. */
    while (i < scaleToBeReordered.length) {
      reOrderedNotes[i] = scaleToBeReordered[reOrderIndex];
      i++;
      reOrderIndex++;
      
      if (reOrderIndex == scaleToBeReordered.length) {reOrderIndex = 0;}

    }
  
    return reOrderedNotes;
  
  }

  public static String[] scaleComparison(String[] scaleOne, String[] scaleTwo) {
    
    String[] commonToneStorage = {"", "", "", "", "", "", "", "", "", "", "", ""};
    // String[] nonCommonTones = {"", "", "", "", "", "", "", "", "", "", "", ""};
    // String[] commonElectrons = {"", "", "", "", "", "", "", "", "", "", "", ""};
    
    int i = 0;
    int iScale1 = 0;
    int iScale2 = 0;

    while (iScale1 < scaleOne.length && iScale2 < scaleTwo.length) {
      if ( scaleOne[iScale1].equals(scaleTwo[iScale2]) ) {
        commonToneStorage[i] = scaleOne[iScale1];

        i++;
        iScale1++;
        iScale2++;
      }
      else {
        iScale2++;
      }

      if ( iScale2 >= scaleTwo.length) {
        iScale1++;
        iScale2 = 0;
      }

      if (i == scaleOne.length || i == scaleTwo.length) {break;}
    }

    int amountOfCommonTones = i;
    String[] commonTones = new String[i];
    
    i = 0;
    while (i < amountOfCommonTones) {
      commonTones[i] = commonToneStorage[i];
      i++;

    }

    return commonTones;
  }

  public static void printComparison(String[] commonTones, String root1, String type1, String root2, String type2) {
    
    //    String magenta = "\033[35;1m";
    //    String white = "\033[0m";

    System.out.printf("\nOkay here are the %d notes, the above scales have in common: ", commonTones.length);
    
    int i = 0;
    while (i < commonTones.length) {
      System.out.print(commonTones[i]);
      i++;
      
      if (i < commonTones.length) {System.out.print(", ");}
    }
  }

}

