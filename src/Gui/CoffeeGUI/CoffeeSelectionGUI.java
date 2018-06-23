package Gui.CoffeeGUI;

import Condiment.CondimentGeneral;
import Containers.Beverage;
import Flavor.Coffee.DeCafPikePlace;
import Flavor.Coffee.Mixed;
import Flavor.Coffee.PikePlace;
import Flavor.Coffee.Verona;
import Gui.ConfirmationGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoffeeSelectionGUI extends JPanel {
    public CoffeeSelectionGUI(JComponent cards){
        setLayout(new GridLayout(4, 2, 5, 5));
        setPreferredSize(new Dimension(800, 800));
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        String text1 = "<html>" + "CAFFE\nVERONA".replaceAll("\\n", "<br>") + "</html>";
        String text2 = "<html>" + "PIKE PLACE".replaceAll("\\n", "<br>") + "</html>";
        String text3 = "<html>" + "DECAF\nPILE PLACE".replaceAll("\\n", "<br>") + "</html>";
        String text4 = "<html>" + "MIX TWO".replaceAll("\\n", "<br>") + "</html>";
        Font btnfont = new Font("Arial", Font.BOLD, 48);
        JButton b1 = new JButton(text1);
        b1.setHorizontalAlignment(SwingConstants.LEFT);
        b1.setFont(btnfont);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.add(new ConfirmationGUI(new Beverage("Verona")), "Verona");
                CardLayout cardLayout = (CardLayout) cards.getLayout();
                cardLayout.show(cards, "Verona");
            }
        });
        JButton b2 = new JButton(text2);
        b2.setHorizontalAlignment(SwingConstants.LEFT);
        b2.setFont(btnfont);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.add(new ConfirmationGUI(new Beverage("PikePlace")), "PikePlace");
                CardLayout cardLayout = (CardLayout) cards.getLayout();
                cardLayout.show(cards, "PikePlace");
            }
        });
        JButton b3 = new JButton(text3);
        b3.setHorizontalAlignment(SwingConstants.LEFT);
        b3.setFont(btnfont);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.add(new ConfirmationGUI(new Beverage("DeCafPikePlace")), "DeCafPikePlace");
                CardLayout cardLayout = (CardLayout) cards.getLayout();
                cardLayout.show(cards, "DeCafPikePlace");
            }
        });
        JButton b4 = new JButton(text4);
        b4.setHorizontalAlignment(SwingConstants.LEFT);
        b4.setFont(btnfont);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.add(new ConfirmationGUI(new Beverage("Mixed")), "Mixed");
                CardLayout cardLayout = (CardLayout) cards.getLayout();
                cardLayout.show(cards, "pickMixedPanel");
            }
        });


        for (int i = 0; i < 8; i++) {
            if (i == 0) {
                add(b1);
            } else if (i == 2) {
                add(b2);
            } else if (i == 4) {
                add(b3);
            } else if (i == 6) {
                add(b4);
            } else {
                add(new JLabel());
            }
        }

    }
}
