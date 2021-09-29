import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

public class projectMajor_17812476 {
	
	public static void main(String[] args) throws IOException {
		boolean menuRun = true;
		
		// Inputs the 4 files into memory
		File CustomersInput = new File("C:\\Users\\Destreza\\Desktop\\Programming Project\\Customers.txt");
		File DailyJobsInput = new File("C:\\Users\\Destreza\\Desktop\\Programming Project\\DailyJobs.Txt");
		File ServiceInput = new File("C:\\Users\\Destreza\\Desktop\\Programming Project\\Service.Txt");
		File VehiclesInput = new File("C:\\Users\\Destreza\\Desktop\\Programming Project\\Vehicles.Txt");
		
		// If files can't be found, gets user to locate them
		CustomersInput = verifyExistence(CustomersInput, "CustomersInput");
		DailyJobsInput = verifyExistence(DailyJobsInput, "DailyJobsInput");
		ServiceInput = verifyExistence(ServiceInput, "ServiceInput");
		VehiclesInput = verifyExistence(VehiclesInput, "VehiclesInput");
		
		// Creates a Scanner object of the files so we can extract the data		
		Scanner Customer = new Scanner(CustomersInput);
		Scanner DailyJobs = new Scanner(DailyJobsInput);
		Scanner Services = new Scanner(ServiceInput);
		Scanner Vehicles = new Scanner(VehiclesInput);
		
		// For each array, calculates the size of the file than declares how big the array should be
		int x = arraySizeCalculation(Customer);
		Customer_17812476[] customerArray = new Customer_17812476[x];
					
		x = arraySizeCalculation(DailyJobs);
		Job_17812476[] dailyJobsArray = new Job_17812476[x];
				
		x = arraySizeCalculation(Services);
		Service_17812476[] servicesArray = new Service_17812476[x];
					
		x = arraySizeCalculation(Vehicles);
		Vehicle_17812476[] vehiclesArray = new Vehicle_17812476[x];
		
		// Creates new Scanner objects because we used up the others
		Scanner customersArrayInput = new Scanner(CustomersInput);
		Scanner dailyJobsArrayInput = new Scanner(DailyJobsInput);
		Scanner servicesArrayInput = new Scanner(ServiceInput);
		Scanner vehiclesArrayInput = new Scanner(VehiclesInput);
		
		// Each for loop below fills out each array element with an object, tokenizer is in the constructors
		for (int i = 0; i < customerArray.length; i++){
			String customerDetails = customersArrayInput.nextLine();
			customerArray[i] = new Customer_17812476(customerDetails);		
		}
		
		for (int i = 0; i < dailyJobsArray.length; i++){
			String dailyJobDetails = dailyJobsArrayInput.nextLine();
			String dailyJobDetails2;
			dailyJobDetails2 = dailyJobDetails.replace(",,", ",0.0,");
			dailyJobsArray[i] = new Job_17812476(dailyJobDetails2);	
		}
		
		for (int i = 0; i < servicesArray.length; i++){
			String servicesDetails = servicesArrayInput.nextLine();
			servicesArray[i] = new Service_17812476(servicesDetails);	
		}
		
		for (int i = 0; i < vehiclesArray.length; i++){
			String vehicleDetails = vehiclesArrayInput.nextLine();
			vehiclesArray[i] = new Vehicle_17812476(vehicleDetails);	
		}
		
		// The entire menu hierarchy occurs in the following method.
		if(menuRun = true){
		menuDisplay(dailyJobsArray, customerArray, vehiclesArray, servicesArray, DailyJobsInput);
		}
		
	}
	  
