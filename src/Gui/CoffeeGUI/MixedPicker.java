package Gui.CoffeeGUI;

import Condiment.CondimentGeneral;
import Containers.Beverage;
import Flavor.Coffee.Mixed;
import Gui.ConfirmationGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class MixedPicker extends JPanel {
    public MixedPicker(JComponent cards){
        setLayout(new GridLayout(4, 2, 5, 5));
        setPreferredSize(new Dimension(800, 800));
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        CheckBoxGroup group = new CheckBoxGroup(2);
        ArrayList<JCheckBox> flavortList = new ArrayList<>();
        String Flavors[] = {"Verona","PikePlace","DeCafPikePlace"};
        for (int i = 0; i < 3; i++)
        {
            JCheckBox checkBox = new JCheckBox( Flavors[i] );
            add( checkBox );
            flavortList.add(checkBox);
            group.register( checkBox );
        }

        JButton gotoLast = new JButton("Confirm");
        gotoLast.setHorizontalAlignment(SwingConstants.LEFT);
        gotoLast.setFont(new Font("Arial", Font.ITALIC, 30));
        gotoLast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.add(new ConfirmationGUI(new Beverage(getSelectedButtonText(flavortList))), "Mixed");
                CardLayout cardLayout = (CardLayout) cards.getLayout();
                cardLayout.show(cards, "Mixed");
            }
        });
        add(gotoLast);
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
    public java.util.List<String> getSelectedButtonText(ArrayList<JCheckBox> buttonList) {
        List<String> selectedListText = new ArrayList<>();
        for (JCheckBox jC : buttonList) {
            if (jC.isSelected()) {
                selectedListText.add(jC.getText());
            }
        }

        return selectedListText;
    }
}
