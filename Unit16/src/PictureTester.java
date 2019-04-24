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
    Picture beach = new Picture("C:\\Users\\glicka0192\\Documents\\GitHub\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  /** Method to test keepOnlyBlue */
  public static void testKeepOnlyBlue()
  {
    Picture beach = new Picture("C:\\Users\\glicka0192\\Documents\\GitHub\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\beach.jpg");
    beach.explore();
    beach.keepOnlyBlue();
    beach.explore();
  }
  /** Method to test keepOnlyRed */
  public static void testKeepOnlyRed()
  {
    Picture beach = new Picture("C:\\Users\\glicka0192\\Documents\\GitHub\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\beach.jpg");
    beach.explore();
    beach.keepOnlyRed();
    beach.explore();
  }
  /** Method to test keepOnlyGreen */
  public static void testKeepOnlyGreen()
  {
    Picture beach = new Picture("C:\\Users\\glicka0192\\Documents\\GitHub\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\beach.jpg");
    beach.explore();
    beach.keepOnlyGreen();
    beach.explore();
  }
  /** Method to test testFixUnderWater */
  public static void testFixUnderwater() {
	  Picture water = new Picture("C:\\Users\\glicka0192\\Documents\\GitHub\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\water.jpg");
	  water.explore();
	  water.fixUnderWater();
	  water.explore();
  }
  /** Method to test testGrayScale */
  public static void testGrayscale()
  {
    Picture beach = new Picture("C:\\Users\\glicka0192\\Documents\\GitHub\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\beach.jpg");
    beach.explore();
    beach.grayScale();
    beach.explore();
  }
  /** Method to test testNegate */
  public static void testNegate()
  {
    Picture beach = new Picture("C:\\Users\\glicka0192\\Documents\\GitHub\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\beach.jpg");
    beach.explore();
    beach.negative();
    beach.explore();
  }
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("C:\\Users\\glicka0192\\Documents\\GitHub\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }

  public static void testRightToLeft()
  {
    Picture redCycle = new Picture("C:\\Users\\AaronTheNerd\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\redMotorcycle.jpg");
    redCycle.explore();
    redCycle.RightToLeft();
    redCycle.explore();
  }
  
  public static void testBotToTop()
  {
    Picture redCycle = new Picture("C:\\Users\\AaronTheNerd\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\redMotorcycle.jpg");
    redCycle.explore();
    redCycle.botToTop();
    redCycle.explore();
  }
  public static void testMirrorDiagnol()
  {
    Picture beach = new Picture("C:\\Users\\AaronTheNerd\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\beach.jpg");
    beach.explore();
    beach.mirrorDiagonal();
    beach.explore();
  }
  /** Method to test mirrorHorizontal */
  public static void testMirrorHorizontal()
  {
    Picture caterpillar = new Picture("C:\\Users\\glicka0192\\Documents\\GitHub\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontal();
    caterpillar.explore();
  }
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("C:\\Users\\glicka0192\\Documents\\GitHub\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  /** Method to test mirrorArms*/
  public static void testMirrorArms() {
	  Picture snowman = new Picture("C:\\Users\\AaronTheNerd\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\snowman.jpg");
	  snowman.explore();
	  snowman.mirrorArms();
	  snowman.explore();
  }
  /** Method to test mirrorGull*/
  public static void testMirrorGull() {
	  Picture gull = new Picture("C:\\Users\\AaronTheNerd\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\seagull.jpg");
	  gull.explore();
	  gull.mirrorGull();
	  gull.explore();
  }
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("C:\\Users\\glicka0192\\Documents\\GitHub\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  public static void testCopy(){
	  Picture copy =new Picture("C:\\Users\\AaronTheNerd\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\640x480.jpg");
	  Picture copied = new Picture("C:\\Users\\AaronTheNerd\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\snowman.jpg");
	  copy.explore();
	  copy.copy(copied, 72, 120);
	  copy.explore();
  }
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("C:\\Users\\glicka0192\\Documents\\GitHub\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\swan.jpg");
    swan.explore();
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
    //testZeroBlue(); 	//done
    //testKeepOnlyBlue();	//done
    //testKeepOnlyRed();	//done
    //testKeepOnlyGreen();	//done
    //testNegate();		//done
    //testGrayscale();	//done
    //testFixUnderwater();	//done
    //testMirrorVertical(); //done
	//testRightToLeft();	//done
	//testMirrorHorizontal(); //done
	//testBotToTop();		//done
	//testMirrorDiagnol();	//done
    //testMirrorTemple();		//done
	//testMirrorArms();		//done
    //testMirrorGull();		//done
    //testCollage();		//done
    testCopy();
    //testEdgeDetection();	//done
    
    //don't worry about anything after this point
    
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}