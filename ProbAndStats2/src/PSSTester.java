import java.io.FileNotFoundException;

public class PSSTester {

	public static void main(String[] args) throws FileNotFoundException{
		
		Plotter test = new Plotter(0, 0);
		
		test.data(-15, 15, 1);
		
		Salter.salt(29);
		
		Smoother.smooth(2, 4);
		

	}

}
