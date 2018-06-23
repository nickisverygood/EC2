package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import Condiment.CondimentGeneral;
import Containers.Beverage;
import Containers.Cup;
import Flavor.FlavorGeneral;
import Machines.Dispenser;

public class ConfirmationGUI extends JPanel {
    Beverage myBBG;
    public ConfirmationGUI(Beverage BVG)
    {
        myBBG = BVG;
        //this.setLayout(new GridLayout(6, 1, 5, 5));
        //JPanel SelAmount = new JPanel(new GridLayout(6, 3, 5, 5));
        Font btnfont2 = new Font("Arial", Font.ITALIC, 30);



        JLabel amountText = new JLabel("Please Select Cup Size");
        String size[] = {"Large","Medium","Small"};
        ButtonGroup group = new ButtonGroup();
        for(String eachsize:size){
            JRadioButton sizeBtn = new JRadioButton(eachsize);
            sizeBtn.setMnemonic(KeyEvent.VK_P);
            sizeBtn.setActionCommand(eachsize);
            sizeBtn.setSelected(true);
            group.add(sizeBtn);
            add(sizeBtn);
            sizeBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    amountText.setText(eachsize);
                }
            });
        }


        String condimentText[] = {"Cream","Splenda","Sugar"};
        ArrayList<JCheckBox> condimentList = new ArrayList<>();
        for(String eachcondimentText:condimentText){
            JCheckBox condiment = new JCheckBox(eachcondimentText);
            condiment.setMnemonic(KeyEvent.VK_P);
            condimentList.add(condiment);
            add(condiment);
            condiment.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
        }

        JButton startBtn = new JButton("Dispense");
        startBtn.setHorizontalAlignment(SwingConstants.LEFT);
        startBtn.setFont(btnfont2);
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Flavor: " + BVG.getFlavors());

                if(getSelectedButtonText(group) != null) BVG.setSize(getSelectedButtonText(group));
                for(String condiments : getSelectedButtonText(condimentList)) BVG.addCondiments(condiments);

                Dispenser<CondimentGeneral> condimentDispenser = new Dispenser<>(BVG.getCondimentParticles());
                Dispenser<FlavorGeneral> flavorDispenser = new Dispenser<>(BVG.getFlavorsParticles());

                Cup mycup = new Cup();
                while (mycup.recieveFlavor(flavorDispenser.dispense()));
                while (mycup.recieveCondiment(condimentDispenser.dispense()));


                DispenserGUI.createAndShowGUI(mycup);
            }
        });

        for (int i = 0; i < 18; i++) {
            if (i == 12) {
                add(startBtn);
            } else if (i == 9) {
                amountText.setFont(new Font("Arial", Font.BOLD, 30));
                add(amountText);
            } else if (i == 3) {
                JLabel name = new JLabel(String.valueOf(myBBG.getFlavors()));
                name.setFont(new Font("Arial", Font.BOLD, 30));
                add(name);
            } else {
                add(new JLabel(""));
            }
        }





    }
    public static void createAndShowGUI()
    {
        JPanel panel = new ConfirmationGUI(new Beverage());


        JFrame frame = new JFrame("Check Box Group");
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
    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
    public List<String> getSelectedButtonText(ArrayList<JCheckBox> buttonList) {
        List<String> selectedListText = new ArrayList<>();
        for (JCheckBox jC : buttonList) {
            if (jC.isSelected()) {
                selectedListText.add(jC.getText());
            }
        }

        return selectedListText;
    }
}
