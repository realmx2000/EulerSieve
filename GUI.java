/**
 * Created by realmx2000 on 2/2/17.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GUI extends JPanel implements ActionListener {
    private JLabel introText;
    private JTextField inputField;
    private ArrayList<ColorPoint> points = new ArrayList<ColorPoint>();
    private JTextArea primeLabel;
    private JButton reset;
    private JScrollPane scroll;
    private int num;
    private int size;
    private int interval;

    public GUI(){
        super.setLayout(new FlowLayout());

        this.setSize(800, 800);
        introText = new JLabel("Enter the number to find primes up to: ");
        inputField = new JTextField(10);
        reset = new JButton("Reset");
        reset.addActionListener(this);
        add(introText);
        add(inputField);
        add(reset);
        inputField.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(reset)){
            remove(scroll);
            for(ColorPoint point : points)
                point.setColor(this.getBackground());
            revalidate();
            repaint();
            add(introText);
            add(inputField);
            add(reset);
            return;
        }
        setNum();
        Sieves sieve = new Sieves(num);
        ArrayList<Integer> primes = new ArrayList<Integer>();
        Random r = new Random();
        ArrayList<Integer> composites = new ArrayList<Integer>();
        while(sieve.getCurrentSieve().get(0) <= Math.sqrt((double) num)){
            Color color = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
            composites = sieve.applyEulerSieve();
            primes.add(composites.get(0));
            for(int i = 1; i < composites.size(); i++) {
                fillGrid(composites.get(i), color);
                paintImmediately(50, 50, 650, 650);
            }
        }
        primes.addAll(sieve.getCurrentSieve());
        primeLabel = new JTextArea("Primes: " + primes.toString(), 3, 50);
        primeLabel.setLineWrap(true);
        primeLabel.setWrapStyleWord(true);
        scroll = new JScrollPane(primeLabel);
        primeLabel.setEditable(false);
        add(scroll);
        revalidate();
        repaint();
    }

    private void setNum(){
        num = Integer.parseInt(inputField.getText());
        size = (int) Math.ceil(Math.sqrt((double) num));
        interval = Math.round((float) 600/size);

    }
    public JTextArea getPrimes(){
        return primeLabel;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(ColorPoint point : points) {
            g.setColor(point.getColor());
            g.fillRect(point.getxCoordinate(), point.getyCoordinate(), interval, interval);
        }

        g.setColor(Color.black);
        g.drawLine(700, 100, 700, 700);
        g.drawLine(100, 700, 700, 700);
        for(int c = 0; c <= size; c++)
            g.drawLine(100, 100 + interval * c, 700, 100 + interval * c);
        for(int r = 0; r <= size; r++)
            g.drawLine(100 + interval * r, 100, 100 + interval * r, 700);
    }

    public void fillGrid(int n, Color color){
        int y = 100 + ((n-1) / size) * interval;
        int x = 100 + ((n-1) % size) * interval;
        points.add(new ColorPoint(color, x, y));
        //repaint();
    }
}
