import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class DayTwo {

  // Rock paper scissors

  List<String> file;
  List<String[]> rounds;

  // Converts text file to array
  public DayTwo() {
    try {
      file = Files.readAllLines(Path.of("src/main/java/DayTwo.txt"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    rounds = new ArrayList<>();
    for (String line : file) {
      rounds.add(line.split(" "));
    }

    System.out.println("Part one: " + partOne());
    System.out.println("Part two: " + partTwo());
  }

  
  private int partOne() {
    int score = 0;
    for (String[] round : rounds) {

      switch (round[1]){
        case "X":
          score++;
          if(round[0].equalsIgnoreCase("c")){
            score+=6;
          }else if(round[0].equalsIgnoreCase("a")){
            score+=3;
          }
          break;
        case "Y":
          score+=2;
          if(round[0].equalsIgnoreCase("a")){
            score+=6;
          }else if(round[0].equalsIgnoreCase("b")){
            score+=3;
          }
          break;
        case "Z":
          score+=3;
          if(round[0].equalsIgnoreCase("b")){
            score+=6;
          }else if(round[0].equalsIgnoreCase("c")){
            score+=3;
          }
          break;
      }
    }
    return score;
  }

  private int partTwo(){
    int score = 0;
    for(String round[] : rounds){
      switch(round[1]){
        case "X":
          boolean[] loss = {true, false, false};
          score+=moveScore(round[0], loss);
          break;
        case "Y":
          boolean[] draw = {false, true, false};
          score+=3+moveScore(round[0], draw);
          break;
        case "Z":
          boolean[] win = {false, false, true};
          score+=6+moveScore(round[0], win);
          break;
      }
    }
    return score;
  }

  private int moveScore(String opponent, boolean[] expectedResult){
    int score = 0;
    switch(opponent){
            case "A":
              if(expectedResult[0]){
                score = 3;
              }else if(expectedResult[1]){
                score = 1;
              }else if(expectedResult[2]){
                score=2;
              }
              break;
            case "B":
              if(expectedResult[0]){
                score = 1;
              }else if(expectedResult[1]){
                score = 2;
              }else if(expectedResult[2]){
                score = 3;
              }
              break;
            case "C":
              if(expectedResult[0]){
                score = 2;
              }else if(expectedResult[1]){
                score = 3;
              }else if(expectedResult[2]){
                score = 1;
              }
              break;
          }
    return score;
  }
  
}