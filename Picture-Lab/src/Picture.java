import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
	{
  /**
   * Constructor that takes no arguments 
   */
	public Picture ()
		{
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
		super();  
		}
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
	public Picture(String fileName)
		{
    // let the parent class handle this fileName
		super(fileName);
		}
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
	public Picture(int height, int width)
		{
    // let the parent class handle this width and height
		super(width,height);
		}
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
	public Picture(Picture copyPicture)
		{
    // let the parent class do the copy
		super(copyPicture);
		}
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
	public Picture(BufferedImage image)
		{
		super(image);
		}
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
	public String toString()
		{
	    String output = "Picture, filename " + getFileName() + 
	      " height " + getHeight() 
	      + " width " + getWidth();
	    return output; 
		}
  /** Method to set the blue to 0 */
	public void zeroBlue()
		{
	    Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    	{
	    	for (Pixel pixelObj : rowArray)
	    		{
	    		pixelObj.setBlue(0);
	    		}
	    	}
		}
	//Method to only keep blue, set red and green to zero
	public void keepOnlyBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setRed(0);
				pixelObj.setGreen(0);
			}
		}
	}
	//Method to negate the image (set each value to 255 minus the current value)
	public void negate() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setRed(255 - pixelObj.getRed());
				pixelObj.setGreen(255 - pixelObj.getGreen());
				pixelObj.setBlue(255 - pixelObj.getBlue());
			}
		}
	}
	//Method to convert image to grayscale (add all values and divide by three)
	public void grayscale() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				int avg = 0;
				avg += (pixelObj.getRed() + pixelObj.getGreen()+ pixelObj.getBlue());
				avg = avg / 3;
				pixelObj.setRed(avg);
				pixelObj.setGreen(avg);
				pixelObj.setBlue(avg);
			}
		}
	}
	//Method to make the fish easier to see in the "water.jpg" image
	public void fixUnderwater() {
		//up blue, down green
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				if (pixelObj.getGreen() > 190 && pixelObj.getBlue() < 120) {
					pixelObj.setGreen(pixelObj.getGreen() - 80);
				}
				else if (pixelObj.getBlue() > 170) {
					pixelObj.setBlue(pixelObj.getBlue() + 80);
				}
			}
		}
	}
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
	public void mirrorVertical()
		{
	    Pixel[][] pixels = this.getPixels2D();
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    int width = pixels[0].length;
	    for (int row = 0; row < pixels.length; row++)
	    	{
	    	for (int col = 0; col < width / 2; col++)
	    		{
		        leftPixel = pixels[row][col];
		        rightPixel = pixels[row][width - 1 - col];
		        rightPixel.setColor(leftPixel.getColor());
	    		}
	    	} 
		}
	//mirror vertically, but from right to left
	public void mirrorVerticalRightToLeft() {
		Pixel[][] pixels = this.getPixels2D();
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    int width = pixels[0].length;
		int height = pixels.length;
	    for (int row = 0; row < height; row++) {
	    	for (int col = width-1; col > width / 2; col--) {
		        leftPixel = pixels[row][col];
		        rightPixel = pixels[row][width - 1 - col];
		        rightPixel.setColor(leftPixel.getColor());
			}
		}
	}
	//mirror horizontally
	public void mirrorHorizontal() {
		Pixel[][] pixels = this.getPixels2D();
	    Pixel topPixel = null;
	    Pixel bottomPixel = null;
	    int width = pixels[0].length;
		int height = pixels.length;
	    for (int row = 0; row < height/2; row++) {
	    	for (int col = 0; col < width; col++) {
		        topPixel = pixels[row][col];
		        bottomPixel = pixels[height - row - 1][col];
		        bottomPixel.setColor(topPixel.getColor());
			}
		}
	}
	public void mirrorHorizontalBotToTop() {
		Pixel[][] pixels = this.getPixels2D();
	    Pixel topPixel = null;
	    Pixel bottomPixel = null;
	    int width = pixels[0].length;
		int height = pixels.length;
	    for (int row = height-1; row > height/2; row--) {
	    	for (int col = 0; col < width; col++) {
		        topPixel = pixels[row][col];
		        bottomPixel = pixels[height - row - 1][col];
		        bottomPixel.setColor(topPixel.getColor());
			}
		}
	}
	public void mirrorDiagonal() {
		//the diagonal line is when row = col
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
	    Pixel bottomPixel = null;
	    int width = pixels[0].length;
		int height = pixels.length;
		int col = 0;
	    for (int row = 0; row < height; row++) {
			try {
				col = row;
				// linePixel = pixels[row][col];
				for (int i = 0; i < col; i++) {
					bottomPixel = pixels[row][i];
					topPixel = pixels[i][col];
					topPixel.setColor(bottomPixel.getColor());
				}
			}
			catch (IndexOutOfBoundsException e) {
				e.printStackTrace();
				System.out.println("out of bounds");
				break;
			}
		}
	}
  /** Mirror just part of a picture of a temple */
	public void mirrorTemple()
		{
	    int mirrorPoint = 276;
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    int count = 0;
	    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
	    for (int row = 27; row < 97; row++)
	    	{
      // loop from 13 to just before the mirror point
	    	for (int col = 13; col < mirrorPoint; col++)
	    		{
		        leftPixel = pixels[row][col];      
		        rightPixel = pixels[row]                       
		                         [mirrorPoint - col + mirrorPoint];
		        rightPixel.setColor(leftPixel.getColor());
	    		}
	    	}
		}
	//mirror snowman arms to make a snowman with four arms
	public void mirrorArms() {
		//(row,col) mirror (160, 110) to (190, 170) and (160, 285) to (190, 245) both horizontally
		//SIMPLER: (row,col) mirror (160,110) to (190, 290) around a mirror placed horizontally
		Pixel[][] pixels = this.getPixels2D();
	    Pixel topPixel = null;
	    Pixel bottomPixel = null;
	    int width = pixels[0].length;
		int height = pixels.length;
	    for (int row = 165; row <= 190; row++) {
	    	for (int col = 110; col <= 290; col++) {
		        topPixel = pixels[row][col];
		        bottomPixel = pixels[height-(row-90)][col];
		        bottomPixel.setColor(topPixel.getColor());
			}
		}
	}
	//mirror seagulls picture to make two seagulls on the beach next to each other
	public void mirrorGull() {
		//(row, col) mirror (235, 235) to (325, 345) vertically
		Pixel[][] pixels = this.getPixels2D();
		Pixel[][] birdPixels = new Pixel[90][110];
	    int width = pixels[0].length;
		int height = pixels.length;
	    for (int row = 235; row < 325; row++) {
	    	for (int col = 235; col < 345; col++) {
		        birdPixels[row-235][col-235] = pixels[row][col];
			}
		}
		for (int row = 0; row < birdPixels.length; row++) {
			for (int col = 0; col < birdPixels[row].length; col++) {
				pixels[row+255][col+350].setColor(birdPixels[row][col].getColor());
			}
		}
	}
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
	public void copy(Picture fromPic, int startRow, int startCol)
		{
	    Pixel fromPixel = null;
	    Pixel toPixel = null;
	    Pixel[][] toPixels = this.getPixels2D();
	    Pixel[][] fromPixels = fromPic.getPixels2D();
	    for (int fromRow = 0, toRow = startRow; 
	         fromRow < fromPixels.length &&
	         toRow < toPixels.length; 
	         fromRow++, toRow++)
	    	{
		      for (int fromCol = 0, toCol = startCol; 
		           fromCol < fromPixels[0].length &&
		           toCol < toPixels[0].length;  
		           fromCol++, toCol++)
		    	  {
			        fromPixel = fromPixels[fromRow][fromCol];
			        toPixel = toPixels[toRow][toCol];
			        toPixel.setColor(fromPixel.getColor());
		    	  }
	    	}   
		}

  /** Method to create a collage of several pictures */
	public void createCollage()
		{
	    Picture flower1 = new Picture("flower1.jpg");
	    Picture flower2 = new Picture("flower2.jpg");
	    this.copy(flower1,0,0);
	    this.copy(flower2,100,0);
	    this.copy(flower1,200,0);
	    Picture flowerNoBlue = new Picture(flower2);
	    flowerNoBlue.zeroBlue();
	    this.copy(flowerNoBlue,300,0);
	    this.copy(flower1,400,0);
	    this.copy(flower2,500,0);
	    this.mirrorVertical();
	    this.write("collage.jpg");
		}
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
	public void edgeDetection(int edgeDist)
		{
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    Pixel[][] pixels = this.getPixels2D();
	    Color rightColor = null;
	    for (int row = 0; row < pixels.length; row++)
	    	{
	    	for (int col = 0; col < pixels[0].length-1; col++)
	    		{
		        leftPixel = pixels[row][col];
		        rightPixel = pixels[row][col+1];
		        rightColor = rightPixel.getColor();
		        if (leftPixel.colorDistance(rightColor) > 
		            edgeDist)
		        		leftPixel.setColor(Color.BLACK);
		        else
		        	leftPixel.setColor(Color.WHITE);
	    		}
	    	}
		}
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
	public static void main(String[] args) 
		{
			// PictureTester.testKeepOnlyBlue(); //A5 Ex.3
			// PictureTester.testNegate(); //A5 Ex.4
			// PictureTester.testGrayscale(); //A5 Ex.5
			// PictureTester.testFixUnderwater(); //A5 Ex.6
			// PictureTester.testMirrorVerticalRightToLeft(); //A6 Ex.1
			// PictureTester.testMirrorHorizontal(); //A6 Ex.2
			// PictureTester.testMirrorHorizontalBotToTop(); //A6 Ex.3
			// PictureTester.testMirrorDiagonal(); //A6 Ex.4
			// PictureTester.testMirrorArms(); //A7 Ex.2
			// PictureTester.testMirrorGull(); //A7 Ex.3
		}
	} // this } is the end of class Picture, put all new methods before this
