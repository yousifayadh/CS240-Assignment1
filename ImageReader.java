import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
public class ImageReader
{
    public static void main(String[] args)
    {
        //creates a BufferedImage object and sets it to null
        BufferedImage image = null;

        //creates a scanner object named keyboard
        Scanner keyboard = new Scanner(System.in);

        //Scanner gets the filepath of the image and assigns it to a string
        System.out.println("Type the file path of the image (remove quotes if they're there");
        String theImage = keyboard.nextLine();

        //try block as the next lines of code deal with files
        try
        {
            //creates a printwriter object to write to a file
            PrintWriter write = new PrintWriter("awesome_picture.txt");
            //uses the BufferedImage object to read the image
            image = ImageIO.read(new File(theImage));

            //gets the height and width of the image
            int imgHeight = image.getHeight();
            int imgWidth = image.getWidth();

            //goes through the entire image using nested for loops and the variables that the height and width was stored in
            for (int i = 0; i < imgWidth; i++)
            {
                for (int j = 0; j < imgHeight; j++)
                {
                    //gets the RGB of the current pixel and turns it to a Hexadecimal String
                    int currentPixel = image.getRGB(j,i);
                    String pixelAsHex = Integer.toHexString(currentPixel);

                    //removes the ff that comes before the hexadecimal version of the RGB as removing it allows it to be used in ImageWriter easier.
                    String pixelAsHexAsNumber = pixelAsHex.substring(2,pixelAsHex.length());
                    //writes the hexadecimal string to the file using PrintWriter and spaces it out
                    write.print("#" + pixelAsHexAsNumber + " ");

                    //prints it to the CLI
                    System.out.print("#" + pixelAsHexAsNumber + " ");

                    //flushes the text printed to the file (needed to actually show the changes on the file)
                    write.flush();
                }
                // separates each line of pixels so that it somewhat looks like the image (just in hexadecimal rather than actual pixels)
                write.println();
                System.out.println();
                write.flush();
            }
            //closes the PrintWriter and Scanner
            write.close();
            keyboard.close();
        }
        //catches IOException
        catch (IOException e)
        {
            System.out.println("This file couldn't be found");
        }

    }


}