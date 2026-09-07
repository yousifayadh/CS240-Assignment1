import java.util.Scanner;
public class ASCIIToDecimal
{

    public static void main (String[] args)
    {

        Scanner keyboard = new Scanner(System.in);
        //takes a string of ASCII
        String s = keyboard.nextLine();

        //for loop that prints the decimal number of the ASCII character
        for (Character c : s.toCharArray())
        {
            System.out.println((int)c);
        }


    }


}