  public static void menuDisplay(Job_17812476[] dailyJobsArray, Customer_17812476 customerArray[], 
  		Vehicle_17812476 vehiclesArray[], Service_17812476 servicesArray[], File dailyJobsInput) throws IOException {
  	boolean menuRunning = true;
  	while(menuRunning){
  		System.out.println("=======   MAIN MENU    ======= \n"	
  				+ "Please enter a task number (1-4) from the list below: \n"
  				+ "  1: Display Jobs \n"	
  				+ "  2: Make Booking \n"
  				+ "  3: Save and Export Jobs \n"	
  				+ "  4: Exit Program \n"
  				+ "==============================");
    	
    	Scanner kboard = new Scanner(System.in);
			String menuChoice = kboard.nextLine();
			
			//Passes the chosen menu number to the mainMenu method
			menuRunning = mainMenu(menuChoice, dailyJobsArray, customerArray, vehiclesArray, servicesArray, dailyJobsInput, menuRunning, customerArray);
  	}
  		  	
  }
  
  public static boolean mainMenu(String menuChoice, Job_17812476[] dailyJobsArray, Customer_17812476 customerArray[], 
  		Vehicle_17812476 vehiclesArray[], Service_17812476 servicesArray[], File dailyJobsInput, boolean menuRunning, Customer_17812476[] customersArray) throws IOException {
  	
  	//Switch case handles the argument choice and follows appropriate action for each option
  		switch(menuChoice) {
  		
    		case "1": {
    			displayJobs(dailyJobsArray);	//Method for displaying the jobs for a selected day
    			System.out.println("=======   DISPLAY JOBS SUB-MENU    =======\n"
    					+ "Please enter a task number (1-4) from the list below: \n"
    		  		+ "  1: Display Job Detail \n"
    		  		+ "  2: Set Fee \n"
    		  		+ "  3: Change Day of Week \n"
    		  		+ "  4: Exit Sub-menu");	
    			
    			Scanner kboard = new Scanner(System.in);
    			menuChoice = kboard.nextLine();
    			
    			//Passes the chosen menu number to the displayJobsSubMenu method
    			displayJobsSubMenu(menuChoice, dailyJobsArray, customerArray, vehiclesArray, servicesArray);
    			break;    			
    		}    		

    		case "2": {
    			System.out.println("=======   MAKE BOOKING SUB-MENU    =======\n"
    					+ "Please enter a task number (1-3) from the list below: \n"
    		  		+ "  1: Book By Registration Number \n"
    		  		+ "  2: Book By Customer \n"
    		  		+ "  3: Exit Sub-menu");	
    			
    			Scanner kboard = new Scanner(System.in);
    			menuChoice = kboard.nextLine();
    			
    			//Passes the chosen menu number to the makeBookingsSubMenu method
    			makeBookingsSubMenu(menuChoice, dailyJobsArray, customerArray, vehiclesArray, servicesArray, dailyJobsInput, customersArray);
    			break;
      		}	    		
    			
    		case "3": {
    			//Opens a new file object to sequentially write lines to
    			FileWriter fw = new FileWriter("DailyJobs.txt", true);	
    			PrintWriter DailyJobs = new PrintWriter(fw);
    			
    			//For each iteration, prints out all the job details, separated appropriately by commas.
    			for(int i = 0; i < dailyJobsArray.length; i++){
    				DailyJobs.print(dailyJobsArray[i].getJobID() + "," + dailyJobsArray[i].getCustomerID() + ","
    						+ dailyJobsArray[i].getRegistration() + "," + dailyJobsArray[i].getDate() + "," +
    						dailyJobsArray[i].getDay() + "," + dailyJobsArray[i].getTotalFee() + ",");
    				
    				//A sub-for loop to display all the service codes in the array field
    				for(int x = 0; x < dailyJobsArray[i].getServiceCodeSize(); x++){
    					DailyJobs.print(dailyJobsArray[i].getServiceCode(x));
    					if(dailyJobsArray[i].getServiceCodeSize() != x + 1){
    						DailyJobs.print(",");
    					}
    				}
    				
    				DailyJobs.println();
    			}
    			DailyJobs.close();
    			break;
    		}	
    			
    		case "4": {
    			menuRunning = false;	//Terminates menu
    			break;
    		}	
    		  			
  		}
			return menuRunning;		  		
  }
  
