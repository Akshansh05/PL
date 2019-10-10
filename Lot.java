import java.util.*;
import java.io.*;
import java.lang.*;
//Lot Class
public  class Lot{

    int size;
    String globalSlot="";
    //Car class
    public class Car{
   
       String regNO,colour;
   
        public Car(String regNO,String colour){
           this.regNO = regNO;
           this.colour = colour;
        }
    }
    ArrayList<Integer> availableSlot;
   
    HashMap<String,Car>slotCar;
   
    HashMap<String,String>regNOSlot;
   
    HashMap<String,ArrayList<String>>colourRegNo;
    //createParkingLot
     public String createParkingLot(String size){
       String returnString = "";
       try {
           this.size=Integer.parseInt(size);
           if(this.size < 0){
           System.out.println("Invalid lot count");
           System.out.println();
           returnString = "Invalid lot count\n";
        }
           
       } catch (Exception e) {
           System.out.println("Invalid lot count");
           System.out.println();
           returnString = "Invalid lot count\n";
       }
       try{
        if(this.size > 0){
          this.availableSlot = new <Integer> ArrayList();
   
          for(int i=1;i<=this.size;i++){
            this.availableSlot.add(i);
          }
          this.slotCar = new <String,Car> HashMap();
          this.regNOSlot = new <String,String> HashMap();
          this.colourRegNo =  new <String,ArrayList<String>> HashMap();
           
          System.out.println("Created a parking lot with "+size+" slots");
          System.out.println();
          returnString = "Created a parking lot with "+size+" slots\n";
        }
       } catch (Exception e) {
            System.out.println("Cannot create parking Lot");
            System.out.println();
            returnString = "Cannot create parking Lot\n";
       }
       return returnString;
    }
   
    //park
     public String park(String regNO, String colour){
        String returnString = "";
       if(this.size == 0){
           System.out.println("Sorry, parking lot is not created");
           System.out.println();
           returnString = "Sorry, parking lot is not created\n";
       }else if (this.regNOSlot.containsKey(regNO)){
           System.out.println("Sorry, car is already parked");
           System.out.println();
           returnString = "Sorry, car is already parked\n";
       }else if(this.slotCar.size() == size){
           System.out.println("Sorry, parking lot is full");
           System.out.println();
           returnString = "Sorry, parking lot is full\n";
       }else{
           Collections.sort(availableSlot);
           String slot = this.availableSlot.get(0).toString();
           Car car = new Car(regNO,colour);
          
           this.slotCar.put(slot,car);
           this.regNOSlot.put(regNO,slot);
   
           if(this.colourRegNo.containsKey(colour)){
               ArrayList<String> regNOList = this.colourRegNo.get(colour);
               this.colourRegNo.remove(colour);
               regNOList.add(regNO);
               this.colourRegNo.put(colour,regNOList);
           }else{
               ArrayList<String> regNOList = new <String> ArrayList();
               regNOList.add(regNO);
               this.colourRegNo.put(colour,regNOList);
           }
           System.out.println("Allocated slot number: "+ slot);
           this.globalSlot=slot;
           System.out.println();
           returnString = "Allocated slot number: "+ slot+"\n";
           this.availableSlot.remove(0);
       }
       return returnString;
    }
   
    //leave
     public String leave(String slotNo){
        String returnString = "";
       if(this.size == 0){
           System.out.println("Sorry, parking lot is not created");
           System.out.println();
           returnString = "Sorry, parking lot is not created\n";
       }else if(Integer.parseInt(slotNo) > this.size){
        System.out.println("Slot Number is greater that Max size");
           System.out.println();
           returnString = "Slot Number is greater that Max size\n";
       }else if(this.slotCar.size() > 0){
   
              if(this.slotCar.get(slotNo) != null){
   
                   Car leftCar = this.slotCar.get(slotNo);
   
                   if(leftCar != null){
                     this.slotCar.remove(slotNo);
                     this.regNOSlot.remove(leftCar.regNO);
                     ArrayList<String> regNOList = this.colourRegNo.get(leftCar.colour);
   
                     if(regNOList.contains(leftCar.regNO)){
                        regNOList.remove(leftCar.regNO);
                     }
                     this.availableSlot.add(Integer.parseInt(slotNo));
                     System.out.println("Slot number "+slotNo+" is free");
                     System.out.println();
                     returnString = "Slot number "+slotNo+" is free\n";
                   }else{
                       System.out.println("No cars found at given slot");
                       System.out.println();
                       returnString = "No cars found at given slot\n";
                   }
              }else{
                 System.out.println("Slot number " + slotNo + " is already empty");
                 System.out.println();
                 returnString = "Slot number " + slotNo + " is already empty\n";
              } 
       }else{
             System.out.println("Parking lot is Empty");
             System.out.println();
             returnString = "Slot number " + slotNo + " is already empty\n";
       }
       return returnString;
     }
   
