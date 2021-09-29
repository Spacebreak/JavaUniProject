import java.util.StringTokenizer;

public class Vehicle_17812476 {

  private String registration;    //registration number for vehicle
  private String make;
  private String model;
  private int year;               //year of manufacture
  private int odometer;           //current odometer reading in km
  private int owner;              //vehicle owners identification number
  private int[] jobs;             //which Jobs have been carried out on this vehicle.
  
  //The constructor accepts a string argument that is tokenized into the various fields
  public Vehicle_17812476(String vehicleDetails) {
  	StringTokenizer tokenizedVehicleDetails = new StringTokenizer(vehicleDetails, ",");
  	registration = tokenizedVehicleDetails.nextToken();
  	make = tokenizedVehicleDetails.nextToken();
  	model = tokenizedVehicleDetails.nextToken();
  	year = Integer.parseInt(tokenizedVehicleDetails.nextToken());
  	odometer = Integer.parseInt(tokenizedVehicleDetails.nextToken());
  	owner = Integer.parseInt(tokenizedVehicleDetails.nextToken());
  	
  	//Because there is an array inside of an array need to use a for loop to process multiple tokens into one array variable
  	int x = 0;
		x  = tokenizedVehicleDetails.countTokens();	//Counts remaining tokens after the 6 other fields, these are the service codes
		jobs = new int[x];
		for(int i = 0; i < x; i++)
			jobs[i] = Integer.parseInt(tokenizedVehicleDetails.nextToken());
  }
  
  public void setRegistration(String inputRegistration) {
  	registration = inputRegistration;

  }
  
  public String getRegistration() {
  	return registration;
  }
  
  public void setMake(String inputMake) {
  	make = inputMake;
  }
  
  public String getMake() {
    return make;
  }
  
  public void setModel(String inputModel) {
  	model = inputModel;
  }
  
  public String getModel() {
    return model;
  }
  
  public void setYear(int inputYear) {
  	year = inputYear;
  }
  
  public int getYear() {
    return year;
  }
  
  public void setOdometer(int inputOdometer) {
  	odometer = inputOdometer;
  }
  
  public int getOdometer() {
    return odometer;
  }
  
  public void setOwner(int inputOwner) {
  	owner = inputOwner;
  }
  
  public int getOwner() {
    return owner;
  }
  
  public void setJobs(int inputJobs, int x) {
  	jobs[x] = inputJobs;
  }
  
  public int getJobs(int x) {
    return jobs[x];
  }

}
