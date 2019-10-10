import java.util.*;
import java.io.*;
import java.lang.*;
//Input Parser Class
public  class InputParser{
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
                    String value = commands.getCommand(inputString);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
                case 2:
                try {
                    String value = commands.getCommand(inputs[0],inputs[1]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
                case 3:
                try {
                    String value = commands.getCommand(inputs[0],inputs[1],inputs[2]);
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