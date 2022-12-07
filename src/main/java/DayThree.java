import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class DayThree {

  List<String> file;
  ArrayList<String[]> rucks;

  String[] test = {
      "vJrwpWtwJgWrhcsFMMfFFhFp",
      "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
      "PmmdzqPrVvPwwTWBwg",
      "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
      "ttgJtRGJQctTZtZT",
      "CrZsJsPPZsGzwwsLwLmpwMDw"
  };

  public DayThree() {

    try {
      file = Files.readAllLines(Path.of("src/main/java/DayThree.txt"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    rucks = new ArrayList<>();
    for (String line : file) {

      String compartmentOne = line.substring(0, (line.length() / 2));
      String compartmentTwo = line.substring((line.length() / 2));
      String[] ruck = { compartmentOne, compartmentTwo };

      rucks.add(ruck);
    }

    System.out.println("Part One: " + partOne());

  }

  private int partOne() {
    int sum = 0;
    for (String[] ruck : rucks) {
      boolean itemFound = false;
      String[] compOne = ruck[0].split("");
      String[] compTwo = ruck[1].split("");
      for (int i = 0; (i < compOne.length); i++) {
        for (int j = 0; j < compTwo.length; j++) {
          if (compOne[i].equals(compTwo[j]) && !itemFound) {
            sum += itemPriority(compOne[i]);
            itemFound = true;
            break;
          }
        }
      }

    }
    return sum;
  }

  private int itemPriority(String itemIn) {
    char item = itemIn.toCharArray()[0];
    return ((int) item < (int) 'a') ? ((int) item) - ((int) 'A') + 27 : ((int) item) - ((int) 'a') + 1;
  }

}