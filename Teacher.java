import java.util.Scanner;

public class Teacher extends Person {

  private Semester semester;
   
   private String department;

   public Teacher(String name, String email, Semester semester){
      super(name, email);
      this.department = defaultData;
      this.semester = semester;
   }

   public Teacher(String name, String email, String department, Semester semester){
      super(name, email);
      this.department = department;
      this.semester = semester;
   }

   public void setDepartment(String department){
    this.department = department;    
  }
  
   public String getDepartment(){
    return department;    
  }    

       
  public String working(){
    if(semester == Semester.SPRING){
      return getName() + " is working this semester";
    }
    else{
      return getName()+" is working for " + semester.getSemesterAbv()+ " but not this semester";
    }
  }

  public String toString(){
    String output = super.toString();
    output += "\nDepartment: " + department  ;
    return output;   
    }
    
   public boolean equals(Object obj){        
     if(obj instanceof Teacher){
       Teacher otherTeacher = (Teacher) obj;
       return super.equals(obj) && department == otherTeacher.department;
     } else {
       return false;
     }
     
   }

}
