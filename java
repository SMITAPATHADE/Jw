1)Write a Java program to print the sum of elements of the array. Also 
display array elements in ascending order.
import java.util.Arrays;

public class ArraySumSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 4};
        int sum = 0;

        // Calculate sum of array elements
        for (int num : arr) {
            sum += num;
        }

        System.out.println("Sum of array elements = " + sum);

        // Sort array in ascending order
        Arrays.sort(arr);

        System.out.println("Array elements in ascending order:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

Output:

Sum of array elements = 20
Array elements in ascending order:
1 2 4 5 8



2)Write a Java Program to Display Armstrong Numbers Between range. 
Accept range from user. 


import java.util.Scanner;

public class ArmstrongRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter starting range: ");
        int start = sc.nextInt();

        System.out.print("Enter ending range: ");
        int end = sc.nextInt();

        System.out.println("Armstrong numbers between " + start + " and " + end + " are:");

        for (int num = start; num <= end; num++) {
            int original = num;
            int sum = 0;
            int digits = String.valueOf(num).length();

            while (num > 0) {
                int digit = num % 10;
                sum += Math.pow(digit, digits);
                num /= 10;
            }

            if (sum == original) {
                System.out.print(original + " ");
            }
        }

        sc.close();
    }
}


Output:

Enter starting range: 1
Enter ending range: 500

Armstrong numbers between 1 and 500 are:
1 2 3 4 5 6 7 8 9 153 370 371 407


3)Write a package for String operation which has two classes Con and 
Comp. Con class has to concatenate two strings and comp class compares 
two strings. Also display proper messages on execution. 


1.con.java
package stringoperation;

public class Con {
    public void concatenate(String str1, String str2) {
        String result = str1 + str2;
        System.out.println("Concatenated String: " + result);
    }
}


comp.java

package stringoperation;

public class Comp {
    public void compare(String str1, String str2) {
        if (str1.equals(str2)) {
            System.out.println("Both strings are equal.");
        } else {
            System.out.println("Both strings are not equal.");
        }
    }
}


3.TestString.java

import java.util.Scanner;
import stringoperation.Con;
import stringoperation.Comp;

public class TestString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        Con c = new Con();
        Comp cp = new Comp();

        System.out.println("\n--- String Operations ---");

        c.concatenate(str1, str2);
        cp.compare(str1, str2);

        sc.close();
    }
}



Folder structure:



StringOperation/
│
├── stringoperation/
│   ├── Con.java
│   └── Comp.java
│
└── TestString.java


Example Output

Enter first string: Hello
Enter second string: World

--- String Operations ---
Concatenated String: HelloWorld
Both strings are not equal.

--- String Operations ---
Concatenated String: HelloHello
Both strings are equal.



4)Write a menu driven program to perform the following operations on 
multidimensional array ie matrix : 
i. Addition 
ii. Multiplication 
iii. Transpose of any matrix. 
iv. Exit 

import java.util.Scanner;

public class MatrixOperations {

    static Scanner sc = new Scanner(System.in);

    // Method to input matrix
    static int[][] inputMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    // Method to display matrix
    static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Matrix addition
    static void addition() {
        System.out.print("Enter rows: ");
        int r = sc.nextInt();

        System.out.print("Enter columns: ");
        int c = sc.nextInt();

        System.out.println("Enter first matrix:");
        int[][] a = inputMatrix(r, c);

        System.out.println("Enter second matrix:");
        int[][] b = inputMatrix(r, c);

        int[][] sum = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }

        System.out.println("Addition of matrices:");
        displayMatrix(sum);
    }

    // Matrix multiplication
    static void multiplication() {
        System.out.print("Enter rows of first matrix: ");
        int r1 = sc.nextInt();

        System.out.print("Enter columns of first matrix: ");
        int c1 = sc.nextInt();

        System.out.println("Enter first matrix:");
        int[][] a = inputMatrix(r1, c1);

        System.out.print("Enter rows of second matrix: ");
        int r2 = sc.nextInt();

        System.out.print("Enter columns of second matrix: ");
        int c2 = sc.nextInt();

        if (c1 != r2) {
            System.out.println(
                "Matrix multiplication is not possible."
                + " Columns of first matrix must equal rows of second matrix."
            );
            return;
        }

        System.out.println("Enter second matrix:");
        int[][] b = inputMatrix(r2, c2);

        int[][] product = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    product[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        System.out.println("Multiplication of matrices:");
        displayMatrix(product);
    }

    // Matrix transpose
    static void transpose() {
        System.out.print("Enter rows: ");
        int r = sc.nextInt();

        System.out.print("Enter columns: ");
        int c = sc.nextInt();

        System.out.println("Enter matrix:");
        int[][] matrix = inputMatrix(r, c);

        int[][] trans = new int[c][r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                trans[j][i] = matrix[i][j];
            }
        }

        System.out.println("Transpose of matrix:");
        displayMatrix(trans);
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== MATRIX OPERATIONS =====");
            System.out.println("1. Addition");
            System.out.println("2. Multiplication");
            System.out.println("3. Transpose");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addition();
                    break;

                case 2:
                    multiplication();
                    break;

                case 3:
                    transpose();
                    break;

                case 4:
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}


