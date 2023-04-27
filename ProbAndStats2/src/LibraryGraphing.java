//https://www.tutorialspoint.com/jfreechart/jfreechart_xy_chart.htm
import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.awt.BasicStroke; 

import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection; 
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class LibraryGraphing extends ApplicationFrame{
	
	private XYSeriesCollection dataset = new XYSeriesCollection();
	
	private XYSeries series = new XYSeries("data");
//
	public LibraryGraphing( String applicationTitle, String chartTitle ) throws FileNotFoundException {
	      super(applicationTitle);
	      JFreeChart plot = ChartFactory.createXYLineChart(chartTitle , "x" ,"y" ,createDataset() ,PlotOrientation.VERTICAL ,
	    		  true , true , false);
	      
	      ChartPanel chartPanel = new ChartPanel( plot );
	      chartPanel.setPreferredSize( new java.awt.Dimension( 600 , 300 ) );
	      final XYPlot xyPlot = plot.getXYPlot( );
	      
	      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
	      renderer.setSeriesPaint( 0 , Color.BLUE );
	      renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
	      xyPlot.setRenderer( renderer ); 
	      setContentPane( chartPanel ); 
	      


	}
	
	public XYDataset createDataset() throws FileNotFoundException{
		
		int min = -15;
		int max = 15;
		int range = 1;
		
		Plotter test = new Plotter(0, 0);
		
		test.data(min, max, range);
		
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
		
		addData(plot);
		
		dataset.addSeries(series);
		
		return dataset;
		
	}
	
	public void addData(ArrayList<Plotter> OGplot){
		
		//XYSeries series = new XYSeries("data");
		
		for (Plotter graph :OGplot) {
			
			series.add(graph.getX(),graph.getY());
		}
		
	}
	
	
	
}

