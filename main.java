/**
 * Created by realmx2000 on 2/1/17.
 */
import java.awt.*;
import javax.swing.*;


public class main {
    public static void main(String[] args){
        GUI gui = new GUI();
        gui.setPreferredSize(new Dimension(800, 800));
        JFrame window = new JFrame();
        window.setLayout(new FlowLayout());
        window.setTitle("Euler Sieve");
        window.setSize(900,900);
        window.add(gui);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        while(true){

        }
    }
}
