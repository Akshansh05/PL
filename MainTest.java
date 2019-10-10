import java.util.*;
import java.io.*;
import java.lang.*;

public class MainTest extends Main{

    Commands commands = new Commands();

    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    public void cleanUpStreams() {
        System.setOut(null);
    }

    public void testcreateParkingLot(String size){
        commands.getCommand("create_parking_lot",size);

        if(outContent.toString().equals("Created a parking lot with "+size+" slots") || ( (Integer.parseInt(size)<0) && outContent.toString().equals("Invalid lot count"))){
            System.out.println("testcreateParkingLot passed");
        }    
    }
    public void testPark(String regNO, String colour){
        commands.getCommand("park",regNO,colour);
        
        
    }
    public static void main(String[] args)  {
        String size="3";
        MainTest test=new MainTest();
        test.testcreateParkingLot(size);

         size="-1";
        test.testcreateParkingLot(size);


        test.testPark("1234","blue");
    }
}