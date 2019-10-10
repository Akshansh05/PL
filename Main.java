import java.util.*;
import java.io.*;
import java.lang.*;
//Main Driver Class
public class Main{
    //Lot Class
    public static class Lot{

        int size;
        
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
         public void createParkingLot(String size){
           
           try {
               this.size=Integer.parseInt(size);
               
           } catch (Exception e) {
               System.out.println("Invalid lot count");
               System.out.println();
           }
           try{
              this.availableSlot = new <Integer> ArrayList();
       
              for(int i=1;i<=this.size;i++){
                this.availableSlot.add(i);
              }
              this.slotCar = new <String,Car> HashMap();
              this.regNOSlot = new <String,String> HashMap();
              this.colourRegNo =  new <String,ArrayList<String>> HashMap();
               
              System.out.println("Created a parking lot with "+size+" slots");
              System.out.println();
           } catch (Exception e) {
                System.out.println("Cannot create parking Lot");
                System.out.println();
           }
        }
       
        //park
         public void park(String regNO, String colour){
       
           if(this.size == 0){
               System.out.println("Sorry, parking lot is not created");
               System.out.println();
           }else if (this.regNOSlot.containsKey(regNO)){
               System.out.println("Sorry, car is already parked");
               System.out.println();
           }else if(this.slotCar.size() == size){
               System.out.println("Sorry, parking lot is full");
               System.out.println();
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
               System.out.println();
               this.availableSlot.remove(0);
           }
        }
       
        //leave
         public void leave(String slotNo){
           if(this.size == 0){
               System.out.println("Sorry, parking lot is not created");
               System.out.println();
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
                       }else{
                           System.out.println("No cars found at given slot");
                           System.out.println();
                       }
                  }else{
                     System.out.println("Slot number " + slotNo + " is already empty");
                     System.out.println();
                  } 
           }else{
                 System.out.println("Parking lot is Empty");
                 System.out.println();
           }
         }
       
        //status
         public void status(){
       
           if(this.size == 0){
               System.out.println("Sorry, parking lot is not created");
               System.out.println();
           }else if(this.slotCar.size() > 0){
               System.out.println("Slot No.   Registration No   Colour");
               Car car;
       
               for(int i=1;i<=this.size;i++){
                   String slotNo = Integer.toString(i);
                   if(this.slotCar.containsKey(slotNo)){
                       car=this.slotCar.get(slotNo);
                       System.out.println(i + "\t" + car.regNO + "\t" + car.colour);
                   }
               }
               System.out.println();       
           }else{
               System.out.println("Parking lot is empty");
               System.out.println();
           }
         }
       
       
        //getRegistrationNumbersFromColor
         public void getRegistrationNumbersFromColor(String colour){
           if(this.size == 0){
               System.out.println("Sorry, parking lot is not created");
               System.out.println();
           }else if(this.colourRegNo.containsKey(colour)){
       
               ArrayList <String> regNOList = this.colourRegNo.get(colour);
               System.out.println();
               for(int i=0;i<regNOList.size();i++){
       
                   if (!(i == regNOList.size() - 1)){
                       System.out.print(regNOList.get(i) + ",");
                   }else{
                       System.out.print(regNOList.get(i));
                   }
               }
              System.out.println(); 
           }else{
               System.out.println("Not found");
               System.out.println();
           }
         }
       
         //getSlotNumbersFromColor
         public void getSlotNumbersFromColor(String colour){
           if(this.size == 0){
               System.out.println("Sorry, parking lot is not created");
               System.out.println();
           }else if(this.colourRegNo.containsKey(colour)){
       
               ArrayList<String> regNOList = this.colourRegNo.get(colour);
               ArrayList<String> slotList = new <String> ArrayList();
               System.out.println();
               for(int i=0;i<regNOList.size();i++){
                   slotList.add(this.regNOSlot.get(regNOList.get(i)));
               }
       
               Collections.sort(slotList);
               for(int i=0;i<slotList.size();i++){
                   if (!(i == slotList.size() - 1)) {
                       System.out.print(slotList.get(i) + ",");
                   }else{
                       System.out.print(slotList.get(i));
                   }
               }
               System.out.println();
           }else{
               System.out.println("Not found");
               System.out.println();
           }
         }
       
        //getSlotNumberFromRegNo
         public void getSlotNumberFromRegNo(String regNO){
           if(this.size == 0){
               System.out.println("Sorry, parking lot is not created");
               System.out.println();
           }else if(this.regNOSlot.containsKey(regNO)){
               System.out.println(this.regNOSlot.get(regNO));
           }else{
               System.out.println("Not found");
               System.out.println();
           }
        }
       
    }
   
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