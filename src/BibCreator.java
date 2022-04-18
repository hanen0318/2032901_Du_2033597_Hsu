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
		scanner.close();
		return n; 
	}
	
	public static void deleteFile(int i)//DELETING 
	{
		File deleteFile = null;
		
		deleteFile = new File("C:\\Java eclipse\\2032901_Du_2033597_Hsu\\src\\Files\\IEEE"+ i +".json");
		deleteFile.delete();
		deleteFile = new File("C:\\Java eclipse\\2032901_Du_2033597_Hsu\\src\\Files\\ACM" + i + ".json");
		deleteFile.delete();
		deleteFile = new File("C:\\Java eclipse\\2032901_Du_2033597_Hsu\\src\\Files\\NJ" + i + ".json");
		deleteFile.delete();
	}
	
	public static void processFilesForValidation(Scanner scanner, PrintWriter pw, int i) throws FileInvalidException, FileNotFoundException
	{
		
		String bib = readFile(scanner); //Using function to read file and put into one big string
		String ieee = "";
		String acm = "";
		String nj = "";
		StringTokenizer seperateArticle = new StringTokenizer(bib, "@"); //breaking string into tokens to seperate the articles when it starts with @
		
		while(seperateArticle.hasMoreTokens())
		{
			
			
		}
		
		//create IEEE file and write to new file from reading ieee string
		pw = new PrintWriter(new FileOutputStream("IEEE"+ i +".json", false));
		pw.println(ieee);
		pw.close();
		
		//create ACM file file and write to new file from reading acm string
		pw = new PrintWriter(new FileOutputStream("ACM"+ i +".json", false));
		pw.println(acm);
		pw.close();
		
		//create NJ file file and write to new file from reading nj string
		pw = new PrintWriter(new FileOutputStream("NJ"+ i +".json", false));
		pw.println(nj);
		pw.close();
		
		valid++;// counter for succesful files.
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		
		System.out.println("Welcome to Bib Creator!");
		
		for(int i = 1; i <= 10; i++) {
		
			try {
				sc = new Scanner(new FileInputStream("Latex" + i + ".bib"));
				sc.close();
			}
			
			catch(FileNotFoundException e) {							   
				System.out.println("Could not open input file Latex" + i + ".bib for reading. \nPlease check if file exists! \nProgram will terminate after closing any opened files.");
	            System.exit(0);
				sc.close();
			} 
		
		}	

		boolean flag = false;
		for (int i = 1; i <= 10; i++)
		{
			//IEEE
			try
			{
				pw = new PrintWriter(new FileOutputStream("IEEE" + i + ".json"));
				pw.close();//Close printwriter object
			}
			catch (FileNotFoundException e)
			{
				System.out.println("Could not create IEEE" + i + ".json for Latex" + i + ".bib.\nClearing directory of all other created output files.");
				pw.close(); //must create another set of closes since it skips when the exception is thrown
			
				for(int j=0; j<i; j++)// looping as many times as files were created
				{
					deleteFile(i);
				}
				System.exit(0);	
			}
			//ACM
			try
			{
				pw = new PrintWriter(new FileOutputStream("ACM" + i + ".json"));
				pw.close();//Close printwriter object
			}
			catch (FileNotFoundException e)
			{
				System.out.println("Could not create ACM" + i + ".json for Latex" + i + ".bib.\nClearing directory of all other created output files.");
				pw.close(); //must create another set of closes since it skips when the exception is thrown
			
				for(int j=0; j<i; j++)// looping as many times as files were created
				{
					deleteFile(i);
				}
				System.exit(0);	
			}
			//NJ
			try
			{
				pw = new PrintWriter(new FileOutputStream("NJ" + i + ".json"));
				pw.close();//Close printwriter object
			}
			catch (FileNotFoundException e)
			{
				System.out.println("Could not create NJ" + i + ".json for Latex" + i + ".bib.\nClearing directory of all other created output files.");
				pw.close(); //must create another set of closes since it skips when the exception is thrown
			
				for(int j=0; j<i; j++)// looping as many times as files were created
				{
					deleteFile(i);
				}
				System.exit(0);	
			}
		}
		
		//VALIDATING N STUFF
		
		
		System.out.println("A total of " + invalid + " files were invalid, and could not be processed. All other " + valid + " files have been created.\n");

		
		System.out.print("\nPlease enter the name of one of the files that you need to review:");
		Scanner inputFile = new Scanner(System.in);
		String fileName = inputFile.next();
		
		try 
		{
			br = new BufferedReader(new FileReader(fileName));
			
			System.out.println("Here are the contents of the successfully created JSON File: " + fileName);
			String nextLine = br.readLine();
			
			while(nextLine!=null) 
			{
				System.out.println(nextLine);
				nextLine = br.readLine();
			}
			System.out.println("\nGoodbye! Hope you have enjoyed creating the needed files using BibCreator.");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Could not open input file. File does not exist; possibly it could not be created!\n");
			System.out.println("However, you will be allowed another chance to enter another file name.");
			System.out.print("Please enter the name of one of the files that you need to review: ");
			fileName = inputFile.next();
			try 
			{
				br = new BufferedReader(new FileReader(fileName));
				
				System.out.println("Here are the contents of the successfully created JSON File: " + fileName);
				String nextLine = br.readLine();
				
				while(nextLine!=null) 
				{
					System.out.println(nextLine);
					nextLine = br.readLine();
				}
				System.out.println("\nGoodbye! Hope you have enjoyed creating the needed files using BibCreator.");
				
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("\nCould not open input file again! Either file does not exist or could not be created.");
				System.out.println("Sorry! I am unable to display your desired files! Program will exit!");
				System.exit(0);
			}
		}finally {
			inputFile.close();
		}
		System.out.print("Goodbye! Hope you enjoyed creating the needed files using BibCreator.");

		System.out.println("A total of " + invalid + " files were invalid, and could not be processed. All other " + valid + " files have been created.\n");
	}

}
