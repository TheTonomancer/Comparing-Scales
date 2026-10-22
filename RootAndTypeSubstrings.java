import java.util.*;

public class SeparatingAnswerIntoRootAndType {
  
  public static void main(String[] args) {
  
    System.out.print("choose a scale: ");
    String scaleOne = userChoosesScale();

    
    String rootNote = rootTypeSeparator(scaleOne, null); //here, I pass in the value null for the first call so that the method returns a root string
    String scaleType = rootTypeSeparator(scaleOne, rootNote); //here, the root substring from the first call is stored in the variable rootNote, and will not be null. so the method will give us the type substring of the users input. 

    System.out.println("\nRoot: " + rootNote);
    System.out.println("Type: " + scaleType);

  }

  public static String userChoosesScale() {
    Scanner input = new Scanner(System.in);
    String userScale = input.nextLine();
    return userScale;
  }

  public static String rootTypeSeparator(String scaleString, String rootNote) {
    
    int spaceIndex = scaleString.indexOf(' ');

    if(rootNote == null){
      return scaleString.substring(0, spaceIndex);
    }
    else {
      return scaleString.substring(spaceIndex + 1, scaleString.length());
    }
  }

}
