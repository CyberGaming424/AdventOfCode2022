import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class DayThree {

  List<String> rucks;
  ArrayList<String[]> splitRucks;

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
      rucks = Files.readAllLines(Path.of("src/main/java/DayThree.txt"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    splitRucks = new ArrayList<>();
    for (String line : rucks) {

      String compartmentOne = line.substring(0, (line.length() / 2));
      String compartmentTwo = line.substring((line.length() / 2));
      String[] ruck = { compartmentOne, compartmentTwo };

      splitRucks.add(ruck);
    }

    System.out.println("Part One: " + partOne());
    System.out.println("Part Two: " + partTwo());

  }

  private int partOne() {
    int sum = 0;
    for (String[] ruck : splitRucks) {
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

  private int partTwo() {
    int sum = 0;

    for (int ruck = 0; ruck < rucks.size(); ruck++) {
      boolean itemFound = false;
      if ((ruck + 1) % 3 == 0) {
        String[] currRuck = rucks.get(ruck).split("");
        String[] prevRuck = rucks.get(ruck - 1).split("");
        String[] secPrevRuck = rucks.get(ruck - 2).split("");

        for (String i : currRuck) {
          for (String j : prevRuck) {
            if (j.equals(i)) {
              for (String l : secPrevRuck) {
                if (j.equals(l) && !itemFound) {
                  itemFound = true;
                  sum += itemPriority(i);
                }
              }
            }
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