import java.util.Scanner;

public class Interrogate {
  public static void main ( String[] args ) {
    String name;
    int age;
    double weight, income;
    
    Scanner keyboard = new Scanner(System.in);
    
    System.out.print( "Hello. Please enter a user name or handle." );
    name = keyboard.next();
    
    System.out.print( "Hi, " + name + "! How old are you? " );
    age = keyboard.nextInt();
    
    System.out.println( "So you're " + age + ", eh? That's not too terribly old." );
    System.out.print( "How much do you weigh, " + name + "? " );
    weight = keyboard.nextDouble();
    
    System.out.println( weight + "! Better keep that quiet!!" );
    System.out.print("Last Question, what is your income, " + name + "?" );
    income = keyboard.nextDouble();
    
    System.out.print( "Hopefully that's " + income + " per hour" );
    System.out.println( " and not per year!" );
    System.out.print( "Access granted, interrogation complete. There is cake in the next room, " );
    System.out.println( name + "." );
  }
}
