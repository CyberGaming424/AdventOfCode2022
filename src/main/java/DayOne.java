import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class DayOne {

  public DayOne() {
    System.out.println("Part One: " + partOne());
    System.out.println("Part Two: " + partTwo());
  }

  private int partOne() {
    int maxCal = 0;
    try {
      List<String> lines = Files.readAllLines(Path.of("src/main/java/DayOne.txt"));
      int cal = 0;
      for (String line : lines) {
        if (line.length() != 0) {
          cal += Integer.parseInt(line);
        } else {
          maxCal = Math.max(cal, maxCal);
          cal = 0;
        }

      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return maxCal;
  }

  private int partTwo() {
    ArrayList<Integer> CalSums = new ArrayList<Integer>();
    try {
      List<String> lines = Files.readAllLines(Path.of("src/main/java/DayOne.txt"));
      int cal = 0;
      for (String line : lines) {
        if (line.length() != 0) {
          cal += Integer.parseInt(line);
        } else {
          CalSums.add(cal);
          cal = 0;
        }

      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    Collections.sort(CalSums);
    return CalSums.get(CalSums.size() - 1) + CalSums.get(CalSums.size() - 2) + CalSums.get(CalSums.size() - 3);
  }

}
