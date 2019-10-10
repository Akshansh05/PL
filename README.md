Project Requirements
----------------------------
```
1.Latest version of JDK.
2.Terminal
```
Build Instructions
----------------------------
```
From the project directory , run this command -

javac Main.java              ------------------(Main File)
javac MainTest.java          ------------------(Test File)
```
Running the project
----------------------------
```
From the project directory , run this command -

java Main fileName.txt       ---------------------(input file Mode)
java Main                    ---------------------(CLI Mode)

java MainTest                -----------------------(Test File CLI Mode)
```
Input for Main
---------------------
```
create_parking_lot 6
park KA-01-HH-1234 White
park KA-01-HH-9999 White
park KA-01-BB-0001 Black
park KA-01-HH-7777 Red
park KA-01-HH-2701 Blue
park KA-01-HH-3141 Black
leave 4
status
park KA-01-P-333 White
park DL-12-AA-9999 White
registration_numbers_for_cars_with_colour White
slot_numbers_for_cars_with_colour White
slot_number_for_registration_number KA-01-HH-3141
slot_number_for_registration_number MH-04-AY-1111
```
Output for main
---------------------
```
Created a parking lot with 6 slots

Allocated slot number: 1

Allocated slot number: 2

Allocated slot number: 3

Allocated slot number: 4

Allocated slot number: 5

Allocated slot number: 6

Slot number 4 is free

Slot No.   Registration No   Colour
1       KA-01-HH-1234   White
2       KA-01-HH-9999   White
3       KA-01-BB-0001   Black
5       KA-01-HH-2701   Blue
6       KA-01-HH-3141   Black

Allocated slot number: 4

Sorry, parking lot is full


KA-01-HH-1234,KA-01-HH-9999,KA-01-P-333

1,2,4
6
Not found
```
Output for MainTest
---------------------
```
Sorry, parking lot is not created

(test park passed)

Created a parking lot with 3 slots

(test createParkingLot passed)

Allocated slot number: 1

(test park passed)

Sorry, car is already parked

(test park passed)

1
(test GetSlotNumberFromRegNo passed)

Not found

(test GetSlotNumberFromRegNo passed)

Slot Number is greater that Max size

(test leave passed)

Allocated slot number: 2

(test park passed)

Slot number 1 is free

(test leave not passed)

Slot number 1 is already empty

(test leave passed)
```