  public static void displayJobsSubMenu(String menuChoice, Job_17812476[] dailyJobsArray, Customer_17812476 customerArray[], 
  		Vehicle_17812476 vehiclesArray[], Service_17812476 servicesArray[]) {
  	
		switch(menuChoice) {
		
  		case "1": {
  			//Lets users look for a chosen Job ID
  			System.out.println("Please input the desired Job ID:");	
  			Scanner kboard = new Scanner(System.in);
  			int jobIDChoice = kboard.nextInt();
  			
  			//The chosen JobID gets passed to the displayJobDetail method
  			displayJobDetail(jobIDChoice, dailyJobsArray, customerArray, vehiclesArray, servicesArray);
  			break;
  			
  		}
  			
  		case "2": {
  			//For a select job, allows you to set the total fee
  			System.out.println("Please input the desired Job ID:");	
  			Scanner kboard = new Scanner(System.in);
  			int jobIDChoice = kboard.nextInt();
  			
  			//The chosen JobID gets passed to the setFee method
  			setFee(jobIDChoice, dailyJobsArray, servicesArray);
  			break;
  		}	
  			
  		case "3": {
  			displayJobs(dailyJobsArray);	//Reloops back to beginning to select day again
  			break;
  		}	
  			
  		case "4": {
  			break;	//Simply terminates the current menu structure
  		}	
  		  			
		}		
		
}
  
  public static void makeBookingsSubMenu(String menuChoice, Job_17812476[] dailyJobsArray, Customer_17812476 customerArray[], 
  		Vehicle_17812476 vehiclesArray[], Service_17812476 servicesArray[], File dailyJobsInput, Customer_17812476[] customersArray) {
  	
  	int additionalJobs = 0;	//Keep track of how many additional jobs have been added to the program
		Job_17812476[] dailyJobsArrayUpdated = new Job_17812476[10];	//Declaring a new array to store jobs in
		
  
			switch(menuChoice) {  	
    		
    		case "1": {
    			//Performs the booking task via Rego #, returns the string of all the data to be passed to the constructor to make the new job
    			String completedJobString = bookViaRegistration(vehiclesArray, dailyJobsArray, dailyJobsInput, additionalJobs, servicesArray, dailyJobsArrayUpdated);
    			dailyJobsArrayUpdated[additionalJobs] = new Job_17812476(completedJobString);	//String passed to constructor	
    	  	additionalJobs++;
    			break;
    			
    		}
    			
    		case "2": {
    			//Performs the booking task via Customer, returns the string of all the data to be passed to the constructor to make the new job
    			String completedJobString = bookViaCustomer(vehiclesArray, dailyJobsArray, dailyJobsInput, additionalJobs, servicesArray, dailyJobsArrayUpdated, customersArray);
    			dailyJobsArrayUpdated[additionalJobs] = new Job_17812476(completedJobString);	//String passed to constructor	
    	  	additionalJobs++;
    			break;
    		}	
    			
    		case "3": {
    			break; //Simply ends current menu structure
    		}	
    		  			
    	}  
			
			//As long as the menu isn't terminated by choosing 3, keeps the user in the sub-menu
			if(!menuChoice.equals("3")){
   			System.out.println("=======   MAKE BOOKING SUB-MENU    =======\n"
  					+ "Please enter a task number (1-3) from the list below: \n"
  		  		+ "  1: Book By Registration Number \n"
  		  		+ "  2: Book By Customer \n"
  		  		+ "  3: Exit Sub-menu");	
			Scanner kboard = new Scanner(System.in);
			menuChoice = kboard.nextLine();
			
			//Reloops onto the same menu to keep it going
			makeBookingsSubMenu(menuChoice, dailyJobsArray, customerArray, vehiclesArray, servicesArray, dailyJobsInput, customersArray);
			}
  	
  }
  
