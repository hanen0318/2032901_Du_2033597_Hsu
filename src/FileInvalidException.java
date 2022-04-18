// -----------------------------------------------------
// Final Project (BibCreator)
// �2022 Darryl Du, Hanen Hsu
// Written by: Darryl Du 2032901, Hanen Hsu 2033597
// -----------------------------------------------------
public class FileInvalidException extends Exception{
	
	//Default constructor
	public FileInvalidException() {
		super("Error: Input file cannot be parsed due to missing information" 
				+ " (i.e. month={}, title={}, etc.) ");
	}
	
	//Parameterized constructor
	//
	public FileInvalidException(String message) {
		super(message);
	}
}