    //status
     public String status(){
        String returnString = "";
       if(this.size == 0){
           System.out.println("Sorry, parking lot is not created");
           System.out.println();
           returnString = "Sorry, parking lot is not created\n";
       }else if(this.slotCar.size() > 0){
           System.out.println("Slot No.   Registration No   Colour");
           returnString+="Slot No.   Registration No   Colour\n";
           Car car;
   
           for(int i=1;i<=this.size;i++){
               String slotNo = Integer.toString(i);
               if(this.slotCar.containsKey(slotNo)){
                   car=this.slotCar.get(slotNo);
                   System.out.println(i + "\t" + car.regNO + "\t" + car.colour);
                   returnString+=Integer.toString(i) +"\t" + car.regNO + "\t" + car.colour+"\n";
               }
           }
           System.out.println();   
           returnString+="\n";    
       }else{
           System.out.println("Parking lot is empty");
           System.out.println();
           returnString = "Parking lot is empty\n";
       }
       return returnString;
     }
   
   
    //getRegistrationNumbersFromColor
     public String getRegistrationNumbersFromColor(String colour){
        String returnString = "";
       if(this.size == 0){
           System.out.println("Sorry, parking lot is not created");
           System.out.println();
           returnString = "Sorry, parking lot is not created\n";
       }else if(this.colourRegNo.containsKey(colour)){
   
           ArrayList <String> regNOList = this.colourRegNo.get(colour);
           System.out.println();
           returnString+="\n";
           for(int i=0;i<regNOList.size();i++){
   
               if (!(i == regNOList.size() - 1)){
                   System.out.print(regNOList.get(i) + ",");
                   returnString += regNOList.get(i) + "," ;
               }else{
                   System.out.print(regNOList.get(i));
                   returnString += regNOList.get(i);
               }
           }
          System.out.println(); 
          returnString+="\n";
       }else{
           System.out.println("Not found");
           System.out.println();
           returnString = "Not found\n";
       }
       return returnString;
     }
   
     //getSlotNumbersFromColor
     public String getSlotNumbersFromColor(String colour){
        String returnString = "";
       if(this.size == 0){
           System.out.println("Sorry, parking lot is not created");
           System.out.println();
           returnString = "Sorry, parking lot is not created\n";
       }else if(this.colourRegNo.containsKey(colour)){
   
           ArrayList<String> regNOList = this.colourRegNo.get(colour);
           ArrayList<String> slotList = new <String> ArrayList();
           System.out.println();
           returnString+="\n";
           for(int i=0;i<regNOList.size();i++){
               slotList.add(this.regNOSlot.get(regNOList.get(i)));
           }
   
           Collections.sort(slotList);
           for(int i=0;i<slotList.size();i++){
               if (!(i == slotList.size() - 1)) {
                   System.out.print(slotList.get(i) + ",");
                   returnString += slotList.get(i) + ",";
               }else{
                   System.out.print(slotList.get(i));
                   returnString += slotList.get(i);
               }
           }
           System.out.println();
           returnString+="\n";
       }else{
           System.out.println("Not found");
           System.out.println();
           returnString = "Not found\n";
       }
       return returnString;
     }
   
    //getSlotNumberFromRegNo
     public String getSlotNumberFromRegNo(String regNO){
        String returnString = "";
       if(this.size == 0){
           System.out.println("Sorry, parking lot is not created");
           System.out.println();
           returnString = "Sorry, parking lot is not created\n";
       }else if(this.regNOSlot.containsKey(regNO)){
           System.out.println(this.regNOSlot.get(regNO));
           returnString = this.regNOSlot.get(regNO) + "\n";
       }else{
           System.out.println("Not found");
           System.out.println();
           returnString = "Not found\n";
       }
       return returnString;
    }
   
}