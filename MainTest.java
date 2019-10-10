import java.util.*;
import java.io.*;
import java.lang.*;

public class MainTest extends Main{

    Commands commands = new Commands();
    Lot lot = new Lot();
    

    public void testcreateParkingLot(String size){
        String value = lot.createParkingLot(size);

        if(value.equals("Created a parking lot with "+size+" slots\n") || ( (Integer.parseInt(size)<0) && value.toString().equals("Invalid lot count\n"))){
            System.out.println("(test createParkingLot passed)");
            System.out.println();
        } else{
            System.out.println("(test createParkingLot not passed)");
            System.out.println();
        }   
    }
    public void testPark(String regNO, String colour){
        String value = lot.park(regNO,colour);
        if(lot.size == 0 && value.equals("Sorry, parking lot is not created\n")){
            System.out.println("(test park passed)");
            System.out.println();
        }else if(lot.slotCar.size() == lot.size && value.equals("Sorry, parking lot is full\n")){
            System.out.println("(test park passed)");
            System.out.println();
        }else if(lot.regNOSlot.containsKey(regNO) && value.equals("Sorry, car is already parked\n")){
            System.out.println("(test park passed)");
            System.out.println();
        }else if(value.equals("Allocated slot number: "+ lot.globalSlot+"\n")){
            System.out.println("(test park passed)");
            System.out.println();
        }else{
            System.out.println("(test park not passed)");
            System.out.println();
        }
              
    }
    public void testLeave(String slotNo){
       int  currenSize=lot.slotCar.size();
     boolean status = lot.slotCar.get(slotNo) != null ? true : false;
        String value=lot.leave(slotNo);
        if(lot.size == 0 && value.equals("Sorry, parking lot is not created\n")){
            System.out.println("(test leave passed)");
            System.out.println();
        }
        else if(Integer.parseInt(slotNo) > lot.size && value.equals("Slot Number is greater that Max size\n")){
            System.out.println("(test leave passed)");
            System.out.println();
        }else if(currenSize > 0 && (status == true) && value.equals("Slot number "+slotNo+" is free\n")){
            System.out.println("(test leave passed)");
            System.out.println();
        }else if(currenSize > 0 && (status == false) && (value.equals("No cars found at given slot\n") || value.equals("Slot number " + slotNo + " is already empty\n") )  ){
            System.out.println("(test leave passed)");
            System.out.println();
        }else{
            System.out.println("(test leave not passed)");
            System.out.println();
        }
    }

    public void testGetSlotNumberFromRegNo(String regNO){
        String value=lot.getSlotNumberFromRegNo(regNO);
        if(lot.size == 0 && value.equals("Sorry, parking lot is not created\n")){
            System.out.println("(test GetSlotNumberFromRegNo passed)");
            System.out.println();
        }else if((lot.regNOSlot.containsKey(regNO)) && (value.equals(lot.regNOSlot.get(regNO) + "\n"))){
            System.out.println("(test GetSlotNumberFromRegNo passed)");
            System.out.println();
        }else if(value.equals("Not found\n")){
            System.out.println("(test GetSlotNumberFromRegNo passed)");
            System.out.println();
        }else{
            System.out.println("(test GetSlotNumberFromRegNo  not passed)");
            System.out.println();
        }
    }
    public static void main(String[] args)  {
        MainTest test=new MainTest();
    
        String  size="3";
        //TC 1
        test.testPark("KA-01-HH-1234","White");
        //TC 2
        test.testcreateParkingLot(size);       
        //TC 3
        test.testPark("KA-01-HH-1234","White");
        //TC 4
        test.testPark("KA-01-HH-1234","White");
        //TC 5
        test.testGetSlotNumberFromRegNo("KA-01-HH-1234");
        //TC 6
        test.testGetSlotNumberFromRegNo("1234");
        //TC 7
        test.testLeave("5");
        //TC 8
        test.testPark("KA-01-HH-9999","blue");
        //TC 9
        test.testLeave("1");
        //TC 10
        test.testLeave("1");
        //Create more test cases to validate
    }
}