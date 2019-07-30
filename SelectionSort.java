import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import java.util.ArrayList;
import java.util.Random;
import java.awt.Graphics2D;

public class SelectionSort {
	
	
	private ArrayList<Rectangle> Bars;
	private Random rand;
	// firstIndex: This will be the beginning index for each iteration that the graph is searched (starts at 0)
	// comparisonIndex: This index will be what is compared to the firstIndex. If this index is smaller then they are switched
	private int firstIndex = 0, comparisonIndex = 0, smallest = 0;
	
	
	
	
	public SelectionSort()
	{
		// Used to set the bars apart
		int displacement = 1;
		Bars = new ArrayList<>();
		rand = new Random();
		// Adds a unique bar into the ArrayList (Note: It is sorted at this point)
		for(int i = 0; i < 100; i++)
		{
			Bars.add(new Rectangle (displacement,900-(i+1)*9, 15, (i+1)*9));
			displacement = displacement +17;
		}
		// This for loop scrambles everything in the ArrayList (Now it's unsorted)
		for(int i = 0; i < 100; i++)
		{
			int n = rand.nextInt(100);
			swap(Bars.get(i), Bars.get(n));
		}
	}
	
	
	public void sort() 
	{
		if(firstIndex < Bars.size()-1)
		{
			// The smallest Index we will assume is the firstIndex
			smallest = firstIndex;
			// The comparison index will begin as one after the FirstIndex
			comparisonIndex = firstIndex+1;
			// Travels through all the unsorted Bars and assigns the smallest if it exists
			for( ;comparisonIndex < Bars.size(); comparisonIndex++)
				if(Bars.get(comparisonIndex).getHeight() < Bars.get(smallest).getHeight())
				    smallest = comparisonIndex;
			
			// Swaps the smallest bar found with the first one 
			swap(Bars.get(firstIndex), Bars.get(smallest));
			firstIndex++;
		}

			
		
	}
	
	// Utility function for swapping bars
	public void swap(Rectangle r1, Rectangle r2)
	{
		int tempY = (int)r1.getY();
		int tempHeight = (int)r1.getHeight();
		r1.setBounds((int)r1.getX(), (int)r2.getY(), (int)r1.getWidth(), (int)r2.getHeight());
		r2.setBounds((int)r2.getX(), tempY		   , (int)r2.getWidth(), tempHeight			);
	}
	
	// Paints the bars according to their status on the list 
	public void paint(Graphics g)
	{
		for(int i = 0; i < 100; i++) 
		{
			// Used for sorting
			if(i == smallest || i == firstIndex)
			{
				g.setColor(Color.RED);
				((Graphics2D) g).fill(Bars.get(i));
			}
			// Sorted
			else if (i < firstIndex)
			{
				g.setColor(Color.GREEN);
				((Graphics2D) g).fill(Bars.get(i));
			}
			// NOT Sorted
			else
			{
				g.setColor(Color.WHITE);
				((Graphics2D) g).fill(Bars.get(i));
			}
		}
			
		
	}

}