  public static String bookViaCustomer(Vehicle_17812476 vehiclesArray[], Job_17812476[] dailyJobsArray, 
  		File dailyJobsInput, int additionalJobs, Service_17812476 servicesArray[], Job_17812476[] dailyJobsArrayUpdated, 
  		Customer_17812476[] customersArray) {
  	String selectedDay = "Monday";		//Jobs automatically are assigned Monday unless specified, due to being least busiest day
  	String userInputCustomerName = "absent";	//To avoid nullpointers
  	String userInputCustomerVehicle = "absent";
  	String completedJobString = "";	//The string to be sent to the constructor to make a new object
  	boolean conditionsMet = false;
  	int dayCount = 0;
  	int customerID = 0;
  	
  	System.out.println("Please enter the customers last name you want to search for: ");
  	Scanner kboard = new Scanner(System.in);
	  userInputCustomerName = kboard.nextLine();
	  int x = 0; //Counts if there are multiple customers with the same name
	  	//For loop returns the details of people with the chosen surname
      for(int a = 0; a < customersArray.length; a++){
      	if(userInputCustomerName.equalsIgnoreCase(customersArray[a].getSurname())){
      		x++;
      		System.out.println("Surname: " + customersArray[a].getSurname() + " Firstname: " + customersArray[a].getFirstName());
      	}      
      }
      
      //If more than one person has same last name, gets user to choose customer based off first name
      if( x >= 2){
      System.out.println("Please enter the first name of the customer you wish to select: ");
  	  userInputCustomerName = kboard.nextLine();
      }
      
      String selectedCustomer = userInputCustomerName;
      
      //Get the desired day off the user, only breaks the loop if there is <12 jobs on the day
      while(conditionsMet == false){
        selectedDay = getDayFromUser("Please enter the number (1-5) of the day you would like to make a booking for: \n"); //Method for day
        for(int y = 0; y < dailyJobsArray.length; y++){
    			if(selectedDay.equals(dailyJobsArray[y].getDay())){
    				dayCount++;      				
    			}	  
        }
        if(dayCount < 12)
					conditionsMet = true;
				else
					System.out.println("There are no more bookings available, please choose another day.");
      }

      //Get the customer ID of the chosen person
  	  for(int i = 0; i < dailyJobsArray.length; i++){
  	  	if(selectedCustomer.equals(customersArray[i].getSurname()) || selectedCustomer.equals(customersArray[i].getFirstName())){
  	  		customerID = customersArray[i].getCustomerID();
  	  	}
  	  }
  	  
  	  //Displays the owner ID and how many vehicles they own
  	  int z = 0;	//To check if the user has multiple vehicles
  	  for(int i = 0; i < vehiclesArray.length; i++){
  	  	if(customerID == vehiclesArray[i].getOwner()){
  	  		z++;
  	  		System.out.println("Owner ID: " + customerID + " Registration: " + vehiclesArray[i].getRegistration());
  	  	}
  	  }
  	  
  	  //Lets the user choose what vehicle they want to make a booking for
      System.out.println("Please enter the registration of the vehicle you want to make a booking for: ");
  	  userInputCustomerVehicle = kboard.nextLine();        
      String selectedVehicle = userInputCustomerVehicle;
      
      //Build a string value to be passed to the constructor to make a new object
      completedJobString = buildAlternateJobString(userInputCustomerVehicle, dailyJobsArray, dailyJobsArrayUpdated, selectedDay, servicesArray);

  	return(completedJobString);
	  	  
  }
  
