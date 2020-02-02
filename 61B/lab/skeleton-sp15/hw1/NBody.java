public class NBody {

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		In infile = new In(filename);
		int N = infile.readInt();
		double r = infile.readDouble();

		// some tests
		// System.out.println("T=" + T + ", dt=" + dt + ", file=" + filename);
		// System.out.println("N=" + N + ", r=" + r);

		Planet[] planets = new Planet[N];
		for (int i = 0; i < N; i++) {
			planets[i] = getPlanet(infile);
		}

		StdDraw.setXscale(-r, r);
		StdDraw.setYscale(-r, r);
		StdDraw.picture(0, 0, "images/starfield.jpg");

		for (int i = 0; i < N; i++) {
			StdDraw.picture(planets[i].x, planets[i].y, "images/" + planets[i].img);
		}

		double t = 0;
		while (t <= T) {
			StdDraw.picture(0, 0, "images/starfield.jpg");
			for (int i = 0; i < N; i++) {
				planets[i].setNetForce(planets);
				planets[i].update(dt);
				StdDraw.picture(planets[i].x, planets[i].y, "images/" + planets[i].img);
			}
			StdDraw.show(10);
			t += dt;
		}

		// StdAudio.loop("audio/2001.mid");

		StdOut.printf("%d\n", N);
		StdOut.printf("%.2e\n", r);
		for (int i = 0; i < N; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                   			planets[i].x, planets[i].y, planets[i].xVelocity,
                   			planets[i].yVelocity, planets[i].mass, planets[i].img);
			}
		}

	public static Planet getPlanet(In instream) {
		return new Planet(instream.readDouble(), instream.readDouble(),
		 instream.readDouble(), instream.readDouble(), instream.readDouble(),
		 instream.readString()); // x, y, xVelocity, yVelocity, mass, img
	}
}