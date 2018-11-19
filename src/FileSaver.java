/** template to open file and append results to it
 * Created by tomaszmichalik on 10/30/18.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileSaver {
    public String file_loc;// = "../results.txt";
    BufferedWriter out;
    List<String> output_list;
    FileSaver(String filename){
        this.output_list = new ArrayList<>();
        this.file_loc = filename;

    }
    public void addString(String s){
        output_list.add(s);
    }

    public void writetoFile(String string) {
        try {
            this.out = new BufferedWriter(new FileWriter(file_loc, true));

            out.write(string);
        }
        catch (IOException e){
            System.out.println("exception occurred +"+e);
            e.printStackTrace();
        }
        resetWriteList();

    }
    public void resetWriteList(){
        try {
            out.newLine();
            out.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        this.output_list.clear();//
    }
}
