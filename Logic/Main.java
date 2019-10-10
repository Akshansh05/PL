import java.util.*;
import java.io.*;
import java.lang.*;
//Main Driver Class
public class Main{

 //main calling function   
 public static void main(String[] args) {

    InputParser inputParser = new InputParser();

    switch (args.length) {
        case 0:
          System.out.println("Please enter 'exit' to quit");
          System.out.println("Waiting for input...");

          //infinite calls until exit
          for(;;){
            try {
                BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                        String inputString = bufferRead.readLine();
                        if (inputString.equalsIgnoreCase("exit")) {
                            break;
                        }else if(inputString.isEmpty() || (inputString == null)){

                        }else{
                            inputParser.parseTextInput(inputString.trim());
                        }
            } catch (Exception e) {
                System.out.println("Oops! Error in reading the input from console.");
                 e.printStackTrace();
            }
           }
            break;
        case 1:
          inputParser.parseFileInput(args[0]); 
            break;
        default:
          System.out.println("Invalid input.");
            break;
    }

}

}