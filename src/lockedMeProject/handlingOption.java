package lockedMeProject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class handlingOption {
	
	 Scanner sc= new Scanner(System.in);
	 public final static String ROOT_DIRECTORY_PATH="./files/";
	

	public static void dispalyMainMenu()
	{	
		
   try {
		String msgPrint=
				"\n \n please enter your chois number :\n \n" +
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
	            	System.out.println("PLEAS ENTER VAID OPTION NUMBER");
	            	
	            	
	              
	              }} catch (InputMismatchException e)
   {
	           	   
                  System.out.println("PLEAS ENTER VAID OPTION  \n");
                  dispalyMainMenu();


}
   
	              
	              
	              }
	              
	// Retrieve all files	
	public static void retriveAllFiles() {
		
	File folder = new File(ROOT_DIRECTORY_PATH);
	File[] listOfFiles = folder.listFiles();
	if (listOfFiles != null && listOfFiles.length > 0) {
    System.out.println("The file in directory : \n "+"---------------------------" );
	for (int i = 0; i < listOfFiles.length; i++) {
	  if (listOfFiles[i].isFile()) {
	    System.out.println("File :" + listOfFiles[i].getName());
	  } else if (listOfFiles[i].isDirectory()) {
	    System.out.println("Directory " + listOfFiles[i].getName());
	  }
	}
	}else{
		System.out.println("---- Empty Directory ---");
	}
	dispalyMainMenu();	
	}
	
	
	
	public static void dispalyMenu()
	
	{	
		try{
			String s= "1-Add file to the Directory \n"+
			 "2-Search file from the in Directory\n" + 
             "3-Delete file from the Directory\n"+
			 "4-Return to main menu \n"+
			 "5-Exit file from the application \n";
	
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
        	 fileName=sc.next();
        	 findFile( fileName);
       	     dispalyMenu();
       	     break;
       	  
         case 3:
        	 System.out.println("please enter the file name to delete: \n");
        	 fileName=sc.next();
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
       	System.out.println("PLEAS ENTER VAID OPTION NUMBER \n");
       	System.exit(0);
       	
         
         }
	}   catch (InputMismatchException e)
		   {
	   
		System.out.println("PLEAS ENTER VAID OPTION NUMBER \n");
		dispalyMenu();
		
		
	  }

		
	}


	//create new file
	  public static void creatFile(String fileName) {
		    try {
		      File myObj = new File(ROOT_DIRECTORY_PATH+fileName+".txt");
		      if (!myObj.exists()) {
		        myObj.createNewFile();
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
	  
	  
	 // delete function
	  public static void deleteFile(String name)
	    {
		  boolean isExist=false;
		    try {
		    	File folder = new File(ROOT_DIRECTORY_PATH);
		    	File[] Files = folder.listFiles();
			      for(File fileEntry : Files) {
			    	  //System.out.println(fileEntry.getName());
			    	  if(fileEntry.isFile()) {
			    	  if (fileEntry.getName().equals(name+".txt")) {
			    		  isExist=true;
			    		  fileEntry.delete();
			    		
			    	  }
			    	  
			      }}
			    	  if(isExist) {
			    		  System.out.println("File is delete \n");
			    		  dispalyMenu();
			    	  }
			    	  else{
			    		  System.out.println("File not found or check the case sensitivity\n"); 
			    		  dispalyMenu();
			    		  
			    	  }
			    	  
			    } catch (Exception e) {
			      System.out.println("An error occurred. \n");
			      e.printStackTrace();
			      dispalyMenu();
			    }
			  }

	// search function
	  public static void findFile(String name)
	    {
		  boolean isExist=false;
		    try {
		    	File folder = new File(ROOT_DIRECTORY_PATH);
		    	File[] Files = folder.listFiles();
			      for(File fileEntry : Files) {
			    	  if(fileEntry.isFile()) {
			    	  if (fileEntry.getName().equals(name+".txt")) {
			    		  isExist=true;
			    	  }
			    	  
			      }}
			    	  if(isExist) {
			    		  System.out.println("File is existed \n");
			    	  }
			    	  else{
			    		  System.out.println("File is not existed in the directory\n"); 
			    		  
			    	  }
			    	  
			    } catch (Exception e) {
			      System.out.println("An error occurred. \n");
			      e.printStackTrace();
			      dispalyMenu();
			    }
			  }

	}

