package Gui;

import Containers.Cup;
import Flavor.FlavorGeneral;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class DispenserGUI extends JPanel {
    public DispenserGUI(Cup mycup)
    {

    }
    public static void createAndShowGUI(Cup mycup){
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(800, 800));
        for(String particles:mycup.peakParticles()){
            JLabel particle = new JLabel("("+particles+")");
            panel.add(particle);
        }
        JFrame frame = new JFrame("Particles inside your cup");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( panel );
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }
    public static void createAndShowGUI()
    {
        JPanel panel = new JPanel();

        panel.setPreferredSize(new Dimension(300, 200));
        JFrame frame = new JFrame("Particles inside your cup");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( panel );
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}
