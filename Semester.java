 public enum Semester{
      SPRING("SP", "Spring"), SUMMER("SU", "Summer"), FALL("FA", "Fall"), DEFAULT("", "No data");
     
     private String semesterAbv;
     private String output;
     
     
     private Semester(String semesterAbv, String output){
       this.semesterAbv = semesterAbv;
       this.output = output;
     }
     
     public String getSemesterAbv(){
       return semesterAbv;
     }
     
     public String toString(){
      return output;
     }
   }
