package lockedMeProject;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class handlingOption {
	
	 Scanner sc= new Scanner(System.in);
	 
	

	public static void dispalyMainMenu()
	{	
   try {
		String msgPrint=
				"please enter your chois number :\n \n" +
	             "1-Retrieving the file\n"+
				 "2-Display File operations menu \n"+
	             "3-Exit the application";
		
	              System.out.println(msgPrint);
	              Scanner sc= new Scanner(System.in);

	           
	             
	           int option=sc.nextInt();
	            
	              switch (option) {
	              
	              case 1:
	            	  retriveAllFiles();
	            	  break;
	            	  
	              case 2:
	            	  dispalyMenu();
	            	  break;
	            	  
	              case 3:
	            	 System.out.println("the porgram is EXIT");
	            	 System.exit(0);
	            	  break;
	            	  
	            default :
	            	System.out.println("PLEAS ENTER FAID OPTION NUMBER");
	            	
	            	
	              
	              }} catch (InputMismatchException e)
   {
	           	   
                  System.out.println("PLEAS ENTER FAID OPTION  \n");
                  dispalyMainMenu();


}
   
	              
	              
	              }
	              
		
	public static void retriveAllFiles() {
		
	File folder = new File("./files/");
	File[] listOfFiles = folder.listFiles();

	for (int i = 0; i < listOfFiles.length; i++) {
	  if (listOfFiles[i].isFile()) {
	    System.out.println("File " + listOfFiles[i].getName());
	  } else if (listOfFiles[i].isDirectory()) {
	    System.out.println("Directory " + listOfFiles[i].getName());
	  }
	}
	
	dispalyMainMenu();	
	}
	
	public static void dispalyMenu()
	
	{	
		try{
			String s= "1-Add file to the application \n"+
			 "2-Search file from the application\n" + 
             "3-Delete file from the application\n"+
			 "4-Return to main menu \n"+
			 "5-Exsit file from the application \n";
	
	  System.out.println(s);
	   
	  Scanner sc= new Scanner(System.in);
	  String fileName;
      int option=sc.nextInt();
     
         switch (option) {
         
         case 1:
        	 System.out.println("please enter the file name: \n");
        	 fileName=sc.next();
        	 creatFile(fileName);
       	  break;
       	  
         case 2:
        	 System.out.println("please enter the file name are you want to search: \n");
       	  dispalyMenu();
       	  break;
       	  
         case 3:
        	 System.out.println("please enter the file name to delete: \n");
        	 fileName=sc.next();
        	 System.out.println(fileName);
       	     deleteFile(fileName);
       	 
       	  break;
       	  
         case 4:
        	 dispalyMainMenu();
        	  break;
        	  
         case 5:
        	 System.out.println("the porgram is EXIT");
        	 System.exit(0);
        	  break;
       default :
       	System.out.println("PLEAS ENTER FAID OPTION NUMBER \n");
       	System.exit(0);
       	
         
         }
	}   catch (InputMismatchException e)
		   {
	   
		System.out.println("PLEAS ENTER FAID OPTION NUMBER \n");
		dispalyMenu();
		
		
	  }

		
	}


	
	  public static void creatFile(String fileName) {
		    try {
		      File myObj = new File("./files/"+fileName+".txt");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName()+ "\n");
		        dispalyMenu();
		      } else {
		        System.out.println("File already exists. \n");
		        dispalyMenu();
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred. \n");
		      e.printStackTrace();
		      dispalyMenu();
		    }
		  }
	  
	  
	  public static void deleteFile(String fileName) { 
		    File myObj = new File(fileName+".txt"); 
		    if (myObj.delete()) { 
		      System.out.println("Deleted the file: " + myObj.getName() +"\n");
		      dispalyMenu();
		    } else {
		      System.out.println("File not found.\n");
		      dispalyMenu();
		    } 
		  }
}
