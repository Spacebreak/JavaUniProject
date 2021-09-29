import java.util.StringTokenizer;

public class Customer_17812476 {

  private int customerID;
  private String surname;
  private String firstname;
  private String address;
  private String suburb;
  private int postcode;
    	
  // The constructor accepts a string argument that is tokenized into the various fields
  public Customer_17812476(String customerDetails) {
  	StringTokenizer tokenizedCustomerDetails = new StringTokenizer(customerDetails, ",");
  	customerID = Integer.parseInt(tokenizedCustomerDetails.nextToken());
  	surname = tokenizedCustomerDetails.nextToken();
	  firstname = tokenizedCustomerDetails.nextToken();
    address = tokenizedCustomerDetails.nextToken();
    suburb = tokenizedCustomerDetails.nextToken();
    postcode = Integer.parseInt(tokenizedCustomerDetails.nextToken());    
  }

	public void setCustomerID(int inputCustomerID) {
  	customerID = inputCustomerID;
  }
  
	public int getCustomerID() {
    return customerID;
  }	
	
  public void setSurname(String inputLastName) {
  	surname = inputLastName;
  }
  
  public String getSurname() {
    return surname;
  }
  
  public void setFirstName(String inputFirstName) {
  	firstname = inputFirstName;
  }
  
	public String getFirstName() {
    return firstname;
  }
  
  public void setAddress(String inputAddress) {
  	address = inputAddress;
  }
  
	public String getAddress() {
    return address;
  }
  
  public void setSuburb(String inputSuburb) {
  	suburb = inputSuburb;
  }
  
	public String getSuburb() {
    return suburb;
  }
  
  public void setPostcode(int inputPostcode) {
  	postcode = inputPostcode;
  }
    	
  public int getPostcode() {
    return postcode;
  }
  
}
