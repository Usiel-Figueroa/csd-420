// Usiel Figueroa
// May 04, 2025
// CSD420-A311 Advanced Java Programming
// M11 Programming Assignment: JAVA JSON API - GSON
// In this example found, we've created a Student class. We'll create a JSON string with student details and deserialize it to student object and then serialize it to an JSON String.

/**
References 
TutorialsPoint. (n.d.). Gson – Quick guide. Retrieved May 4, 2025, from https://www.tutorialspoint.com/gson/gson_quick_guide.htm
 */





import com.google.gson.Gson; 
import com.google.gson.GsonBuilder;  

public class GsonTester { 
   public static void main(String[] args) { 
      String jsonString = "{\"name\":\"Mahesh\", \"age\":21}"; 

      GsonBuilder builder = new GsonBuilder(); 
      builder.setPrettyPrinting(); 

      Gson gson = builder.create(); 
      Student student = gson.fromJson(jsonString, Student.class); 
      System.out.println(student);    

      jsonString = gson.toJson(student); 
      System.out.println(jsonString);  
   } 
} 

class Student { 
   private String name; 
   private int age; 
   public Student(){} 

   public String getName() { 
      return name; 
   }

   public void setName(String name) { 
      this.name = name; 
   } 

   public int getAge() { 
      return age; 
   }

   public void setAge(int age) { 
      this.age = age; 
   }

   public String toString() { 
      return "Student [ name: "+name+", age: "+ age+ " ]"; 
   }  
}