import Containers.Beverage;
import Gui.CoffeeGUI.CoffeeSelectionGUI;
import Gui.CoffeeGUI.MixedPicker;
import Gui.ConfirmationGUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MainScreen extends JPanel {
    public MainScreen() {
        super(new GridLayout(1, 1));

        JTabbedPane tabbedPane = new JTabbedPane();

        JComponent cards = new JPanel(new CardLayout());
        JComponent cards2 = new JPanel(new CardLayout());
        JComponent cards3 = new JPanel(new CardLayout());

        cards.add(new CoffeeSelectionGUI(cards), "1");
        cards.add(new MixedPicker(cards), "pickMixedPanel");

        tabbedPane.addTab("Tab 1", cards);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        tabbedPane.addTab("Tab 2", cards2);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        tabbedPane.addTab("Tab 3", cards3);
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);


        String labels[] = {"Coffee","Hot Chocolate","Hot Water"};
        int index = 0;
        for(String eachlabel : labels){
            JLabel lab0 = new JLabel();
            lab0.setText(eachlabel);
            lab0.setPreferredSize(new Dimension(300, 200));
            tabbedPane.setTabComponentAt(index++, lab0);  // tab index, jLabel
            lab0.setFont(new Font("Serif", Font.BOLD, 40));
        }


        tabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                System.out.println("Tab: " + tabbedPane.getSelectedIndex());
                if (tabbedPane.getSelectedIndex() == 0) {
                    CardLayout cardLayout = (CardLayout) cards.getLayout();
                    cardLayout.show(cards, "1");
                } else if (tabbedPane.getSelectedIndex() == 1) {
                    CardLayout cardLayout = (CardLayout) cards2.getLayout();
                    cards2.add(new ConfirmationGUI(new Beverage("HotChocolate")), "HotChocolate");
                    cardLayout.show(cards2, "HotChocolate");
                } else if (tabbedPane.getSelectedIndex() == 2) {
                    CardLayout cardLayout = (CardLayout) cards3.getLayout();
                    cards3.add(new ConfirmationGUI(new Beverage("HotWater")), "HotWater");
                    cardLayout.show(cards3, "HotWater");
                }
            }
        });
        tabbedPane.setTabPlacement(JTabbedPane.LEFT);
        //Add the tabbed pane to this panel.
        add(tabbedPane);

        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

    /**
     * Returns an ImageIcon, or null if the path was invalid.
     */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = MainScreen.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from
     * the event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("MainScreen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new MainScreen(), BorderLayout.CENTER);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static Beverage mydrink = new Beverage();

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.



        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }
}