Output:

===== MATRIX OPERATIONS =====
1. Addition
2. Multiplication
3. Transpose
4. Exit
Enter your choice: 1

Enter rows: 2
Enter columns: 2

Enter first matrix:
1 2
3 4

Enter second matrix:
5 6
7 8

Addition of matrices:
6       8
10      12

===== MATRIX OPERATIONS =====
1. Addition
2. Multiplication
3. Transpose
4. Exit
Enter your choice: 4

Program terminated.


5)Write a program to define a class Account having members custname, 
accno. Define default and parameterized constructor. Create a subclass 
called SavingAccount with members savingbal, minbal. Create a derived 
class AccountDetail that extends the class SavingAccount with members, 
depositamt and withdrawalamt. Write a appropriate method to display 
customer details. 


import java.util.Scanner;

// Base class
class Account {
    String custname;
    int accno;

    // Default constructor
    Account() {
        custname = "Unknown";
        accno = 0;
    }

    // Parameterized constructor
    Account(String custname, int accno) {
        this.custname = custname;
        this.accno = accno;
    }
}

// Derived class
class SavingAccount extends Account {
    double savingbal;
    double minbal;

    SavingAccount(String custname, int accno, double savingbal, double minbal) {
        super(custname, accno);
        this.savingbal = savingbal;
        this.minbal = minbal;
    }
}

// Derived class from SavingAccount
class AccountDetail extends SavingAccount {
    double depositamt;
    double withdrawalamt;

    AccountDetail(String custname, int accno, double savingbal,
                  double minbal, double depositamt, double withdrawalamt) {

        super(custname, accno, savingbal, minbal);
        this.depositamt = depositamt;
        this.withdrawalamt = withdrawalamt;
    }

    // Method to display customer details
    void displayDetails() {
        double finalBalance = savingbal + depositamt - withdrawalamt;

        System.out.println("\n----- Customer Account Details -----");
        System.out.println("Customer Name  : " + custname);
        System.out.println("Account Number : " + accno);
        System.out.println("Saving Balance : " + savingbal);
        System.out.println("Minimum Balance: " + minbal);
        System.out.println("Deposit Amount : " + depositamt);
        System.out.println("Withdrawal Amt : " + withdrawalamt);
        System.out.println("Final Balance  : " + finalBalance);

        if (finalBalance >= minbal) {
            System.out.println("Status         : Minimum balance maintained");
        } else {
            System.out.println("Status         : Minimum balance NOT maintained");
        }
    }
}

// Main class
public class AccountDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter account number: ");
        int accno = sc.nextInt();

        System.out.print("Enter saving balance: ");
        double savingbal = sc.nextDouble();

        System.out.print("Enter minimum balance: ");
        double minbal = sc.nextDouble();

        System.out.print("Enter deposit amount: ");
        double deposit = sc.nextDouble();

        System.out.print("Enter withdrawal amount: ");
        double withdrawal = sc.nextDouble();

        AccountDetail obj = new AccountDetail(
            name, accno, savingbal, minbal, deposit, withdrawal
        );

        obj.displayDetails();

        sc.close();
    }
}



output:

Enter customer name: Rahul
Enter account number: 101
Enter saving balance: 5000
Enter minimum balance: 1000
Enter deposit amount: 2000
Enter withdrawal amount: 1500

----- Customer Account Details -----
Customer Name  : Rahul
Account Number : 101
Saving Balance : 5000.0
Minimum Balance: 1000.0
Deposit Amount : 2000.0
Withdrawal Amt : 1500.0
Final Balance  : 5500.0
Status         : Minimum balance maintained

Account
   ↓
SavingAccount
   ↓
AccountDetail
This is an example of multilevel inheritance in Java.

6)Write a class Driver with attributes license_no, name, address and age. 
Initialize values through the parameterized constructor. If age of Driver 
is less than 18 then user-defined exception should be generated —Age 
is below 18 years— 


