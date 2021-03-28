/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

  public static void testKeepOnlyBlue() {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.keepOnlyBlue(); //A5 Ex.3
    beach.explore();
  }

  public static void testNegate() {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.negate(); //A5 Ex.4
    beach.explore();
  }

  public static void testGrayscale() {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.grayscale(); //A5 Ex.5
    beach.explore();
  }

  public static void testFixUnderwater() {
    Picture water = new Picture("water.jpg");
    water.explore();
    water.fixUnderwater(); //A5 Ex.6
    water.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  public static void testMirrorVerticalRightToLeft() {
    Picture butterfly = new Picture("butterfly1.jpg");
    butterfly.explore();
    butterfly.mirrorVerticalRightToLeft(); //A6 Ex. 1
    butterfly.explore();
  }

  public static void testMirrorHorizontal() {
    Picture motorcycle = new Picture("redMotorcycle.jpg");
    motorcycle.explore();
    motorcycle.mirrorHorizontal(); //A6 Ex. 2
    motorcycle.explore();
  }

  public static void testMirrorHorizontalBotToTop() {
    Picture motorcycle = new Picture("redMotorcycle.jpg");
    motorcycle.explore();
    motorcycle.mirrorHorizontalBotToTop(); //A6 Ex. 3
    motorcycle.explore();
  }

  public static void testMirrorDiagonal() {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorDiagonal(); //A6 Ex. 4
    beach.explore();
  }

  public static void testMirrorArms() {
    Picture snowman = new Picture("snowman.jpg");
    snowman.explore();
    snowman.mirrorArms(); //A7 Ex.2
    snowman.explore();
  }

  public static void testMirrorGull() {
    Picture seagull = new Picture("seagull.jpg");
    seagull.explore();
    seagull.mirrorGull(); //A7 Ex.3
    seagull.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}