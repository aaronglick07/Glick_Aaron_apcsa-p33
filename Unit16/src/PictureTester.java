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
    Picture caterpillar = new Picture("C:\\Users\\glicka0192\\Documents\\GitHub\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\caterpiller.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  /** Method to test mirrorHorizontal */
  public static void testMirrorHorizontal()
  {
    Picture caterpillar = new Picture("C:\\Users\\glicka0192\\Documents\\GitHub\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\caterpiller.jpg");
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
 
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("C:\\Users\\glicka0192\\Documents\\GitHub\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\640x480.jpg");
    canvas.createCollage();
    canvas.explore();
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
    testZeroBlue(); 	//done
    testKeepOnlyBlue();	//done
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    testNegate();		//done
    testGrayscale();	//done
    //testFixUnderwater();
    testMirrorVertical(); //done
	testMirrorHorizontal(); //done
    testMirrorTemple();		//done
	//testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    testCollage();		//done
    //testCopy();
    testEdgeDetection();	//done
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}