import java.util.*;
import java.io.*;
import java.lang.*;
//Class for calling Method with given Input String
public  class Commands{
    Lot lot = new Lot();
//Make Method for no parameter
String value = "";
public String getCommand(String commandString){
   if(commandString.equalsIgnoreCase("status")){                
     this.value = lot.status();
   }else{
     System.out.println("Invalid Command");
     this.value= "Invalid Command\n";
   }
   return this.value;
}
//Make Method for 1 parameter
public String getCommand(String commandString,String para){
   if(commandString.equalsIgnoreCase("create_parking_lot")){
     this.value = lot.createParkingLot(para);
   }
   else if(commandString.equalsIgnoreCase("leave")){
     this.value = lot.leave(para);
   }
   else if(commandString.equalsIgnoreCase("registration_numbers_for_cars_with_colour")){
     this.value = lot.getRegistrationNumbersFromColor(para);
   }
   else if(commandString.equalsIgnoreCase("slot_numbers_for_cars_with_colour")){
     this.value = lot.getSlotNumbersFromColor(para);
   }
   else if(commandString.equalsIgnoreCase("slot_number_for_registration_number")){
     this.value = lot.getSlotNumberFromRegNo(para);
   }else{
    System.out.println("Invalid Command");
    this.value= "Invalid Command\n";
  }
   return this.value;
}
//Make Method for 2 parameters
public String getCommand(String commandString,String para1,String para2){
    if(commandString.equalsIgnoreCase("park")){
     this.value = lot.park(para1,para2);
    }else{
      System.out.println("Invalid Command");
    this.value= "Invalid Command\n";
    }
    return this.value;
}
}