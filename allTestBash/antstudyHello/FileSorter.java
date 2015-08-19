import java.io.*;
import java.util.*;
//import org.apache.tools.ant.BuildException;
//import org.apache.tools.ant.Task;
 
//public class FileSorter extends Task {
public class FileSorter  {
    private File file, tofile;    
    // The method executing the task
    //public void execute() throws BuildException {
    public void execute()  {
        System.out.println("Sorting file="+file);
       // try {
            BufferedReader from =   new BufferedReader(new FileReader(file));
            BufferedWriter to =    new BufferedWriter(new FileWriter(tofile));
            List allLines = new ArrayList();
    // read in the input file
            String line = from.readLine();
            while (line != null) {
                allLines.add(line);
                line = from.readLine();
            }
            from.close();
            // sort the list
            Collections.sort(allLines);
            // write out the sorted list
            for (ListIterator i=allLines.listIterator(); i.hasNext(); ) {
                String s = (String)i.next();
                to.write(s);
                to.newLine();
            }
            to.close();
       // } catch (FileNotFoundException e) {
       //     throw new BuildException(e);
       // } catch (IOException e) {
       //     throw new BuildException(e);
       // }
    }
            // The setter for the "file" attribute
    public void setFile(File file) {
            this.file = file;
    }
           // The setter for the "tofile" attribute
    public void setTofile(File tofile) {
            this.tofile = tofile;
    }
}
