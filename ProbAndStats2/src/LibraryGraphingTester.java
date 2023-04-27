//https://www.tutorialspoint.com/jfreechart/jfreechart_xy_chart.htm
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.jfree.ui.RefineryUtilities;

public class LibraryGraphingTester {

	public static void main(String[] args) throws FileNotFoundException {
		
		LibraryGraphing test = new LibraryGraphing("Window", "Graph");
		LibrarySalting salt = new LibrarySalting("Window", "Graph");
		
		test.pack();
		salt.pack();
		
		RefineryUtilities.positionFrameOnScreen(test, 0.5, 0.0);
		RefineryUtilities.positionFrameOnScreen(salt, 0.5, 0.5);
		
		test.setVisible(true);
		salt.setVisible(true);
		
	}

}
