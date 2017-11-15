package new7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * JDK 7 New: Samples for The try-with-resources Statement
 * @author SimonC
 * @see https://docs.oracle.com/javase/8/docs/technotes/guides/language/try-with-resources.html
 */
public class TryWithResources {

	public static void main(String[] args) throws IOException {
			//The try-with-resources statement ensures that each resource is closed at the end of the statement.
			//Any object that implements java.lang.AutoCloseable, 
			//    which includes all objects which implement java.io.Closeable, 
			//    can be used as a resource.
			String path = "C:\\Users\\SimonC.LEOSYS\\Desktop\\adType.txt";
			String aLine = readFirstLineFromFile(path);
			System.out.println("aLine=" + aLine);
			
			aLine = readFirstLineFromFileWithFinallyBlock(path);
			System.out.println("aLine again=" + aLine);
			
			writeToFileZipFileContents("D:\\LeadWS7\\TestWeb8\\src\\new7\\adType.zip",
					"C:\\Users\\SimonC.LEOSYS\\Desktop\\test\\a.txt");
	}

	//try-with-resources statement
	//if the methods readLine and close both throw exceptions, 
	//   then the method readFirstLineFromFileWithFinallyBlock throws the exception 
	//        thrown from the finally block; 
	//   the exception thrown from the try block is suppressed
	private static String readFirstLineFromFile(String path) throws IOException {
			try (BufferedReader br = new BufferedReader(new FileReader(path))) {//try-with-resources statement
					return br.readLine();
			}
	}
	
	//Prior to Java SE 7
	//if exceptions are thrown from both the try block and the try-with-resources statement, 
	//   then the method readFirstLineFromFile throws the exception thrown from the try block; 
	//   the exception thrown from the try-with-resources block is suppressed.
	private static String readFirstLineFromFileWithFinallyBlock(String path) throws IOException {
			BufferedReader br = new BufferedReader(new FileReader(path));
			try {
					return br.readLine();
			} finally {
					if (br != null) br.close();
			}
	}
	
	//two declarations in a try-with-resources statement.
	public static void writeToFileZipFileContents(String zipFileName, String outputFileName) 
			throws java.io.IOException {
			
			Charset charset = StandardCharsets.US_ASCII;
			Path outputFilePath = Paths.get(outputFileName);
			
			// Open zip file and create output file with try-with-resources statement
			try (
					ZipFile zf = new ZipFile(zipFileName);
					//String s = "";//Compile error: The resource type String does not implement java.lang.AutoCloseable
					BufferedWriter writer = Files.newBufferedWriter(outputFilePath, charset)
			){
					//Enumerate each entry
					for (Enumeration entries = zf.entries(); entries.hasMoreElements();) {
							// Get the entry name and write it to the output file
							String newLine = System.getProperty("line.separator");
							String zipEntryName = ((ZipEntry)entries.nextElement()).getName() + newLine;
							System.out.println("zipEntryName=" + zipEntryName);
							writer.write(zipEntryName, 0, zipEntryName.length());
					}
			}
	}
	
	//automatically close a java.sql.Statement object
	public static void viewTable(Connection con) throws SQLException {

			String query = "select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES";

			try (Statement stmt = con.createStatement()) {
					ResultSet rs = stmt.executeQuery(query);
					while (rs.next()) {
							String coffeeName = rs.getString("COF_NAME");
							int supplierID = rs.getInt("SUP_ID");
							float price = rs.getFloat("PRICE");
							int sales = rs.getInt("SALES");
							int total = rs.getInt("TOTAL");
							System.out.println(coffeeName + ", " + supplierID + ", " + price 
									+ ", " + sales + ", " + total);
					}
			} catch (SQLException e) {
					e.printStackTrace();
			}
	}
}
