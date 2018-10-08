import java.util.Scanner;

public class ForgetfulNote {
  public static void main( String[] args ){
    Scanner keyboard = new Scanner(System.in);
    
    System.out.println( "Tell me who you are. ( Please type your name.)" );
    keyboard.next();
    
    System.out.println( "What is 6 multiplied by 7?" );
    keyboard.nextInt();
    
    System.out.println( Enter a number between 0.0 and 1.0." );
    keyboard.nextDouble();
    
    System.out.println( "Is there anything else we should add?" );
    keyboard.next();
  }
}

//next time gotta have somewhere to stuff all this input.