  public static String buildAlternateJobString(String userInputVehicleRegistration, Job_17812476[] dailyJobsArray, 
  		Job_17812476[] dailyJobsArrayUpdated, String userInputDay, Service_17812476 servicesArray[] ){
  	
  	Scanner kboard = new Scanner(System.in);  	
  	String finalJob = null;
  	
  	//Variables to be concatenated into one string to be passed into constructor
 	  String jobID;	
 	  String customerID;
 	  String registration;
 	  String date = null;
 	  String day;
 	  String totalFee;
 	  String serviceCode;
 	  
 	  //Gets all the missing details from the user to put them all together, to make a new object out of
 	  for(int i = 0; i < dailyJobsArray.length; i++){
 	  	if(userInputVehicleRegistration.equals(dailyJobsArray[i].getRegistration())){
 	  		jobID =  Integer.toString(dailyJobsArray[i].getJobID());
 	  		customerID =  Integer.toString(dailyJobsArray[i].getCustomerID());
 	  		registration = userInputVehicleRegistration;
 	  		
 	  		//Assigns the proper date to the date field based off the users chosen day
 	  		if(userInputDay.equals("Monday"))
 	  			date = "10/11/2014";
 	  			else if(userInputDay.equals("Tuesday"))
 	  				date = "11/11/2014";
 	  			else if(userInputDay.equals("Wednesday"))
 	  				date = "12/11/2014";
 	  			else if(userInputDay.equals("Thursday"))
 	  				date = "13/11/2014";
 	  			else if(userInputDay.equals("Friday"))
 	  				date = "14/11/2014";
 	  		
 	  		day = userInputDay;
 	  		totalFee = Double.toString(dailyJobsArray[i].getTotalFee());
 	  		
 	  		//Concatenates portion of string
 	  		finalJob = jobID + "," + customerID + "," + registration + "," + date + "," + day + "," + totalFee + ",";
 	  		 	
 	  		//Asks user how many services to be performed on vehicle, keeps it within a reasonable range
 	  		System.out.println("How many services would you like to perform on this job?");
 	  		int numberOfServices = kboard.nextInt();
 	  		while(numberOfServices < 1 || numberOfServices > 6){
   	 	  	System.out.println("Please enter a reasonable number (1-6) of services for the day:");
   	 	  	numberOfServices = kboard.nextInt();
   	 	  }
 	 	  
 	  		//For the amount of services required, displays the list of available services and lets the user input which ones they desire
 	  		for(int x = 0; x < numberOfServices; x++){
 	  			System.out.println("Please enter the next service you would like to select (input 1-14): ");
 	  			serviceCode = getServiceChoiceFromUser(servicesArray, x);
 	  			
 	  			//Concatenates job services onto the end of the line
 	  			finalJob = finalJob + serviceCode;
 	  			if(x+1 != numberOfServices)
 	  				finalJob = finalJob + ",";
 	  		}
 	  		 	  		
 	  	}
 	  		
 	  }
 	  System.out.println("Job added: " + finalJob); //Shows the user the job that got added to the system
  	return finalJob;
  }
  
  public static String bookViaRegistration(Vehicle_17812476 vehiclesArray[], Job_17812476[] dailyJobsArray, 
  		File dailyJobsInput, int additionalJobs, Service_17812476 servicesArray[], Job_17812476[] dailyJobsArrayUpdated) {
  	String selectedDay = "Monday";		//Jobs automatically are assigned Monday unless specified, due to being least busiest day
  	String completedJobString;
  	boolean conditionsMet = false;
  	boolean vehicleFound = false;			//Makes sure vehicle exists in system
  	String userInputVehicleRegistration = "absent";
  	
  	System.out.println("Please enter the vehicle registration you want to make a booking for: ");
  	Scanner kboard = new Scanner(System.in);
	  userInputVehicleRegistration = kboard.nextLine();
	  
	  //Ensures a vehicle is found before moving on
	  while(vehicleFound = false){	  	
	  	System.out.println("Please enter the vehicle registration you want to make a booking for: ");
		  userInputVehicleRegistration = kboard.nextLine();
		  
		  //Searches array for vehicle, if found loop breaks
      for(int a = 0; a < vehiclesArray.length; a++){
      	if(userInputVehicleRegistration.equalsIgnoreCase(vehiclesArray[a].getRegistration())){
      		vehicleFound = true;
      	}
      }
	  }				
	  
	  //Block statement makes user choose a day until a valid one occurs
	  while(conditionsMet == false){
	  	int dayCount = 0;
      for(int i = 0; i < vehiclesArray.length; i++){
      	if(userInputVehicleRegistration.equalsIgnoreCase(vehiclesArray[i].getRegistration())){
      		selectedDay = getDayFromUser("Please enter the number (1-5) of the day you would like to make a booking for: \n");
      		for(int x = 0; x < dailyJobsArray.length; x++){
      			if(selectedDay.equals(dailyJobsArray[x].getDay())){
      				dayCount++;      				
      			}	  				
      		}
      		if(dayCount < 12)
  					conditionsMet = true;
  				else
  					System.out.println("There are no more bookings available, please choose another day.");
      	}
      }
	  }
	  
	  //String created for passing to constructor later on
  	completedJobString = buildJobString(userInputVehicleRegistration, dailyJobsArray, dailyJobsArrayUpdated, selectedDay, servicesArray);

  	return(completedJobString);	  	  
  }
  
