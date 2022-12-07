import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class DayThree {

  List<String> file;
  ArrayList<String[]> rucks;

  public DayThree() {

    try {
      file = Files.readAllLines(Path.of("src/main/java/DayThree.txt"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    rucks = new ArrayList<>();
    for (String line : file) {

      String compartmentOne = line.substring(0, (line.length() / 2) + 1);
      String compartmentTwo = line.substring((line.length() / 2) + 1);
      String[] ruck = { compartmentOne, compartmentTwo };

      rucks.add(ruck);
    }

    System.out.println("Part One: " + partOne());

  }

  private int sum = 0;

  private int partOne() {

    rucks.forEach((ruck) -> {
      for (String compOneItem : ruck[0].split("")) {
        for (String compTwoItem : ruck[1].split("")) {
          if (compOneItem.equals(compTwoItem))
            sum += itemPriority(compOneItem.toCharArray()[0]);
        }
      }
    });
    return sum;
  }

  private int itemPriority(char item) {
    return ((int) item < (int) 'a') ? ((int) item) - ((int) 'A') + 1 : ((int) item) - ((int) 'a') + 1;
  }

}