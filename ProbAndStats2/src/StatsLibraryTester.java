
public class StatsLibraryTester {

	public static void main(String[] args) {
		
		StatsLibrary test = new StatsLibrary();
		
		System.out.println("The hypergeomteric distribution for the given numbers is = " + test.hyperGeo(20, 10, 3));
		
		System.out.println("Tchevysheffs theorem = " + test.tchebysheffThm(3));
		
		System.out.println("The poisson distribution for the given values is = " + test.poissonDist(2, 1));

	}

}