  public static String buildJobString(String userInputVehicleRegistration, Job_17812476[] dailyJobsArray, 
  		Job_17812476[] dailyJobsArrayUpdated, String userInputDay, Service_17812476 servicesArray[] ){
  	
  	//Method is near identical to buildAlternateJobString, I left it too late to have time to condense the methods
  	
  	Scanner kboard = new Scanner(System.in);  	
  	String finalJob = null;
  	
 	  String jobID;
 	  String customerID;
 	  String registration;
 	  String date = null;
 	  String day;
 	  String totalFee;
 	  String serviceCode;
 	  
 	  for(int i = 0; i < dailyJobsArray.length; i++){
 	  	if(userInputVehicleRegistration.equals(dailyJobsArray[i].getRegistration())){
 	  		jobID =  Integer.toString(dailyJobsArray[i].getJobID());
 	  		customerID =  Integer.toString(dailyJobsArray[i].getCustomerID());
 	  		registration = userInputVehicleRegistration;
 	  		
 	  		if(userInputDay.equals("Monday"))
 	  			date = "10/11/2014";
 	  			else if(userInputDay.equals("Tuesday"))
 	  				date = "11/11/2014";
 	  			else if(userInputDay.equals("Wednesday"))
 	  				date = "12/11/2014";
 	  			else if(userInputDay.equals("Thursday"))
 	  				date = "13/11/2014";
 	  			else if(userInputDay.equals("Friday"))
 	  				date = "14/11/2014";
 	  		
 	  		day = userInputDay;
 	  		totalFee = Double.toString(dailyJobsArray[i].getTotalFee());
 	  		
 	  		finalJob = jobID + "," + customerID + "," + registration + "," + date + "," + day + "," + totalFee + ",";
 	  		 	
 	  		System.out.println("How many services would you like to perform on this job?");
 	  		int numberOfServices = kboard.nextInt();
 	  		while(numberOfServices < 1 || numberOfServices > 6){
   	 	  	System.out.println("Please enter a reasonable number (1-6) of services for the day:");
   	 	  	numberOfServices = kboard.nextInt();
   	 	  }
 	 	  
 	  		for(int x = 0; x < numberOfServices; x++){
 	  			System.out.println("Please enter the next service you would like to select (input 1-14): ");
 	  			serviceCode = getServiceChoiceFromUser(servicesArray, x);
 	  			finalJob = finalJob + serviceCode;
 	  			if(x+1 != numberOfServices)
 	  				finalJob = finalJob + ",";
 	  		}
 	  		 	  		
 	  	}
 	  		
 	  }
 	  System.out.println("Job added: " + finalJob);
  	return finalJob;
  }
  
  public static String getServiceChoiceFromUser(Service_17812476 servicesArray[], int x){
  	String userServiceChoice;
  	
  	if(x == 0){
    	System.out.println("Please choose a number (1-14) from the list of services below: ");
    	for(int i = 0; i < servicesArray.length; i++){
    		System.out.println(i + 1 + ": Service code " + servicesArray[i].getServiceCode() + ": " + servicesArray[i].getDescription());
    	}
  	}
  	Scanner kboard = new Scanner(System.in);
	  userServiceChoice = Integer.toString(kboard.nextInt());//
	  userServiceChoice = serviceCodeConversion(userServiceChoice);
		return userServiceChoice;
  	
  }
  