// User-defined exception
class AgeBelow18Exception extends Exception {
    AgeBelow18Exception(String message) {
        super(message);
    }
}

// Driver class
class Driver {
    String license_no;
    String name;
    String address;
    int age;

    // Parameterized constructor
    Driver(String license_no, String name, String address, int age)
            throws AgeBelow18Exception {

        if (age < 18) {
            throw new AgeBelow18Exception("Age is below 18 years");
        }

        this.license_no = license_no;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    // Method to display driver details
    void display() {
        System.out.println("\n----- Driver Details -----");
        System.out.println("License No : " + license_no);
        System.out.println("Name       : " + name);
        System.out.println("Address    : " + address);
        System.out.println("Age        : " + age);
    }
}

// Main class
public class DriverDemo {
    public static void main(String[] args) {

        try {
            Driver d = new Driver(
                "MH12AB1234",
                "Rahul",
                "Pune",
                17
            );

            d.display();

        } catch (AgeBelow18Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
Output when age is below 18

Exception: Age is below 18 years
Output when age is 18 or above
If the age is changed to 25:

----- Driver Details -----
License No : MH12AB1234
Name       : Rahul
Address    : Pune
Age        : 25


7)Write a program to create an abstract class named Shape that contains 
two integers and an empty method named printArea(). Provide three 
classes named Rectangle, Triangle and Circle such that each one of the 
classes extends the class Shape. Each one of the classes contain only the 
method printArea() that prints the area of the given shape. (use method 
overriding).


import java.util.Scanner;

// Abstract class
abstract class Shape {
    int a, b;

    // Empty abstract method
    abstract void printArea();
}

// Rectangle class
class Rectangle extends Shape {

    Rectangle(int length, int breadth) {
        a = length;
        b = breadth;
    }

    // Method overriding
    void printArea() {
        System.out.println("Area of Rectangle = " + (a * b));
    }
}

// Triangle class
class Triangle extends Shape {

    Triangle(int base, int height) {
        a = base;
        b = height;
    }

    // Method overriding
    void printArea() {
        System.out.println("Area of Triangle = " + (0.5 * a * b));
    }
}

// Circle class
class Circle extends Shape {

    Circle(int radius) {
        a = radius;
    }

    // Method overriding
    void printArea() {
        System.out.println("Area of Circle = " + (Math.PI * a * a));
    }
}

// Main class
public class ShapeDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length of rectangle: ");
        int length = sc.nextInt();

        System.out.print("Enter breadth of rectangle: ");
        int breadth = sc.nextInt();

        Rectangle r = new Rectangle(length, breadth);
        r.printArea();

        System.out.print("\nEnter base of triangle: ");
        int base = sc.nextInt();

        System.out.print("Enter height of triangle: ");
        int height = sc.nextInt();

        Triangle t = new Triangle(base, height);
        t.printArea();

        System.out.print("\nEnter radius of circle: ");
        int radius = sc.nextInt();

        Circle c = new Circle(radius);
        c.printArea();

        sc.close();
    }
}

Sample Output

Enter length of rectangle: 10
Enter breadth of rectangle: 5
Area of Rectangle = 50

Enter base of triangle: 8
Enter height of triangle: 6
Area of Triangle = 24.0

Enter radius of circle: 7
Area of Circle = 153.93804002589985

Concept Used
       

              Shape (Abstract Class)
                     |
          -------------------------
          |           |           |
      Rectangle    Triangle     Circle


8)Write a program which define class Employee with data member as id, 
name and salary Store the information of ‘n’ employees and display the 
name of employee having maximum salary (Use array of object) 


import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    // Method to accept employee details
    void accept() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        id = sc.nextInt();

        sc.nextLine(); // Consume newline

        System.out.print("Enter Employee Name: ");
        name = sc.nextLine();

        System.out.print("Enter Employee Salary: ");
        salary = sc.nextDouble();
    }

    // Method to display employee details
    void display() {
        System.out.println("Employee ID     : " + id);
        System.out.println("Employee Name   : " + name);
        System.out.println("Employee Salary : " + salary);
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        // Array of objects
        Employee[] emp = new Employee[n];

        // Accept employee information
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Employee " + (i + 1));

            emp[i] = new Employee();
            emp[i].accept();
        }

        // Find employee with maximum salary
        int max = 0;

        for (int i = 1; i < n; i++) {
            if (emp[i].salary > emp[max].salary) {
                max = i;
            }
        }

        // Display result
        System.out.println("\n--- Employee Having Maximum Salary ---");
        emp[max].display();

        sc.close();
    }
}

output:

Enter number of employees: 3

