import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonReader {
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<Person> folks = new ArrayList<>();

        try
        {
            // uses a fixed known path:
            //  Path file = Paths.get("c:\\My Documents\\data.txt");

            // use the toolkit to get the current working directory of the IDE
            // Not sure if the toolkit is thread safe...
            File workingDirectory = new File(System.getProperty("user.dir"));

            // Typiacally, we want the user to pick the file so we use a file chooser
            // kind of ugly code to make the chooser work with NIO.
            // Because the chooser is part of Swing it should be thread safe.
            chooser.setCurrentDirectory(workingDirectory);
            // Using the chooser adds some complexity to the code.
            // we have to code the complete program within the conditional return of
            // the filechooser because the user can close it without picking a file

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                // Typical java pattern of inherited classes
                // we wrap a BufferedWriter around a lower level BufferedOutputStream
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                // Finally we can read the file LOL!

                int line = 0;
                while(reader.ready())
                {
                    rec = reader.readLine();
                    String[] recSplit = rec.split(", ");
                    line++;

                    Person p = new Person(recSplit[0], recSplit[1], recSplit[2], recSplit[3], Integer.parseInt(recSplit[4]));
                    folks.add(p);
                }

                System.out.printf( "%-15s %-15s %-15s %-15s %-15s %n", "ID#", "Firstname", "Lastname", "Title", "YOB");
                System.out.println("======================================================================");
                for(Person p: folks) {
                    System.out.printf("\n%-15s %-15s %-15s %-15s %-15s", p.getID(), p.getFirstName(), p.getLastName(), p.getTitle(), p.getYOB());
                }

                reader.close(); // must close the file to seal it and flush buffer
                System.out.println("\n\nData file read!");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