  public static String serviceCodeConversion(String userSpecification){
  	String serviceCode = "0";

  	//Converts the menu choice into the desired Service code requested
	  if(userSpecification.equals("1"))
	  	serviceCode = "1197";
	  	else if (userSpecification.equals("2"))
	  		serviceCode = "1200";
	  	else if (userSpecification.equals("3"))
	  		serviceCode = "1201";
	  	else if (userSpecification.equals("4"))
	  		serviceCode = "1202";
	  	else if (userSpecification.equals("5"))
	  		serviceCode = "1203";
	  	else if (userSpecification.equals("6"))
	  		serviceCode = "1204";
	  	else if (userSpecification.equals("7"))
	  		serviceCode = "1205";
	  	else if (userSpecification.equals("8"))
	  		serviceCode = "1206";
	  	else if (userSpecification.equals("9"))
	  		serviceCode = "1207";
	  	else if (userSpecification.equals("10"))
	  		serviceCode = "1208";
	  	else if (userSpecification.equals("11"))
	  		serviceCode = "1209";
	  	else if (userSpecification.equals("12"))
	  		serviceCode = "1210";
	  	else if (userSpecification.equals("13"))
	  		serviceCode = "1211";
	  	else if (userSpecification.equals("14"))
	  		serviceCode = "1220";

  	return serviceCode;
  }
    
  public static String getDayFromUser(String userSpecification){
  	//Allows user to choose the day based off inputting a number
  	String day = null;
  	
  	System.out.println(userSpecification
	  		+ "1: Monday \n"
	  		+ "2: Tuesday \n"
	  		+ "3: Wednesday \n"
	  		+ "4: Thursday \n"
	  		+ "5: Friday");	
  	
  	Scanner kboard = new Scanner(System.in);
	  int userInput = kboard.nextInt();
	  if(userInput == 1)
	  	day = "Monday";
	  	else if (userInput == 2)
	  		day = "Tuesday";
	  	else if (userInput == 3)
	  		day = "Wednesday";
	  	else if (userInput == 4)
	  		day = "Thursday";
	  	else if (userInput == 5)
	  		day = "Friday";

  	return day;
  }
  
  public static void displayJobs(Job_17812476 dailyJobsArray[]) {
  	//Gets day from user than displays all related jobs to that day
  	String day = getDayFromUser("Please enter the number (1-5) of the day you would like to view the jobs for: \n");
	  	
	  System.out.println("Job ID : Customer ID : Vehicle Registration : Day : Total Fee : Service Code(s)");
		for (int i = 0; i < dailyJobsArray.length; i++){
			
			//Searches array and displays details corresponding to the jobID
			if(day.equals(dailyJobsArray[i].getDay())){
			System.out.print(dailyJobsArray[i].getJobID() + " : " + dailyJobsArray[i].getCustomerID() + " : " + dailyJobsArray[i].getRegistration() 
					 + " : " + dailyJobsArray[i].getDay() + " : " + dailyJobsArray[i].getTotalFee() + " : ");
  			
			for(int j = 0; j < dailyJobsArray[i].getServiceCodeSize(); j++){
  				System.out.print(dailyJobsArray[i].getServiceCode(j));
  				
  				if(j + 1 < dailyJobsArray[i].getServiceCodeSize())
  					System.out.print(", ");  				
  			}			
  			System.out.println();  			
			}		
			
		}
		
	}
  
