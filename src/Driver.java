import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Project Title: Binary Tree and Hashing Lab
 * Project Description: Creates a cross-reference listing for the text-based document
 *                      located in getty.txt as well as a hash table for a collection of omitted words located
 *                      in omit.txt. Allows the user to query for a few select words additionally.
 * Version or Date: May 17, 2019
 * How to Start the Project: Run the Driver.java main method.
 * Palomar ID: 012173849
 *
 * @author Tomas Kaljevic
 */
public class Driver {
    /**
     * Starts the application by creating the cross-reference listing, hash table,
     * and prompting the user to query or quit the program.
     * @param args the system arguments being passed in
     * @throws IOException if there is a problem writing data
     */
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));

        Xref xref = new Xref(pw);
        xref.getGettysburg();
        xref.printWordData();

        pw.close();
    }
}
