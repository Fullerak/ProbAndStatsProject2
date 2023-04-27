import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Smoother {


	public static void smooth(int num, int repeat) {
		
		//assigning variables to my file and temp
		String file = "C:\\Users\\Kaden\\git\\ProbAndStatsProject2\\ProbAndStats2\\SaltedGraph.csv";
		BufferedReader reader = null;
		String line;
		int temp = 0;
		int count = 0;
		
		try
		{
		//making a new csv for the smoother graph
			File smoothed = new File("SmoothedGraph.csv");
			PrintWriter out = new PrintWriter(smoothed);
			reader = new BufferedReader(new FileReader(file));
			
			//keeping the row for each so we can grab the values split and smooth y
			ArrayList<Integer> arr = new ArrayList<Integer>();
			String[] row;
			
			while((line = reader.readLine()) !=null) {
				row=line.split(",");
				for(int i = 0; i<row.length;i++) {
					arr.add(Integer.valueOf(row[i].trim()));
				}
			}
			//determines how many times the logic is run, even though this is inefficient it is all i could think of at the time
			for(int i = 0; i<repeat;i++) {
				for(int j=1; j<arr.size();j+=2) {
					for(int k=j-(num*2);k <= j + (num*2);k+=2) {
						
						if(!(k<0 || k > arr.size())) {
							temp+=arr.get(k);
							count++;
						}
					}
						arr.set(j, (temp/count));
						temp = 0;
						count = 0;

				}
				
			}
			//outputting into the csv by points
			for(int i = 0; i < arr.size(); i+=2)
			{
				out.printf("%d, %d\n", arr.get(i), arr.get(i+1));
			}
			
			out.close();
		}
		catch(Exception e) {
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
