import java.util.Scanner;
public class NumberBaseConverter
{
    public static void main(String[] args)
    {
        //declares and initializes variables that will help with the binary conversions
        boolean unsigned = false;
        String isItNegative = "";

        //scanner that is used to hold the type of base the user is converting from and to.
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What are you converting from and what are you converting to");
        String from = keyboard.next();
        String to = keyboard.next();
        //if either from or to is binary
        if (to.equalsIgnoreCase("binary") || from.equalsIgnoreCase("binary"))
        {
            //asks if the value will be signed/two's complement or unsigned and holds the answer in a string variable called isItUnsigned
            System.out.println("Would you like your binary value to be accounted as two's complement or unsigned? If unsigned, write yes. If signed/two's complement, write no");
            String isItUnsigned = keyboard.next();

            //uses the value of isItUnsigned to assign either true or false to the unsigned boolean
            if (isItUnsigned.equalsIgnoreCase("yes"))
            {
                unsigned = true;

            }
            else if (isItUnsigned.equalsIgnoreCase("no"))
            {

                unsigned = false;

                //if the number being converted from is binary, asks if the binary number is negative and stores it in String variable isItNegative
                if (from.equalsIgnoreCase("binary"))
                {
                System.out.println("Is the original binary number you're entering negative");
                isItNegative = keyboard.next();
                }
            }
        }

        //takes in the value in the original base
        System.out.println("Write your original number");
        String originalBase = keyboard.next();
        //if the original base is decimal or octal, it will run another conditional that checks if unsigned is true and originalBase is less than 0.
        if (from.equalsIgnoreCase("decimal") || from.equalsIgnoreCase("octal"))
        {
            //if the number is unsigned binary but the originalBase is less than 0 (negative), it will not let user continue until they answer put in a positive number, or 0.
            if (unsigned && Long.parseLong(originalBase) < 0)
            {

                while (Long.parseLong(originalBase) < 0)
                {
                    System.out.println("This number cannot be given as unsigned. Please reenter a number");
                    originalBase = keyboard.next();
                }
            }

        }
        //if the originalBase is in decimal
        if (from.equalsIgnoreCase("decimal"))
        {
            // the number in originalBase is parsed into a long
            long originalBaseAsLong = Long.parseLong(originalBase);
            //if converting into binary
            if (to.equalsIgnoreCase("binary"))
            {
                //checks if unsigned is true. If it is, it uses toUnsignedString. If it isn't, toBinaryString is used.
                if (unsigned)
                {
                    System.out.println(Long.toUnsignedString(originalBaseAsLong, 2));
                }
                else
                {
                    System.out.println(Long.toBinaryString(originalBaseAsLong));
                }
            }
            // if converting into decimal from decimal, originalBase is just printed as it's already in decimal
            else if (to.equalsIgnoreCase("decimal"))
            {
                System.out.println(originalBaseAsLong);
            }
            // if converting into octal from decimal, uses toOctalString
            else if (to.equalsIgnoreCase("octal"))
            {
                //first, checks if value of originalBase is < 0
                Long originalBaseABS = (long) 0;
                if (originalBaseAsLong < 0)
                {
                    // if it is, finds abs of originalBase, then puts that next to a - sign in the answer (still correct answer)
                    originalBaseABS = Math.abs(originalBaseAsLong);
                    System.out.println("-" + Long.toOctalString(originalBaseABS));
                }
                else
                //if it isn't, toOctalString is used
                {
                    System.out.println(Long.toOctalString(originalBaseAsLong));
                }

            }
            //if converting to hex, uses toHexString
            else if (to.equalsIgnoreCase("hex"))
            {
                System.out.println(Long.toHexString(originalBaseAsLong));
            }
            //if none of the above is true, it prints that the base put in isn't supported
            else
            {
                System.out.println("The base you're converting to isn't supported.");
            }

        }
        // else if the original base is binary
        else if (from.equalsIgnoreCase("binary"))
        {
            // declares and initializes variables to 0
            Long binaryAsDecimal = (long) 0;
            String binaryAsDecimalString = "";

            //if unsigned is true, it parses the value and turns that value into a string using the unsigned methods of parseLong and toString
            if (unsigned)
            {

                binaryAsDecimal = Long.parseUnsignedLong(originalBase, 2);
                binaryAsDecimalString = Long.toUnsignedString(binaryAsDecimal);
            }
            //otherwise, if the binary is negative, it adds 1's to the beginning until the vallue of originalBase is 64 characters in length (trailing 1's which is why code checks if it's negative)
            else
            {
                if (isItNegative.equalsIgnoreCase("yes"))
                {
                    while (originalBase.length() < 64)
                    {
                        originalBase = "1" + originalBase;

                    }
                    //still parses it unsigned due to Java's way of dealing with 64 bit binary that starts with 1 (answer is still correct)
                    binaryAsDecimal = Long.parseUnsignedLong(originalBase,2);
                    System.out.println(binaryAsDecimal);
                }




            }
            // if converting to decimal, prints the decimal value
            if (to.equalsIgnoreCase("decimal"))
            {
                System.out.println(binaryAsDecimalString);
            }
            // if converting to binary, just prints the originalBase which is in binary
            else if (to.equalsIgnoreCase("binary"))
            {
                System.out.println(originalBase);
            }
            //if converting to octal, converts decimal value of the binary to octal
            else if (to.equalsIgnoreCase("octal"))
            {

                System.out.println(Long.toOctalString(binaryAsDecimal));
            }
            //if converting to hex, converts decimal value of the binary to hex
            else if (to.equalsIgnoreCase("hex"))
            {

                System.out.println(Long.toHexString(binaryAsDecimal));
            }
            //if none of the conditionals above work, it prints that the base being converted to isn't supported
            else
            {
                System.out.println("The base you're converting to isn't supported.");
            }
        }

        // if converting from octal
        else if (from.equalsIgnoreCase("octal"))
        {
            //converts the octal value to decimal
            Long octalAsDecimal = Long.parseLong(originalBase, 8);
            String binaryAsDecimalString = octalAsDecimal.toString();
            // if converting to decimal, just prints decimal value of octal found above
            if (to.equalsIgnoreCase("decimal"))
            {
                System.out.println(octalAsDecimal);
            }

            //if converting to binary, converts decimal value of octal to binary
            else if (to.equalsIgnoreCase("binary"))
            {
                System.out.println(Long.toBinaryString(octalAsDecimal));
            }
            //prints the original base value as that was already in octal if the code gets to this point
            else if (to.equalsIgnoreCase("octal"))
            {

                System.out.println(originalBase);
            }
            // converts decimal value of octal to hex
            else if (to.equalsIgnoreCase("hex"))
            {

                System.out.println(Long.toHexString(octalAsDecimal));
            }
            //if none of the conditionals above work, then it prints that the base the user is converting to isn't supported
            else
            {
                System.out.println("The base you're converting to isn't supported.");
            }
        }
        // converting from hex
        else if (from.equalsIgnoreCase("hex"))
        {
            //converts the hex value to decimal
            Long hexAsDecimal = Long.parseLong(originalBase, 16);
            String binaryAsDecimalString = hexAsDecimal.toString();
            // if converting to decimal, prints decimal value found above
            if (to.equalsIgnoreCase("decimal"))
            {
                System.out.println(hexAsDecimal);
            }
            //if converting to binary, converts the decimal value of the hex into binary
            else if (to.equalsIgnoreCase("binary"))
            {
                System.out.println(Long.toBinaryString(hexAsDecimal));
            }
            // if converting to octal, converts decimal value of the hex into octal
            else if (to.equalsIgnoreCase("octal"))
            {

                System.out.println(Long.toOctalString(hexAsDecimal));
            }
            //prints hex value (already found if the code gets to this conditional)
            else if (to.equalsIgnoreCase("hex"))
            {

                System.out.println(originalBase);
            }
            // message if none of the above conditionals work
            else
            {
                System.out.println("The base you're converting to isn't supported.");
            }
        }
        // if none of the conditionals for the bases the user is converting from work, then it just prints that the base user is converting from isn't supported
        else
        {
            System.out.println("The base you're converting from isn't supported.");
        }



    }
}
