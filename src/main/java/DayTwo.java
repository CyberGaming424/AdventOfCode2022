import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class DayTwo {

  List<String> file;
  List<String[]> rounds;

  public DayTwo() {
    try {
      file = Files.readAllLines(Path.of("src/main/java/DayTwo.txt"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    rounds = new ArrayList<String[]>();
    for (String line : file) {
      rounds.add(line.split(" "));
    }

    System.out.println("Part one: " + partOne());
  }

  private int partOne() {
    int score = 0;
    for (String[] round : rounds) {
      if (round[1].equalsIgnoreCase("x")) {
        score += 1;
        if (round[0].equalsIgnoreCase("c"))
          score += 6;
        else if (round[0].equals("a"))
          score += 3;
      } else if (round[1].equalsIgnoreCase("y")) {
        score += 2;
        if (round[0].equalsIgnoreCase("a"))
          score += 6;
        else if (round[0].equals("b"))
          score += 3;
      } else if (round[1].equalsIgnoreCase("z")) {
        score += 3;
        if (round[0].equalsIgnoreCase("b"))
          score += 6;
        else if (round[0].equals("c"))
          score += 3;
      }
    }
    return score;
  }

}