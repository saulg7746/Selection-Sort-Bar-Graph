import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Algorthims extends JPanel implements ActionListener{

	SelectionSort SelectionSort;
	
	public Algorthims()
	{
		setBackground(Color.BLACK);
		SelectionSort = new SelectionSort();
		Timer timer = new Timer(80, this);
        timer.start();
        setFocusable(true);

		
	}
    public void paintComponent(Graphics g )
    {
    	super.paintComponent(g);
    	SelectionSort.paint(g);
    	
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		SelectionSort.sort();
		repaint();

	}


	
}
