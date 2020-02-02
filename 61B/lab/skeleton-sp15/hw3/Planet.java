public class Planet {
	private double x;
	private double y;
	private double xVelocity;
	private double yVelocity;
	private double mass;
	private String img;

	private double xNetForce;
	private double yNetForce;

	private double xAccel;
	private double yAccel;

	private double radius;

	public Planet(double x, double y, double xVelocity, double yVelocity,
	 double mass, String img, double radius) {
		this.x = x;
		this.y = y;
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
		this.mass = mass;
		this.img = img;
		this.radius = radius;
	}

	public double calcDistance(Planet planet) {
		double xp = planet.x;
		double yp = planet.y;
		return Math.sqrt((xp - x) * (xp - x) + (yp - y) * (yp - y));
	}

	public double calcPairwiseForce(Planet planet) {
		double G = 6.67E-11;
		double dist = calcDistance(planet);
		return G * planet.mass * mass / (dist * dist); 
	}

	public double calcPairwiseForceX(Planet planet) {
		return calcPairwiseForce(planet) * (planet.x - x) / calcDistance(planet);
	}

	public double calcPairwiseForceY(Planet planet) {
		return calcPairwiseForce(planet) * (planet.y - y) / calcDistance(planet);
	}
 
	public void setNetForce(Planet[] planets) {
		xNetForce = 0;
		yNetForce = 0;
		for (int i = 0; i < planets.length; i++) {
			if (planets[i] != this) {
				xNetForce += calcPairwiseForceX(planets[i]);
				yNetForce += calcPairwiseForceY(planets[i]);
			}
		}
	}

	public void draw() {
		StdDraw.picture(x, y, img);
	}

	public void update(double dt) {
		// setNetForce(this);
		xAccel = xNetForce / mass;
		yAccel = yNetForce / mass;
		xVelocity += xAccel * dt;
		yVelocity += yAccel * dt;
		x += xVelocity * dt;
		y += yVelocity * dt;
	}

	public double getMass() {
		return mass;
	}

	public double getRadius() {
		return radius;
	}
}