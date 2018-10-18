import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTester {
  public class static void main (String args [])/**shouldn't the array be b4 args?**/ {
    ObjectMapper mapper = new ObjectMapper();
    String jsonString = "{\"name\":\CommonName\", \"age\":42}";
    
    //map json to a class, in this case, "student"
    
    try {
      Student student = mapper.readValue(jsonString, Student.class); //potentially replace with util.scanner's keyboard.next ?
      
      System.out.println(jsonString);
      
      jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
      
      System.out.println(jsonString);
    }
    
    catch (JsonParseException e) { e.printStackTrace(); }
    catch (JsonMappingException e) { e.printStackTrace(); }
    catch (IOException e) { e.printStackTrace(); }
  }
}

class Student /** or whatnot... **/  {
  private String name;
  private int age;
  public Student(){}
  public String getName() {
    return name;
  }
  public void setName(String name){
    this.name = name;
  }
  public int getAge(){
    return age;
  }
  public void setAge(int age){
    this.age = age;
  }
  public String toString(){
    return "Student [ name: "+name+", age: "+age+ " ]";
  }
}
