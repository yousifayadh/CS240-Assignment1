import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.Color;
public class ImageWriter
{
    public static void main(String[] args)
    {
        try
        {
            //creates a new null bufferedimage and a filereader that reads from a file containing the hexadecimal values
            BufferedImage image = null;
            Scanner fileReader = new Scanner(new File ("the_image.txt"));


            //file object that reads from smile.png
            File theFile = new File("smile.png");

            //assigns image file to read from the smile.png file
            image = ImageIO.read(theFile);



            //gets the image width and height from the
            int imgHeight = image.getHeight();
            int imgWidth = image.getWidth();


            //nested for loop that iterates through the image's width and height to alter the pixels
            for (int i = 0; i < imgHeight; i++)
            {
                for (int j = 0; j < imgWidth; j++)
                {
                    //reads the next string from "the_image.txt" (each value is spaced out from another)
                    String currentHex = fileReader.next();

                    //turns the hexadecimal/hexcode value into it's color form
                    Color thePixel = Color.decode(currentHex);

                    //declares and assigns an int variable with the RGB value of the new pixel(needed to use .setRGB())
                    int thePixelAsNumber = thePixel.getRGB();

                    //sets the pixel at the specificed width and height to the new pixel.
                    image.setRGB(j, i, thePixelAsNumber);

                    //writes the new image to the smile.png file
                    ImageIO.write(image, "png", theFile);

                }
                //closes the fileReader
                fileReader.close();
            }

        }
        //catches IOException
        catch (IOException e)
        {
            System.out.println("This file couldn't be found.");
        }


    }

}