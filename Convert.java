import java.util.Scanner;

/**
Full Name: Minh Tri Le
Student ID: A00249054

Program Description: This program allows users to convert between different forms of measurement. The supported units of measurement are:
1. km <-> mi (kilometer <-> mile)
2. cm <-> in (centimeter <-> inch)
3. kg <-> lb (kilogram <-> pound)
4. g <-> oz (gram <-> ounce)
5. c <-> f (Celsius degree <-> Fahrenheit degree)
6. l <-> cups (liter <-> US cup)

To use this program:
1. Please enter a value
2. Then enter one of the above supported units to convert to its respective unit.
**/

public class Convert {
  public static void main(String args[]) {
    Scanner myScanner = new Scanner(System.in);

    String valueInput = "";
    double value = 0;
    String unit = "";

    Boolean isValidValue = false; // To determine if input 'value' is in correct format, so no more input attempt is required
    do {
      System.out.println("Enter a value to convert: ");
      try {
        valueInput = myScanner.nextLine();
        if (valueInput.equals("quit")) {  // Allow users to quit program at anytime
          return;
        }
        value = Float.valueOf(valueInput);  // Convert 'valueInput' string to 'value' float for computation
        isValidValue = true;
      } catch(Exception e) {
        System.out.println("The input is not a numeric value and therefore will not be used to convert to other units. Please try again or type 'quit' to exit.");
      }
    } while (!isValidValue);  // Allow users to try enter value again if there's any mistaken or wrong input value

    Boolean isValidUnit = false; // To determine if input 'unit' is supported, so no more input attempt is required
    double result = 0;  // 'result' double for computation
    String resultText = ""; // 'resultText' string for showing result in console
    do {
      System.out.println("Enter the current unit of measure: ");
      unit = myScanner.nextLine().toLowerCase();  // Regardless of input 'unit' case => case-insensitive

      if (unit.equals("quit")) {  // Allow users to quit program at anytime
        return;
      }

      resultText = String.format("%.2f", value) + unit + " is equal to ";

      switch (unit) {
        case "km":
          result = value * 0.62;
          resultText += String.format("%.2f", result) + "mi";
          isValidUnit = true;
          break;
        case "mi":
          result = value * 1.61;
          resultText += String.format("%.2f", result) + "km";
          isValidUnit = true;
          break;
        case "cm":
          result = value * 0.39;
          resultText += String.format("%.2f", result) + "in";
          isValidUnit = true;
          break;
        case "in":
          result = value * 2.54;
          resultText += String.format("%.2f", result) + "cm";
          isValidUnit = true;
          break;
        case "kg":
          result = value * 2.2;
          resultText += String.format("%.2f", result) + "lb";
          isValidUnit = true;
          break;
        case "lb":
          result = value * 0.45;
          resultText += String.format("%.2f", result) + "kg";
          isValidUnit = true;
          break;
        case "g":
          result = value * 0.04;
          resultText += String.format("%.2f", result) + "oz";
          isValidUnit = true;
          break;
        case "oz":
          result = value * 28.35;
          resultText += String.format("%.2f", result) + "g";
          isValidUnit = true;
          break;
        case "c":
          result = (value * 9/5) + 32;
          resultText += String.format("%.2f", result) + "F";
          isValidUnit = true;
          break;
        case "f":
          result = (value - 32) * 5/9;
          resultText += String.format("%.2f", result) + "C";
          isValidUnit = true;
          break;
        case "l":
          result = value * 4.17;
          if (result == 1) {
            resultText += String.format("%.2f", result) + "cup";
          } else {
            resultText += String.format("%.2f", result) + "cups";
          }
          isValidUnit = true;
          break;
        case "cup":
          result = value * 0.24;
          resultText += String.format("%.2f", result) + "L";
          isValidUnit = true;
          break;
        case "cups":
          result = value * 0.24;
          resultText += String.format("%.2f", result) + "L";
          isValidUnit = true;
          break;
        default:
          resultText = "Unsupported unit of measure. Please try again or type 'quit' to exit.";
      }
      System.out.println(resultText); // Print final result to console
    } while (!isValidUnit);  // Allow users to try enter value again if there's any mistaken or wrong input unit
  }
}
