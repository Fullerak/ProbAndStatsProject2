import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Salter {

	public static void salt(int maxVal) {
		
		//assigning variables to my file and temp
		String file = "C:\\Users\\Kaden\\git\\ProbAndStatsProject2\\ProbAndStats2\\Graph.csv";
		BufferedReader reader = null;
		String line;
		int temp;
		
		//try catch 
		try
		{
			//creating a new csv for the salted data
			File salted = new File("SaltedGraph.csv");
			PrintWriter out = new PrintWriter(salted);
			
			//creating instance of the reader
			reader = new BufferedReader(new FileReader(file));
			
			//storing all my plotted points
			ArrayList<Integer> arr = new ArrayList<Integer>();
			
			//as long as the row is not empty keep reading
			while((line = reader.readLine()) != null) 
			{
				//splitting the two points on each row
				String[] row = line.split(",");
			
				for (int i = 1; i < row.length; i += 2)
				{
					//salting the y values
					temp = Integer.valueOf(row[i].trim()) + ThreadLocalRandom.current().nextInt(-maxVal, maxVal+1);
					row[i] = String.valueOf(temp);
				}
				//using a temp array for point values
				for(int i = 0; i < row.length; i++)
				{
					arr.add(Integer.valueOf(row[i]));
				}
				out.printf("%d, %d\n", arr.get(0), arr.get(1));
				arr.removeAll(arr);
			}
			out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				reader.close();
			} 
			catch (IOException f)
			{
				f.printStackTrace();
			}
			
		}
		
		
	}
	
	
}
