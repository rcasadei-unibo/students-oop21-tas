package main.java.tas.utils;

/**
 * Class that models a dimension.
 */
public class Size {

	private double width;
	private double height;

	/**
	 * Constructor that set up a dimension by double values.
	 * 
	 * @param width  of the dimension.
	 * @param height of the dimension.
	 */
	public Size(double width, double height) {
		this.width = width;
		this.height = height;
	}

	/**
	 * Constructor that set up a dimension by integer values.
	 * 
	 * @param width  of the dimension.
	 * @param height of the dimension.
	 */
	public Size(int width, int height) {
		this.width = width;
		this.height = height;
	}

	/**
	 * @return the width of the dimension.
	 */
	public double getWidth() {
		return this.width;
	}

	/**
	 * @return the height of the dimension.
	 */
	public double getHeight() {
		return this.height;
	}
	
	/**
	 * Returns the diagonal of the rectangle described by Dimension
	 * 
	 * @return the diagonal described by the rectangle described by Dimension
	 */
	public double getDiagonal() {
		return Math.hypot(this.width, this.height) / 2;
	}

}
