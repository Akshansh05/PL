import java.util.*;
import java.io.*;
import java.lang.*;
//Class for calling Method with given Input String
public  class Commands{
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