Enter details of Employee 1
Enter Employee ID: 101
Enter Employee Name: Rahul
Enter Employee Salary: 25000

Enter details of Employee 2
Enter Employee ID: 102
Enter Employee Name: Amit
Enter Employee Salary: 35000

Enter details of Employee 3
Enter Employee ID: 103
Enter Employee Name: Priya
Enter Employee Salary: 30000

--- Employee Having Maximum Salary ---
Employee ID     : 102
Employee Name   : Amit
Employee Salary : 35000.0

9)Write a program to create a super class Vehicle having members 
Company and price. Derive two different classes LightMotorVehicle 
(mileage) and HeavyMotorVehicle (capacity_in_tons). Accept the 
information for "n" vehicles and display the information in appropriate 
form. While taking data, ask user about the type of vehicle first. 

import java.util.Scanner;

// Super class
class Vehicle {
    String company;
    double price;

    void acceptBasicDetails(Scanner sc) {
        System.out.print("Enter Company: ");
        company = sc.nextLine();

        System.out.print("Enter Price: ");
        price = sc.nextDouble();
        sc.nextLine();
    }

    void displayBasicDetails() {
        System.out.println("Company : " + company);
        System.out.println("Price   : " + price);
    }
}

// Light Motor Vehicle
class LightMotorVehicle extends Vehicle {
    double mileage;

    void accept(Scanner sc) {
        acceptBasicDetails(sc);

        System.out.print("Enter Mileage (km/l): ");
        mileage = sc.nextDouble();
        sc.nextLine();
    }

    void display() {
        displayBasicDetails();
        System.out.println("Mileage : " + mileage + " km/l");
    }
}

// Heavy Motor Vehicle
class HeavyMotorVehicle extends Vehicle {
    double capacity_in_tons;

    void accept(Scanner sc) {
        acceptBasicDetails(sc);

        System.out.print("Enter Capacity (tons): ");
        capacity_in_tons = sc.nextDouble();
        sc.nextLine();
    }

    void display() {
        displayBasicDetails();
        System.out.println("Capacity: " + capacity_in_tons + " tons");
    }
}

// Main class
public class VehicleDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Arrays of objects
        LightMotorVehicle[] light = new LightMotorVehicle[n];
        HeavyMotorVehicle[] heavy = new HeavyMotorVehicle[n];

        int lightCount = 0;
        int heavyCount = 0;

        for (int i = 0; i < n; i++) {

            System.out.println("\nVehicle " + (i + 1));
            System.out.println("1. Light Motor Vehicle");
            System.out.println("2. Heavy Motor Vehicle");
            System.out.print("Enter vehicle type: ");

            int type = sc.nextInt();
            sc.nextLine();

            if (type == 1) {
                light[lightCount] = new LightMotorVehicle();
                light[lightCount].accept(sc);
                lightCount++;

            } else if (type == 2) {
                heavy[heavyCount] = new HeavyMotorVehicle();
                heavy[heavyCount].accept(sc);
                heavyCount++;

            } else {
                System.out.println("Invalid vehicle type!");
                i--;
            }
        }

        // Display Light Motor Vehicles
        System.out.println("\n===== LIGHT MOTOR VEHICLES =====");

        if (lightCount == 0) {
            System.out.println("No Light Motor Vehicles.");
        } else {
            for (int i = 0; i < lightCount; i++) {
                System.out.println("\nVehicle " + (i + 1));
                light[i].display();
            }
        }

        // Display Heavy Motor Vehicles
        System.out.println("\n===== HEAVY MOTOR VEHICLES =====");

        if (heavyCount == 0) {
            System.out.println("No Heavy Motor Vehicles.");
        } else {
            for (int i = 0; i < heavyCount; i++) {
                System.out.println("\nVehicle " + (i + 1));
                heavy[i].display();
            }
        }

        sc.close();
    }
}

output:
Enter number of vehicles: 2

Vehicle 1
1. Light Motor Vehicle
2. Heavy Motor Vehicle
Enter vehicle type: 1
Enter Company: Maruti
Enter Price: 800000
Enter Mileage (km/l): 20

Vehicle 2
1. Light Motor Vehicle
2. Heavy Motor Vehicle
Enter vehicle type: 2
Enter Company: Tata
Enter Price: 2500000
Enter Capacity (tons): 10

===== LIGHT MOTOR VEHICLES =====

Vehicle 1
Company : Maruti
Price   : 800000.0
Mileage : 20.0 km/l

===== HEAVY MOTOR VEHICLES =====

Vehicle 1
Company : Tata
Price   : 2500000.0
Capacity: 10.0 tons

Inheritance Structure:

                 Vehicle
                /       \
               /         \
