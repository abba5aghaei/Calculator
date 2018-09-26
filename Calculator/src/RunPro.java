//INOG
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

//author @abba5aghaei

public class RunPro {
	
	static MainFrame run = new MainFrame();

	public static void main(String[] args) {
		
		run.setBounds(450, 100, 320, 445);
		
		run.setTitle("Calculator");
		
		run.setVisible(true);
		
		run.setResizable(false);
		
		run.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Image im = Toolkit.getDefaultToolkit().getImage("images/calcu.png");
		
		run.setIconImage(im);
		
		Timer movment = new Timer();
		
		movment.schedule(new mover(), 0, 30);
	}
	public static class mover extends TimerTask {

		public void run() {
			
			run.ads.setBounds(run.ads.getX()-1, 0, 520, 24);
			
			if(run.ads.getX() == -500)
				run.ads.setBounds(run.getWidth(), 0, 520, 24);
		}
	}
}