package stringManipulation;
import java.text.DecimalFormat;
public class StringDecimal {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		

	/*	String stringLitersOfPetrol = ".123";
		System.out.println("string liters of petrol putting in preferences is "+stringLitersOfPetrol);
		
		Float litersOfPetrol = Float.parseFloat(stringLitersOfPetrol);
		DecimalFormat df = new DecimalFormat("0.00");
		df.setMaximumFractionDigits(2);
		stringLitersOfPetrol = df.format(litersOfPetrol);
		System.out.println("liters of petrol before putting in editor : "+stringLitersOfPetrol);*/
		
		
		String index = "Welcome to Innodata";
		System.out.println("Index of t ::- " +index.indexOf("t"));
		
		
		System.out.println("String after replacing l with Z ::- " +index.replace('l', 'Z'));
		
		System.out.println("----------------------------------------------------------------------------");
		
		// Initialising String
	      String Str = new String("Welcome to geeksforgeeks");
	       
	      // original string 
	      System.out.print("Original String : " );
	      System.out.println(Str);
	       
	      // Using replaceAll to replace regex with replace_str
	      System.out.print("After replacing regex with replace_str : " );
	      System.out.println(Str.replaceAll("(.*)geeks(.*)", "ASTHA TYAGI"));
	      
	      System.out.println("----------------------------------------------------------------------------");
	      
	   // Initialising String
	      String StrChange = "Welcome to geeksforgeeks";
	       
	      // original string 
	      System.out.print("Original String : " );
	      System.out.println(StrChange);
	       
	      // Using replaceFirst to replace regex with replace_str
	      // Replaces 1st occurrence of geeks with ASTHA
	      System.out.print("After replacing 1st occurrence of regex with replace_str  : " );
	      System.out.println(StrChange.replaceFirst("geeks", "ASTHA"));
	      
	      System.out.println("----------------------------------------------------------------------------");
	      
	      String revString = "Arun";
	      
	      StringBuilder sr = new StringBuilder();
	      sr.append(revString);
	      
	      sr = sr.reverse();	      
	      // print reversed String
	      System.out.println("Reverse String is ::- " +sr);
	      
	      System.out.println("----------------------------------------------------------------------------");
	      
	      char[] array = revString.toCharArray();
	      System.out.print("Reverse String Using Array ::- ");
	      
	      for (int i = array.length-1; i>=0; i--)	    	  
	            System.out.print(array[i]);

	}

}
