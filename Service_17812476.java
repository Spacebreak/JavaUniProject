import java.util.StringTokenizer;

public class Service_17812476 {

  private int serviceCode;     // unique identifier for Service
  private String name;         // name of service
  private String description;  // description of service
  private double price;        // normal price for service (before any discounts or surcharges)
  
//The constructor accepts a string argument that is tokenized into the various fields
  public Service_17812476(String servicesDetails) {
  	StringTokenizer tokenizedServiceDetails = new StringTokenizer(servicesDetails, ",");
  	serviceCode = Integer.parseInt(tokenizedServiceDetails.nextToken());
  	name = tokenizedServiceDetails.nextToken();
	  description = tokenizedServiceDetails.nextToken();
    price = Double.parseDouble(tokenizedServiceDetails.nextToken());
  }

  public void setServiceCode(int inputServiceCode) {
  	serviceCode = inputServiceCode;
  }
  
  public int getServiceCode() {
    return serviceCode;
  }
  
  public void setName(String inputName) {
  	name = inputName;
  }
  
  public String getName() {
    return name;
  }
    
  public void setDescription(String inputDescription) {
  	description = inputDescription;
  }
  
  public String getDescription() {
    return description;
  }
  
  public void setPrice(double inputPrice) {
  	price = inputPrice;
  }
  
  public double getPrice() {
    return price;
  }
  
}