  public static void displayJobDetail(int jobIDChoice, Job_17812476 dailyJobsArray[], Customer_17812476 customerArray[], 
  		Vehicle_17812476 vehiclesArray[], Service_17812476 servicesArray[]) {
  	//This method brings together related details that are spanned across all the classes
  	
  	//The main loop that everything else is based off, because Customer ID relates to everything
  	for(int i=0; i < dailyJobsArray.length; i++){
  		if(jobIDChoice == dailyJobsArray[i].getJobID()){
  			System.out.println("Job ID: " + dailyJobsArray[i].getJobID() + "\n"
  					+ "Customer ID: " + dailyJobsArray[i].getCustomerID());
  			
  	  	for(int x = 0; x < customerArray.length; x++){
  	  		if(dailyJobsArray[i].getCustomerID() == customerArray[x].getCustomerID()){
  	  			System.out.println("Customer Surname: " + customerArray[x].getSurname() + "\n"
  	  					+ "Customer Address: " + customerArray[x].getAddress());
  	  		}
  	  	}
  	  	
  	  	for(int x = 0; x < vehiclesArray.length; x++){
  	  		if(dailyJobsArray[i].getCustomerID() == vehiclesArray[x].getOwner()){
  	  			System.out.println("Vehicle Registration: " + vehiclesArray[x].getRegistration() + "\n"
  	  					+ "Vehicle Make: " + vehiclesArray[x].getMake() + "\n"
  							+ "Vehicle Model: " + vehiclesArray[x].getModel() + "\n"
  							+ "Vehicle Year:  " + vehiclesArray[x].getYear());
  	  			x += 100;
  	  		}
  	  	}
  	  	for(int x = 0; x < dailyJobsArray[i].getServiceCodeSize(); x++){
  	  		System.out.print("Service Code, Name and Price: " + dailyJobsArray[i].getServiceCode(x));
  	  		for(int y = 0; y < servicesArray.length; y++){
  	  			
  	  			if(dailyJobsArray[i].getServiceCode(x) == servicesArray[y].getServiceCode()){
    	  			System.out.print(", " + servicesArray[y].getName()
    	  					+ ", " + servicesArray[y].getPrice() + "\n");
  	  			}  	  		
  	  		}
  	  	}  	  	
  	  	
  	  	System.out.println("Day: " + dailyJobsArray[i].getDay());
  	  	System.out.println("Total Fee: " + dailyJobsArray[i].getTotalFee());
  	  	
  		}
  	}  	
  }
  
  public static void setFee(int jobIDChoice, Job_17812476 dailyJobsArray[], Service_17812476 servicesArray[]) {
  	//Allows user to set the fee for a chosen job
  	double totalPrice = 0.0;
  	double lowestPrice = 0.0;
  	
  	//For the main array, if the job ID matches
  	for(int i = 0; i < dailyJobsArray.length; i++){													//~For the entire array,
  		if(jobIDChoice == dailyJobsArray[i].getJobID()){											//~if jobID matches inputed jobID, 
  			for(int x = 0; x < dailyJobsArray[i].getServiceCodeSize(); x++){		//~looks at the service codes array field within the job
  				for(int y = 0; y < servicesArray.length; y++)											//~runs the loop for each service code
  					if(dailyJobsArray[i].getServiceCode(x) == servicesArray[y].getServiceCode()){		//~crosschecks service code to servicearray to get price
  						totalPrice += servicesArray[y].getPrice();										//~adds price to running total.
  					}
  			}  			
  			
    		lowestPrice = totalPrice - 0.2 * totalPrice; //Calculates lowest possible price of job
    		System.out.println("Please input the desired fee for this job: ");  		
    		Scanner kboard = new Scanner(System.in);    		
  		  double userInput = kboard.nextDouble();
  		  
  		  //Ensures that the fee can only be set within a certain range
  		  while(userInput < lowestPrice){
  		  	System.out.println("The value must be atleast greater than: " + lowestPrice);
  		  	userInput = kboard.nextDouble();
  		  }
  		  dailyJobsArray[i].setTotalFee(userInput);   			
  		}  			
  	}
  }
  
  public static int arraySizeCalculation(Scanner fileInput) {
  	int x = 0;
		while(fileInput.hasNext()){
			fileInput.nextLine();
			x++;
		}	
		return x;
  }
  
  public static File verifyExistence(File Input, String fileName) {
  	//Verifies if the files exists, if not gets the user to locate where it is
  	if(Input.exists() == false) {
			System.out.println("System could not locate the file: " + fileName +". Did you want to attempt to locate it? Y=Yes, N=Terminate.");

			Scanner kboard = new Scanner(System.in);
			String userInput = kboard.nextLine();
			if(userInput.equalsIgnoreCase("Y")){
				while(Input.exists() == false){
				System.out.println("Please input the file path of " + fileName + ".");	
				userInput = kboard.nextLine();
				Input = new File(userInput);
				}
			}
			else if(!userInput.equalsIgnoreCase("Y"));
			//menuRun = false;  Ran out of time to implement
		}
    return Input;
  }

}
