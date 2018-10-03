
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Calendar;      // only need this one class

/// TextClock
public class exp1 {
	
    

    public static void main(String[] args) {
        JFrame clock = new TextClockWindow();
        clock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton btnNewButton = new JButton("london");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        Container content1 = this.getContentPane();
        clock.getContentPane().add(btnNewButton);
        content1.add(timeField);
        
        JButton btnNewButton_2 = new JButton("India");
        btnNewButton_2.addActionListener(new ActionListener()
        {public void actionPerformed(ActionEvent e)
        {
        	 Calendar now = Calendar.getInstance();
             int h = now.get(Calendar.HOUR_OF_DAY);
             int m = now.get(Calendar.MINUTE);
             int s = now.get(Calendar.SECOND);
             timeField.setText("" + h + ":" + m + ":" + s);
        }
        });
       // btnNewButton_2.setVisible(true);
        clock.getContentPane().add(btnNewButton_2);
        
        JButton btnNewButton_1 = new JButton("paris");
        clock.getContentPane().add(btnNewButton_1);
        clock.setVisible(true);
    }//end main
}//endclass TextClock


////// TextClockWindow
class TextClockWindow extends JFrame {
    

    private JTextField timeField;  // set by timer listener

    

    public TextClockWindow() {
        // Build the GUI - only one panel
        timeField = new JTextField(6);
        timeField.setFont(new Font("sansserif", Font.PLAIN, 48));

        Container content = this.getContentPane();
        content.setLayout(new FlowLayout());
        content.add(timeField); 
        
        this.setTitle("Text Clock");
        this.pack();

        // Create a 1-second timer and action listener for it.
        // Specify package because there are two Timer classes
        javax.swing.Timer t = new javax.swing.Timer(1000,
              new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                      Calendar now = Calendar.getInstance();
                      int h = now.get(Calendar.HOUR_OF_DAY)-5;
                      int m = now.get(Calendar.MINUTE)-30;
                      int s = now.get(Calendar.SECOND);
                      timeField.setText("" + h + ":" + m + ":" + s);
                  }
              });
        t.start();  // Start the timer
    }//end constructor
}//endclass TextClock