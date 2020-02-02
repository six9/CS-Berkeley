package parkinglot;

public class Space {
	private int type;
	private double x;
	private double y;
	private Car car = null;

	public Space(int type, double x, double y) {
		this.type = type;
		this.x = x;
		this.y = y;
	}

	/* Get the type of this given parking space. 
	 * 0 = regular, 1 = compact, 2 = handicapped-only. */
	public int getType() {
		return type;
	}

	public boolean isFree() {
		return this.car == null;
	}

	public boolean park(Car car) {
		if (getType() == 0 && this.car == null) {
			this.car = car;
			return true;
		} else if (getType() == 1 && car.getType() == 1 && this.car == null) {
			this.car = car;
			return true;
		} else if (getType() == 2 && car.getType() == 2) {
			this.car = car;
			return true;
		} else {
			return false;
		}
	}

	public boolean leave() {
		this.car = null;
		return true;
	}

	private double calcDistance() {
		// Used in park() to get the distance between the entrance and parking space.
		return Math.sqrt(x * x + y * y);
	}
}