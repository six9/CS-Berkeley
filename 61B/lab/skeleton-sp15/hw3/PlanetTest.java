import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class PlanetTest {
	@Test
	public void testComparator() {
		Planet mars = new Planet(10, 10, 23, 17, 50, "Mars.png", 1000);
		Planet earth = new Planet(5, 5, 15, 12, 120, "Earth.png", 2000);
		Planet venus = new Planet(3, 3, 12, 8, 150, "Venus.png", 1800);

		Planet[] planets = new Planet[]{mars, earth, venus};
		MassComparator massComparator = new MassComparator();
		RadiusComparator radiusComparator = new RadiusComparator();

		Arrays.sort(planets, massComparator);
		System.out.println("Sorted by mass:");
		System.out.println(Arrays.toString(planets));

		Arrays.sort(planets, radiusComparator);
		System.out.println("Sorted by radius:");
		System.out.println(Arrays.toString(planets));
	}

	public static void main(String[] args) {
		jh61b.junit.textui.runClasses(PlanetTest.class);
	}
}