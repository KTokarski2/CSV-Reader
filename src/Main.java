import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String [] args) throws IOException {

        String path = "src/example.txt";
        String [] line;
        String [] lineWithoutFirstLine;
        int howManyStringsInLine = 0;
        int howManyLinesInCsv = 0;
        List<String> fileLines = null;
        HashMap<String,String []> csvMap = new HashMap<>();
        String connectedString = "";

        try {
             fileLines = new BufferedReader(new FileReader(path))
                    .lines()
                    .skip(1)
                    .collect(Collectors.toList());

             System.out.println("This is your CSV file: ");
            System.out.println("-----------------------------------------------------------------------------------");

            for (int i = 0; i < fileLines.size(); i++) {
                System.out.println(fileLines.get(i));
                howManyLinesInCsv ++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("-------------------------------------------------------------------------------------------");

        line = fileLines.get(0).split(";");
        howManyStringsInLine = line.length;
        System.out.println("You have " + howManyLinesInCsv + " lines in your file");
        System.out.println("You have " + howManyStringsInLine + " strings in each line");

        System.out.println("-------------------------------------------------------------------------------------------");

        for (int i = 0; i < fileLines.size(); i++) {
            line = fileLines.get(i).split(";");
            String key = line[0];
            lineWithoutFirstLine = Arrays.copyOfRange(line,1,line.length);
            //connectedString = String.join(";",lineWithoutFirstLine);
            csvMap.put(key,lineWithoutFirstLine);
        }

        System.out.println("This is your CSV map: ");
        System.out.println();
        csvMap.forEach((k,v) -> System.out.println(k + ": " + Arrays.toString(v)));

        csvMap.forEach((k,v) -> System.out.println("first column: " + k));
        csvMap.forEach((k,v) -> System.out.println("third column: " + v[3]));

    }
}
