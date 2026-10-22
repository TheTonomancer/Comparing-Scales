import java.util.*;

public class Main {
  
  public static void main(String[] args) {
  
    System.out.print("choose a scale: ");
    String scaleOne = userChoosesScale();

    String[] rootAndType = separateInputIntoRootAndType(scaleOne);


    System.out.println(rootAndType[0]);
    System.out.println(rootAndType[1]);

  }

  public static String userChoosesScale() {
    Scanner input = new Scanner(System.in);
    String userScale = input.nextLine();
    return userScale;
  }

  public static String[] separateInputIntoRootAndType(String scaleString) {
    
    int spaceIndex = scaleString.indexOf(' ');
    
    String root = scaleString.substring(0, spaceIndex);
    String type = scaleString.substring(spaceIndex + 1, scaleString.length());
    
    String[] scaleElements = {root, type};
    return scaleElements;
  }

}
