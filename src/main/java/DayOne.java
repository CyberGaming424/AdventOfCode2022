import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DayOne {

    public DayOne(){
        try {
            List<String> lines = Files.readAllLines(Path.of("src/main/java/DayOne.txt"));
            for (String line : lines) {
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
