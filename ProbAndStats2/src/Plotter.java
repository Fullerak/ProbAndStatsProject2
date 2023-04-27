import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Plotter {
	
	private int x;
	private int y;

	Plotter(int xVal, int yVal) {
		
		x = xVal;
		y = yVal;
		
	}
	
	public int getX() {
		
		return x;
	}
	
	public int getY() {
		
		return y;
	}
	
	public int printMethod(ArrayList<Plotter> plot) {
		for(int i=0;i<plot.size();i++) {
			System.out.println(plot.indexOf(i));
		}
		return 0;
	}
	
	public static void data(int min, int max, int range) throws FileNotFoundException{
		
		ArrayList<Plotter> plot = new ArrayList<Plotter>();
		
		int xPoint = 0;
		int yPoint = 0;
		
		for(int i = min; i <= max; i = i + range) {
			
			if (i == min) {
				
				xPoint = min;
				
			}
			else {
				
				xPoint += range;
				
			}
			
			yPoint = (int) (Math.pow(xPoint, 2) + 3);
			
			plot.add(new Plotter(xPoint, yPoint));
		}
		
		for (Plotter graph :plot) {
			
			System.out.println(graph.getX() + graph.getY());
		}
		
		File csv = new File("Graph.csv");
		PrintWriter out = new PrintWriter(csv);
		
		for (Plotter graph :plot) {
			
			out.printf("%d, %d\n", graph.getX(), graph.getY());
		}
		
		out.close();
	}
	
}


