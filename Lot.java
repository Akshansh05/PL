import java.util.*;

public class Lot{

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