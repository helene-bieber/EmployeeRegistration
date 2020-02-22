import java.util.Comparator;

public class Person implements Comparable<Person>{ 
  
  private String name;   
  private String email;
  public static final String defaultData = "No data yet";

  private static int numPersons = 0; 
    
  public Person(String name, String email){
   this.name = name;
   this.email = email;
         Person.numPersons++;

  }
  
  public Person(String name){
    this(defaultData, name);
          Person.numPersons++;

  }
  
  public void setName(String name){
    this.name = name;    
  }
  
  public String getName(){
        return name;    
  }    
  
   public void setEmail(String email){
    this.email = email;    
  }
  
  public String getEmail(){
        return email;    
  }  
  
  public static int getNumberOfPersons() {
		return Person.numPersons;
	}
   
  public String toString(){
    String output = "Name: " + name + "\nEmail: " + email; 
    return output;
  }
  
  public boolean equals(Object obj){        
    if(obj instanceof Person){
       Person otherPerson = (Person) obj;
       
       String otherPersonName = otherPerson.name;
       String otherPersonEmail = otherPerson.email;
       
       if(name.equalsIgnoreCase(otherPersonName) && email.equalsIgnoreCase(otherPersonEmail)){
           return true;
       } else {
           return false;
       }
    } else{
       return false;
    }   
  }
  
  
   public int compareTo(Person p){
    if(getName().compareToIgnoreCase(p.getName())!=0){ 
			return getName().compareToIgnoreCase(p.getName()); 
	 } else { 
			return getEmail().compareToIgnoreCase(p.getEmail()); 
    }
  }

 
} 