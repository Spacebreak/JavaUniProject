import java.util.StringTokenizer;

public class Job_17812476 {

  private int jobID;             // unique job identification number
  private int customerID;        // unique customer identification number
  private String registration;   // registration number for vehicle for this job
  private int[] serviceCode;     // the service codes to be carried out on the vehicle for the job
  private double totalFee;       // total price for the Job
  private String date;           // when the job is carried out by mechanic
  private String day;            // day of the week that job is booked for
  
  private int serviceCodeSize; 	 // holds how many values are stored in the serviceCode array, needed for access logic in main
  
  //Tried to make a copy constructor, failed miserably.
  public Job_17812476(Job_17812476 object){
  	jobID = object.jobID;
  	customerID = object.customerID;
  	registration = object.registration;
  	totalFee = object.totalFee;  	
  	date = object.date;
  	day =  object.day;  	  	
  	serviceCodeSize = object.serviceCodeSize;
  	
  	for(int i = 0; i < serviceCodeSize; i++)
			serviceCode[i] = object.serviceCode[i];
  }
  
  //The constructor accepts a string argument that is tokenized into the various fields
  public Job_17812476(String dailyJobDetails) {
  	StringTokenizer tokenizedJobDetails = new StringTokenizer(dailyJobDetails, ",");
  	jobID = Integer.parseInt(tokenizedJobDetails.nextToken());
  	customerID = Integer.parseInt(tokenizedJobDetails.nextToken());
  	registration = tokenizedJobDetails.nextToken();
  	date =  tokenizedJobDetails.nextToken();
  	day =  tokenizedJobDetails.nextToken();  	
  	totalFee = Double.parseDouble(tokenizedJobDetails.nextToken());  	
  	
  	//Calculate required size of array and fill it with remaining tokens.
  	serviceCodeSize = tokenizedJobDetails.countTokens();  	
		serviceCode = new int[serviceCodeSize];
		for(int i = 0; i < serviceCodeSize; i++)
			serviceCode[i] = Integer.parseInt(tokenizedJobDetails.nextToken());
  }

  public void setJobID(int inputJobID) {
  	jobID = inputJobID;
  }
  
  public int getJobID() {
    return jobID;
  }
  
  public void setCustomerID(int inputCustomerID) {
  	customerID = inputCustomerID;
  }
  
  public int getCustomerID() {
    return customerID;
  }
  
  public void setRegistration(String inputRegistration) {
  	registration = inputRegistration;
  }
  
  public String getRegistration() {
    return registration;
  }
  
  public void setServiceCode(int inputServiceCode, int x) {
  	serviceCode[x] = inputServiceCode;
  }
  
  public int getServiceCode(int x) {
    return serviceCode[x];
  }
  
  public void setTotalFee(double inputTotalFee) {
  	totalFee = inputTotalFee;
  }
  
  public double getTotalFee() {
    return totalFee;
  }
  
  public void setDate(String inputDate) {
  	date = inputDate;
  }
  
  public String getDate() {
    return date;
  }
  
  public void setDay(String inputDay) {
  	day = inputDay;
  }
  
  public String getDay() {
    return day;
  }
  
  public void setServiceCodeSize(int inputServiceCodeSize) {
    serviceCodeSize = inputServiceCodeSize;
  }
  
  public int getServiceCodeSize() {
    return serviceCodeSize;
  }
    
}
