import java.util.*;

public class SeparatingAnswerIntoRootAndType {
  
  public static void main(String[] args) {
  
    System.out.print("choose a scale: ");
    String scaleOne = userChoosesScale();

    String rootNote = getRootSubString(scaleOne);
    String scaleType = getScaleTypeSubString(scaleOne);

    System.out.println("\nRoot: " + rootNote);
    System.out.println("Type: " + scaleType);

  }

  public static String userChoosesScale() {
    Scanner input = new Scanner(System.in);
    String userScale = input.nextLine();
    return userScale;
  }

  public static String getRootSubString(String scaleString) {
    
    int spaceIndex = scaleString.indexOf(' ');
    
    return scaleString.substring(0, spaceIndex);
  }

  public static String getScaleTypeSubString(String scaleString) {
    
    int spaceIndex = scaleString.indexOf(' ');

    return scaleString.substring(spaceIndex + 1, scaleString.length());
  }

}
