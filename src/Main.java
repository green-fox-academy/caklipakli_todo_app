import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> listOfTasks;


           if (args.length == 0) {

                listOfTasks = ReadFileIntoAList("../assets/argumentsList.txt");

               for (int i = 0; i < listOfTasks.size(); i++) {
                   System.out.println(listOfTasks.get(i));
               }

           } else {

               if (args[0].equals("-l")) {

                   listOfTasks = ReadFileIntoAList("../assets/todolist.txt");
                   ListOfTasks toDo = new ListOfTasks(listOfTasks);
                   toDo.printSreen();

               }
               if (args[0].equals("-a")) {

                   listOfTasks = ReadFileIntoAList("../assets/todolist.txt");
                   listOfTasks.add("Feed the monkey");
                   writeListIntoFile("../assets/todolist.txt", listOfTasks);

               }
           }
    }

    public static List<String> ReadFileIntoAList(String path) {
        List<String> listOfTasks = new ArrayList<>();
        try {
            Path filePath = Paths.get(path);
            listOfTasks = Files.readAllLines(filePath);
            return listOfTasks;

        } catch (IOException ex) {
            System.out.println("File doesnt exists.");
        }

        return listOfTasks;
    }

    public static void writeListIntoFile(String path, List<String> list) {
        List<String> content = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            content.add(list.get(i));
        }

        try {
            Path filePath = Paths.get(path);
            Files.write(filePath, content);

        } catch (Exception e) {
            System.out.println("Sorry, sg wrong");
        }
    }
}
