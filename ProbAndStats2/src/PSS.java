import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PSS {
	
	private int x;
	private int y;

	PSS(int xVal, int yVal) {
		
		x = xVal;
		y = yVal;
		
	}
	
	public int getX() {
		
		return x;
	}
	
	public int getY() {
		
		return y;
	}
	
	public static void data(int min, int max, int range) throws FileNotFoundException{
		
		ArrayList<PSS> plot = new ArrayList<PSS>();
		
		int x = 0;
		int y = 0;
		
		for(int i = min; i <= max; i = i + range) {
			
			if (i == min) {
				
				x = min;
				
			}
			else {
				
				x += range;
				
			}
			
			y = 2 * x + 3;
			
			plot.add(new PSS(x, y));
		}
		
		File csv = new File("Graph.csv");
		PrintWriter out = new PrintWriter(csv);
		
		for (PSS graph :plot) {
			
			out.printf("%d, %d\n", graph.getX(), graph.getY());
		}
		
		out.close();
	}
	
	
	
}
