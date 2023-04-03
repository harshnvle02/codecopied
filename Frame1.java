package TRT;
import javax.swing.JFrame;

public class Frame1 extends JFrame{

    private static final long serialVersionUID = 1L;

    Frame1() {
        GamePanel panel = new GamePanel();
        this.add(panel);
        this.setTitle("snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
