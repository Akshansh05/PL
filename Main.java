import java.util.*;
import java.io.*;
import java.lang.*;
//Main Driver Class
public class Main{

    //Class for calling Method with given Input String
    public static class Commands{
             Lot lot = new Lot();
        //Make Method for no parameter
        public void getCommand(String commandString){
            if(commandString.equalsIgnoreCase("status")){                
                 lot.status();
            }
        }
         //Make Method for 1 parameter
        public void getCommand(String commandString,String para){
            if(commandString.equalsIgnoreCase("create_parking_lot")){
                 lot.createParkingLot(para);
            }
            if(commandString.equalsIgnoreCase("leave")){
                 lot.leave(para);
            }
            if(commandString.equalsIgnoreCase("registration_numbers_for_cars_with_colour")){
                 lot.getRegistrationNumbersFromColor(para);
            }
            if(commandString.equalsIgnoreCase("slot_numbers_for_cars_with_colour")){
                 lot.getSlotNumbersFromColor(para);
            }
            if(commandString.equalsIgnoreCase("slot_number_for_registration_number")){
                 lot.getSlotNumberFromRegNo(para);
            }
        }
        //Make Method for 2 parameters
        public void getCommand(String commandString,String para1,String para2){
             if(commandString.equalsIgnoreCase("park")){
                 lot.park(para1,para2);
             }
        }
    }


    //Input Parser Class
    public static class InputParser{
        Commands commands;
        Lot lot;
        public InputParser(){
            commands = new Commands();
            lot = new Lot();
        }

        //CLI arguments with method call
        public void parseTextInput(String inputString){

            String inputs[]=inputString.split(" ");
            switch (inputs.length) {
                case 1:
                    try {
                        commands.getCommand(inputString);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                    case 2:
                    try {
                         commands.getCommand(inputs[0],inputs[1]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                    case 3:
                    try {
                          commands.getCommand(inputs[0],inputs[1],inputs[2]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;      
            
                default:
                System.out.println("Invalid input.");
                    break;
            }
        }

        //Take Input From File
        public void parseFileInput(String filePath) {
            File inputFile = new File(filePath);
            try {
                BufferedReader br = new BufferedReader(new FileReader(inputFile));
                String line;
                try {
                    while ((line = br.readLine()) != null) {
                        parseTextInput(line.trim());
                    }
                } catch (IOException ex) {
                    System.out.println("Error in reading the input file.");
                    ex.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found in the path specified.");
                e.printStackTrace();
            }
        }
    }

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