import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {

        String name= "C:\\Users\\mcrossley\\Desktop\\images\\myImage.png";
        File file= new File(name);
        BufferedImage img = ImageIO.read(file);
        Color whiteCol = new Color (255, 255, 255);

        int height=img.getHeight();
        int width=img.getWidth();
        int pixel,red,green,blue;
        String asBinary;
        int max=0;
        int whitePix = ((255)<<16) | (255<<8) | 255;
        int blackPix = 0;
        int newGreen,newBlue,newRed;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixel = img.getRGB(x,y);
                Color color = new Color(pixel, true);
                red = color.getRed();
                String redBin = Integer.toString(red,2);
                green = color.getGreen();
                String greenBin = Integer.toString(green,2);
                blue = color.getBlue();
                String blueBin = Integer.toString(blue,2);
                if(redBin.charAt(redBin.length()-1)=='1'){
                    newRed=255;
                }else{
                    newRed=0;
                }
                if(greenBin.charAt(greenBin.length()-1)=='1'){
                    newGreen=255;
                }else{
                    newGreen=0;
                }
                if(blueBin.charAt(blueBin.length()-1)=='1'){
                    newBlue=255;
                }else{
                    newBlue=0;
                }

                pixel =((newRed)<<16) | (newGreen<<8) | newBlue;
                img.setRGB(x, y, pixel);

            }
        }
        System.out.println(max);
        File outPutImage = new File("C:\\Users\\mcrossley\\Desktop\\images\\LSBimage.png");
        ImageIO.write(img, "png", outPutImage);


    }
}
