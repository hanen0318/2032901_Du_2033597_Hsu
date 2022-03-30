// -----------------------------------------------------
// Final Project (BibCreator)
// ©2022 Darryl Du, Hanen Hsu
// Written by: Darryl Du 2032901, Hanen Hsu 2033597
// -----------------------------------------------------
import java.util.Scanner; //scanner
import java.io.FileInputStream; //reading data
import java.io.FileOutputStream; //writing data
import java.util.StringTokenizer; //string Tokenizer
import java.io.BufferedReader; //read text file
import java.util.regex.Matcher; //import for pattern matching
import java.util.regex.Pattern; //import for pattern matching
import java.io.File; //file and directory pathnames
import java.io.FileNotFoundException; //exception for reading and writing
import java.io.FileReader; //used to read data (in characters) from files
import java.io.IOException;//exception
import java.io.PrintWriter;//print the formatted representation of objects to the text-output stream

public class BibCreator {

	static int invalid = 0, valid = 0;//how many valid or invalid files
	
	public static String readFile(Scanner scanner)
	{
		String n = "";
		while (scanner.hasNextLine()) 
		{
			n += scanner.nextLine(); //adding to string
		}
		scanner.close(); //Close Scanner
		return n; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("******Welcome to Bib Creator!******");
		
		
	}

}
