import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
	///////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public Picture() {
		/*
		 * not needed but use it to show students the implicit call to super()
		 * child constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName
	 *            the name of the file to create the picture from
	 */
	public Picture(String fileName) {
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param height
	 *            the height of the desired picture
	 * @param width
	 *            the width of the desired picture
	 */
	public Picture(int height, int width) {
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 * 
	 * @param copyPicture
	 *            the picture to copy
	 */
	public Picture(Picture copyPicture) {
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image
	 *            the buffered image to use
	 */
	public Picture(BufferedImage image) {
		super(image);
	}

	////////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName,
	 *         height and width.
	 */
	public String toString() {
		String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
		return output;

	}

	public void encode(Picture messagePict) {
		Random seedGenerator = new Random();
		int seed = seedGenerator.nextInt(16);
		encodeSeed(seed);
		Random rand = new Random(seed);
		Pixel[][] messagePixels = messagePict.getPixels2D();
		Pixel[][] currentPixels = this.getPixels2D();
		int openSpacesLeft = messagePixels.length * messagePixels[0].length;
		boolean spacesMap[] = new boolean[openSpacesLeft];
		java.util.Arrays.fill(spacesMap, false);
		for (int x = 0; x < messagePixels.length; x++) {
			for (int y = 0; y < messagePixels[x].length; y++) {
				int tempIndex = rand.nextInt(openSpacesLeft);
				int index = tempIndex;
				for (int i = 0; i < spacesMap.length; i++) {
					if (!spacesMap[i]) {
						tempIndex--;
						if(tempIndex == 0){
							index=i;
						}
					}
				}
				
				spacesMap[index] = true;
				int encodingPosY = index / messagePixels.length;
				int encodingPosX = index % messagePixels.length;
				openSpacesLeft--;
				// changing the blue values now
				Pixel currPixel = null;
				Pixel messagePixel = null;
				currPixel = currentPixels[encodingPosX][encodingPosY];
				if (currPixel.getBlue() % 2 == 1){
					currPixel.setBlue(currPixel.getBlue() - 1);
				}
				messagePixel = messagePixels[x][y];
				if (messagePixel.colorDistance(Color.BLACK) < 50){
					currPixel.setBlue(currPixel.getRed() + 1);
				}
				
			}
			if(x % 20 == 0)System.out.println("Progress " + (1.0- (double) openSpacesLeft / (double)(messagePixels.length * messagePixels[0].length)) * 100.0 + "%");
		}
	}

	public Picture decode() {
		int seed = getSeed();
		Random rand = new Random(seed);
		Picture messagePicture = new Picture(this.getHeight(), this.getWidth());
		Pixel[][] messagePixels = messagePicture.getPixels2D();
		int openSpacesLeft = messagePixels.length * messagePixels[0].length;
		boolean spacesMap[] = new boolean[openSpacesLeft];
		java.util.Arrays.fill(spacesMap, false);
		for (int x = 0; x < messagePixels.length; x++) {
			for (int y = 0; y < messagePixels[x].length; y++) {
				int tempIndex = rand.nextInt(openSpacesLeft);
				int index = tempIndex;
				for (int i = 0; i < spacesMap.length; i++) {
					if (!spacesMap[i]) {
						tempIndex--;
						if(tempIndex == 0){
							index=i;
						}
					}
				}
				spacesMap[index] = true;
				int encodingPosY = index / messagePixels.length;
				int encodingPosX = index - (messagePixels.length * encodingPosY);
				openSpacesLeft--;
				// extracting the blue values now
				Pixel[][] currentPixels = this.getPixels2D();
				//messagePixels[x][y] = currentPixels[encodingPosX][encodingPosY];
				if (currentPixels[encodingPosX][encodingPosY].getBlue() % 2 == 0) {
					messagePixels[x][y].setColor(Color.BLACK);
				}
				else{
					messagePixels[x][y].setColor(Color.WHITE);
					
				}
			}
			if(x % 20 == 0)System.out.println("Progress " + (1.0 - (double) openSpacesLeft / (double)(messagePixels.length * messagePixels[0].length)) * 100.0 + "%");
		}
		return messagePicture;
	}

	public int getSeed() {
		Pixel[][] pixels = this.getPixels2D();
		int seedTotal = 0;
		if (pixels[0][0].getBlue() % 2 == 1) {
			seedTotal += 8;
		}
		if (pixels[pixels.length - 1][0].getBlue() % 2 == 1) {
			seedTotal += 4;
		}
		if (pixels[pixels.length - 1][pixels[0].length - 1].getBlue() % 2 == 1) {
			seedTotal += 2;
		}
		if (pixels[0][pixels[0].length - 1].getBlue() % 2 == 1) {
			seedTotal += 1;
		}
		return seedTotal;
	}

	public void encodeSeed(int seed) {
		String binary = Integer.toBinaryString(seed);
		String paddingZeros = "";
		for (int i = 0; i < 4 - binary.length(); i++) {
			paddingZeros += "0";
		}
		binary = paddingZeros + binary;
		boolean topLeft = binary.substring(0, 1).equals("1");
		boolean topRight = binary.substring(1, 2).equals("1");
		boolean BottomRight = binary.substring(2, 3).equals("1");
		boolean BottomLeft = binary.substring(3, 4).equals("1");
		Pixel[][] currentPixels = this.getPixels2D();
		if (currentPixels[0][0].getBlue() % 2 == 1) {
			currentPixels[0][0].setBlue(currentPixels[0][0].getBlue() + 1);
		}
		if (currentPixels[currentPixels.length - 1][0].getBlue() % 2 == 1) {
			currentPixels[currentPixels.length - 1][0]
					.setBlue(currentPixels[currentPixels.length - 1][0].getBlue() + 1);
		}
		if (currentPixels[currentPixels.length - 1][currentPixels[0].length - 1].getBlue() % 2 == 1) {
			currentPixels[currentPixels.length - 1][currentPixels[0].length - 1]
					.setBlue(currentPixels[currentPixels.length - 1][currentPixels[0].length - 1].getBlue() + 1);
		}
		if (currentPixels[0][currentPixels[0].length - 1].getBlue() % 2 == 1) {
			currentPixels[0][currentPixels[0].length - 1]
					.setBlue(currentPixels[0][currentPixels[0].length - 1].getBlue() + 1);
		}
		if (topLeft) {
			currentPixels[0][0].setBlue(currentPixels[0][0].getBlue() + 1);
		}
		if (topRight) {
			currentPixels[currentPixels.length - 1][0]
					.setBlue(currentPixels[currentPixels.length - 1][0].getBlue() + 1);
		}
		if (BottomRight) {
			currentPixels[currentPixels.length - 1][currentPixels[0].length - 1]
					.setBlue(currentPixels[currentPixels.length - 1][currentPixels[0].length - 1].getBlue() + 1);
		}
		if (BottomLeft) {
			currentPixels[0][currentPixels[0].length - 1]
					.setBlue(currentPixels[0][currentPixels[0].length - 1].getBlue() + 1);
		}
	}

	public void encodeOG(Picture messagePict) {
		Pixel[][] messagePixels = messagePict.getPixels2D();
		Pixel[][] currPixels = this.getPixels2D();
		Pixel currPixel = null;
		Pixel messagePixel = null;
		int count = 0;
		for (int row = 0; row < this.getHeight(); row++) {
			for (int col = 0; col < this.getWidth(); col++) {
				// if the current pixel red is odd make it even
				currPixel = currPixels[row][col];
				if (currPixel.getRed() % 2 == 1)
					currPixel.setRed(currPixel.getRed() - 1);
				messagePixel = messagePixels[row][col];
				if (messagePixel.colorDistance(Color.BLACK) < 50) {
					currPixel.setRed(currPixel.getRed() + 1);
					count++;
				}
			}
		}
		System.out.println(count);
	}

	public Picture decodeOG() {
		Pixel[][] pixels = this.getPixels2D();
		int height = this.getHeight();
		int width = this.getWidth();
		Pixel currPixel = null;

		Pixel messagePixel = null;
		Picture messagePicture = new Picture(height, width);
		Pixel[][] messagePixels = messagePicture.getPixels2D();
		int count = 0;
		for (int row = 0; row < this.getHeight(); row++) {
			for (int col = 0; col < this.getWidth(); col++) {
				currPixel = pixels[row][col];
				messagePixel = messagePixels[row][col];
				if (currPixel.getRed() % 2 == 1) {
					messagePixel.setColor(Color.BLACK);
					count++;
				}
			}
		}
		System.out.println(count);
		return messagePicture;
	}

	/** Method to set the blue to 0 */
	public void zeroBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setBlue(0);
			}
		}
	}

	/**
	 * Method that mirrors the picture around a vertical mirror in the center of
	 * the picture from left to right
	 */
	public void mirrorVertical() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	public void RightToLeft() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = width - 1; col > width / 2; col--) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	public void mirrorHorizontal() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		int height = pixels.length;
		for (int row = 0; row < height / 2; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				topPixel = pixels[row][col];
				bottomPixel = pixels[height - 1 - row][col];
				bottomPixel.setColor(topPixel.getColor());
			}
		}
	}

	public void botToTop() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		int height = pixels.length;
		for (int row = height - 1; row > height / 2; row--) {
			for (int col = 0; col < pixels[0].length; col++) {
				topPixel = pixels[row][col];
				bottomPixel = pixels[height - 1 - row][col];
				bottomPixel.setColor(topPixel.getColor());
			}
		}
	}

	public void mirrorDiagonal() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int height = pixels.length;
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < row; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[col][row];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	/** Mirror just part of a picture of a temple */
	public void mirrorTemple() {
		int mirrorPoint = 276;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int count = 0;
		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 27; row < 97; row++) {
			// loop from 13 to just before the mirror point
			for (int col = 13; col < mirrorPoint; col++) {

				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	public void mirrorArms() {
		int mirrorPoint = 194;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		for (int row = 163; row < mirrorPoint; row++) {
			for (int col = 103; col < 291; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[mirrorPoint - row + mirrorPoint][col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	public void mirrorGull() {
		int mirrorPoint = 342;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		for (int row = 234; row < 321; row++) {
			for (int col = 239; col < mirrorPoint; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	/**
	 * copy from the passed fromPic to the specified startRow and startCol in
	 * the current picture
	 * 
	 * @param fromPic
	 *            the picture to copy from
	 * @param startRow
	 *            the start row to copy to
	 * @param startCol
	 *            the start col to copy to
	 */
	public void copy(Picture fromPic, int startRow, int startCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	public void copy2(Picture fromPic, int startRow, int startCol, int endRow, int endCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length && toRow < endRow; fromRow++, toRow++) {
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
					&& toCol < endCol; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	/** Method to create a collage of several pictures */
	public void createCollageOrignal() {
		Picture flower1 = new Picture(
				"C:\\Users\\glicka0192\\Documents\\GitHub\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\flower1.jpg");
		Picture flower2 = new Picture(
				"C:\\Users\\glicka0192\\Documents\\GitHub\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\flower2.jpg");
		this.copy(flower1, 0, 0);
		this.copy(flower2, 100, 0);
		this.copy(flower1, 200, 0);
		Picture flowerNoBlue = new Picture(flower2);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		this.copy(flower1, 400, 0);
		this.copy(flower2, 500, 0);
		this.mirrorVertical();
		this.write("C:\\Users\\glicka0192\\Documents\\GitHub\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\640x480.jpg");
	}

	public void createMyCollage() {
		Picture flower3 = new Picture(
				"C:\\Users\\glicka0192\\Documents\\GitHub\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\flower1.jpg");
		Picture flower4 = new Picture(
				"C:\\Users\\glicka0192\\Documents\\GitHub\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\flower2.jpg");
		this.copy(flower3, 0, 0);
		this.copy(flower4, 100, 0);
		this.copy(flower3, 200, 0);
		Picture flowerNoBlue = new Picture(flower4);
		Picture flowerGray = new Picture(flower3);
		flowerNoBlue.fixUnderWater();
		flowerGray.grayScale();
		Picture flowerKeepOnlyRed = new Picture(flower4);
		flowerKeepOnlyRed.keepOnlyRed();
		this.copy(flowerNoBlue, 300, 200);
		this.copy(flowerGray, 400, 300);
		this.copy(flowerKeepOnlyRed, 500, 400);
		this.mirrorVertical();
		this.write("C:\\Users\\glicka0192\\Documents\\GitHub\\Glick_Aaron_apcsa-p33\\Unit16\\src\\images\\640x480.jpg");
	}

	/**
	 * Method to show large changes in color
	 * 
	 * @param edgeDist
	 *            the distance for finding edges
	 */
	public void edgeDetection(int edgeDist) {
		Pixel mainPixel = null;
		Pixel rightPixel = null;
		Pixel bottomPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color mainColor = null;
		for (int row = 0; row < pixels.length - 1; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				mainPixel = pixels[row][col];
				rightPixel = pixels[row][col + 1];
				bottomPixel = pixels[row + 1][col];
				mainColor = mainPixel.getColor();
				if (rightPixel.colorDistance(mainColor) > edgeDist || bottomPixel.colorDistance(mainColor) > edgeDist)
					mainPixel.setColor(Color.BLACK);
				else
					mainPixel.setColor(Color.WHITE);
			}
		}
	}

	/*
	 * Main method for testing - each class in Java can have a main method
	 */
	public static void main(String[] args) {

	}

	public void keepOnlyBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel p : row) {
				p.setRed(0);
				p.setGreen(0);
			}
		}
	}

	public void keepOnlyRed() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel p : row) {
				p.setBlue(0);
				p.setGreen(0);
			}
		}
	}

	public void keepOnlyGreen() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel p : row) {
				p.setRed(0);
				p.setBlue(0);
			}
		}
	}

	public void fixUnderWater() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel p : row) {
				p.setBlue(p.getBlue() - 60);
				p.setGreen(p.getGreen() - 60);
				p.setRed(p.getRed() + 60);
			}
		}
	}

	public void grayScale() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel p : row) {
				int greenval = p.getGreen();
				p.setRed(greenval);
				p.setBlue(greenval);
			}
		}
	}

	public void negative() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel p : row) {
				p.setRed(255 - p.getRed());
				p.setGreen(255 - p.getGreen());
				p.setBlue(255 - p.getBlue());
			}
		}
	}

} // this } is the end of class Picture, put all new methods before this