LightMotorVehicle    HeavyMotorVehicle
     |                    |
  mileage            capacity_in_tons


10)Write a package game which will have 2 classes Indoor & Outdoor. Use 
a function display () to generate the list of players for the specific game. 
Use default & parameterized constructor 

1.Indoor.java

package game;

public class Indoor {
    String gameName;
    String[] players;

    // Default constructor
    public Indoor() {
        gameName = "Chess";
        players = new String[]{"Player 1", "Player 2"};
    }

    // Parameterized constructor
    public Indoor(String gameName, String[] players) {
        this.gameName = gameName;
        this.players = players;
    }

    // Display players
    public void display() {
        System.out.println("\nIndoor Game: " + gameName);
        System.out.println("List of Players:");

        for (String player : players) {
            System.out.println(player);
        }
    }
}

2.Outdoor.java

package game;

public class Outdoor {
    String gameName;
    String[] players;

    // Default constructor
    public Outdoor() {
        gameName = "Cricket";
        players = new String[]{"Player 1", "Player 2", "Player 3"};
    }

    // Parameterized constructor
    public Outdoor(String gameName, String[] players) {
        this.gameName = gameName;
        this.players = players;
    }

    // Display players
    public void display() {
        System.out.println("\nOutdoor Game: " + gameName);
        System.out.println("List of Players:");

        for (String player : players) {
            System.out.println(player);
        }
    }
}

3.GameDemo.java

import game.Indoor;
import game.Outdoor;

public class GameDemo {
    public static void main(String[] args) {

        // Using default constructors
        Indoor indoor = new Indoor();
        Outdoor outdoor = new Outdoor();

        indoor.display();
        outdoor.display();

        // Using parameterized constructors
        String[] chessPlayers = {"Rahul", "Amit"};
        String[] cricketPlayers = {
            "Rohit", "Virat", "Rahul", "Hardik", "Jadeja"
        };

        Indoor i = new Indoor("Chess", chessPlayers);
        Outdoor o = new Outdoor("Cricket", cricketPlayers);

        System.out.println("\n--- Using Parameterized Constructors ---");

        i.display();
        o.display();
    }
}


Folder Structure

GamePackage/
│
├── game/
│   ├── Indoor.java
│   └── Outdoor.java
│
└── GameDemo.java

output:
Indoor Game: Chess
List of Players:
Player 1
Player 2

Outdoor Game: Cricket
List of Players:
Player 1
Player 2
Player 3

--- Using Parameterized Constructors ---

Indoor Game: Chess
List of Players:
Rahul
Amit

Outdoor Game: Cricket
List of Players:
Rohit
Virat
Rahul
Hardik
Jadeja

11)Define a “Clock” class that does the following; 
a. Accept Hours, Minutes and Seconds 
b. Check the validity of numbers 
c. Set the time to AM/PM mode 
Use the necessary constructors and methods to do the above task

import java.util.Scanner;

class Clock {
    int hours;
    int minutes;
    int seconds;

    // Default constructor
    Clock() {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }

    // Parameterized constructor
    Clock(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    // Method to check validity
    boolean isValid() {
        if (hours < 0 || hours > 23) {
            return false;
        }

        if (minutes < 0 || minutes > 59) {
            return false;
        }

        if (seconds < 0 || seconds > 59) {
            return false;
        }

        return true;
    }

    // Method to display time in AM/PM format
    void setAMPM() {
        if (!isValid()) {
            System.out.println("Invalid time!");
            return;
        }

        String period;
        int displayHour;

        if (hours >= 12) {
            period = "PM";
        } else {
            period = "AM";
        }

        displayHour = hours % 12;

        if (displayHour == 0) {
            displayHour = 12;
        }

        System.out.printf("Time in AM/PM format: %02d:%02d:%02d %s%n",
                displayHour, minutes, seconds, period);
    }
}

public class ClockDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Hours (0-23): ");
        int h = sc.nextInt();

        System.out.print("Enter Minutes (0-59): ");
        int m = sc.nextInt();

        System.out.print("Enter Seconds (0-59): ");
        int s = sc.nextInt();

        // Create object using parameterized constructor
        Clock c = new Clock(h, m, s);

        // Check validity
        if (c.isValid()) {
            System.out.println("Time is valid.");
            c.setAMPM();
        } else {
            System.out.println("Invalid time entered!");
        }

        sc.close();
    }
}

output:
Enter Hours (0-23): 15
Enter Minutes (0-59): 30
Enter Seconds (0-59): 45

Time is valid.
Time in AM/PM format: 03:30:45 PM

